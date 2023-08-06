package com.example.dictionary.repository;

import com.example.dictionary.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Integer> {

   List<SearchHistory> findWordByUserId(int uid);

}
//    void insertSearch(int wid, int uid);