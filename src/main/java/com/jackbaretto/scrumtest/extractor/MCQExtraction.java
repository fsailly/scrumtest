package com.jackbaretto.scrumtest.extractor;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Extract the MCQ from screenshots. To run this class properly, you need to get the right Tesserect library (C++) built for your OS.
 * It wrapped in the tess4j dependency only for windows 7 x86/x64, as DLL.
 * More information about this library at https://github.com/tesseract-ocr/tesseract/wiki/Compiling
 * <p>
 * Created by florentsailly on 07/12/2016.
 */
public class MCQExtraction {

    private MCQExtraction() {
        throw new IllegalAccessError("Utility class");
    }

    public static void main(String[] args) {

        final ITesseract ocr = createOcr();
        final File mcqPicture = getSampleMCQ();

        try {
            // TODO : faire un test sur la reconnaissance de N caractères ??
            String recognizedCharacters = ocr.doOCR(mcqPicture);
            Logger.getLogger(MCQExtraction.class.getName()).info(recognizedCharacters);
        } catch (TesseractException e) {
            Logger.getLogger(MCQExtraction.class.getName()).log(Level.SEVERE,e.getMessage(),e);
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
