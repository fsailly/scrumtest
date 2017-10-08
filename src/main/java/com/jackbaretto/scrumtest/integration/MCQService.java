package com.jackbaretto.scrumtest.integration;

import com.baretto.mcq.datamodel.Question;
import com.jackbaretto.scrumtest.extractor.question.ExtractedQuestionImpl;
import com.jackbaretto.scrumtest.extractor.question.QuestionDTO;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * MCQ services.
 * Created by mehdi on 14/12/16.
 */
public interface MCQService {

    Set<Question> findAll();

    /**
     * Retrieve all unvalidate question.
     * @return Set of {@link QuestionDTO}
     */
    Set<Question> findUnvalidate();


    /**
     * Extract all MCQ from "samples" directory.
     */
    void extractAll() throws IOException;

    void save(List<ExtractedQuestionImpl> questions);
}
