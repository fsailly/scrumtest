package com.jackbaretto.scrumtest.extractor.type;

/**
 * In charge of question type  extraction.
 * Created by mehdi on 16/01/17.
 */
public interface QuestionTypeExtractor {
    QuestionType extract(String extraction);
}
