package com.example.controller;

import com.example.model.NaSaImg;
import com.example.service.INasaImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/nasa")
public class NasaController {
    @Autowired
    private INasaImgService nasaImgService;

    @GetMapping("")
    public String index(Model model, ModelMap modelMap) {

        model.addAttribute("comment", new NaSaImg());
        List<NaSaImg> naSaImgList = nasaImgService.findAll();
        modelMap.addAttribute("listComment", naSaImgList);
        return "index";
    }

    @PostMapping("/comment")
    public String save(NaSaImg naSaImg, RedirectAttributes redirectAttributes) {
        nasaImgService.save(naSaImg);
        redirectAttributes.addFlashAttribute("message", "save ok");
        return "redirect:/nasa";
    }


    @GetMapping("/like/{id}")
    public String like(@PathVariable long id,RedirectAttributes redirectAttributes){
        NaSaImg naSaImg = nasaImgService.findById(id);
        naSaImg.setLike(naSaImg.getLike()+1);
        nasaImgService.update(naSaImg);
        redirectAttributes.addFlashAttribute("message","like ok");
        return "redirect:/nasa";
    }
}
