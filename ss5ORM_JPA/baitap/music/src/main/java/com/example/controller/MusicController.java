package com.example.controller;

import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String index(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/creat")
    public String creat(Model model) {
        model.addAttribute("music", new Music());
        return "creat";
    }

    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Creat ok");
        return "redirect:/music";
    }
    @GetMapping("/edit/{id}")
    public String edit( @PathVariable("id") long id,Model model){
        model.addAttribute("music",musicService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Music music,RedirectAttributes redirectAttributes){
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message","Update ok");

        return "redirect:/music";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id,Model model){
        musicService.remove(id);
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList",musicList);
        return "index";
    }
    @GetMapping("/views/{id}")
    public String views(@PathVariable long id,Model model){
        model.addAttribute("music",musicService.findById(id));
        return "views";
    }
}
