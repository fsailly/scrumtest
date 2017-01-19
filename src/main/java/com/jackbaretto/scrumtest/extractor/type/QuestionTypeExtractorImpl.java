package com.jackbaretto.scrumtest.extractor.type;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mehdi on 16/01/17.
 */
@Component("questionTypeExtractor")
public class QuestionTypeExtractorImpl implements QuestionTypeExtractor {

    /** If extraction contains "Choose * answers", the question have * responses.*/
    private static final String N_RESPONSES_PATTERN = "^((.*?(\\bChoose\\b)).*?(\\banswers\\b))";
    private static final String ONE_RESPONSE_PATTERN = "Choose one answer";
    private static final String ALL_THAT_APPLY_PATTERN = "Choose all that";

    @Override
    public QuestionType extract(String extraction) {
        if(extraction.contains(ONE_RESPONSE_PATTERN)){
            return QuestionType.ONE_RESPONSE;
        } else if(extraction.contains(ALL_THAT_APPLY_PATTERN)){
            return QuestionType.ALL_THAT_APPLY;
        }

        final Pattern sentencesPattern = Pattern.compile(N_RESPONSES_PATTERN, Pattern.DOTALL);
        final Matcher sentencesMatcher = sentencesPattern.matcher(extraction);
        if(sentencesMatcher.find()){
            return QuestionType.N_RESPONSE;
        }
        throw new QuestionTypeNotFoundException("No question type found for : " +extraction);
    }
}
