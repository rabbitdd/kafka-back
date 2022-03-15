package main.service;

import main.entity.Queue;
import main.entity.Schedule;
import main.repository.QueueRepository;
import main.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueService {


    private final QueueRepository queueRepository;
    private final ScheduleRepository scheduleRepository;

    public QueueService(QueueRepository queueRepository, ScheduleRepository scheduleRepository) {
        this.queueRepository = queueRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public Queue getQueueById(Long id) {
        return queueRepository.getQueueById(id);
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.getScheduleById(id);
    }

    public List<Queue> getAllQueueByUserId(Long id) {
        List<Queue> queues = queueRepository.getQueuesByUserId(id);
        if (queues != null) {
            return queues;
        }
        return new ArrayList<>();
    }
}
