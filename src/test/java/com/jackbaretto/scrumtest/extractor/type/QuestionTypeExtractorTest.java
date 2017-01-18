package com.jackbaretto.scrumtest.extractor.type;

import com.jackbaretto.scrumtest.extractor.question.ExtractedSampleQuestions;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mehdi on 16/01/17.
 */
public class QuestionTypeExtractorTest {

    @Test
    public void testOneResponse(){
        QuestionTypeExtractor extractor = new QuestionTypeExtractorImpl();
        final ExtractedSampleQuestions classicQuestionFullExtraction = ExtractedSampleQuestions.CLASSIC_QUESTION_FULL_EXTRACTION;
        QuestionType questionType = extractor.extract(classicQuestionFullExtraction.getExtractedQuestionLabel());
        Assert.assertEquals(QuestionType.ONE_RESPONSE, questionType);
    }

    @Test
    public void testTwoResponses(){
        QuestionTypeExtractor extractor = new QuestionTypeExtractorImpl();
        final ExtractedSampleQuestions classicQuestionFullExtraction = ExtractedSampleQuestions.QUESTION_WITH_TWO_RESPONSES;
        QuestionType questionType = extractor.extract(classicQuestionFullExtraction.getExtractedQuestionLabel());
        Assert.assertEquals(QuestionType.N_RESPONSE, questionType);
    }


    @Test
    public void testAllThatApply(){
        QuestionTypeExtractor extractor = new QuestionTypeExtractorImpl();
        final ExtractedSampleQuestions classicQuestionFullExtraction = ExtractedSampleQuestions.MULTI_CHOICES_QUESTION;
        QuestionType questionType = extractor.extract(classicQuestionFullExtraction.getExtractedQuestionLabel());
        Assert.assertEquals(QuestionType.ALL_THAT_APPLY, questionType);
    }
}
