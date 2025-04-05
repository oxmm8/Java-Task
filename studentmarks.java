import java.util.Scanner;

class StudentGrade { 
    public static void main(String args[])
	 {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the marks for 5 subjects:");

        // Student marks in subjects
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();

        // Total marks
        int x = a + b + c + d + e;
        System.out.println("Total marks are: " + x);

        // Average percentage
        double p = (x / 500.0) * 100; 
        System.out.println("Average Percentage is: " + p);

        // Student Grade
        if (p >= 90) {
            System.out.println("Grade: A");
        } else if (p >= 80) {
            System.out.println("Grade: B");
        } else if (p >= 70) {
            System.out.println("Grade: C");
        } else if (p >= 60) {
            System.out.println("Grade: D");
        } else if (p >= 40) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: F");
        }

        scan.close(); 
    }
}