package org.fortune.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class LinesService {

    private static final CharSequence[] SENTENCE_BREAK_CHARS = new CharSequence[]{".", "?", "!"};

    public String getCompleteSentence(final List<String> lines, final int lineNumber) {

        StringBuilder stringBuilder = new StringBuilder();

        if (!endsWithAny(lines.get(lineNumber - 1), SENTENCE_BREAK_CHARS)) {
            stringBuilder.append(getPreLines(lines, lineNumber - 1));
        }

        stringBuilder.append(lines.get(lineNumber));

        if (!endsWithAny(lines.get(lineNumber), SENTENCE_BREAK_CHARS)) {
            stringBuilder.append(getPostLines(lines, lineNumber + 1));
        }

        return stringBuilder.toString().trim();
    }

    private String getPreLines(List<String> lines, int searchStart) {
        StringBuilder builder = new StringBuilder();
        while (true) {
            String line = lines.get(searchStart--);
            if (containsAny(line, SENTENCE_BREAK_CHARS)) {
                builder.insert(0, substring(line, StringUtils.indexOfAny(line, SENTENCE_BREAK_CHARS) + 1));
                break;
            }
            builder.insert(0, line);
        }
        return builder.toString();
    }

    private String getPostLines(List<String> lines, int searchStart) {
        StringBuilder builder = new StringBuilder();
        while (true) {
            String line = lines.get(searchStart++);
            if (containsAny(line, SENTENCE_BREAK_CHARS)) {
                builder.append(substring(line, 0, StringUtils.indexOfAny(line, SENTENCE_BREAK_CHARS) + 1));
                break;
            }
            builder.append(line);
        }
        return builder.toString();
    }


}
