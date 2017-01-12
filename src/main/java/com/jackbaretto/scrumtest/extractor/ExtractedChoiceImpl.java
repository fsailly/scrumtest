package com.jackbaretto.scrumtest.extractor;

/**
 * Created by mehdi on 12/01/17.
 */
public class ExtractedChoiceImpl implements ExtractedChoice {
    private final String label;

    public ExtractedChoiceImpl(String choiceLabel) {
        label = choiceLabel;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExtractedChoiceImpl that = (ExtractedChoiceImpl) o;

        return label != null ? label.equals(that.label) : that.label == null;
    }

    @Override
    public int hashCode() {
        return label != null ? label.hashCode() : 0;
    }
}
