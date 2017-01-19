package com.jackbaretto.scrumtest.extractor.question;

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
    private Long id;
    @Column(unique = true)
    private String label;
    private QuestionType type;
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
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
       return  HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public List<ExtractedChoiceImpl> getChoices() {
        return choices;
    }
}
