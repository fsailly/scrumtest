package com.jackbaretto.scrumtest.integration;

import com.baretto.mcq.datamodel.Question;
import com.jackbaretto.scrumtest.extractor.question.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * MCQ service.
 * Created by mehdi on 14/12/16.
 */
@Service
@Transactional
public class MCQServiceImpl implements MCQService {

    @Autowired
    private MCQExtractor extractor;
    @Autowired
    private MCQRepository mcqRepository;

    @Override
    public Set<Question> findAll(){
        Iterable<ExtractedQuestionImpl> extractedQuestions = mcqRepository.findAll();
        return QuestionMapper.map(extractedQuestions);
    }

    @Override
    public void extractAll() throws IOException {
        List<ExtractedQuestionImpl> mcqs = new ArrayList<>();
        ClassPathResource classPathResource = new ClassPathResource("/com/jackbaretto/scrumtest/extractor/samples");
        String url = classPathResource.getURL().getPath();
        mcqs.addAll(extractor.extractMCQ(new ExtractionParameters(url)));
        mcqRepository.save(mcqs);
    }
}
