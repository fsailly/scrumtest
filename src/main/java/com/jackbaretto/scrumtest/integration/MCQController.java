package com.jackbaretto.scrumtest.integration;

import com.baretto.mcq.datamodel.Question;
import com.jackbaretto.scrumtest.extractor.question.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

/**
 * Created by mehdi on 14/12/16.
 */
@RestController
@RequestMapping(value = "mcq")
public class MCQController {

    @Autowired
    private MCQService mcqService;


    @RequestMapping(value = "/extractAll")
    public void extractAll() throws IOException {
        mcqService.extractAll();
    }

    @RequestMapping(value = "/findAll")
    public Set<Question> findAll() {
        return  mcqService.findAll();
    }

    @RequestMapping(value="/findUnvalidate")
    public Set<QuestionDTO> findUnvalidateQuestions() {
        return  mcqService.findUnvalidate();
    }
}
