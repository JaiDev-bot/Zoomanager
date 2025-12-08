package com.example.Zoomanager.dto.animalDTO;

import java.time.LocalDateTime;

public record AnimalSearchDTO(Long id, String name, Long idEspecie, LocalDateTime LastTimeFed) {}
