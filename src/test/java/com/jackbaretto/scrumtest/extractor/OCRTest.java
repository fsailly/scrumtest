package com.jackbaretto.scrumtest.extractor;

import com.jackbaretto.scrumtest.extractor.choice.MCQChoiceExtractor;
import com.jackbaretto.scrumtest.extractor.question.*;
import com.jackbaretto.scrumtest.extractor.type.QuestionTypeExtractorImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * This class tests the constancy of the tesseract recognition.
 * Created by florentsailly on 09/12/2016.https://github.com/djakpat/PlatiniumQuiz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MCQExtractor.class,QuestionTypeExtractorImpl.class, MCQQuestionExtractor.class , MCQChoiceExtractor.class})
@EnableConfigurationProperties
public class OCRTest {

    private static final int HQ_CHARACTER_COUNT_LINUX = 999;
    private static final int HQ_CHARACTER_COUNT_MAC = 1001;
    @Autowired
    private MCQExtractor mcqExtractor;
    @Test
    public void recognitionCountTest() {
        final ExtractionParameters extractionParameters = new ExtractionParameters(getSampleMCQUrl());

        final List<ExtractedQuestionImpl> extractedQuestions = mcqExtractor.extractMCQ(extractionParameters);
        final ExtractedQuestionImpl question = extractedQuestions.get(0);
        Assert.assertEquals(60, question.getLabel().length());
    }


    /**
     * @return MCQ picture from Resource folder
     */
    private static String getSampleMCQUrl() {
        return OCRTest.class.getResource("samples/HQ-mcq.png").getPath();
    }
}
