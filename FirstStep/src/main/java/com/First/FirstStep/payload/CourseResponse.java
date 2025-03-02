package com.First.FirstStep.payload;

import com.First.FirstStep.Model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    List<Course> content;
}
