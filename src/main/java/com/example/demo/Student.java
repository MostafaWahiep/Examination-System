package com.example.demo;

import java.util.Scanner;

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
        this.exams = exams;
        exams = new Exam[1];
    }

    public void setexam(Exam exam){
        Scanner s = new Scanner(System.in);
        addexam(exam);
        int grade = 0;
        for(Question q:exam.getQuestions()){
            Main.displayques(q);
            System.out.print("enter your choice: ");
            grade += q.check_ans(s.next().charAt(0));
        }
        System.out.println("your grade is " + grade +" out of " + exam.getMark());
        exam.getExam_report().getHisto().addgrade(grade);
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
