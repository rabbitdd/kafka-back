package main.repository;

import main.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Long> {
    Queue getQueueById(Long id);
    List<Queue> getQueuesByUserId(Long userId);
}
