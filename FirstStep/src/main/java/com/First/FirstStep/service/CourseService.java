package com.First.FirstStep.service;

import com.First.FirstStep.Model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course createCourse(Course course);

    Course updateCourse(Course course,Long courseId);

    void deleteCourse(Long courseId);
}
