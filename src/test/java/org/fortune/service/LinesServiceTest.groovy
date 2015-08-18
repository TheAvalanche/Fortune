package org.fortune.service

import spock.lang.Specification


class LinesServiceTest extends Specification {

    LinesService linesService = new LinesService()

    def "should return full sentence" () {
        given:
        def lines = ["First sentence. One ", "two ", "three ", "four ", "five. Last sentence."]
        when:
        def sentence = linesService.getCompleteSentence(lines, 1)
        then:
        sentence == "One two three four five."
    }

}