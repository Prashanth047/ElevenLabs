import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<Student> studentList=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

    }
    private static Student findStudentById(int id){
        for(Student s:studentList){
            if(s.getId()==id)
                    return s;
        }
        return null;
    }
    private static void  addStudent(){
        System.out.println("Enter student id: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        String name=sc.nextLine();

        System.out.println("Enter marks: ");
        double marks=sc.nextDouble();

        studentList.add(new Student(id,name,marks));
        System.out.println("Student details added successfully");
    }

    private static void viewStudents(){
        if(studentList.isEmpty()){
            System.out.println("No records found");
        }
        else{
            System.out.println("List of students are below: ");
            studentList.forEach(System.out::println);
        }
    }

    private static void updateStudent(){
        System.out.println("Enter id to update student: ");
        int id=sc.nextInt();
        Student s=findStudentById(id);

        if(s!=null){
            sc.nextLine();
            System.out.println("Enter name: ");
            String name=sc.nextLine();

            System.out.println("Enter marks: ");
            double marks=sc.nextDouble();

            s.setName(name);
            s.setMarks(marks);
            System.out.println("Record updated successfully");
        }else{
            System.out.println("Student with id:"+id+" not found");
        }
    }

    private static void deleteStudent(){
        System.out.println("Enter the id of student to be removed: ");
        int id=sc.nextInt();
        Student s=findStudentById(id);

        if(s!=null){
            studentList.remove(s);
            System.out.println("Student record deleted");
        }else{
            System.out.println("Student with id:"+id+" not found");
        }

    }


}