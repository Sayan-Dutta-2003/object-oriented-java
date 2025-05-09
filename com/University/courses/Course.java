package com.University.courses;

public class Course {
    private final String courseCode;
    private final String courseName;
    private final int capacity;
    private int enrolled;
    private final double minGrade;

    public Course(String code, String name, int cap, double minGrade) {
        this.courseCode = code;
        this.courseName = name;
        this.capacity = cap;
        this.minGrade = minGrade;
        this.enrolled = 0;
    }


    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCapacity() { return capacity; }
    public int getEnrolled() { return enrolled; }
    public double getMinGrade() { return minGrade; }

    public boolean canEnroll() {
        return enrolled < capacity;
    }

    public void enrollStudent() {
        if(canEnroll()) enrolled++;
    }
}