package com.jackbaretto.scrumtest.extractor.question;

import com.jackbaretto.scrumtest.extractor.choice.MCQChoiceExtractor;
import com.jackbaretto.scrumtest.extractor.type.QuestionTypeExtractor;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In charge of MCQ extraction from image files
 * Created by florentsailly on 13/12/2016.
 */
@Component
public class MCQExtractor {

    private final ITesseract ocr = createOcr();
    @Autowired
    private MCQQuestionExtractor mcqQuestionExtractor;
    @Autowired
    private MCQChoiceExtractor mcqChoiceExtractor;
    @Autowired
    private QuestionTypeExtractor questionTypeExtractor;


    public List<ExtractedQuestionImpl> extractMCQ(final ExtractionParameters extractionParameters) {
        final List<ExtractedQuestionImpl> extractionResults = new ArrayList();
        for (final File mcqPicture : extractionParameters.getMcqPictures()) {
            final String recognizedMcq = this.recognizeCharacters(mcqPicture);
            ExtractedQuestionImpl question = mcqQuestionExtractor.extract(recognizedMcq);
            question.addChoices(mcqChoiceExtractor.extract(recognizedMcq));
            extractionResults.add(question);
        }
        return extractionResults;
    }

    private String recognizeCharacters(final File mcqPicture) {
        try {
            return  this.ocr.doOCR(mcqPicture);
        } catch (final TesseractException e) {
            Logger.getLogger(MCQExtractor.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return StringUtils.EMPTY;
    }

    /**
     * Instanciates the OCR
     */
    private ITesseract createOcr() {
        //JNA Interface Mapping
        final ITesseract opticalCharacterRecognition = new Tesseract();

        //You either set your own tessdata folder with your custom language pack or
        //use LoadLibs to load the default tessdata folder for you.
        //This is mandatory to provide one !!

        opticalCharacterRecognition.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
        return opticalCharacterRecognition;
    }
}
