package com.example.ExaminationSystem;

public class Question {
    private String name;
    private String[] choices;
    private int grade;
    Integer countf;
    String evaloution_rank;
    private char correct_choice;
    public Question(String name, String choices[], char correct_choice, int grade) {
        this.name = name;
        this.choices = choices;
        this.correct_choice = correct_choice;
        this.grade = grade;
        countf = 0;
    }
    public String getEvaloution_rank() {
        return evaloution_rank;
    }
    public void setEvaloution_rank(String evaloution_rank) {
        this.evaloution_rank = evaloution_rank;
    }
    public Question(){
        choices = new String[4];
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setChoices(String choice, int x) {
        if(x>=0&&x<4)
            choices[x-1] = choice;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setCorrect_choice(char correct_choice) {
        this.correct_choice = correct_choice;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getChoices(int x) {
        return choices[x];
    }

    public int check_ans(char c) {
        if(c == correct_choice)
            return grade;
        else{
            countf++;
            return 0;
        }
    }
}
