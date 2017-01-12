package com.jackbaretto.scrumtest.extractor;

/**
 * Created by mehdi on 11/01/17.
 */
public class ExtractedQuestionImpl implements ExtractedQuestion {
    private String label;

    ExtractedQuestionImpl(String aLabel) {
        label = aLabel;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        ExtractedQuestionImpl that = (ExtractedQuestionImpl) o;

        return label != null ? label.equals(that.label) : that.label == null;
    }

    @Override
    public int hashCode() {
        return label != null ? label.hashCode() : 0;
    }
}
