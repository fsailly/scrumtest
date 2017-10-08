package com.jackbaretto.scrumtest.extractor.choice;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by mehdi on 12/01/17.
 */
@Entity
@Table(name = "Choice")
public class ExtractedChoiceImpl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 5000)
    private String label;

    private boolean selected;

    private ExtractedChoiceImpl() {
    }

    public ExtractedChoiceImpl(final String choiceLabel, final boolean selectedChoice) {
        this.label = choiceLabel;
        this.selected = selectedChoice;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtractedChoiceImpl that = (ExtractedChoiceImpl) o;

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
}
