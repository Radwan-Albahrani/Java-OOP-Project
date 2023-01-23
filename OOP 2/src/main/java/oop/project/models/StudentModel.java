package oop.project.models;

public class StudentModel extends UserModel
{
    private String courseID;
    private String courseName;
    private double quizGrade;
    private double midtermGrade;
    private double finalGrade;
    private double projectGrade;
    private double totalGrade;

    public String getCourseID()
    {
        return courseID;
    }

    public void setCourseID(String courseID)
    {
        this.courseID = courseID;
    }

    public double getQuizGrade()
    {
        return quizGrade;
    }

    public void setQuizGrade(double quizGrade)
    {
        this.quizGrade = quizGrade;
    }

    public double getMidtermGrade()
    {
        return midtermGrade;
    }

    public void setMidtermGrade(double midtermGrade)
    {
        this.midtermGrade = midtermGrade;
    }

    public double getProjectGrade()
    {
        return projectGrade;
    }

    public void setProjectGrade(double projectGrade)
    {
        this.projectGrade = projectGrade;
    }

    public double getFinalGrade()
    {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade)
    {
        this.finalGrade = finalGrade;
    }

    public double getTotalGrade()
    {
        return totalGrade;
    }

    public void setTotalGrade(double totalGrade)
    {
        this.totalGrade = totalGrade;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
}
