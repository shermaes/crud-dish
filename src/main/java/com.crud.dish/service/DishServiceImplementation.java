package com.crud.dish.service;

import com.crud.dish.entity.Dish;
import com.crud.dish.entity.Review;
import com.crud.dish.repository.DishRepository;
import com.crud.dish.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImplementation implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish createReview(Review review) {
        Dish dish = dishRepository.findById(review.getFkDishId()).get();
        dish.addReview(review);
        reviewRepository.save(review);
        return dishRepository.save(dish);
    }

    @Override
    public void deleteReview(Review review) {
    reviewRepository.deleteById(review.getId());

    }

    @Override
    public void deleteDish(Dish dish) {
        Dish dishToBeDeleted = dishRepository.findById(dish.getId()).get();
        if(dishToBeDeleted.getReviews().size()>=0){
            dishToBeDeleted.getReviews().forEach(review -> reviewRepository.deleteById(review.getId()));
        }
        dishRepository.deleteById(dish.getId());
    }

    @Override
    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }
}
