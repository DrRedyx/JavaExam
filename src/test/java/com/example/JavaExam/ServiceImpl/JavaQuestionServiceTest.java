package com.example.JavaExam.ServiceImpl;

import com.example.JavaExam.Exception.AmountBiggerThenQuestionsListSizeException;
import com.example.JavaExam.Exception.QuestionIsNotFindException;
import com.example.JavaExam.Exception.QuestionsInListException;
import com.example.JavaExam.Question;
import com.example.JavaExam.Service.ExaminerService;
import com.example.JavaExam.ServiceImpl.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static com.example.JavaExam.ServiceImpl.ConstantaForTests.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JavaQuestionServiceTest {

    private JavaQuestionService out;

    @BeforeEach
    public void setOut() {
        out = new JavaQuestionService();
    }

    @Test
    public void addTest() {
        assertEquals(out.add(QUESTION_1), QUESTION_1);
    }

    @Test
    public void throwExceptionWithTwoSameQuestions() {
        out.add(QUESTION_1);
        assertThrows(QuestionsInListException.class,
                () -> out.add(QUESTION_1));
    }

    @Test
    public void deleteTest() {
        out.add(QUESTION_1);
        assertEquals(out.remove(QUESTION_1), QUESTION_1);
    }

    @Test
    public void throwExceptionQuestionNotFind() {
        out.add(QUESTION_1);
        assertThrows(QuestionIsNotFindException.class,
                () -> out.remove(QUESTION_2));
    }


    @Test
    public void getRandomTest() {
        out.add(QUESTION_1);
        assertEquals(out.getRandomQuestion(), QUESTION_1);
    }
}