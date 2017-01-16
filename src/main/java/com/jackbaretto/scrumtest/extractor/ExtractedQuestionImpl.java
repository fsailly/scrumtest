package com.jackbaretto.scrumtest.extractor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by mehdi on 11/01/17.
 */
public class ExtractedQuestionImpl implements ExtractedQuestion {
    private String label;
    private QuestionType type;

    ExtractedQuestionImpl(String aLabel, QuestionType aType) {
        label = aLabel;
        type = aType;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public QuestionType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
       return  HashCodeBuilder.reflectionHashCode(this);
    }
}
