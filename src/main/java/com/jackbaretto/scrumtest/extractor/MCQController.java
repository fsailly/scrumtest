package com.jackbaretto.scrumtest.extractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehdi on 14/12/16.
 */
@RestController
@RequestMapping(value = "mcq")
public class MCQController {

    @Autowired
    private MCQService mcqService;
    @Autowired
    private MCQExtractor extractor;

    @RequestMapping(value = "/test")
    public void test() throws IOException {
        List<ExtractionResult> mcqs = new ArrayList<ExtractionResult>();
        ClassPathResource classPathResource = new ClassPathResource("/com/jackbaretto/scrumtest/extractor/samples");
        String url = classPathResource.getURL().getPath();
        mcqs.addAll(extractor.extractMCQ(new ExtractionParameters(url)));
        mcqService.save(mcqs);
    }

    @RequestMapping(value = "/findAll")
    public Iterable<ExtractionResult> findAll() {
        return mcqService.findAll();
    }
}
