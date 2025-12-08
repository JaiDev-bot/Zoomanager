package com.example.Zoomanager.repositories.repositoryInterface;

import com.example.Zoomanager.entity.Especie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {}