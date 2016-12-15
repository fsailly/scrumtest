package com.jackbaretto.scrumtest.extractor;

import java.net.URL;

/**
 * This class tests the constancy of the tesseract recognition.
 * Created by florentsailly on 09/12/2016.
 */
public class ExtractionTest {


    public void recognitionTest() {
        MCQExtraction.main(new String[]{getSampleMCQUrl()});
    }

    /**
     * @return MCQ picture from Resource folder
     */
    private static String getSampleMCQUrl() {
        URL mcqUrl = ExtractionTest.class.getResource("samples");
        return mcqUrl.getFile();
    }
}
