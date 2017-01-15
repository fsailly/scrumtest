package com.jackbaretto.scrumtest.extractor;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by mehdi on 12/01/17.
 */
public class ChoiceExtractorTest {

    private final String expectedClassicQuestionChoiceA = "He or she does not have to be there; he or she oniy has to ensure\n" +
            "the Deve|opment Team has a Dai|y Scrum.";
    private final String expectedClassicQuestionChoiceB = "To write down any changes to the Sprint Back|og, inc|uding adding\n" +
            "new items, and tracking progress on the bum-down.";
    private final String expectedClassicQuestionChoiceC = "To make sure every team member answers the three questions.";
    private final String expectedClassicQuestionChoiceD = "To gather status and progress information to report to\n" +
            "management.";

    private final String expectedAssertionChoiceA = "Without exception.";
    private final String expectedAssertionChoiceB = "Whenever the product is free of defects.";
    private final String expectedAssertionChoiceC = "To make sure the Deve|opment Team is done every Sprint.";
    private final String expectedAssertionChoiceD = "When it makes sense.";

    private final String expectedShortChoiceA = "Commitment";
    private final String expectedShortChoiceB = "Courage";
    private final String expectedShortChoiceC = "0penness";
    private final String expectedShortChoiceD = "Foous";
    private final String expectedShortChoiceE = "Respect";
    private final String expectedShortChoiceF = "AH of the above";

    // Test extract from HQ-mcq1.png
    @Test
    public void testExtractShortChoices(){
        final MCQChoiceExtractor choiceExtractor = new MCQChoiceExtractor();
        final List<ExtractedChoice> choices = choiceExtractor.extract(ExtractedSampleQuestions.QUESTION_WITH_SHORT_CHOICES.getExtractedQuestionLabel());
        Assert.assertEquals(6, choices.size());

        Assert.assertEquals(this.expectedShortChoiceA, choices.get(0).getLabel());
        Assert.assertEquals(this.expectedShortChoiceB, choices.get(1).getLabel());
        Assert.assertEquals(this.expectedShortChoiceC, choices.get(2).getLabel());
        Assert.assertEquals(this.expectedShortChoiceD, choices.get(3).getLabel());
        Assert.assertEquals(this.expectedShortChoiceE, choices.get(4).getLabel());
        Assert.assertEquals(this.expectedShortChoiceF, choices.get(5).getLabel());

        Assert.assertFalse(choices.get(0).isSelected());
        Assert.assertFalse(choices.get(1).isSelected());
        Assert.assertFalse(choices.get(2).isSelected());
        Assert.assertFalse(choices.get(3).isSelected());
        Assert.assertFalse(choices.get(4).isSelected());
        Assert.assertTrue(choices.get(5).isSelected());
    }

    @Test
    public void testExtractTrueOrFalseChoices(){
        final MCQChoiceExtractor choiceExtractor = new MCQChoiceExtractor();
        final List<ExtractedChoice> choices = choiceExtractor.extract(ExtractedSampleQuestions.QUESTION_TRUE_FALSE.getExtractedQuestionLabel());
        Assert.assertEquals(2, choices.size());

        Assert.assertEquals(Boolean.toString(Boolean.TRUE), choices.get(0).getLabel());
        Assert.assertEquals(Boolean.toString(Boolean.FALSE), choices.get(1).getLabel());
    }


    @Test
    public void testExtractChoicesFromClassicQuestion() {
        final MCQChoiceExtractor choiceExtractor = new MCQChoiceExtractor();
        final List<ExtractedChoice> choices = choiceExtractor.extract(ExtractedSampleQuestions.CLASSIC_QUESTION_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(4, choices.size());
        Assert.assertEquals(this.expectedClassicQuestionChoiceA, choices.get(0).getLabel());
        Assert.assertEquals(this.expectedClassicQuestionChoiceB, choices.get(1).getLabel());
        Assert.assertEquals(this.expectedClassicQuestionChoiceC, choices.get(2).getLabel());
        Assert.assertEquals(this.expectedClassicQuestionChoiceD, choices.get(3).getLabel());
        Assert.assertTrue(choices.get(0).isSelected());
        Assert.assertFalse(choices.get(1).isSelected());
        Assert.assertFalse(choices.get(2).isSelected());
        Assert.assertFalse(choices.get(3).isSelected());
    }


    @Test
    public void testExtractChoicesFromAssertionToComplete() {
        final MCQChoiceExtractor choiceExtractor = new MCQChoiceExtractor();
        final List<ExtractedChoice> choices = choiceExtractor.extract(ExtractedSampleQuestions.ASSERTION_TO_COMPLETE_FULL_EXTRACTION.getExtractedQuestionLabel());
        Assert.assertEquals(4, choices.size());
        Assert.assertEquals(this.expectedAssertionChoiceA, choices.get(0).getLabel());
        Assert.assertEquals(this.expectedAssertionChoiceB, choices.get(1).getLabel());
        Assert.assertEquals(this.expectedAssertionChoiceC, choices.get(2).getLabel());
        Assert.assertEquals(this.expectedAssertionChoiceD, choices.get(3).getLabel());
        Assert.assertFalse(choices.get(0).isSelected());
        Assert.assertFalse(choices.get(1).isSelected());
        Assert.assertFalse(choices.get(2).isSelected());
        Assert.assertTrue(choices.get(3).isSelected());
    }
}
