package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.NutritionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionLogRepo extends JpaRepository<NutritionLog, Long> {
}
