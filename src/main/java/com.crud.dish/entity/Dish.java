package com.crud.dish.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Dish")
@Table(name = "dish")
@Data
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String plate;

    private String chef;

    private Integer price;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )

    private List<Review> reviews = new ArrayList<>();

    public Dish addReview(Review review) {
        this.reviews.add(review);
        return this;
    }

}
