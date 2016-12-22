package com.jackbaretto.scrumtest.extractor;

import com.jackbaretto.scrumtest.MCQExtraction;

import java.net.URL;

/**
 * This class tests the constancy of the tesseract recognition.
 * Created by florentsailly on 09/12/2016.
 */
public class ExtractionLauncher {


    public void launch() {
        MCQExtraction.main(new String[]{getSampleMCQUrl()});
    }

    /**
     * @return MCQ picture from Resource folder
     */
    private static String getSampleMCQUrl() {
        final URL mcqUrl = ExtractionLauncher.class.getResource("samples");
        return mcqUrl.getFile();
    }
}
