package com.jackbaretto.scrumtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Extract the MCQ from screenshots. To run this class properly, you need to get the right Tesserect library (C++) built for your OS.
 * It wrapped in the tess4j dependency only for windows 7 x86/x64, as DLL.
 * More information about this library at https://github.com/tesseract-ocr/tesseract/wiki/Compiling
 * <p>
 * Created by florentsailly on 07/12/2016.
 */
@SpringBootApplication
public class MCQExtraction {

    public static void main(String[] args) {
        SpringApplication.run(MCQExtraction.class, args);
    }

}
