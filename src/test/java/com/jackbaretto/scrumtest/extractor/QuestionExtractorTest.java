package com.jackbaretto.scrumtest.extractor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mehdi on 11/01/17.
 */
public class QuestionExtractorTest {

    private final String expectedQuestion = "What is the main reason for the Scrum Master to be at the Daily Scrum?";

    private final String expectedAssertion = "The Product Owner must reIease each Increment to production.";

    @Test
    public void testExtractClassicQuestion() {
        final MCQQuestionExtractor questionExtractor = new MCQQuestionExtractor();
        final ExtractedQuestion extractedQuestion = questionExtractor.extract(ExtractedSampleQuestions.CLASSIC_QUESTION_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(this.expectedQuestion, extractedQuestion.getLabel());
    }

    @Test
    public void testExtractAssertionToComplete() {
        final MCQQuestionExtractor questionExtractor = new MCQQuestionExtractor();
        final ExtractedQuestion extractedQuestion = questionExtractor.extract(ExtractedSampleQuestions.ASSERTION_TO_COMPLETE_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(this.expectedAssertion, extractedQuestion.getLabel());
    }


    @Test(expected = QuestionNotFoundException.class)
    public void testExtractorCantExtractQuestion() {
        final MCQQuestionExtractor questionExtractor = new MCQQuestionExtractor();
        questionExtractor.extract("Default string without any question.");
    }


}
