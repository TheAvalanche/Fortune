package org.fortune.service;

import org.fortune.schema._2_0.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookParser {


    public List<String> getLines(FictionBook fictionBook) {
        return getLinesStream(
                getSections(fictionBook).stream()
                        .filter(section -> !section.getPOrImageOrPoem().isEmpty())
                        .map(SectionType::getPOrImageOrPoem).flatMap(Collection::stream))
                .collect(Collectors.toList());
    }

    private Stream<String> getLinesStream(Stream<JAXBElement<?>> stream) {
        Stream<Serializable> poemStream = getPoemLinesStream(stream);
        Stream<Serializable> textStream = getTextLinesStream(stream);

        return Stream.concat(poemStream, textStream).map(s -> (String) s);
    }

    private Stream<Serializable> getPoemLinesStream(Stream<JAXBElement<?>> stream) {
        return stream
                .filter(s -> s.getValue() instanceof PoemType)
                .map(s -> ((PoemType) s.getValue()).getStanza()).flatMap(Collection::stream)
                .map(PoemType.Stanza::getV).flatMap(Collection::stream)
                .map(StyleType::getContent).flatMap(Collection::stream);
    }

    private Stream<Serializable> getTextLinesStream(Stream<JAXBElement<?>> stream) {
        return stream
                .filter(s -> s.getValue() instanceof PType)
                .map(s -> ((PType) s.getValue()).getContent()).flatMap(Collection::stream);
    }

    public List<SectionType> getSections(FictionBook fictionBook) {
        List<SectionType> sections = new LinkedList<>();
        fictionBook.getBody().stream()
                .map(FictionBook.Body::getSection)
                .flatMap(Collection::stream).forEach(s -> addSubsections(s, sections));
        return sections;
    }

    private void addSubsections(SectionType section, List<SectionType> sectionTypes) {
        if (section.getSection() != null) {
            section.getSection().stream().forEach(s -> addSubsections(s, sectionTypes));
        }
        sectionTypes.add(section);
    }

    public FictionBook stringToBook(String book) throws JAXBException {
        JAXBContext c = JAXBContext.newInstance(FictionBook.class);
        Unmarshaller unmarshaller = c.createUnmarshaller();
        return (FictionBook) unmarshaller.unmarshal(new StringReader(book));
    }

}
