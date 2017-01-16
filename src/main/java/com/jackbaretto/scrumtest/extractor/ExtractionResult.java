package com.jackbaretto.scrumtest.extractor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


}
