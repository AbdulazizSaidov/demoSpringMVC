package com.vibenar.controller;

import com.vibenar.entity.Admin;
import com.vibenar.entity.User;
import com.vibenar.mapping.UserMapping;
import com.vibenar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/")
public class UserController {

   @Autowired
    public UserService userService;

   @Autowired
   ExportToPdfIn exportToPdfIn;

    @GetMapping("/")
    public String getIndex(){
        String ss = "index";
        return ss;
    }

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam(value = "log") String log, @RequestParam(value = "pass") String pass, Model model){
        List<Admin> admins = userService.getAdmins(log, pass);
        if(admins==null || admins.isEmpty()){
            return "error";
        }
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/cv")
    public String getCV(Model model, @RequestParam(value = "id") Integer id){
        List<User> list = userService.getUser(id);
        model.addAttribute("user", list.get(0));
        return "userCV";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.getUser(id).get(0));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/cv?id=" + user.getId();
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/toPdf/{id}")
    public void toPdf(@PathVariable("id") Long id, HttpServletResponse response){
        exportToPdfIn.toPdf(id, response);
    }

}
