package org.fortune.service;

import org.fortune.schema._2_0.FictionBook;
import org.fortune.schema._2_0.PoemType;
import org.fortune.schema._2_0.SectionType;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookParser {

    public List<String> parseLines(FictionBook fictionBook) {
        return fictionBook.getBody().stream()
                .map(FictionBook.Body::getSection)
                .flatMap(Collection::stream)
                .filter(s -> s.getSection() != null)
                .map(SectionType::getSection)
                .flatMap(Collection::stream)
                .filter(s -> s.getPoem() != null)
                .map(s -> s.getPoem().getStanza())
                .flatMap(Collection::stream)
                .map(PoemType.Stanza::getV)
                .flatMap(Collection::stream)
                .filter(p -> p.getContent().get(0) instanceof String)
                .map(p -> (String) p.getContent().get(0))
                .collect(Collectors.toList());
    }

    public List<String> getLines(FictionBook fictionBook) {

        return getSections(fictionBook).stream()
                .filter(section -> section.getPoem() != null)
                .map(s -> s.getPoem().getStanza()).flatMap(Collection::stream)
                .map(PoemType.Stanza::getV).flatMap(Collection::stream)
                .map(p -> (String) p.getContent().get(0))
                .collect(Collectors.toList());

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
