package com.onlinecourse.platform.controller;

import com.onlinecourse.platform.entity.Course;
import com.onlinecourse.platform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public String getAllCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }
    
    @PostMapping
    public String createCourse(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/courses";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}