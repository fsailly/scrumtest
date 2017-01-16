package com.jackbaretto.scrumtest.extractor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mehdi on 11/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionExtractorTest {

    private final String expectedQuestion = "What is the main reason for the Scrum Master to be at the Daily Scrum?";

    private final String expectedAssertion = "The Product Owner must reIease each Increment to production.";

    private final String expectedTrueFalseQuestion="The sprint Goa| is a resuIt of sprint P|anning, as is the Sprint Back|og.";

    @InjectMocks
    private MCQQuestionExtractor mcqQuestionExtractor;
    @Mock
    private QuestionTypeExtractor questionTypeExtractor;


    @Test
    public void testExtractClassicQuestion() {
        Mockito.when(questionTypeExtractor.extract(Mockito.anyString())).thenReturn(QuestionType.ONE_RESPONSE);
        final ExtractedQuestion extractedQuestion = mcqQuestionExtractor.extract(ExtractedSampleQuestions.CLASSIC_QUESTION_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(this.expectedQuestion, extractedQuestion.getLabel());
        Assert.assertEquals(QuestionType.ONE_RESPONSE, extractedQuestion.getType());
    }

    @Test
    public void testExtractAssertionToComplete() {
        Mockito.when(questionTypeExtractor.extract(Mockito.anyString())).thenReturn(QuestionType.ONE_RESPONSE);
        final ExtractedQuestion extractedQuestion = mcqQuestionExtractor.extract(ExtractedSampleQuestions.ASSERTION_TO_COMPLETE_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(this.expectedAssertion, extractedQuestion.getLabel());
        Assert.assertEquals(QuestionType.ONE_RESPONSE, extractedQuestion.getType());
    }

    @Test
    public void testExtractTrueFalseQuestion(){
        Mockito.when(questionTypeExtractor.extract(Mockito.anyString())).thenReturn(QuestionType.ONE_RESPONSE);
        final ExtractedQuestion extractedQuestion = mcqQuestionExtractor.extract(ExtractedSampleQuestions.QUESTION_TRUE_FALSE.getExtractedQuestionLabel());
        Assert.assertEquals(this.expectedTrueFalseQuestion, extractedQuestion.getLabel());
        Assert.assertEquals(QuestionType.ONE_RESPONSE, extractedQuestion.getType());
    }
    @Test(expected = QuestionNotFoundException.class)
    public void testExtractorCantExtractQuestion() {
        Mockito.when(questionTypeExtractor.extract(Mockito.anyString())).thenReturn(QuestionType.ONE_RESPONSE);
        mcqQuestionExtractor.extract("Default string without any question.");
    }


}
