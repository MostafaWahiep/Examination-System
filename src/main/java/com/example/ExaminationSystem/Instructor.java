package com.example.ExaminationSystem;

public class Instructor extends User{
    private String name;
    private String mobile_num;
    private String email;
    private int age;
    private Course[] courses;
    private int num_of_courses = 0;

    public Instructor(String username, String password, String name, String mobile_num, String email, int age) {
        super(username, password);
        this.name = name;
        this.mobile_num = mobile_num;
        this.email = email;
        this.age = age;
        courses = new Course[num_of_courses];
    }
    public String getName() {
        return name;
    }

    public void addCourse(Course course){
            Course[] temp = new Course[++num_of_courses];
            System.arraycopy(courses, 0, temp, 0, courses.length);
            courses = temp;
            courses[num_of_courses] = course;
    }
    /*
    public Exam setExam(Course course, String id, float duration, float startTime, float endTime, String date){
        Exam exam = new Exam(id,course,duration,startTime,endTime, date);
        Histogram histo = new Histogram(exam);
        Exam_Report exam_report = new Exam_Report(exam, histo);
        exam.setExam_report(exam_report);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Type \"add\" to add question and \"stop\" to end");
            String s = scanner.nextLine();
            if (s.equals("add") == true){
                String name;
                String[] choices = new String[4];
                int grade;
                char correct_choice;
                System.out.println("Type the question name");
                name = scanner.nextLine();
                System.out.println("Type the first choice");
                choices[0] = scanner.nextLine();
                System.out.println("Type the second choice");
                choices[1] = scanner.nextLine();
                System.out.println("Type the third choice");
                choices[2] = scanner.nextLine();
                System.out.println("Type the last choice");
                choices[3] = scanner.nextLine();
                System.out.println("Type correct choice(a or b or c or d)");
                correct_choice = scanner.next().charAt(0);
                System.out.println("Type the question grade");
                grade = scanner.nextInt();
                exam.addquestoin(new Question(name, choices, correct_choice, grade));
                scanner.nextLine();
            }
            else if(s.equals("stop") == true)
                break;
            else{}
        }
        course.addExam(exam);
        return exam;
    }
    */
}
