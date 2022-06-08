package com.example.JavaExam.Service;

import com.example.JavaExam.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection <Question> getQuestions(int amount);
}
