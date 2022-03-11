package com.example.music.controller;


import com.example.music.dto.MusicDto;
import com.example.music.model.Music;
import com.example.music.service.IMusicService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String index(Model model) {
//        List<Music> musicList = musicService.findAll();
//        model.addAttribute("musicList", musicList);
//        return "index";
        model.addAttribute("musicList", musicService.findAll());
        return "/views/index";
    }

    @GetMapping("/creat")
    public String creat(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/views/creat";

    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        Be
//
//        musicService.save(music);
//        redirectAttributes.addFlashAttribute("message", "Creat ok");
//        return "redirect:/music";
        if (bindingResult.hasErrors()) {
            return "/views/creat";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Creat ok");
            return "redirect:/music";


        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/views/edit";
    }

    @PostMapping("/update")
    public String update(Music music, RedirectAttributes redirectAttributes) {
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message", "Update ok");

        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        musicService.remove(id);
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "/views/index";

    }

    @GetMapping("/views/{id}")
    public String views(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/views/views";
    }
}
