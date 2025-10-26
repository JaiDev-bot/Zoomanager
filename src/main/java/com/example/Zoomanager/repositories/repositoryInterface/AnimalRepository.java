package com.example.Zoomanager.repositories.repositoryInterface;

import com.example.Zoomanager.entity.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
    List<Animal> findHungryAnimals();

}