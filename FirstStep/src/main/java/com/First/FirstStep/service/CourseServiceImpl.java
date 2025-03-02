package com.First.FirstStep.service;

import com.First.FirstStep.Model.Course;
import com.First.FirstStep.exception.APIException;
import com.First.FirstStep.exception.ResourceNotFoundException;
import com.First.FirstStep.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll().stream().toList();
        if(courses.isEmpty()){
            throw  new APIException("No Courses");
        }
        return courses;
    }

    @Override
    public Course createCourse(Course course) {
        Course savingCourse = courseRepository.findByCourseName(course.getCourseName());
        if(savingCourse!=null){
            throw new APIException("Course with CourseName " + course.getCourseName() + " already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course ,Long courseId) {
        Course savedCourseOptional = courseRepository.findById(courseId)
                .orElseThrow(()->  new ResourceNotFoundException("Course","CourseId",courseId));
        course.setCourseId(courseId);
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()->new ResourceNotFoundException("Course","CourseId",courseId));
        courseRepository.delete(course);
    }
}
