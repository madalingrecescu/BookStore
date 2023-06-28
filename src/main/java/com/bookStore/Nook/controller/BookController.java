package com.bookStore.Nook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.Nook.entity.Book;
import com.bookStore.Nook.entity.FavoriteBookList;
import com.bookStore.Nook.service.BookService;
import com.bookStore.Nook.service.FavoriteBookListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private FavoriteBookListService favoriteBookListService;
	

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
	
	@GetMapping("/favorite_books")
	public String getFavoriteBooks(Model model) {
		List<FavoriteBookList> list = favoriteBookListService.getAllFavoriteBooks();
		model.addAttribute("book",list);
		return "favoriteBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getFavoriteList(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		FavoriteBookList favoriteBook = new FavoriteBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
		favoriteBookListService.saveFavoriteBook(favoriteBook);
		return  "redirect:/favorite_books";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
