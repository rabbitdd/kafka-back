package main.controller;

import main.entity.Official;
import main.entity.Queue;
import main.entity.QueueBack;
import main.repository.DocumentRepository;
import main.service.OfficialService;
import main.service.QueueService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @Autowired
    UserService userService;

    @Autowired
    OfficialService officialService;

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

    @GetMapping("/getUserQueue")
    List<QueueBack> getQueueByUser(@RequestParam String login){
        List<QueueBack> queueBacks = new ArrayList<>();
        long id = userService.getUserId(login);
        List<Queue> queues = queueService.getAllQueueByUserId(id);
        for(int i = 0; i < queues.size(); i++){
            QueueBack qb = new QueueBack();
            qb.setId(queues.get(i).getId());
            Official official = officialService.getOfficialById(queues.get(i).getOfficialId());
            qb.setName(official.getName() + " " + official.getSurname());
            System.out.println(qb.getName());
            qb.setPlace(queues.get(i).getPlace());
            qb.setPriority(queues.get(i).getPriority());
            qb.setTime(official.getTimeOfReceipts().toString());
            queueBacks.add(qb);
        }
        return queueBacks;
    }
}
