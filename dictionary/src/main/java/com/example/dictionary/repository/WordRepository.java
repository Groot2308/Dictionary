package com.example.dictionary.repository;

import com.example.dictionary.entity.Words;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WordRepository extends JpaRepository<Words, Integer> {

    List<Words> findByCategoryId(int id);

    @Query("SELECT w FROM Words w WHERE w.word LIKE %?1%")
    List<Words> findByWord(String word);

    Words findById(int wid);


}
