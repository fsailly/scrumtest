package com.jackbaretto.scrumtest.extractor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Encapsulates the result of an OCR extraction
 * Created by florentsailly on 15/12/2016.
 */
@Entity
public class ExtractionResult implements Serializable{

    static final ExtractionResult EMPTY = new ExtractionResult("");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition="TEXT")
    private String recognizedCharacters;

    protected ExtractionResult(){

    }

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


    @Override
    public String toString() {
        return "ExtractionResult : "+recognizedCharacters;
    }

}
