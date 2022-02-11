package com.example.JavaExam.ServiceImpl;

import com.example.JavaExam.Exception.AmountBiggerThenQuestionsListSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.JavaExam.ServiceImpl.ConstantaForTests.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService out;

    @BeforeEach
    public void setExaminerService() {
        examinerService = new ExaminerServiceImpl(out);
    }


    @Test
    public void getExamTest() {
        out.add(QUESTION_1);
        when(out.getAll()).thenReturn(TRUE_LIST_1);
        assertEquals(TRUE_LIST_1, examinerService.getQuestions(1));

    }

    @Test
    public void getExceptionWithAmountBigger() {
        when(out.getAll()).thenReturn(TRUE_LIST);
        assertThrows(AmountBiggerThenQuestionsListSizeException.class,
                () -> examinerService.getQuestions(5));
    }
}