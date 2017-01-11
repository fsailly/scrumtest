package com.jackbaretto.scrumtest.extractor;

/**
 * In charge of MCQ question extraction.
 *
 * Created by mehdi on 11/01/17.
 */
public class MCQQuestionExtractor {

    /**
     * Extract question from String.
     * @param extract String which contains a question.
     * @return result {@link ExtractionResult}
     */
    public ExtractedQuestion extract(String extract) {
        return new ExtractedQuestionImpl("");
    }
}
