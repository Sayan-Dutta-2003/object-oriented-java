package com.University.applicants;

import com.University.courses.Course;

public class Applicant {
    private final String applicantId;
    private final String name;
    private final double grade;
    private Course selectedCourse;

    public Applicant(String id, String name, double grade) {
        this.applicantId = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public String getApplicantId() { return applicantId; }
    public String getName() { return name; }
    public double getGrade() { return grade; }
    public Course getSelectedCourse() { return selectedCourse; }

    public void selectCourse(Course course) {
        this.selectedCourse = course;
    }
}