package service;

import com.crud.dish.entity.Dish;
import com.crud.dish.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DishService {

    Dish createDish(Dish dish);

    Dish createReview(Review review);

    void deleteReview(Review review);

    void deleteDish(Dish dish);

    List<Dish> findAllDishes();
}
