package com.example.JavaExam.ServiceImpl;

import com.example.JavaExam.Question;

import java.util.List;

public class ConstantaForTests {

    public static Question QUESTION_1 = new Question("Какой язык Java","ООП язык");
    public static Question QUESTION_2 = new Question("Три признака ООП","Наследование, Полиморфизм и Инкапсуляция");
    public static Question QUESTION_3 = new Question("Что можно делать на Java","Писать backend часть приложения");
    public static Question QUESTION_4 = new Question("Что такое наследование","Наследование это возможность одного класса пользоваться методами другого класса");

    public static List<Question> TRUE_LIST = List.of(
            new Question("Какой язык Java","ООП язык"),
            new Question("Три признака ООП","Наследование, Полиморфизм и Инкапсуляция"),
            new Question("Что можно делать на Java","Писать backend часть приложения"),
            new Question("Что такое наследование","Наследование это возможность одного класса пользоваться методами другого класса")
    );
    public static List<Question> TRUE_LIST_1 = List.of(
            new Question("Какой язык Java","ООП язык")
    );

}
