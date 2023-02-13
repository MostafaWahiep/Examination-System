package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    static Scanner scanner;
     static ArrayList<Student> students;
     static ArrayList<Instructor> instructors;
     static ArrayList<Adminstrator> admins;
     static ArrayList<Exam> exams;


    public static void main(String[] args){
        
            Student s1 = new Student("s1", "p", "khalil", "1", "11", "45");
            Student s2 = new Student("s2", "p", "Donia", "2", "11", "45");
            Student s3 = new Student("s3", "p", "Omar", "3", "11", "45");
            Student s4 = new Student("s4", "p", "Nour", "4", "11", "45");
            Student s5 = new Student("s5", "p", "Abdelrahman", "5", "11", "45");
            Instructor i1 = new Instructor("i1", "i", "khalil", "11", "45", 11);
            Instructor i2 = new Instructor("i2", "i", "Hossam", "11", "45", 11);
            Adminstrator a1 = new Adminstrator("a1", "a");
            Adminstrator a2 = new Adminstrator("a1", "a");
            students = new ArrayList<Student>();
            students.add(s1);
            students.add(s2);
            students.add(s3);
            students.add(s4);
            students.add(s5);
            instructors = new ArrayList<Instructor>();
            instructors.add(i1);
            instructors.add(i2);
            admins = new ArrayList<Adminstrator>();
             Course opp = new Course("opp1", "opp", "cse231", i1);
             Course logic = new Course("opp2", "logic", "cse111", i2);
             exams=new ArrayList<Exam>();
        
        boolean logged_inS = false;
        boolean logged_inI = false;
        boolean logged_inA = false;
 
        
        scanner = new Scanner(System.in);
        TestLogin t1;
        int indexS=0;
        int indexA=0;
        int indexI=0;
        boolean run = true;
        while (run)
        {
            String s = scanner.nextLine();
            String ss[] = s.split(" ");
            switch (ss[0])
            {
                case "rg":
                {
                    switch (ss[1])
                    {
                        case "st":
                        {
                            String username, password, name, ID, mobile_num, email;
                            System.out.println("enter your Name");
                            name = scanner.nextLine();
                            System.out.println("enter your ID");
                            ID = scanner.nextLine();
                            System.out.println("enter your mobile number");
                            mobile_num = scanner.nextLine();
                            System.out.println("enter your email");
                            email = scanner.nextLine();
                            System.out.println("enter your username");
                            username = scanner.nextLine();
                            System.out.println("enter your password");
                            password = scanner.nextLine();
                            students.add(new Student(username,password,name, ID,mobile_num,email));
                            break;
                        }
                        case "in":
                        {
                            String username, password, name, mobile_num, email;
                            int age;
                            System.out.println("enter your name");
                            name = scanner.nextLine();
                            System.out.println("enter your age");
                            age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("enter your mobile number");
                            mobile_num = scanner.nextLine();
                            System.out.println("enter your email");
                            email = scanner.nextLine();
                            System.out.println("enter your username");
                            username = scanner.nextLine();
                            System.out.println("enter your password");
                            password = scanner.nextLine();
                            instructors.add(new Instructor(username,password,name, mobile_num,email, age));
                            break;
                        }
                        case "ad":
                        {
                            String username, password;
                            System.out.println("enter your username");
                            username = scanner.nextLine();
                            System.out.println("enter your password");
                            password = scanner.nextLine();
                            admins.add(new Adminstrator(username,password));
                            break;
                        }
                    }
                   break;
                }
                case "lg":
                {
                    if (ss[1].equals("st"))
                    {
                           while(logged_inS==false)
   
                           {  
                               System.out.println("Enter username");
                               String s11=scanner.nextLine();
                               System.out.println("Enter password");
                               String s22=scanner.nextLine();
                               t1=new TestLogin(s11,s22);
                              
                               
                               for(int i=0;i<students.size();i++)
                               {
                               if(students.get(i).verify_login(t1)==true)
                               {   indexS=i;
                                logged_inS=true;
                                System.out.println("Welcome " + students.get(i).getName());
                                  break;
                               }
                               }
                           }
                    }
                    else if(ss[1].equals("in")) 
                    { 
                        while(logged_inI==false)
   
                           {  
                               System.out.println("Enter username");
                               String s11=scanner.nextLine();
                               System.out.println("Enter password");
                               String s22=scanner.nextLine();
                               t1=new TestLogin(s11,s22);
                               
                               for(int i=0;i<instructors.size();i++)
                               {
                               if(instructors.get(i).verify_login(t1)==true)
                               {   indexI=i;
                                logged_inI=true;
                                System.out.println("Welcome " + instructors.get(i).getName());
                                  break;
                               }
                               }
                           }
                        
                    }
                    else if(ss[1].equals("ad")) 
                    { 
                        while(logged_inA==false)
   
                           {  
                               System.out.println("Enter username");
                               String s11=scanner.nextLine();
                               System.out.println("Enter password");
                               String s22=scanner.nextLine();
                               t1=new TestLogin(s11,s22);
                               for(int i=0;i<admins.size();i++)
                               {
                                   if(admins.get(i).verify_login(t1)==true)
                                   {
                                       indexA=i;
                                       logged_inA=true;
                                       System.out.println("Welcome ");
                                       break;
                                   }
                               }
                           }
                      
                    }
                    break;
                }
               case "lo":
                {
                    if(logged_inI==true || logged_inS==true || logged_inA==true)
                    {
                   
                    logged_inI=false;
                    logged_inA=false;
                    logged_inS=false;
                    System.out.println("Goodbye!");
                    }
                    break;
                }
               case "se":
               {
                   if(logged_inI==true)
                   {
                       System.out.println("Enter start time");
                       float f=scanner.nextFloat();
                       scanner.nextLine();
                       System.out.println("Enter end time");
                       float f1=scanner.nextFloat();
                       scanner.nextLine();
                       float duration=f-f1;
                       System.out.println("Enter date");
                       String fs=scanner.nextLine();
                       String id=opp.getID();
                       Exam ex=new Exam();
                       //ex=instructors.get(indexI).setExam(opp,id, duration, f, f1, fs);
                       exams.add(ex);
                   }
                   else
                       System.out.println("not allowed");
                   break;
               }
               case"ex":
               {     if(logged_inS==true)
                   {
                       students.get(indexS).setexam(exams.get(0));
                   }
                   else
                        System.out.println("not allowed");
                   break;
               }
               case"re":
               {
                   if(logged_inI==true){
                    exams.get(0).getExam_report().display_histo();
                    exams.get(0).getExam_report().display_tough();
                    }
                    else
                        System.out.println("not allowed");
                   break;
               }
                case "qr":
                {
                    if(logged_inI==true) {
                        exams.get(0).getExam_report().showrank();
                    }
                    else
                        System.out.println("not allowed");
                    break;
                }
                case "end":
                {
                    System.out.println("app closes");
                    run = false;
                    break;
                }
                default:
                {
                    System.out.println("invalid");
                }
            }
        }
    }
    

    public static int have_exam(Student s, Exam ex){
        Question[] questions = ex.getQuestions();
        int sum = 0;
        for(int i = 0; i < ex.getNum_of_questions();i++) {
            displayques(questions[i]);
            char c = scanner.nextLine().charAt(0);
            sum += questions[i].check_ans(c);
        }
        return sum;
    }

    public static void displayques(Question question){
        System.out.println(question.getName());
        System.out.println("a." + question.getChoices(0));
        System.out.println("b." + question.getChoices(1));
        System.out.println("c." + question.getChoices(2));
        System.out.println("d." + question.getChoices(3));
    }
}
