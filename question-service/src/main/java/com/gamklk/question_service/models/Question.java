package com.gamklk.question_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String questionTitle;

    @Column(nullable = false)
    private String option1;

    @Column(nullable = false)
    private String option2;

    @Column(nullable = false)
    private String option3;

    @Column(nullable = false)
    private String option4;

    @Column(nullable = false)
    private String difficultyLevel;

    @Column(nullable = false)
    private String category;
}
