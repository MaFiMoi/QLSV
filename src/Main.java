import java.awt.desktop.OpenURIEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Enter/Insert new student information");
            System.out.println("2. Print student list to screen");
            System.out.println("3. Delete students by code");
            System.out.println("4. Sort students in descending order of score");
            System.out.println("5. Search for students by student code or student name");
            System.out.println("6. Check student scores");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    System.out.print("Enter student code to delete: ");
                    String code = scanner.nextLine();
                    removeByCode(code);
                    break;
                case 4:
                    sortByGradeDesc();
                    System.out.println("Students sorted by grade in descending order:");
                    output();
                    break;
                case 5:
                    System.out.print("Enter student code or name to search: ");
                    String keyword = scanner.nextLine();
                    Student student = findByCodeOrName(keyword);
                    if (student != null) {
                        System.out.println(student.toString());
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter minimum grade to search: ");
                    float x = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline left-over
                    List<Student> filteredStudents = filterByGrade(x);
                    if (filteredStudents != null) {
                        System.out.println("Students with grade >= " + x + ":");
                        for (Student s : filteredStudents) {
                            System.out.println(s.toString());
                        }
                    } else {
                        System.out.println("No students found");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    public static void input()
    {
        System.out.println("Nhap vao thong tin sinh vien:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma sv:");
        String code = scanner.nextLine();
        System.out.println("Nhap ten sv:");
        String name = scanner.nextLine();
        System.out.println("Nhap diem:");
        float grade = scanner.nextFloat();
        Student student = new Student(code, name, grade);
        studentList.add(student);

    }
    public static void output(){
        for(Student student: studentList){
            System.out.println(student.toString());
        }
    }
    public static void removeByCode(String code)
    {
        studentList.removeIf(student -> student.getCode().equals(code));
    }
    public static  void sortByGradeDesc(){
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade()));
    }
    public static Student findByCodeOrName(String keyword){
        for (Student student : studentList) {
            if (student.getCode().equals(keyword) || student.getName().equals(keyword)) {
                return student;
            }
        }
        return null;
    }
    public static List<Student> filterByGrade(float x){
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}




