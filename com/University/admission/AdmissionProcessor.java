package com.University.admission;

import com.University.courses.Course;
import com.University.applicants.Applicant;

public class AdmissionProcessor {
    public boolean processApplication(Applicant applicant) {
        Course course = applicant.getSelectedCourse();
        if(course != null &&
                applicant.getGrade() >= course.getMinGrade() &&
                course.canEnroll()) {
            course.enrollStudent();
            return true;
        }
        return false;
    }
}

