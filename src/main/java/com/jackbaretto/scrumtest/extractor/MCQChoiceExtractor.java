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

    private static final int MINIMUM_CHOICE_LENGHT = 10;
    private static final String EACH_CHOICE_PARSER = ".+?\\.";
    private static final String CHOICE_FINDER = "[A-Z]\\)";
    private static final int TEXT_BEFORE_CHOICES_INDEX = 0;

    /**
     * Extract a list of {@link ExtractedChoice} from String.
     *
     * @param extraction String which contains a question.
     * @return result {@link ExtractionResult}
     */
    List<ExtractedChoice> extract(final String extraction) {
        final String[] choicesLabel = extraction.split(CHOICE_FINDER);
        final String[] cleanedLabels = ArrayUtils.remove(choicesLabel, TEXT_BEFORE_CHOICES_INDEX);
        final List<ExtractedChoice> choices = new ArrayList();
        for (final String eachChoiceLabel : cleanedLabels) {
            final Pattern cleanerPattern = Pattern.compile(EACH_CHOICE_PARSER, Pattern.DOTALL);
            final Matcher dirtyQuestionMatcher = cleanerPattern.matcher(eachChoiceLabel);
            final StringBuilder finalChoiceLabel = new StringBuilder();
            while (dirtyQuestionMatcher.find()) {
                final String unfilteredLabel = dirtyQuestionMatcher.group();
                if (unfilteredLabel.length() > MINIMUM_CHOICE_LENGHT) {
                    finalChoiceLabel.append(unfilteredLabel);
                }
            }
            choices.add(new ExtractedChoiceImpl(finalChoiceLabel.toString().trim()));
        }
        return choices;
    }
}
