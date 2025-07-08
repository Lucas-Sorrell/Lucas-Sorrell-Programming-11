//import scanner so we can handle user input
import java.util.Scanner;

public class Main
{
    //make scanner variable global so we can use it across different methods
    static Scanner scan;

    public static void main(String[] args)
    {
        scan = new Scanner(System.in);
        createPresetSchool();

        /*
        i was going to allow the user to make a custom school, but i think the assignment only required a preset list of students/teachers

        System.out.println("Would you like to use a preset school, or make a custom school? (Enter \"p\" for preset, \"c\" for custom)");
        while (true)
        {
            String answer = scan.nextLine();
            if (answer.equals("p"))
            {
                createPresetSchool();
                break;
            }
            else if (answer.equals("c"))
            {
                createCustomSchool();
                break;
            }
            else
            {
                System.out.println("Invalid choice, try again.");
            }
        }
        */

        //boolean to control the main menu loop
        boolean isFinished = false;
        while (!isFinished)
        {
            //print menu and ask the user what they want to do
            System.out.println("\nWhat would you like to do?\n1. Add Student\n2. Add Teacher\n3. Delete Student\n4. Delete Teacher\n5. Show all Students\n6. Show all Teachers\n7. Quit");
            String choice = scan.nextLine();

            //switch statement to handle all possible menu options
            switch (choice)
            {
                case "1":
                    //adding a student
                {
                    //ask user for first name, last name, and grade
                    String studentFirstName = getName("Enter student's first name: ");
                    String studentLastName = getName("Enter student's last name: ");
                    int grade = getGrade("Enter student's grade: ");
                    //add student to the school
                    school.addStudent(studentFirstName, studentLastName, grade);
                }
                break;

                case "2":
                    //adding a teacher
                    {
                        //ask user for first name, last name, and subject
                        String teacherFirstName = getName("Enter teacher's first name: ");
                        String teacherLastName = getName("Enter teacher's last name: ");
                        String subject = getSubject("Enter teacher's subject: ");
                        //add teacher to the school
                        school.addTeacher(teacherFirstName, teacherLastName, subject);
                    }
                    break;

                case "3":
                    //deleting a student
                    {
                        String studentFirstName = formatStringCase(getName("Enter first name of student to delete: "));
                        String studentLastName = formatStringCase(getName("Enter last name of student to delete: "));
                        //try to remove student; notify user whether it worked or not
                        if (!school.deleteStudent(studentFirstName, studentLastName))
                        {
                            System.out.println("Failed to find student.");
                        }
                        else
                        {
                            System.out.println("Removed student.");
                        }
                    }
                    break;

                case "4":
                    //deleting a teacher
                    {
                        String teacherFirstName = formatStringCase(getName("Enter first name of teacher to delete: "));
                        String teacherLastName = formatStringCase(getName("Enter last name of teacher to delete: "));
                        //try to remove teacher; notify user whether it worked or not
                        if (!school.deleteTeacher(teacherFirstName, teacherLastName))
                        {
                            System.out.println("Failed to find teacher.");
                        }
                        else
                        {
                            System.out.println("Removed teacher.");
                        }
                    }
                    break;

                case "5":
                    //show all students
                    school.showAllStudents();
                    break;

                case "6":
                    //show all teachers
                    school.showAllTeachers();
                    break;

                case "7":
                    //quit program
                    System.out.println("Exiting program.");
                    isFinished = true;
                    break;

                default:
                    //if the user enters anything else, the program handles it and allows them to try again
                    System.out.println("Invalid input, try again.");
            }
        }
    }

    //make school variable accessible throughout the class
    static School school;

    //method to create a school and pre-fill it with some students and teachers
    private static void createPresetSchool()
    {
        //create new school object
        school = new School("BSS", "Canada", 69);

        //add some preset students
        school.addStudent("Lucas", "Sorrell", 11);
        school.addStudent("Jane", "Doe", 10);
        school.addStudent("Mike", "Johnson", 12);
        school.addStudent("Emily", "Brown", 9);
        school.addStudent("Chris", "Davis", 11);
        school.addStudent("Sarah", "Wilson", 10);
        school.addStudent("David", "Miller", 12);
        school.addStudent("Ashley", "Taylor", 9);
        school.addStudent("Brian", "Anderson", 11);
        school.addStudent("Laura", "Thomas", 10);

        //add some preset teachers
        school.addTeacher("Bob", "Billing", "History");
        school.addTeacher("Linda", "Hall", "Math");
        school.addTeacher("James", "Clark", "Science");
    }

    //method to format input strings to proper capitalization
    static private String formatStringCase(String input)
    {
        input = input.toLowerCase();
        char c = Character.toUpperCase(input.charAt(0));
        return c + input.substring(1);
    }

    //asks for a general string from the user, makes sure it's not empty
    static private String getString(String prompt)
    {
        while (true)
        {
            System.out.println(prompt);
            String str = scan.nextLine();
            if (str.length() > 0)
            {
                return formatStringCase(str);
            }
            System.out.println("Invalid string, try again.");
        }
    }

    //asks user for a name and makes sure it's at least 2 characters long
    static private String getName(String prompt)
    {
        while (true)
        {
            String name = getString(prompt);

            if (name.length() >= 2)
            {
                return name;
            }
            System.out.println("Invalid name, must be longer than 1 character.");
        }
    }

    //asks for a subject from the user and validates it similarly to name
    static private String getSubject(String prompt)
    {
        while (true)
        {
            String subject = getString(prompt);
            if (subject.length() >= 2)
            {
                return subject;
            }
            System.out.println("Invalid subject, must be longer than 1 character.");
        }
    }

    //general number getter, handles invalid inputs with try/catch
    static private int getNumber(String prompt)
    {
        int number;
        while (true)
        {
            System.out.println(prompt);
            try
            {
                number = Integer.parseInt(scan.nextLine());
                break;
            }
            //if user enters non-number input, we handle it and ask again
            catch (NumberFormatException e)
            {
                System.out.println("Invalid number, try again.");
            }
        }
        return number;
    }

    //specifically asks for a grade between 8 and 12, and checks range
    static private int getGrade(String prompt)
    {
        while (true)
        {
            int grade = getNumber(prompt);
            if (grade >= 8 && grade <= 12)
            {
                return grade;
            }
            System.out.println("Invalid grade, please enter a proper high-school grade. (8-12)");
        }
    }
}