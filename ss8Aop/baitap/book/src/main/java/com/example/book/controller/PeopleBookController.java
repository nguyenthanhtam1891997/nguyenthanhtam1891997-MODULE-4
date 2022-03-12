package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.Book_People;
import com.example.book.model.People;
import com.example.book.service.book.IBookService;
import com.example.book.service.book_people.IBookPeopleService;
import com.example.book.service.people.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/book")
public class PeopleBookController {

    @Autowired
    private IPeopleService peopleService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookPeopleService bookPeopleService;

    @GetMapping("")
    public String showBook(Model model) {
        model.addAttribute("bookList", bookService.findAll());

        model.addAttribute("bookPeople", new Book_People());
        model.addAttribute("bookPeopleList", bookPeopleService.findAll());

        model.addAttribute("peopleList", peopleService.findAll());
        return "listBook";
    }

    @PostMapping("/rental")
    public String rentalBook(Book_People bookPeople, RedirectAttributes redirectAttributes,Model model) {

        Book book = bookService.findById(bookPeople.getBook().getId());

        if (book.getAmountBook() <= 0) {
//            redirectAttributes.addFlashAttribute("message", "sách bạn thuê không có");
            model.addAttribute("message","sách bạn thuê không có");
            return "error";
        } else {
            book.setAmountBook(book.getAmountBook() - 1);
            bookPeople.setCodeBook(String.valueOf(new Random().nextInt(100) + 1));
            bookPeopleService.save(bookPeople);
            redirectAttributes.addFlashAttribute("message", "thuê sách được rồi");
            return "redirect:/book";
        }

    }

    @PostMapping("/give")
    public String giveBook(@RequestParam String codeBook, RedirectAttributes redirectAttributes,Model model) {
        if (bookPeopleService.findByCodeBook(codeBook) == null) {
//            redirectAttributes.addFlashAttribute("message", "mã mượng sách không đúng ");
            model.addAttribute("message","mã mượng sách không đúng ");
            return "error";

        } else {
            Book_People bookPeople = bookPeopleService.findByCodeBook(codeBook);
            Book book = bookService.findById(bookPeople.getBook().getId());
            book.setAmountBook(book.getAmountBook() + 1);
            bookPeopleService.remove(bookPeople.getId());
            redirectAttributes.addFlashAttribute("message", "đã trả được sách ");
            return "redirect:/book";
        }



    }
}
