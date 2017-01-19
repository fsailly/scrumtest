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
 */
public class QuestionMapper {

    public static final Map<QuestionType, AnswerConstraint> QUESTION_TYPE_CONVERTER =new HashMap();

    static {
        QUESTION_TYPE_CONVERTER.put(QuestionType.ALL_THAT_APPLY, AnswerConstraint.ALL_THAT_APPLY);
        QUESTION_TYPE_CONVERTER.put(QuestionType.ONE_RESPONSE, AnswerConstraint.ONE_RESPONSE);
        QUESTION_TYPE_CONVERTER.put(QuestionType.N_RESPONSE, AnswerConstraint.N_RESPONSES);
    }


    private static Question map(ExtractedQuestionImpl extractedQuestion) {
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
     * Map an extractedQuestion into {@link Question}.
     * @param extractedQuestions
     * @return a set of question
     */
    public static Set<Question> map(Iterable<ExtractedQuestionImpl> extractedQuestions){
        final Set<Question> questions = new HashSet();
        for (ExtractedQuestionImpl extractedQuestion:extractedQuestions) {
            questions.add(map(extractedQuestion));
        }
        return questions;
    }
}
