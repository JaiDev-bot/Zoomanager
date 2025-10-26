package com.example.Zoomanager.dto.animalDTO;

import java.time.LocalTime;

public record AnimalSearchDTO(Long id, String name, Long idEspecie, LocalTime LastTimeFed) {}
