package com.jackbaretto.scrumtest.extractor;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * In charge of MCQ choice extraction.
 *
 * Created by mehdi on 12/01/17.
 */
public class MCQChoiceExtractor {

    /**
     * Extract a list of {@link ExtractedChoice} from String.
     *
     * @param extraction String which contains a question.
     * @return result {@link ExtractionResult}
     */
    public List<ExtractedChoice> extract(String extraction) {
        String[] choicesLabel = extraction.split("[A-Z]\\)");
        String[] cleanedLabels = ArrayUtils.remove(choicesLabel,0);
        List<ExtractedChoice> choices = new ArrayList();
        for (String eachChoiceLabel: cleanedLabels) {
            choices.add(new ExtractedChoiceImpl(eachChoiceLabel.trim()));
        }
        return choices;
    }
}
