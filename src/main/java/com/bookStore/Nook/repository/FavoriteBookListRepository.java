package com.bookStore.Nook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.Nook.entity.FavoriteBookList;

@Repository
public interface FavoriteBookListRepository extends JpaRepository<FavoriteBookList, Integer>{

}
