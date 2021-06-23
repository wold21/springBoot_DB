package com.db.table.controller;

import com.db.table.domain.UserDTO;
import com.db.table.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public String getUserList(Model model){
        List<UserDTO> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "userList";
    }
}
