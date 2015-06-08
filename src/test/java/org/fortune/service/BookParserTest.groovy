package org.fortune.service
import org.fortune.schema._2_0.FictionBook
import spock.lang.Specification

class BookParserTest extends Specification {

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

    def testText = '''<?xml version="1.0" encoding="UTF-8"?>
                      <FictionBook xmlns="http://www.gribuser.ru/xml/fictionbook/2.0" xmlns:l="http://www.w3.org/1999/xlink">
                        <body>
                          <section>
                            <p>Жечь было наслаждением.</p>
                            <p>Жесткая улыбка застыла на лице Монтэга, улыбка-гримаса, которая появляется на губах у человека, когда его вдруг опалит огнем и он стремительно отпрянет назад от его жаркого прикосновения.</p>
                          </section>
                          <section>
                            <p>Он все еще не хотел впустить в комнату свет с улицы.</p>
                            <p>Вынув зажигалку, он нащупал саламандру, выгравированную на серебряном диске, нажал…</p>
                          </section>
                        </body>
                      </FictionBook>'''

    def "should get all sections with subsections"() {
        given:
        FictionBook fictionBook = bookParser.stringToBook(testPoem)
        when:
        def sections = bookParser.getSections(fictionBook)
        then:
        sections.size() == 4
    }

    def "should get all poem lines"() {
        given:
        FictionBook fictionBook = bookParser.stringToBook(testPoem)
        when:
        def lines = bookParser.getLines(fictionBook)
        then:
        lines.size() == 4
    }

    def "should get all text lines"() {
        given:
        FictionBook fictionBook = bookParser.stringToBook(testText)
        println(fictionBook.getBody().get(0).getSection().get(0))
        when:
        def lines = bookParser.getLines(fictionBook)
        then:
        lines.size() == 4
    }

}
