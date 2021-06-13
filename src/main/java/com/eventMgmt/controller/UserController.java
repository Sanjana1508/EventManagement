package com.eventMgmt.controller;

import com.eventMgmt.entity.User;
import com.eventMgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUsers(Model theModel){

        List<User> users= userService.findAll();
        theModel.addAttribute("users",users);
        return "listUsers";

    }
}
