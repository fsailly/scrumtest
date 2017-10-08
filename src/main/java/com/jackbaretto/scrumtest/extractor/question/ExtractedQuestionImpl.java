package com.jackbaretto.scrumtest.extractor.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jackbaretto.scrumtest.extractor.choice.ExtractedChoiceImpl;
import com.jackbaretto.scrumtest.extractor.type.QuestionType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehdi on 11/01/17.
 */
@Entity
@Table(name = "QUESTION")
public class ExtractedQuestionImpl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;
    @JsonProperty
    @Column(length = 5000)
    private String label;
    @JsonProperty
    private QuestionType type;
    @JsonProperty
    /** Check if a question is valid. A valid question doesn't contain special character (ie : '|','[') in words.*/
    private boolean valid = false;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = ExtractedChoiceImpl.class)
    private List<ExtractedChoiceImpl> choices = new ArrayList();

    private ExtractedQuestionImpl() {
    }


    ExtractedQuestionImpl(String aLabel, QuestionType aType) {
        label = aLabel;
        type = aType;
    }

    public String getLabel() {
        return label;
    }

    public QuestionType getType() {
        return type;
    }

    public void addChoices(List<ExtractedChoiceImpl> newChoices) {
        choices.addAll(newChoices);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtractedQuestionImpl that = (ExtractedQuestionImpl) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public List<ExtractedChoiceImpl> getChoices() {
        return choices;
    }
}
