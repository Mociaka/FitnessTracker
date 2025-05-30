package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepo extends JpaRepository<Goal, Long> {
}
