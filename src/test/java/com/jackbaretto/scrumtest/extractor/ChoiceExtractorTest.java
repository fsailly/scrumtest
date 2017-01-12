package com.jackbaretto.scrumtest.extractor;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by mehdi on 12/01/17.
 */
public class ChoiceExtractorTest {
    private String expectedClassicQuestionChoiceA = "I He or she does not have to be there; he or she oniy has to ensure\n" +
            "the Deve|opment Team has a Dai|y Scrum.";
    private String expectedClassicQuestionChoiceB = "To write down any changes to the Sprint Back|og, inc|uding adding\n" +
            "new items, and tracking progress on the bum-down.";
    private String expectedClassicQuestionChoiceC = "To make sure every team member answers the three questions.";
    private String expectedClassicQuestionChoiceD = "To gather status and progress information to report to\n" +
            "management.";

    @Test
    public void testExtractChoicesFromClassicQuestion() {
        MCQChoiceExtractor choiceExtractor = new MCQChoiceExtractor();
        final List<ExtractedChoice> choices = choiceExtractor.extract(ExtractedSampleQuestions.CLASSIC_QUESTION_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(4, choices.size());
        Assert.assertEquals(expectedClassicQuestionChoiceA, choices.get(0).getLabel());
        Assert.assertEquals(expectedClassicQuestionChoiceB, choices.get(1).getLabel());
        Assert.assertEquals(expectedClassicQuestionChoiceC, choices.get(2).getLabel());
        Assert.assertEquals(expectedClassicQuestionChoiceD, choices.get(3).getLabel());
    }
}