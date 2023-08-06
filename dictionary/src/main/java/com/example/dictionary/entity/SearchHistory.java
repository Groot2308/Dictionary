package com.example.dictionary.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "SearchHistory")
@Data
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Words word;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "search_date")
    private Date createDate;

    public SearchHistory(){

    }

    public SearchHistory(int id, Words word, User user, Date createDate) {
        this.id = id;
        this.word = word;
        this.user = user;
        this.createDate = createDate;
    }
}
