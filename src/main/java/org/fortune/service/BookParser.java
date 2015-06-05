package org.fortune.service;

import org.fortune.schema._2_0.FictionBook;
import org.fortune.schema._2_0.PoemType;
import org.fortune.schema._2_0.SectionType;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public String findLine(FictionBook fictionBook, int page, int line) {
        return (String) fictionBook.getBody().get(0).getSection().get(page).getPoem().getStanza().get(line).getV().get(line).getContent().get(0);
    }

}
