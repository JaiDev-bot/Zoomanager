package com.example.Zoomanager.repositories.repositoryInterface;

import com.example.Zoomanager.entity.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
    @Query(
        nativeQuery = true,
        value = """
            SELECT a.*
            FROM animal a
            JOIN especie e ON a.id_especie = e.id
            WHERE (
                e.horario_primeira_refeicao IS NOT NULL
                AND current_time > e.horario_primeira_refeicao
                AND a.last_time_fed < (current_date + e.horario_primeira_refeicao)
            )
            OR (
                e.horario_segunda_refeicao IS NOT NULL
                AND current_time > e.horario_segunda_refeicao
                AND a.last_time_fed < (current_date + e.horario_segunda_refeicao)
            )
            OR (
                e.horario_terceira_refeicao IS NOT NULL
                AND current_time > e.horario_terceira_refeicao
                AND a.last_time_fed < (current_date + e.horario_terceira_refeicao)
            )
        """
    )
    List<Animal> findHungryAnimals();

}