package com.jackbaretto.scrumtest.extractor;

/**
 * Created by florentsailly on 15/12/2016.
 */
public class ExtractionResult {

    static final ExtractionResult EMPTY = new ExtractionResult("");

    private final String recognizedCharacters;

    public ExtractionResult(final String recognizedCharacters) {
        this.recognizedCharacters = recognizedCharacters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtractionResult that = (ExtractionResult) o;

        return recognizedCharacters != null ? recognizedCharacters.equals(that.recognizedCharacters) : that.recognizedCharacters == null;
    }

    @Override
    public int hashCode() {
        return recognizedCharacters != null ? recognizedCharacters.hashCode() : 0;
    }
}
