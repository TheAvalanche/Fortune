package org.fortune.rest;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.fortune.schema._2_0.FictionBook;
import org.fortune.service.BookParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping("/lines")
public class LinesController {

    @Autowired
    BookParser bookParser;

    @RequestMapping(value = "/find/{lineNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LinesResult findLine(@PathVariable Integer lineNumber) throws IOException, JAXBException {
        FictionBook fictionBook = bookParser.stringToBook(Resources.toString(Resources.getResource("Onegin.fb2"), Charsets.UTF_8));
        return new LinesResult(bookParser.getLines(fictionBook).get(lineNumber));
    }

}
