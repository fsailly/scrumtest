package com.jackbaretto.scrumtest.extractor.question;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;
import com.baretto.mcq.datamodel.internals.ChoiceImpl;
import com.baretto.mcq.datamodel.internals.QuestionImpl;
import com.jackbaretto.scrumtest.extractor.choice.ExtractedChoiceImpl;
import com.jackbaretto.scrumtest.extractor.type.QuestionType;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by mehdi on 18/01/17.
 */
public class QuestionMapperTest {

    @Test
    public void testMapExtractedQuestionIntoQuestion() {
        ExtractedQuestionImpl extractedQuestion = createExtractedQuestion();
        Set<Question> mappedQuestions = QuestionMapper.mapExtractedQuestionIntoQuestion(Arrays.asList(extractedQuestion));

        Question expectedQuestion = createQuestion();

        Assert.assertEquals(1, mappedQuestions.size());
        Question mappedQuestion = mappedQuestions.iterator().next();
        Assert.assertEquals(expectedQuestion, mappedQuestion);

    }

    @Test
    public void testMapExtractedQuestionIntoQuestionDTO() {
        ExtractedQuestionImpl extractedQuestion = createExtractedQuestion();
        Set<ExtractedQuestionImpl> unvalidateQuestions = new HashSet();
        unvalidateQuestions.add(extractedQuestion);
        Set<QuestionDTO> mappedQuestions = QuestionMapper.mapExtractedQuestionIntoQuestionDTO(unvalidateQuestions);

        QuestionDTO expectedQuestionDTO = createQuestionDTO();

        Assert.assertEquals(1, mappedQuestions.size());
        QuestionDTO mappedQuestion = mappedQuestions.iterator().next();
        Assert.assertEquals(expectedQuestionDTO, mappedQuestion);

    }

    private QuestionDTO createQuestionDTO() {
        final ChoiceDTO choiceA = new ChoiceDTO("Without exception.", false);
        final ChoiceDTO choiceB = new ChoiceDTO("Whenever the product is free of defects.", false);
        final ChoiceDTO choiceC = new ChoiceDTO("To make sure the Deve|opment Team is done every Sprint.", false);
        final ChoiceDTO choiceD = new ChoiceDTO("When it makes sense.", true);


        final Set<ChoiceDTO> choices = new HashSet();
        choices.add(choiceA);
        choices.add(choiceB);
        choices.add(choiceC);
        choices.add(choiceD);


        String questionLabel = "The Product Owner must reIease each Increment to production.";
        return new QuestionDTO(questionLabel, choices, AnswerConstraint.ONE_RESPONSE);
    }

    private ExtractedQuestionImpl createExtractedQuestion() {
        final ExtractedQuestionImpl extractedQuestion = new ExtractedQuestionImpl("The Product Owner must reIease each Increment to production.", QuestionType.ONE_RESPONSE);
        List<ExtractedChoiceImpl> choices = new ArrayList();
        choices.add(new ExtractedChoiceImpl("Without exception.", false));
        choices.add(new ExtractedChoiceImpl("Whenever the product is free of defects.", false));
        choices.add(new ExtractedChoiceImpl("To make sure the Deve|opment Team is done every Sprint.", false));
        choices.add(new ExtractedChoiceImpl("When it makes sense.", true));
        extractedQuestion.addChoices(choices);
        return extractedQuestion;
    }

    private Question createQuestion() {
        final Choice choiceA = new ChoiceImpl("Without exception.", false);
        final Choice choiceB = new ChoiceImpl("Whenever the product is free of defects.", false);
        final Choice choiceC = new ChoiceImpl("To make sure the Deve|opment Team is done every Sprint.", false);
        final Choice choiceD = new ChoiceImpl("When it makes sense.", true);


        final Set<Choice> choices = new HashSet();
        choices.add(choiceA);
        choices.add(choiceB);
        choices.add(choiceC);
        choices.add(choiceD);

        final Set<Choice> correctChoices = new HashSet();
        correctChoices.add(choiceD);

        String questionLabel = "The Product Owner must reIease each Increment to production.";
        return new QuestionImpl(questionLabel, choices, correctChoices, AnswerConstraint.ONE_RESPONSE);
    }


}
