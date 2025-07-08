public class Student
{
    //basic student info
    private String firstName;
    private String lastName;
    private int grade;
    private int studentID;

    //shared variable to generate unique student IDs
    private static int nextStudentID = 1;

    //default constructor (empty student)
    Student()
    {
        firstName = "";
        lastName = "";
        grade = 0;
        studentID = nextStudentID++;
    }

    //custom constructor for student creation
    Student(String firstName, String lastName, int grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentID = nextStudentID++;
    }

    //getters and setters for student fields
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public int getStudentID()
    {
        return studentID;
    }

    //method to print the student's info in a clean way
    public void printSelf()
    {
        System.out.println("Name: " + firstName + " " + lastName + " | Grade: " + grade + " | Student Number: " + studentID);
    }

    //optional string representation if needed
    @Override
    public String toString()
    {
        return "Name: " + firstName + " " + lastName + " | Grade: " + grade + " | Student Number: " + studentID;
    }
}