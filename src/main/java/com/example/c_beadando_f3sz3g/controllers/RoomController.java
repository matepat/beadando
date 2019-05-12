package com.example.c_beadando_f3sz3g.controllers;

import com.example.c_beadando_f3sz3g.entities.Room;
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
public class RoomController {
    private CourseService courseService;
    private RoomService roomService;

    @Autowired
    public void setCourseService(CourseService courseService) {this.courseService = courseService;}
    @Autowired
    public void setRoomService(RoomService roomService) {this.roomService = roomService;}

    @RequestMapping("/terem/uj")
    public String getNemRoom(Model model){
        model.addAttribute("room", new Room());
        return "newroom";
    }

    @RequestMapping(value = "/terem/save", method = POST)
    public String saveLeve(@Valid Room room){
        roomService.saveOrUpdate(room);
        return "redirect:/";
    }

    @RequestMapping("/terem/{id}")
    public String getRoom(Model model, @PathVariable int id){
        model.addAttribute("room", roomService.getById(id));
        model.addAttribute("courses", courseService.listAllByRoomId(id));
        return "room";
    }

    @RequestMapping("/terem/szerkesztes/{id}")
    public String editRoom(Model model, @PathVariable int id){
        model.addAttribute("room", roomService.getById(id));
         return "editroom";
    }

    @RequestMapping("/terem/delete/{id}")
    public String deleteRoom(@PathVariable int id){
        roomService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/terem/update/{id}")
    public String updateRoom(@PathVariable int id, @Valid Room room){
        room.setId(id);
        roomService.saveOrUpdate(room);
        return "redirect:/";
    }
}
