package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.NutritionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionLogRepo extends JpaRepository<NutritionLog, Long> {
}
