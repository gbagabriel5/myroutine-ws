package com.example.caravan.repository;

import com.example.caravan.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByTitleIgnoreCaseContaining(String title);
}
