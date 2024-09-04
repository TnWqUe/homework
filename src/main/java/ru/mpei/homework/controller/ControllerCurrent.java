package ru.mpei.homework.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mpei.homework.service.DetailsService;


@RestController
@Slf4j
public class ControllerCurrent {

    @Autowired
    private DetailsService repo;

    //задание уставки
    @GetMapping("/saveSetPoint")
    public void saveSetPoint(@RequestParam double setPoint){
        repo.saveSetPoint(setPoint);
    }

    //поиск фаз, где происходит короткое замыкание
    @GetMapping("/data/findFault")
    public String findFault(@RequestParam long startIndex, @RequestParam long endIndex){
        return repo.findFault(startIndex, endIndex);
    }
}
