package com.example.dictionary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Words")
@Data
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private int id;
    @Column(name = "word")
    private String word;
    @Column(name = "phonics")
    private String phonics;
    @Column(name = "translations")
    private String translations;
    @Column(name = "definition")
    private String definition;
    @Column(name = "example")
    private String example;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "image")
    private String image;

    public Words() {
    }

    public Words(int id, String word, String phonics, String translations, String definition, String example, Category category, String image) {
        this.id = id;
        this.word = word;
        this.phonics = phonics;
        this.translations = translations;
        this.definition = definition;
        this.example = example;
        this.category = category;
        this.image = image;
    }


}