public class Teacher
{
    //teacher's basic info
    private String firstName;
    private String lastName;
    private String subject;

    //default constructor (empty teacher)
    Teacher()
    {
        firstName = "";
        lastName = "";
        subject = "";
    }

    //custom constructor for creating teachers
    Teacher(String firstName, String lastName, String subject)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    //getters and setters
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

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    //method to print the teacher's info in a readable format
    public void printSelf()
    {
        System.out.println("Name: " + firstName + " " + lastName + " | Subject: " + subject);
    }

    //optional string representation if needed
    @Override
    public String toString()
    {
        return "Name: " + firstName + " " + lastName + " | Subject: " + subject;
    }
}