package com.jackbaretto.scrumtest.extractor;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ExtractedChoiceImpl that = (ExtractedChoiceImpl) o;

        if (this.selected != that.selected) return false;
        return this.label != null ? this.label.equals(that.label) : that.label == null;
    }

    @Override
    public int hashCode() {
        int result = this.label != null ? this.label.hashCode() : 0;
        result = 31 * result + (this.selected ? 1 : 0);
        return result;
    }
}
