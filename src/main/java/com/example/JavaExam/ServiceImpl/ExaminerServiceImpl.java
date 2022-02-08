package com.example.JavaExam.ServiceImpl;

import com.example.JavaExam.Exception.AmountBiggerThenQuestionsListSizeException;
import com.example.JavaExam.Question;
import com.example.JavaExam.Service.ExaminerService;
import com.example.JavaExam.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (amount <= questionService.getAll().size()) {
            while (questions.size() != amount) {
                questions.add(questionService.getRandomQuestion());
            }
            return questions;
        } else {
            throw new AmountBiggerThenQuestionsListSizeException();
        }
    }
}
