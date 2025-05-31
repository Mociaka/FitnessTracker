package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.Goal;
import org.example.fitnesstracker.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepo extends JpaRepository<Goal, Long> {
    List<Goal> findAllByUsers(Users users);
}
