package com.example.JavaExam.Controller;

import com.example.JavaExam.Question;
import com.example.JavaExam.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/add")
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        questionService.add(question1);
        return question1 + "is added";
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        questionService.remove(question1);
        return question1 + "is removed";
    }
    @GetMapping(path = "")
    public String getAllQuestions() {
        return "List of questions and answers: " + questionService.getAll();
    }
}
