package com.bookStore.Nook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.Nook.entity.Book;
import com.bookStore.Nook.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getAllBook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("bookList");   nume template
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.save(book);
		
		return "redirect:/available_books";
	}
}
