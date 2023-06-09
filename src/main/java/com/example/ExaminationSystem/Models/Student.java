package com.example.ExaminationSystem.Models;

public class Student extends User {
    private String name;
    private String ID;
    private String mobile_num;
    private String email;
    private Exam exams[];
    private int num_of_exams = 0;
    private boolean have_exam;

    public Student(String username, String password, String name, String ID, String mobile_num, String email) {
        super(username, password);
        this.name = name;
        this.ID = ID;
        this.mobile_num = mobile_num;
        this.email = email;
        exams = new Exam[1];
    }

    public String getName() {
        return name;
    }

    public void addexam(Exam exam){
        if(have_exam == true) {
            Exam[] temp = new Exam[num_of_exams + 1];
            System.arraycopy(exams, 0, temp, 0, exams.length);
            exams = temp;
            exams[num_of_exams++] = exam;
        }else {
            exams[num_of_exams++] = exam;
            have_exam = true;
        }
    }
}
