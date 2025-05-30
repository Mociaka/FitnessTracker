package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepo extends JpaRepository<Goal, Long> {
}
