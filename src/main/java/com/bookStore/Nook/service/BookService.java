package com.bookStore.Nook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Nook.entity.Book;
import com.bookStore.Nook.repository.BookRepository;

@Service
public class BookService {

		@Autowired
		private BookRepository bookRepository;
		public BookService(BookRepository bookRepository) {
			
			this.bookRepository = bookRepository;
		}
		
		public void save(Book book) {
			bookRepository.save(book);
		}
		
		public List<Book> getAllBook(){
			return bookRepository.findAll();
		}
		
		public Book getBookById(int id) {
			return bookRepository.findById(id).get();
		}
}
