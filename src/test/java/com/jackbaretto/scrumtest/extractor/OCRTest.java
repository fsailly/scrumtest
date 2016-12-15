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

    private static final int HQ_CHARACTER_COUNT = 999;

    @Test
    public void recognitionCountTest() {
        final ExtractionParameters extractionParameters = new ExtractionParameters(getSampleMCQUrl());
        final MCQExtractor mcqExtractor = new MCQExtractor();
        final List<ExtractionResult> extractionResults = mcqExtractor.extractMCQ(extractionParameters);
        final ExtractionResult sampleMCQResult = extractionResults.get(0);
        Assert.assertEquals(HQ_CHARACTER_COUNT, sampleMCQResult.getRecognizedCharacters().length());
    }

    /**
     * @return MCQ picture from Resource folder
     */
    private static String getSampleMCQUrl() {
        final URL mcqUrl = OCRTest.class.getResource("samples/HQ-mcq.png");
        return mcqUrl.getFile();
    }
}
