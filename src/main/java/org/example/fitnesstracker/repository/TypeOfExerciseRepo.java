package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.TypeOfExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfExerciseRepo extends JpaRepository<TypeOfExercise, Long> {
}
