package com.jackbaretto.scrumtest.extractor.question;

import com.jackbaretto.scrumtest.extractor.type.QuestionType;

/**
 * Sample questions extracted by the OCR
 * <p>
 * Created by florentsailly on 12/01/2017.
 */
public enum ExtractedSampleQuestions {

    CLASSIC_QUESTION_FULL_EXTRACTION(ExtractedSampleQuestions.CLASSIC_QUESTION_FULL_EXTRACTION_LABEL, QuestionType.ONE_RESPONSE),
    ASSERTION_TO_COMPLETE_FULL_EXTRACTION(ExtractedSampleQuestions.ASSERTION_TO_COMPLETE_FULL_EXTRACTION_LABEL, QuestionType.ONE_RESPONSE),
    QUESTION_WITH_SHORT_CHOICES(ExtractedSampleQuestions.QUESTION_WITH_SHORT_CHOICES_LABEL, QuestionType.ONE_RESPONSE),
    QUESTION_TRUE_FALSE(ExtractedSampleQuestions.QUESTION_TRUE_FALSE_LABEL, QuestionType.ONE_RESPONSE),
    MULTI_CHOICES_QUESTION(ExtractedSampleQuestions.MULTI_CHOICES_QUESTION_LABEL, QuestionType.ALL_THAT_APPLY),
    QUESTION_WITH_TWO_RESPONSES(ExtractedSampleQuestions.QUESTION_WITH_TWO_RESPONSES_LABEL, QuestionType.N_RESPONSE);


    private static final String QUESTION_WITH_TWO_RESPONSES_LABEL = " E mytestcom.net C 0 iii @\n" +
            "Professiona| Scrum Master $ubject Areas I Scrum.org | Assessment - PSM I +\n" +
            "AssessmenI - PSM I\n" +
            "V Assessment - -\n" +
            "You are taking the fo|lowing assessment:\n" +
            "Name PSM I\n" +
            "Description Professional Scrum Master I Assessment\n" +
            "Timer Time Remaining (minutes:seconds) : 49:53\n" +
            "Quesﬁon\n" +
            "Use one of the Submit buttons to save your answer and move to the next or previous question. You can a|so use the Bookmark\n" +
            "button to save your answers and navigate to any other question page. PIease note, when you've answered a|| the questions, you\n" +
            "must oiick the Save and Finish button on the ﬁna| question page to indiIIte you're done taking this test and it's now ready to be\n" +
            "soored.\n" +
            "23) What are the two primary ways a Scrum Master keeps a Deve|opment Team working at its highest leve| of\n" +
            "productivity?\n" +
            "7 Bookmark this question\n" +
            "\n" +
            "Choose 2 answers.\n" +
            "\n" +
            "A) By faciIitating DeveIopment Team decisions\n" +
            "\n" +
            "B) T By ensuring the meetings start and end at the proper time\n" +
            "\n" +
            "C) By removing impedimenIs that hinder the DeveIopment Team\n" +
            "\n" +
            "D) T By keeping high va|ue features high in the Product Bachog\n" +
            "\n" +
            "Submit <— Back Submit —> Forward\n" +
            "Open Bookmarks";

    private static final String CLASSIC_QUESTION_FULL_EXTRACTION_LABEL = "scrummg i Assessment - PSM i - coogle chrome ? ﬂ iii E; E‘ _ r l')\n" +
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

