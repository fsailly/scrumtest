package com.jackbaretto.scrumtest.extractor.question;

import com.jackbaretto.scrumtest.extractor.type.QuestionType;
import com.jackbaretto.scrumtest.extractor.type.QuestionTypeExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In charge of MCQ question extraction.
 * <p>
 * Created by mehdi on 11/01/17.
 */
@Component
public class MCQQuestionExtractor {


    /**
     * The question pattern is defined as following :
     * - starts one character after the question number written followed by a right parenthesis.
     * - finishes at the first punctuaction character found before the first "Bookmark" found after the question start.
     */
    private static final String DIRTY_QUESTION_PATTERN = "([0-9]+\\).*?)(?=Bookmark)";

    /**
     * Clean undesired extra characters added after the end of the question by the OCR
     */
    private static final String QUESTION_CLEANER_PATTERN = ".*[\\.\\:\\?]+";
    @Autowired
    private QuestionTypeExtractor questionTypeExtractor;

    /**
     * Extract question from String.
     *
     * @param extraction String which contains a question.
     * @return result {@link ExtractionResult}
     */
    ExtractedQuestionImpl extract(final String extraction) {
        final String dirtyLabel = extractDirtyLabel(extraction);
        final String cleanLabel = cleanLabel(dirtyLabel);
        final QuestionType questionType = questionTypeExtractor.extract(extraction);
        return new ExtractedQuestionImpl(cleanLabel,questionType);

    }



    private String cleanLabel(final String dirtyLabel) {
        final Pattern questionCleanerPattern = Pattern.compile(QUESTION_CLEANER_PATTERN, Pattern.DOTALL);
        final Matcher questionCleanerMatcher = questionCleanerPattern.matcher(dirtyLabel);
        if (questionCleanerMatcher.find()) {
            return questionCleanerMatcher.group(0);
        }
        throw new QuestionNotFoundException();
    }

    private String extractDirtyLabel(final String extract) {
        final Pattern dirtyQuestionPattern = Pattern.compile(DIRTY_QUESTION_PATTERN, Pattern.DOTALL);
        final Matcher dirtyQuestionMatcher = dirtyQuestionPattern.matcher(extract);
        final String unfilteredLabel;
        if (dirtyQuestionMatcher.find()) {
            unfilteredLabel = dirtyQuestionMatcher.group(1);
            final String largeQuestionLabel = unfilteredLabel.split("\\)")[1];
            return largeQuestionLabel.trim();
        }
        throw new QuestionNotFoundException();
    }
}
