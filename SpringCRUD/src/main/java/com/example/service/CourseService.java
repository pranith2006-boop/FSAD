package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.model.Course;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    // ADD
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    // GET ALL
    public List<Course> getAllCourses() {
        return courseList;
    }

    // GET BY ID
    public Course getCourseById(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public Course updateCourse(int id, Course updatedCourse) {
        Course existing = getCourseById(id);

        if (existing != null) {
            existing.setTitle(updatedCourse.getTitle());
            existing.setDuration(updatedCourse.getDuration());
            existing.setFee(updatedCourse.getFee());
            return existing;
        }
        return null;
    }

    // DELETE
    public boolean deleteCourse(int id) {
        Course course = getCourseById(id);
        if (course != null) {
            courseList.remove(course);
            return true;
        }
        return false;
    }

    // SEARCH BY TITLE
    public List<Course> searchByTitle(String title) {
        return courseList.stream()
                .filter(c -> c.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
