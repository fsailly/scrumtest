package com.jackbaretto.scrumtest.extractor.question;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by mehdi on 24/01/17.
 */
public class ChoiceDTO {
    private final boolean isValid;
    private final String label;

    public ChoiceDTO(String aLabel, boolean choiceIsValid) {
        this.label = aLabel;
        this.isValid=choiceIsValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getLabel() {
        return label;
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
