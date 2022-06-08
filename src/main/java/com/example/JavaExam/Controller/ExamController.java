package com.example.JavaExam.Controller;

import com.example.JavaExam.Question;
import com.example.JavaExam.Service.ExaminerService;
import com.example.JavaExam.ServiceImpl.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get")
    public String getExamQuestions(@RequestParam("amount") int amount) {
        return "Your exam list: " + examinerService.getQuestions(amount);
    }
}
