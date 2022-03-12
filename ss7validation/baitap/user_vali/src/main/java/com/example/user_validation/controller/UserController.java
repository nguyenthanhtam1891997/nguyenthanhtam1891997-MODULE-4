package com.example.user_validation.controller;

import com.example.user_validation.dto.UserDto;
import com.example.user_validation.model.User;
import com.example.user_validation.service.IUserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String inputUser(Model model, @PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("userList", userService.findAll(pageable));

        return "input";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("userList", userService.findAll(pageable));
            return "input";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "add ok");

            return "redirect:/user";
        }
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("user",userService.findById(id));
        return "view";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        userService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete ok");
        return "redirect:/user";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("userDto",userService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute UserDto userDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
    new UserDto().validate(userDto,bindingResult);
    if (bindingResult.hasFieldErrors()){
        return "edit";
    }else {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","edit ok");
        return "redirect:/user";
    }

    }

}
