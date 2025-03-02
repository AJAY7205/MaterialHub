package com.First.FirstStep.controller;

import com.First.FirstStep.Model.Course;
import com.First.FirstStep.repositories.CourseRepository;
import com.First.FirstStep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> course = courseService.getAllCourses();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        courseService.createCourse(course);
        return new ResponseEntity<>(course ,HttpStatus.CREATED);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long courseId){
        Course updatedCourse = courseService.updateCourse(course, courseId);
        return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>("Deleted SuccessFully: " + courseId,HttpStatus.OK);
    }
}
