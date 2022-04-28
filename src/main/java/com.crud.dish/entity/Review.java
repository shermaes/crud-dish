package com.crud.dish.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="Review")
@Table(name="review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private Long fkDishId;

}
