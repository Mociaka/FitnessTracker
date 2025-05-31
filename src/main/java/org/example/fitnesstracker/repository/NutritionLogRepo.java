package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.NutritionLog;
import org.example.fitnesstracker.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionLogRepo extends JpaRepository<NutritionLog, Long> {
    List<NutritionLog> findAllByUsers(Users user);
}
