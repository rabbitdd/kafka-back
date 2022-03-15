package main.controller;

import main.entity.Queue;
import main.repository.DocumentRepository;
import main.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @GetMapping("/queue/get")
    String getQueue(@RequestParam Long id) {
        return queueService.getQueueById(id).toString();
    }

    @GetMapping("/queue/schedule/get")
    String getSchedule(@RequestParam Long id) {
        return queueService.getScheduleById(id).toString();
    }

    @GetMapping("/queue/getAll")
    List<Queue> getQueueAllByUserId(@RequestParam Long id) {
        return queueService.getAllQueueByUserId(id);
    }
}
