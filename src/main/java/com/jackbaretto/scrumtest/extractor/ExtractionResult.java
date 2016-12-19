package com.jackbaretto.scrumtest.extractor;

/**
 * Encapsulates the result of an OCR extraction
 * Created by florentsailly on 15/12/2016.
 */
public class ExtractionResult {

    static final ExtractionResult EMPTY = new ExtractionResult("");

    private final String recognizedCharacters;

    public ExtractionResult(final String recognizedCharacters) {

        this.recognizedCharacters = recognizedCharacters;
    }

    public String getRecognizedCharacters() {
        return this.recognizedCharacters;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ExtractionResult that = (ExtractionResult) o;

        return this.recognizedCharacters != null ? this.recognizedCharacters.equals(that.recognizedCharacters) : that.recognizedCharacters == null;
    }

    @Override
    public int hashCode() {

        return this.recognizedCharacters != null ? this.recognizedCharacters.hashCode() : 0;
    }
}
