package com.example.ExaminationSystem;

public class Course {
    private String ID;
    private String name;
    private String course_code;
    private Instructor instructor;
    private Exam setofexams[];
    private Student students[];
    private int num_of_exams;
    private boolean first_exam = false;

    public Course(String ID, String name, String course_code, Instructor instructor) {
        this.ID = ID;
        this.name = name;
        this.course_code = course_code;
        this.instructor = instructor;
        setofexams = new Exam[1];
    }

    public String getName() {
        return name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public Instructor getInstructor() {
        return instructor;
    }
    public void addExam(Exam exam){
        if(first_exam == true) {
            Exam[] temp = new Exam[num_of_exams + 1];
            System.arraycopy(setofexams, 0, temp, 0, setofexams.length);
            setofexams = temp;
            setofexams[num_of_exams++] = exam;
        }else {
            setofexams[num_of_exams++] = exam;
            first_exam = true;
        }
    }

    public String getID() {
        return ID;
    }
}
