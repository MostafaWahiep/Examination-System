package com.example.demo;

public class Histogram {
    private Exam exam;
    private int exam_code;
    private int grades[];
    private int numofgrades;
    private boolean firstgrade;
    private int frequency_arr[];
    public Histogram(Exam exam) {
        this.exam = exam;
        exam_code = exam.getID();
        grades = new int[1];
    }

    public int[] getFrequency_arr() {
        processFrequency_arr();
        return frequency_arr;
    }

    public int[] getGrades() {
        return grades;
    }
    public void addgrade(int x){
        if(firstgrade == true) {
            int[] temp = new int[numofgrades + 1];
            System.arraycopy(grades, 0, temp, 0, grades.length);
            grades = temp;
            grades[numofgrades++] = x;
        }else {
            grades[numofgrades++] = x;
            firstgrade = true;
        }
    }
    public void processFrequency_arr() {
        frequency_arr = new int[exam.getMark() + 1];
        for(int i = 0; i < grades.length; i++)
            frequency_arr[grades[i]]++;
    }
    public void display(){
        this.processFrequency_arr();
        System.out.println("Marks --- Frequency");
        for (int i = 0; i < frequency_arr.length; i++)
        {
            System.out.println(i + "    ----    "+ frequency_arr[i]);
        }
    }

}