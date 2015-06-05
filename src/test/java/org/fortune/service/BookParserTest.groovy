package org.fortune.service

import org.fortune.schema._2_0.FictionBook
import spock.lang.Specification

import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

class BookParserTest extends Specification {

    FictionBook fictionBook

    BookParser bookParser = new BookParser()

    def setup() {
        JAXBContext c = JAXBContext.newInstance(FictionBook.class)
        Unmarshaller unmarshaller = c.createUnmarshaller()
        fictionBook = (FictionBook) unmarshaller.unmarshal(this.class.getResourceAsStream("/Onegin.fb2"))
    }

    def "Should return the first line"() {
        when:
        def line = bookParser.findLine(fictionBook, 0, 1)
        then:
        line == "He мысля гордый свет забавить,"
    }

    def "Should add all lines to list"() {
        when:
        def lines = bookParser.parseLines(fictionBook)
        then:
        lines.size() == 91
    }

}
