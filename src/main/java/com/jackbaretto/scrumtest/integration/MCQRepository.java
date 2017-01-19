package com.jackbaretto.scrumtest.integration;

import com.jackbaretto.scrumtest.extractor.question.ExtractedQuestionImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * MCQ repository used in order to store or retrieve MCQ.
 * Created by mehdi on 14/12/16.
 */
@Repository
public interface MCQRepository extends CrudRepository<ExtractedQuestionImpl,Long> {

}
