package org.example.fitnesstracker.repository;

import org.example.fitnesstracker.models.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepo extends JpaRepository<Progress, Long> {
}
