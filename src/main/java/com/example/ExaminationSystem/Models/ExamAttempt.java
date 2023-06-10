package com.example.ExaminationSystem.Models;

public class ExamAttempt {
    private Student student;
    private Exam exam;
    private Integer grade;
    private String date;
    private Integer answered_questions;
    private Integer correct_answers;
    private String Feedback;
    private Integer num_questions;

    public ExamAttempt(Student student, Exam exam, String date, Integer grade, Integer answered_questions, Integer correct_answers) {
        this.student = student;
        this.exam = exam;
        this.grade = grade;
        this.date = date;
        this.answered_questions = answered_questions;
        this.correct_answers = correct_answers;
        this.num_questions = exam.getNum_of_questions();
    }

    public String getStudent() {
        return student.getName();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getExam() {
        return exam.getID();
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Integer getAnswered_questions() {
        return answered_questions;
    }

    public void setAnswered_questions(Integer answered_questions) {
        this.answered_questions = answered_questions;
    }

    public int getCorrect_answers() {
        return correct_answers;
    }

    public void setCorrect_answers(Integer correct_answers) {
        this.correct_answers = correct_answers;
    }

    public String getCourse() {
        return exam.getCourse_Code();
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public float getGradePercentage() {
        return (float) grade / exam.getMark() * 100;
    }

    public Integer getNum_questions() {
        return num_questions;
    }

}
