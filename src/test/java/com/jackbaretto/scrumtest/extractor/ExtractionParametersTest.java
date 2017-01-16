package com.jackbaretto.scrumtest.extractor;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Set;

/**
 * Created by mehdi on 26/12/16.
 */
public class ExtractionParametersTest {

    @Test
    public void testGetMCQPictures() throws Exception {
        final String url = ExtractionParametersTest.class.getResource("samples").getPath();
        ExtractionParameters extractionParameters = new ExtractionParameters(url);


        Set<File> pictures = extractionParameters.getMcqPictures();
        Assert.assertEquals(8, pictures.size());
        for (File eachPicture : pictures) {
            Assert.assertTrue(eachPicture.getName().endsWith(".png"));
        }
    }

}