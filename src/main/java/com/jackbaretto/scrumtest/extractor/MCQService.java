package com.jackbaretto.scrumtest.extractor;

import java.util.List;

/**
 * MCQ services.
 * Created by mehdi on 14/12/16.
 */
public interface MCQService {

    void save(List<ExtractionResult> mcqs);

    Iterable<ExtractionResult> findAll();
}
