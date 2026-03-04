package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Course;
import com.example.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if (course.getTitle() == null || course.getTitle().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Course title cannot be empty");
        }

        Course saved = service.addCourse(course);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllCourses());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {

        Course course = service.getCourseById(id);

        if (course == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Course not found with id " + id);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(course);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(
            @PathVariable int id,
            @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if (updated == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Cannot update. Course not found.");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Course deleted successfully");
    }

    // SEARCH BY TITLE
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> list = service.searchByTitle(title);

        if (list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No courses found with title: " + title);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }
}
