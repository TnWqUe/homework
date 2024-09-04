package ru.mpei.homework.controller;
//отдельный контроллер для работы с файлом
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.mpei.homework.service.FileService;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/data/upload")
    public void uploadFile(@RequestParam MultipartFile file){
        fileService.parseFile(file);
    }

}