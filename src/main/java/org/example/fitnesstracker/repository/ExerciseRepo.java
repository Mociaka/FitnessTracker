package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
}
