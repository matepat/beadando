package com.example.c_beadando_f3sz3g.controllers;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.entities_form.CourseForm;
import com.example.c_beadando_f3sz3g.services.CourseService;
import com.example.c_beadando_f3sz3g.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CourseController {
    private CourseService courseService;
    private RoomService roomService;

    @Autowired
    public void setCourseService(CourseService courseService) {this.courseService = courseService;}
    @Autowired
    public void setRoomService(RoomService roomService) {this.roomService = roomService;}

    @RequestMapping("/kurzus/uj")
    public String getNewCourse(Model model){
        model.addAttribute("course", new CourseForm());
        model.addAttribute("rooms", roomService.listAll());
        return "newcourse";
    }

    @RequestMapping(value = "/kurzus/save", method = POST)
    public String saveCourse(@Valid CourseForm courseForm){
        courseService.saveOrUpdate(courseService.CourseFormToCourse(courseForm));
        return "redirect:/";
    }

    @RequestMapping("/kurzus/{id}")
    public String getCourse(@PathVariable int id, Model model){
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        model.addAttribute("room", course.getRoom());
        return "course";
    }

    @RequestMapping("/kurzus/szerkesztes/{id}")
    public String getEditCourse(Model model, @PathVariable int id){
        model.addAttribute("course", new CourseForm(courseService.getById(id)));
        model.addAttribute("rooms", roomService.listAll());
        return "editcourse";
    }

    @RequestMapping("/kurzus/edit/{id}")
    public String updateCourse(@PathVariable int id, @Valid CourseForm updatedCourseForm){
        updatedCourseForm.setId(id);
        courseService.saveOrUpdate(courseService.CourseFormToCourse(updatedCourseForm));
        return "redirect:/";
    }

    @RequestMapping("/kurzus/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.delete(id);
        return "redirect:/";
    }
}
