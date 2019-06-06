package com.example.c_beadando_f3sz3g.controllers;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.entities.Room;
import com.example.c_beadando_f3sz3g.services.CourseService;
import com.example.c_beadando_f3sz3g.services.RoomService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApiController {
    private CourseService courseService;
    private RoomService roomService;

    @Autowired
    public void setCourseService(CourseService courseService) {this.courseService = courseService;}
    @Autowired
    public void setRoomService(RoomService roomService) {this.roomService = roomService;}

    @ResponseBody
    @RequestMapping("/api/room/getbyid/{id}")
    public String getRoomById(@PathVariable int id){
        Room room = roomService.getById(id);
        String rtnJson = "";
        try {
            rtnJson = new JSONObject()
                    .put("status", "ok")
                    .put("name",room.getName())
                    .put("level", room.getLevel())
                    .put("id", room.getId())
                    .toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rtnJson;
    }

    @ResponseBody
    @RequestMapping("/api/course/getbyroomid/{id}")
    public String getCourseByRoom(@PathVariable int id){
        Room room = roomService.getById(id);
        List<Course> courses = courseService.listAllByRoom(room);
        JSONObject coursesJson = new JSONObject();
        JSONArray coursesListJson = new JSONArray();
        try {
            coursesJson.put("status", "ok");
            for(Course course : courses){
                JSONObject courseJson = new JSONObject();
                courseJson.put("name", course.getName());
                courseJson.put("id", course.getId());
                coursesListJson.put(courseJson);
            }
            coursesJson.put("courses", coursesListJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return coursesJson.toString();
    }
}
