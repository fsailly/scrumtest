package com.jackbaretto.scrumtest.extractor.question;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.jackbaretto.scrumtest.extractor.question.ChoiceDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

/**
 *
 * Created by mehdi on 24/01/17.
 */
public class QuestionDTO {
    private final String label;
    private final Set<ChoiceDTO> choices;

    private final AnswerConstraint answerConstraint;

    public QuestionDTO(String questionLabel, Set<ChoiceDTO> theChoices, AnswerConstraint aConstraint) {
        this.label = questionLabel;
        this.choices = theChoices;
        this.answerConstraint = aConstraint;
    }

    public String getLabel() {
        return label;
    }

    public Set<ChoiceDTO> getChoices() {
        return choices;
    }

    public AnswerConstraint getAnswerConstraint() {
        return answerConstraint;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
