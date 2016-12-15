package com.jackbaretto.scrumtest.extractor;

import java.util.List;
import java.util.logging.Logger;

/**
 * Extract the MCQ from screenshots. To run this class properly, you need to get the right Tesserect library (C++) built for your OS.
 * It wrapped in the tess4j dependency only for windows 7 x86/x64, as DLL.
 * More information about this library at https://github.com/tesseract-ocr/tesseract/wiki/Compiling
 * <p>
 * Created by florentsailly on 07/12/2016.
 */
public class MCQExtraction {

    /**
     * This lauching Argument contains the MCQ file or folder URL
     */
    private static final int MCQ_FILE_ARG = 0;

    private MCQExtraction() {
        throw new IllegalAccessError("Utility class");
    }

    public static void main(final String[] args) {
        final ExtractionParameters extractionParameters = new ExtractionParameters(args[MCQ_FILE_ARG]);
        final MCQExtractor mcqExtractor = new MCQExtractor();
        final List<ExtractionResult> extractionResults = mcqExtractor.extractMCQ(extractionParameters);
        Logger.getLogger(MCQExtraction.class.getName()).info("Mcq count : " + extractionResults.size());
    }

}
