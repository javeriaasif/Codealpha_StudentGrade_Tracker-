import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;
    
    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("=== CodeAlpha - Student Grade Tracker ===");
        System.out.print("How many students data you want to enter? ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Grade (0-100): ");
            double grade = scanner.nextDouble();
            scanner.nextLine();
            
            students.add(new Student(name, grade));
        }

        // Calculate stats
        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;
        String topStudent = students.get(0).name;

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
            }
        }

        double average = total / students.size();

        // Display Report
        System.out.println("\n========== GRADE REPORT ==========");
        System.out.println("Total Students: " + students.size());
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("==================================");
        
        System.out.println("\nAll Students:");
        for (Student s : students) {
            System.out.println("- " + s.name + ": " + s.grade);
        }

        scanner.close();
    }
}