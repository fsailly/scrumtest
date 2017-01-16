package com.jackbaretto.scrumtest.extractor;

/**
 * Question extracted from MCQ.
 * <p>
 * Created by mehdi on 11/01/17.
 */
public interface ExtractedQuestion {

    String getLabel();

    QuestionType getType();
}
