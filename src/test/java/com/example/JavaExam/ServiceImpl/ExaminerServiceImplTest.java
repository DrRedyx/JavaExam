package com.example.JavaExam.ServiceImpl;

import com.example.JavaExam.Exception.AmountBiggerThenQuestionsListSizeException;
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

    @Mock
    private JavaQuestionService out;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getExamTest() {
        when(out.getAll()).thenReturn(TRUE_LIST);
        assertEquals(2, examinerService.getQuestions(2));

    }

    @Test
    public void getExceptionWithAmountBigger() {
        when(out.getAll()).thenReturn(TRUE_LIST);
        assertThrows(AmountBiggerThenQuestionsListSizeException.class,
                () -> examinerService.getQuestions(5));
    }
}