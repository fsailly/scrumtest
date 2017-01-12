package com.jackbaretto.scrumtest.extractor;

import com.baretto.mcq.datamodel.Question;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mehdi on 11/01/17.
 */
public class QuestionExtractorTest {

    private final String extract = "scrummg i Assessment - PSM i - coogle chrome ? ﬂ iii E; E‘ _ r l')\n" +
            "6 / oMm. Drive»GooglE x Y M Fwd:PSM|Assessr x Y w meessionalScrun x » 9 SLrurluzrgIAsses: x m_ imi\n" +
            "<- e a hrrpsyMww.myresr¢om.ner/app/myrakearesrLaun:hrorm.:rm a a 0 r J 0 g\n" +
            "S 555 Apps I agilité I javascripr I github I architecture I java I dn(ker I persnnnel I a regarder I (nursera I amundi I andrnid I (nntinunusinte I nvh I spnar I raspberry I 0therbnnkmarks\n" +
            "a \\ )Scrum.org\n" +
            "6 Assessment - PSM I\n" +
            "O 4 V Assessment - -\n" +
            "You are taking the fo||owing assessment:\n" +
            "Name PSM I\n" +
            "Description Professiona| Scrum Master | Assessment\n" +
            "Timer TIme RemaInIng (mInutes:seconds) : 55:33\n" +
            "Question\n" +
            "Use one of the Submit buttons to save your answer and move to the next or previous question.\n" +
            "You can a|so use the Bookmark button to save your answers and navigate to any other question\n" +
            "page. P|ease note, when you've answered a|| the questions, you must c|ick the Save and Finish\n" +
            "button on the ﬁna| question page to indicate you're done taking this test and it's now ready to be\n" +
            "scored.\n" +
            "13) What is the main reason for the Scrum Master to be at the Daily Scrum?\n" +
            "Bookmark this question\n" +
            "Choose one answer.\n" +
            "A) I He or she does not have to be there; he or she oniy has to ensure\n" +
            "the Deve|opment Team has a Dai|y Scrum.\n" +
            "B) To write down any changes to the Sprint Back|og, inc|uding adding\n" +
            "new items, and tracking progress on the bum-down.\n" +
            "C) To make sure every team member answers the three questions.\n" +
            "D) To gather status and progress information to report to\n" +
            "management.\n" +
            ".\n" +
            "a\n" +
            "I .";

    private final String expectedQuestion = "What is the main reason for the Scrum Master to be at the Daily Scrum?";


    @Test
    public void testExtractQuestion() {
        MCQQuestionExtractor questionExtractor = new MCQQuestionExtractor();
        ExtractedQuestion extractedQuestion = questionExtractor.extract(extract);
        Assert.assertEquals(expectedQuestion, extractedQuestion.getLabel());
    }


    @Test(expected = QuestionNotFoundException.class)
    public void testExtractorCantExtractQuestion() {
        MCQQuestionExtractor questionExtractor = new MCQQuestionExtractor();
        questionExtractor.extract("Default string without any question.");
    }

}
