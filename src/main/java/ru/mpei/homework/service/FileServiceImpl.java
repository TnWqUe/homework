package ru.mpei.homework.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.mpei.homework.repository.CurrentRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private CurrentRepository repo;

    @Override
    @SneakyThrows
    public void parseFile(MultipartFile file) {
        InputStream inputStream = file.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        //чтение каждой строки и ее обработка
        while (line != null) {
            String[] stringParts = line.split(",");
            if (stringParts.length > 3) {
                String ia = stringParts[1];
                String ib = stringParts[2];
                String ic = stringParts[3];
                log.info("Time = {} , ia ={}, ib ={}, ic={}", ia, ib, ic);
                repo.addPoint(Double.parseDouble(ia),Double.parseDouble(ib),Double.parseDouble(ic));
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        log.info("FIle read successfully");
    }
}