package com.jackbaretto.scrumtest.extractor;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In charge of MCQ choice extraction.
 * <p>
 * Created by mehdi on 12/01/17.
 */
class MCQChoiceExtractor {
    /**
     * a Fix to remove undesired characters at the end of the choices labels
     */
    private static final int MINIMUM_SENTENCE_LENGHT = 10;
    private static final String CHOICE_SENTENCES_PARSER = ".+?\\.";
    private static final String CHOICE_FINDER = "[A-Z]\\)";
    private static final int CHOICES_START_INDEX = 0;
    private static final int SELECTED_CHOICE_BEGIN_INDEX = 2;
    private static final int NO_SELECTION_FOUND = 1;
    private static final String FIND_SELECTION_PATTERN = "^\\s[\\.0I]\\s";

    /**
     * Extract a list of {@link ExtractedChoice} from String.
     *
     * @param extraction String which contains a question.
     * @return result {@link ExtractionResult}
     */
    List<ExtractedChoice> extract(final String extraction) {
        final String[] choicesRawLabels = removeQuestionHeader(extraction);
        final List<ExtractedChoice> extractedChoices = new ArrayList();
        for (String eachChoiceRawLabel : choicesRawLabels) {
            final boolean selected = detectIfSelected(eachChoiceRawLabel);
            if (selected) {
                eachChoiceRawLabel = eachChoiceRawLabel.substring(SELECTED_CHOICE_BEGIN_INDEX);
            }
            final String choiceCleanLabel = cleanChoiceLabel(eachChoiceRawLabel);
            extractedChoices.add(new ExtractedChoiceImpl(choiceCleanLabel.trim(), selected));
        }
        return extractedChoices;
    }

    /**
     * Clean the choice label by reconstructing correct sentences
     *
     * @param choiceRawLabel choice label to be cleaned
     * @return a cleaned choice label
     */
    private String cleanChoiceLabel(final String choiceRawLabel) {
        final Pattern sentencesPattern = Pattern.compile(CHOICE_SENTENCES_PARSER, Pattern.DOTALL);
        final Matcher sentencesMatcher = sentencesPattern.matcher(choiceRawLabel);
        final StringBuilder finalChoiceLabel = new StringBuilder();
        while (sentencesMatcher.find()) {
            final String unfilteredLabel = sentencesMatcher.group();
            if (unfilteredLabel.length() > MINIMUM_SENTENCE_LENGHT) {
                finalChoiceLabel.append(unfilteredLabel);
            }
        }
        return finalChoiceLabel.toString();
    }

    /**
     * Remove what's before the choices
     *
     * @param extraction the raw extracted text
     * @return the table of choices
     */
    private String[] removeQuestionHeader(final String extraction) {
        final String[] choicesLabel = extraction.split(CHOICE_FINDER);
        return ArrayUtils.remove(choicesLabel, CHOICES_START_INDEX);
    }

    /**
     * Indicates if the choice is selected
     *
     * @param rawChoiceLabel the label to be tested
     * @return the selection state
     */
    private boolean detectIfSelected(final String rawChoiceLabel) {
        final int splitResult = rawChoiceLabel.split(FIND_SELECTION_PATTERN).length;
        return splitResult != NO_SELECTION_FOUND;
    }
}