    private static final String MULTI_CHOICES_QUESTION_LABEL="111 E mytestcom.net C 0 iii @\n" +
            "Professiona| Scrum Master subject Areas Scrum.org | Assessment - PSM I +\n" +
            "Assessment - PSM I\n" +
            "V Assessment - -\n" +
            "You are taking the fo|lowing assessment:\n" +
            "Name PSM I\n" +
            "Description Professional Scrum Master I Assessment\n" +
            "Timer Time Remaining (minutes:seconds) : 49:08\n" +
            "Question\n" +
            "Use one of the Submit buttons to save your answer and move to the next or previous question. You can a|so use the Bookmark\n" +
            "button to save your answers and navigate to any other question page. PIease note, when you've answered a|| the questions, you\n" +
            "must olick the Save and Finish button on the ﬁna| question page to indiIIte you're done taking this test and it's now ready to be\n" +
            "soored.\n" +
            "26) Which of the fo||owing are ro|es on a Scrum Team?\n" +
            "7 Bookmark this question\n" +
            "\n" +
            "Choose all that appIy.\n" +
            "\n" +
            "A) Scrum Master\n" +
            "\n" +
            "B) T Users\n" +
            "\n" +
            "C) T Customers\n" +
            "\n" +
            "D) DeveIopment Team\n" +
            "\n" +
            "E) Product Owner\n" +
            "\n" +
            "Submit <— Back Submit -> Forward\n" +
            "Open Bookmarks";
    private static final String QUESTION_WITH_SHORT_CHOICES_LABEL = "< 111 H mytestcom.net C 0 iii @\n" +
            "Professiona| Scrum Master Subject Areas Scrum.org | Assessment - PSM I +\n" +
            "Assessment - PSM I\n" +
            "V Assessment - -\n" +
            "You are taking the fo|lowing assessment:\n" +
            "Name PSM I\n" +
            "Description Professional Scrum Master I Assessment\n" +
            "Timer Time Remaining (minutes:seconds) : 56:42\n" +
            "Question\n" +
            "Use one of the Submit buttons to save your answer and move to the next or previous question. You can a|so use the Bookmark\n" +
            "button to save your answers and navigate to any other question page. PIease note, when you've answered a|| the questions, you\n" +
            "must oiick the Save and Finish button on the ﬁna| question page to indiIIte you're done taking this test and it's now ready to be\n" +
            "soored.\n" +
            "8) Which Scrum Va|ue is affected by a Iack of trust in the Scrum Team?\n" +
            "7 Bookmark this question\n" +
            "\n" +
            "Choose one answer.\n" +
            "\n" +
            "A) Commitment\n" +
            "\n" +
            "B) Courage\n" +
            "\n" +
            "C) 0penness\n" +
            "\n" +
            "D) Foous\n" +
            "\n" +
            "E) Respect\n" +
            "\n" +
            "F) 0 AH of the above\n" +
            "\n" +
            "Submit <— Back Submit -> Forward\n" +
            "Open Bookmarks";

    private static final String QUESTION_TRUE_FALSE_LABEL="< [l] E mytestcom.net C 0 iii @\n" +
            "Professiona| Scrum Master subject Areas Scrum.org | Assessment - PSM I +\n" +
            "Assessment - PSM I\n" +
            "V Assessment - -\n" +
            "You are taking the fo|lowing assessment:\n" +
            "Name PSM I\n" +
            "Description Professional Scrum Master I Assessment\n" +
            "Timer Time Remaining (minutes:seconds) : 52:55\n" +
            "Quesiion\n" +
            "Use one of the Submit buttons to save your answer and move to the next or previous question. You can a|so use the Bookmark\n" +
            "button to save your answers and navigate to any other question page. PIease note, when you've answered a|| the questions, you\n" +
            "must oiick the Save and Finish button on the ﬁna| question page to indiIIte you're done taking this test and it's now ready to be\n" +
            "soored.\n" +
            "15) The sprint Goa| is a resuIt of sprint P|anning, as is the Sprint Back|og.\n" +
            "7 Bookmark this question\n" +
            "\n" +
            "Choose one answer.\n" +
            "\n" +
            "A) 0 True\n" +
            "\n" +
            "B) ' Fa|se\n" +
            "\n" +
            "Submit <- Back Submit -> Forward\n" +
            "Open Bookmarks";

    private static final String ASSERTION_TO_COMPLETE_FULL_EXTRACTION_LABEL = "< 111 u mytestcom.net O 0 ﬁ @\n" +
            "Professiona| Scrum Master Subject Areas Scrum.org | Assessment - PSM I +\n" +
            "Assessment - PSM I\n" +
            "V Assessment - -\n" +
            "You are taking the fo|lowing assessment:\n" +
            "Name PSM I\n" +
            "Description Professional Scrum Master I Assessment\n" +
            "Timer Time Remaining (minutes:seconds) : 57:55\n" +
            "Question\n" +
            "Use one of the Submit buttons to save your answer and move to the next or previous question. You can a|so use the Bookmark\n" +
            "button to save your answers and navigate to any other question page. PIease note, when you've answered a|| the questions, you\n" +
            "must oiick the Save and Finish button on the ﬁna| question page to indiIIte you're done taking this test and it's now ready to be\n" +
            "soored.\n" +
            "5) The Product Owner must reIease each Increment to production.\n" +
            "7 Bookmark this question\n" +
            "\n" +
            "Choose one answer.\n" +
            "\n" +
            "A) Without exception.\n" +
            "\n" +
            "B) Whenever the product is free of defects.\n" +
            "\n" +
            "C) To make sure the Deve|opment Team is done every Sprint.\n" +
            "\n" +
            "D) 0 When it makes sense.\n" +
            "\n" +
            "Submit <— Back Submit -> Forward\n" +
            "Open Bookmarks";

    private final ExtractedQuestionImpl extractedQuestion;
    ExtractedSampleQuestions(final String theExtractedQuestion, final QuestionType questionType) {
        this.extractedQuestion = new ExtractedQuestionImpl(theExtractedQuestion, questionType);
    }

    public String getExtractedQuestionLabel() {
        return this.extractedQuestion.getLabel();
    }
}