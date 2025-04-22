package com.explorer.user_service.repository;

import com.explorer.user_service.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Person, Long> {

    List<Person> findByRole(String role);
}

/*
List<Car> findByBrand(String brand);
    List<Car> findByCarType(CarType carType);
    List<Car> findByCarStatus(CarStatus carStatus);
    @Query("SELECT c FROM Car c WHERE c.seats > 5 AND c.carStatus = 'AVAILABLE'")
    List<Car> findMoreThan5Seats();
 */