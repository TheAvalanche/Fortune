package org.fortune.service
import org.fortune.schema._2_0.FictionBook
import spock.lang.Specification

class BookParserTest extends Specification {

    FictionBook fictionBook

    BookParser bookParser = new BookParser()

    def testPoem = '''<?xml version="1.0" encoding="utf-8"?>
                        <FictionBook xmlns="http://www.gribuser.ru/xml/fictionbook/2.0" xmlns:l="http://www.w3.org/1999/xlink">
                          <body>
                            <section>
                              <section>
                                  <poem>
                                    <stanza>
                                      <v>Test1</v>
                                    </stanza>
                                  </poem>
                              </section>
                            </section>
                            <section>
                              <poem>
                                <stanza>
                                  <v>Test1</v>
                                  <v>Test2</v>
                                </stanza>
                              </poem>
                            </section>
                          </body>
                          <body>
                            <section>
                              <poem>
                                <stanza>
                                  <v>Test1</v>
                                </stanza>
                              </poem>
                            </section>
                          </body>
                        </FictionBook>'''

    def "should get all sections with subsections"() {
        when:
        FictionBook fictionBook = bookParser.stringToBook(testPoem)
        def sections = bookParser.getSections(fictionBook)
        then:
        sections.size() == 4
    }

    def "should get all poem lines"() {
        when:
        FictionBook fictionBook = bookParser.stringToBook(testPoem)
        def lines = bookParser.getLines(fictionBook)
        then:
        lines.size() == 4
    }

}
