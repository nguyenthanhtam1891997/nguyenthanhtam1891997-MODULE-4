package com.example.validation.controller;

import com.example.validation.dto.UserDto;
import com.example.validation.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/input";
    }
    @PostMapping("/validate")
    public ModelAndView validate(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ModelAndView("/input");
        }else {
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(userDto,userModel);
            return new ModelAndView("/result");
        }
    }

}
