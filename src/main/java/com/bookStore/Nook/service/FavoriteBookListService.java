package com.bookStore.Nook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Nook.entity.FavoriteBookList;
import com.bookStore.Nook.repository.FavoriteBookListRepository;

@Service
public class FavoriteBookListService {

	@Autowired
	private FavoriteBookListRepository favoriteBookListRepository;
	
	public void saveFavoriteBook(FavoriteBookList book) {
		favoriteBookListRepository.save(book);
	}
	
	public List<FavoriteBookList> getAllFavoriteBooks(){
		return favoriteBookListRepository.findAll();
	}
	
	public void deleteById(int id) {
		favoriteBookListRepository.deleteById(id);
	}
}
