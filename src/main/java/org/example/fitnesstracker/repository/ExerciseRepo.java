package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
}
