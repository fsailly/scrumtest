package com.jackbaretto.scrumtest.extractor;

/**
 * Thrown if an {@link QuestionTypeExtractor} implementation cannot extract a {@link QuestionType}O
 * Created by mehdi on 12/01/17.
 */
public class QuestionTypeNotFoundException extends RuntimeException {
    public QuestionTypeNotFoundException(String message) {
        super(message);
    }
}
