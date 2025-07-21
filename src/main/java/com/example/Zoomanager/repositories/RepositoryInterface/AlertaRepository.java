package com.example.Zoomanager.repositories.RepositoryInterface;

import com.example.Zoomanager.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}