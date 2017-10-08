package com.jackbaretto.scrumtest.integration;

import com.baretto.mcq.datamodel.Question;
import com.jackbaretto.scrumtest.extractor.question.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mehdi on 14/12/16.
 */
@RestController
@RequestMapping(value = "mcq")
public class MCQController {

    @Autowired
    private MCQService mcqService;


    @RequestMapping(value = "/extractAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void extractAll() throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    mcqService.extractAll();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        executor.submit(task);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Set<Question> findAll() {
        return  mcqService.findAll();
    }

    @RequestMapping(value="/findUnvalidate", method = RequestMethod.GET)
    public Set<Question> findUnvalidateQuestions() {
        return  mcqService.findAll();
    }


    @RequestMapping(value="/save", method = RequestMethod.POST)
    public void save(@RequestBody List<ExtractedQuestionImpl> questions) {
        mcqService.save(questions);
    }
}
