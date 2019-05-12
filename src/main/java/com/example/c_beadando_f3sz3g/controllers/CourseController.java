package com.example.c_beadando_f3sz3g.controllers;

import com.example.c_beadando_f3sz3g.entities.Course;
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
        model.addAttribute("course", new Course());
        model.addAttribute("rooms", roomService.listAll());
        return "newcourse";
    }

    @RequestMapping(value = "/kurzus/save", method = POST)
    public String saveCourse(@Valid Course course){
        courseService.saveOrUpdate(course);
        return "redirect:/";
    }

    @RequestMapping("/kurzus/{id}")
    public String getCourse(@PathVariable int id, Model model){
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        model.addAttribute("room", roomService.getById(course.getRoomId()));
        return "course";
    }

    @RequestMapping("/kurzus/szerkesztes/{id}")
    public String getEditCourse(Model model, @PathVariable int id){
        model.addAttribute("course", courseService.getById(id));
        model.addAttribute("rooms", roomService.listAll());
        return "editcourse";
    }

    @RequestMapping("/kurzus/edit/{id}")
    public String updateCourse(@PathVariable int id, @Valid Course updatedCourse){
        updatedCourse.setId(id);
        courseService.saveOrUpdate(updatedCourse);
        return "redirect:/";
    }

    @RequestMapping("/kurzus/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.delete(id);
        return "redirect:/";
    }
}
