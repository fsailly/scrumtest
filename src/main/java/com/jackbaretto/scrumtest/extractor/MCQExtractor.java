package com.jackbaretto.scrumtest.extractor;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by florentsailly on 13/12/2016.
 */
public class MCQExtractor {

    private final ITesseract ocr = createOcr();

    public MCQExtractor() {
    }

    public List<ExtractionResult> extractMCQ(ExtractionParameters extractionParameters) {
        List<ExtractionResult> extractionResults = new ArrayList<ExtractionResult>();
        for (File mcqPicture : extractionParameters.getMcqPictures()) {
            final ExtractionResult recognizedMcq = this.recognizeCharacters(mcqPicture);
            extractionResults.add(recognizedMcq);
        }
        return extractionResults;
    }

    private ExtractionResult recognizeCharacters(File mcqPicture) {
        try {
            // TODO : faire un test sur la reconnaissance de N caractères ??
            final String recognizeCharacters = this.ocr.doOCR(mcqPicture);
            Logger.getLogger(MCQExtractor.class.getName()).info(recognizeCharacters);
            return new ExtractionResult(recognizeCharacters);
        } catch (TesseractException e) {
            Logger.getLogger(MCQExtractor.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return ExtractionResult.EMPTY;
    }

    /**
     * Instanciates the OCR
     */
    private static ITesseract createOcr() {

        //JNA Interface Mapping
        ITesseract ocr = new Tesseract();


        //You either set your own tessdata folder with your custom language pack or
        //use LoadLibs to load the default tessdata folder for you.
        //This is mandatory to provide one !!

        ocr.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
        return ocr;
    }
}
