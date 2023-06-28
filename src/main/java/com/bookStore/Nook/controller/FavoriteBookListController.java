package com.bookStore.Nook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.Nook.service.FavoriteBookListService;

@Controller
public class FavoriteBookListController {
	
	@Autowired
	private FavoriteBookListService favoriteBookListService;

	@RequestMapping("/deleteFavoriteList/{id}")
	public String deleteFavoriteBookList(@PathVariable("id") int id) {
		favoriteBookListService.deleteById(id);
		return "redirect:/favorite_books";
	}
}
