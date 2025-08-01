package com.example.Zoomanager.repositories.RepositoryInterface;

import com.example.Zoomanager.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

