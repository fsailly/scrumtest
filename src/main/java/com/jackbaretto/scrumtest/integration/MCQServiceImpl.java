package com.jackbaretto.scrumtest.integration;

import com.baretto.mcq.datamodel.Question;
import com.jackbaretto.scrumtest.extractor.question.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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

    private final  List<ExtractedQuestionImpl> extractedQuestions = new ArrayList<>();
    @Override
    public Set<Question> findAll() {
        //Iterable<ExtractedQuestionImpl> extractedQuestions = mcqRepository.findByValidTrue();
        return QuestionMapper.mapExtractedQuestionIntoQuestion(extractedQuestions);
    }

    @Override
    public Set<Question> findUnvalidate() {
        Set<ExtractedQuestionImpl> unvalidateQuestions = mcqRepository.findByValidFalse();
        return  QuestionMapper.mapExtractedQuestionIntoQuestion(extractedQuestions);
    }

    @Override
    public void extractAll() throws IOException {
        List<ExtractedQuestionImpl> mcqs = new ArrayList<>();
        ClassPathResource classPathResource = new ClassPathResource("/com/jackbaretto/scrumtest/extractor/samples");
        String url = classPathResource.getURL().getPath();
        mcqs.addAll(extractor.extractMCQ(new ExtractionParameters(url)));
        save(mcqs);
    }

    @Override
    public void save(List<ExtractedQuestionImpl> questions) {
       extractedQuestions.addAll(questions);
        for (ExtractedQuestionImpl question : questions) {
            try {
                mcqRepository.save(question);
            } catch (Exception exception){
                System.err.println ("Error during saving question : " + question.getLabel() + ", exception " + exception.getMessage());
            }
        }
    }
}
