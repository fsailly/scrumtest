package com.jackbaretto.scrumtest.extractor.question;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;
import com.baretto.mcq.datamodel.internals.ChoiceImpl;
import com.baretto.mcq.datamodel.internals.QuestionImpl;
import com.jackbaretto.scrumtest.extractor.choice.ExtractedChoiceImpl;
import com.jackbaretto.scrumtest.extractor.type.QuestionType;

import java.util.*;

/**
 * In charge of transform {@link ExtractedQuestionImpl} into {@link Question}.
 * <p>
 * Created by mehdi on 18/01/17.
 *
 * @TODO Mehdi 24/01:2017 : This 2 mapping are similars !!!
 */
public class QuestionMapper {

    public static final Map<QuestionType, AnswerConstraint> QUESTION_TYPE_CONVERTER =new HashMap();

    static {
        QUESTION_TYPE_CONVERTER.put(QuestionType.ALL_THAT_APPLY, AnswerConstraint.ALL_THAT_APPLY);
        QUESTION_TYPE_CONVERTER.put(QuestionType.ONE_RESPONSE, AnswerConstraint.ONE_RESPONSE);
        QUESTION_TYPE_CONVERTER.put(QuestionType.N_RESPONSE, AnswerConstraint.N_RESPONSES);
    }


    /**
     * Map an {@link ExtractedQuestionImpl} into {@link Question}.
     * @param extractedQuestions
     * @return a set of question
     */
    public static Set<Question> mapExtractedQuestionIntoQuestion(Iterable<ExtractedQuestionImpl> extractedQuestions){
        final Set<Question> questions = new HashSet();
        for (ExtractedQuestionImpl extractedQuestion:extractedQuestions) {
            questions.add(mapExtractedQuestionIntoQuestion(extractedQuestion));
        }
        return questions;
    }
    private static Question mapExtractedQuestionIntoQuestion(ExtractedQuestionImpl extractedQuestion) {
        final Set<Choice> choices = new HashSet();
        final Set<Choice> correctChoices = new HashSet();
        for (ExtractedChoiceImpl extractedChoice : extractedQuestion.getChoices()) {
            boolean isCorrectChoice = extractedChoice.isSelected();
            final ChoiceImpl choice = new ChoiceImpl(extractedChoice.getLabel(), isCorrectChoice);
            choices.add(choice);
            if(isCorrectChoice){
                correctChoices.add(choice);
            }
        }
        AnswerConstraint answerConstraint = QUESTION_TYPE_CONVERTER.get(extractedQuestion.getType());
        return new QuestionImpl(extractedQuestion.getLabel(), choices, correctChoices, answerConstraint);
    }



    /**
     * Map an {@link ExtractedQuestionImpl} into {@link QuestionDTO}.
     * @param unvalidateQuestions
     * @return a set of question {@link QuestionDTO}
     */
    public static Set<QuestionDTO> mapExtractedQuestionIntoQuestionDTO(Set<ExtractedQuestionImpl> unvalidateQuestions) {
        final Set<QuestionDTO> questions = new HashSet();
        for (ExtractedQuestionImpl unvalidateExtractedQuestion:unvalidateQuestions) {
            questions.add(mapExtractedQuestionIntoQuestionDTO(unvalidateExtractedQuestion));
        }
        return questions;
    }

    private static QuestionDTO mapExtractedQuestionIntoQuestionDTO(ExtractedQuestionImpl unvalidateQuestion) {
        final Set<ChoiceDTO> choices = new HashSet();
        for (ExtractedChoiceImpl extractedChoice : unvalidateQuestion.getChoices()) {
            boolean isCorrectChoice = extractedChoice.isSelected();
            final ChoiceDTO choice = new ChoiceDTO(extractedChoice.getLabel(), isCorrectChoice);
            choices.add(choice);

        }
        AnswerConstraint answerConstraint = QUESTION_TYPE_CONVERTER.get(unvalidateQuestion.getType());
        return new QuestionDTO(unvalidateQuestion.getLabel(), choices, answerConstraint);
    }
}
