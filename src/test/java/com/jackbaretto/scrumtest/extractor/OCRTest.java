package com.jackbaretto.scrumtest.extractor;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.List;

/**
 * This class tests the constancy of the tesseract recognition.
 * Created by florentsailly on 09/12/2016.
 */
public class OCRTest {

    private static final int HQ_CHARACTER_COUNT_LINUX = 999;
    private static final int HQ_CHARACTER_COUNT_MAC = 1001;

    @Test
    public void recognitionCountTest() {
        final int expectedCharacterCount = getExpectedCharacterCount();
        final ExtractionParameters extractionParameters = new ExtractionParameters(getSampleMCQUrl());
        final MCQExtractor mcqExtractor = new MCQExtractor();
        final List<ExtractionResult> extractionResults = mcqExtractor.extractMCQ(extractionParameters);
        final ExtractionResult sampleMCQResult = extractionResults.get(0);
        Assert.assertEquals(expectedCharacterCount, sampleMCQResult.getRecognizedCharacters().length());
    }

    private int getExpectedCharacterCount() {
        if (OSUtils.isUnix()) {
            return HQ_CHARACTER_COUNT_LINUX;
        } else if (OSUtils.isMac()) {
            return HQ_CHARACTER_COUNT_MAC;
        }
        return 0;
    }

    /**
     * @return MCQ picture from Resource folder
     */
    private static String getSampleMCQUrl() {
        return OCRTest.class.getResource("samples/HQ-mcq.png").getPath();
    }
}
