package com.jackbaretto.scrumtest.extractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * MCQ service.
 * Created by mehdi on 14/12/16.
 */
@Service
@Transactional
public class MCQServiceImpl implements MCQService {
    @Autowired
    private MCQRepository mcqRepository;
    @Override
    public void save(List<ExtractionResult> mcqs) {
        mcqRepository.save(mcqs);
    }
    @Override
    public Iterable<ExtractionResult> findAll(){
        return mcqRepository.findAll();
    }
}
