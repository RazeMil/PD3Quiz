package com.jerome_tay.pd3quiz;

import android.provider.BaseColumns;

public final class QuizSetter {

    private QuizSetter() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "answer1";
        public static final String COLUMN_OPTION2 = "answer2";
        public static final String COLUMN_OPTION3 = "answer3";
        public static final String COLUMN_OPTION4 = "answer4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}