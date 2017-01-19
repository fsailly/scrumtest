package com.jackbaretto.scrumtest.integration;

import com.baretto.mcq.datamodel.Question;

import java.io.IOException;
import java.util.Set;

/**
 * MCQ services.
 * Created by mehdi on 14/12/16.
 */
public interface MCQService {

    Set<Question> findAll();

    /**
     * Extract all MCQ from "samples" directory.
     */
    void extractAll() throws IOException;
}
