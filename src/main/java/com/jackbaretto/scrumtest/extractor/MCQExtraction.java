package com.jackbaretto.scrumtest.extractor;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;
import java.net.URL;

/**
 * Extract the MCQ from screenshots
 * <p>
 * Created by florentsailly on 07/12/2016.
 */
public class MCQExtraction {

    public static void main(String[] args) {

        final ITesseract ocr = createOcr();
        final File mcqPicture = getSampleMCQ();

        try {
            String recognizedCharacters = ocr.doOCR(mcqPicture);
            System.out.println(recognizedCharacters);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     *
     * @return MCQ picture from Resource folder
     */
    private static File getSampleMCQ() {
        URL mcqUrl = MCQExtraction.class.getResource("sample-mcq.png");
        return new File(mcqUrl.getFile());
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