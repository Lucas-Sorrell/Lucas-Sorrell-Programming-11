//import ArrayList so we can store lists of students and teachers
import java.util.ArrayList;

public class School
{
    //lists to hold teacher and student objects
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    //basic info about the school
    private String schoolName;
    private String country;
    private int district;

    //default constructor creates empty school
    School()
    {
        schoolName = "";
        country = "";
        district = 0;
    }

    //custom constructor allows setting name, country, and district right away
    School(String schoolName, String country, int district)
    {
        this.schoolName = schoolName;
        this.country = country;
        this.district = district;
    }

    //basic getters and setters for school info
    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public int getDistrict()
    {
        return district;
    }

    public void setDistrict(int district)
    {
        this.district = district;
    }

    //adds a student to the student list
    public void addStudent(String firstName, String lastName, int grade)
    {
        Student newStudent = new Student(firstName, lastName, grade);
        students.add(newStudent);
    }

    //adds a teacher to the teacher list
    public void addTeacher(String firstName, String lastName, String subject)
    {
        Teacher newTeacher = new Teacher(firstName, lastName, subject);
        teachers.add(newTeacher);
    }

    //finds a student in the list based on name and returns their index (or -1 if not found)
    private int getStudentIndexByName(String firstName, String lastName)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if ((students.get(i).getFirstName().equals(firstName)) && (students.get(i).getLastName().equals(lastName)))
            {
                return i;
            }
        }
        return -1;
    }

    //deletes a student based on their name (returns true if successful, false if not found)
    public boolean deleteStudent(String firstName, String lastName)
    {
        int studentIndex = getStudentIndexByName(firstName, lastName);
        if (studentIndex >= 0)
        {
            students.remove(studentIndex);
            return true;
        }
        return false;
    }

    //same logic as student version, but for teachers
    private int getTeacherIndexByName(String firstName, String lastName)
    {
        for (int i = 0; i < teachers.size(); i++)
        {
            if ((teachers.get(i).getFirstName().equals(firstName)) && (teachers.get(i).getLastName().equals(lastName)))
            {
                return i;
            }
        }
        return -1;
    }

    //removes a teacher by name (true if successful)
    public boolean deleteTeacher(String firstName, String lastName)
    {
        int teacherIndex = getTeacherIndexByName(firstName, lastName);
        if (teacherIndex >= 0)
        {
            teachers.remove(teacherIndex);
            return true;
        }
        return false;
    }

    //print all students in the school
    public void showAllStudents()
    {
        System.out.println("Students: ");
        for (int i = 0; i < students.size(); i++)
        {
            students.get(i).printSelf();
        }
    }

    //print all teachers in the school
    public void showAllTeachers()
    {
        System.out.println("Teachers: ");
        for (int i = 0; i < teachers.size(); i++)
        {
            teachers.get(i).printSelf();
        }
    }
}