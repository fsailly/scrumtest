package com.jackbaretto.scrumtest.extractor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by mehdi on 12/01/17.
 */
public class ExtractedChoiceImpl implements ExtractedChoice {
    private final String label;

    private boolean selected;

    ExtractedChoiceImpl(final String choiceLabel, final boolean selectedChoice) {
        this.label = choiceLabel;
        this.selected = selectedChoice;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
       return  HashCodeBuilder.reflectionHashCode(this);
    }
}
