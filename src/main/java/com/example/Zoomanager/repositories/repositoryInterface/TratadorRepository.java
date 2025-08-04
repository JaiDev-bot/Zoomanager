package com.example.Zoomanager.repositories.repositoryInterface;

import com.example.Zoomanager.entity.Tratador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratadorRepository extends JpaRepository<Tratador, Long> {
}