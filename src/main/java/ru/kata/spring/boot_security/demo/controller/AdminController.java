package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.util.ArrayList;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(Model model) {

        model.addAttribute("people", userService.getAllUsers());

        return "admin";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {

        model.addAttribute("person", userService.getById(id));
        return "show";
    }

    @GetMapping("/addUser")
    public String newUser(@ModelAttribute("user") User user, Role role) {
        return "addUser";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user,
                                @RequestParam("listRoles") ArrayList<Long> roles) {

        userService.saveUser(user, roleService.getAllRoles(roles));
        return "redirect:/admin";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam("listRoles") ArrayList<Long> roles) {
        userService.update(user, roleService.getAllRoles(roles));
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

}
