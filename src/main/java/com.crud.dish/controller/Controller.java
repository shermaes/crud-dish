package com.crud.dish.controller;

import com.crud.dish.entity.Dish;
import com.crud.dish.entity.Review;
import com.crud.dish.service.DishService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private DishService service;

    @GetMapping("get/dishes")
    public List<Dish> getAllDishes(){
        return service.findAllDishes();
    }

    @PostMapping("save/dish")
    public Dish createDish(@RequestBody Dish dish){
    return service.createDish(dish);
    }

    @PostMapping("save/review")
    public Dish createReview(@RequestBody Review review){
        return service.createReview(review);
    }

    @DeleteMapping("delete/dish")
    public void deleteDish(@RequestBody Dish dish){
        service.deleteDish(dish);
    }

    @DeleteMapping("delete/review")
    public void deleteReview(@RequestBody Review review){
        service.deleteReview(review);
    }
}
