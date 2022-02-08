package com.example.JavaExam.ServiceImpl;

import com.example.JavaExam.Exception.QuestionIsNotFindException;
import com.example.JavaExam.Exception.QuestionsInListException;
import com.example.JavaExam.Question;
import com.example.JavaExam.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    List<Question> questions;


    public JavaQuestionService() {
        questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question ques = new Question(question, answer);
        if (!questions.contains(ques)) {
            questions.add(ques);
            return ques;
        } else {
         throw new QuestionsInListException();
        }
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        } else {
            throw new QuestionsInListException();
        }
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionIsNotFindException();
        }
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int num = random.nextInt(questions.size());
        return questions.get(num);

    }
}
