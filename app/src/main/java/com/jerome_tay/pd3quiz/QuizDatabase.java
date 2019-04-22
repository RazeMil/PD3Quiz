package com.jerome_tay.pd3quiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jerome_tay.pd3quiz.QuizSetter.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PD3Quiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("Which one of these schools deals with infocomm?", "SOI", "SOH", "SHL","SEG", 1);
        addQuestion(q1);
        Question q2 = new Question("What is one of the lifeskills points category you need to pass?", "Physical Points", "Mind Points", "Health Points","Mental Points", 2);
        addQuestion(q2);
        Question q3 = new Question("Where is the North Canteen Located at?", "W1", "E3", "W6","W3", 3);
        addQuestion(q3);
        Question q4 = new Question("What is the term of mid year exams?", "HWP", "MSE", "ESE","MSA", 4);
        addQuestion(q4);
        Question q5 = new Question("What does GPA stands for?", "Go Party Afternoon", "Grade Point Average", "Grade Point Accumulative","Grand Penguin Arrival", 2);
        addQuestion(q5);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getanswer1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getanswer2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getanswer3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getanswer4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setanswer1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setanswer2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setanswer3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setanswer4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}