import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


class OnlineExamSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean loggedIn = false;
    private static boolean signedUp = false;
    private static Timer timer;
    private static TimerTask task;
    

    public static void main(String[] args) {
        while (true) {
            if (!loggedIn && !signedUp) {
                System.out.println("===== Online Exam System =====");
                System.out.println("1. Login");
                System.out.println("2. Signup");
                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        signup();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else if (!loggedIn && signedUp) {
                System.out.println("Signup successful! Please login to continue.");
                login();
            } else {
                System.out.println("===== Online Exam System =====");
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Start Exam");
                System.out.println("3. Close Session and Logout");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        updateProfileAndPassword();
                        break;
                    case 2:
                        startExam();
                        break;
                    case 3:
                        closeSessionAndLogout();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static void login() {
        System.out.println("===== Login =====");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Perform authentication logic here
        // You can use a database or hardcoded values for demonstration purposes
        if (authenticateUser(username, password)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        System.out.println();
    }

    private static void signup() {
        System.out.println("===== Signup =====");
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Perform signup logic here
        // You can use a database or other storage mechanism to store the new user's credentials
        signedUp = true;
        System.out.println("Signup successful!");

        System.out.println();
    }

    private static boolean authenticateUser(String username, String password) {
        // Hardcoded values for demonstration purposes
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        return username.equals(hardcodedUsername) && password.equals(hardcodedPassword);
    }

    private static void updateProfileAndPassword() {
        System.out.println("===== Update Profile and Password =====");
        // Implement logic to update user profile and password
        System.out.println("Profile and password updated successfully!");
        System.out.println();
    }

    
    private static void startExam() {
        System.out.println("===== Exam =====");

        // Set the exam duration (in milliseconds)
        long examDuration = 300000; // 5 minutes
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                submitExam();
            }
        }, examDuration);

        // Implement logic for the exam
        // Display the MCQs, allow the user to select answers, and manage the timer

        // Display and process the MCQ
        System.out.println("Q1: What is the capital of France?");
        System.out.println("1) Paris");
        System.out.println("2) London");
        System.out.println("3) Rome");
        System.out.println("4) Berlin");

        // Get the user's answer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer (enter the corresponding number): ");
        int answer = scanner.nextInt();

        // Validate and process the answer
        switch (answer) {
            case 1:
                System.out.println("Correct answer!");
                // Perform any required actions for a correct answer
                break;
            default:
                System.out.println("Incorrect answer!");
                // Perform any required actions for an incorrect answer
                break;
        }

        // Continue with the rest of the exam and other questions

        // Cancel the timer as the exam is completed
        timer.cancel();

        System.out.println("Exam completed. Submitting answers...");
        // Implement logic to submit the answers automatically
        submitExam();

        System.out.println("Exam submitted successfully!");
        System.out.println();
    }

    private static void submitExam() {
        // Implement logic to submit the answers automatically
        System.out.println("Submitting exam...");
        // Additional code to handle the submission process
        System.exit(0); // Exit the program after submission
    }


    private static void closeSessionAndLogout() {
        System.out.println("Closing session and logging out...");
        loggedIn = false;
        System.out.println("Logged out successfully!");
        System.out.println();
    }
}
