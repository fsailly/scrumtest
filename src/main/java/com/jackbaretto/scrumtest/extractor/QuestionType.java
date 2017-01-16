package com.jackbaretto.scrumtest.extractor;

/**
 * Represent the constraint on the answer of a MCQ question:
 * -ONE_RESPONSE: only one good response,
 * -ALL_THAT_APPLY: one or more good response,
 * -N_RESPONSES: N good responses.
 * Created by mehdi on 16/01/17.
 */
public enum QuestionType {
    ONE_RESPONSE,
    N_RESPONSE,
    ALL_THAT_APPLY;
}
