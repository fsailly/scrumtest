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
}
