package com.jackbaretto.scrumtest.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In charge of MCQ question extraction.
 * <p>
 * Created by mehdi on 11/01/17.
 */
public class MCQQuestionExtractor {

    public static final String QUESTION_PATTERN = "(.*[0-9]\\).*\\?)";

    /**
     * Extract question from String.
     *
     * @param extract String which contains a question.
     * @return result {@link ExtractionResult}
     */
    public ExtractedQuestion extract(String extract) {
        Pattern pattern = Pattern.compile(QUESTION_PATTERN);
        Matcher matcher = pattern.matcher(extract);
        String label = "";
        if (matcher.find()) {
            label = matcher.group(1);
            String questionLabel = label.split("\\)")[1];
            return new ExtractedQuestionImpl(questionLabel.trim());
        }
        throw new QuestionNotFoundException();
    }
}
