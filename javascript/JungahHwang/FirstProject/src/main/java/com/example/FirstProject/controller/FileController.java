package com.example.FirstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileController {

    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload (@RequestParam(value = "fileList", required = false) List<MultipartFile> fileList) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail";
        }
        return "Upload Success";
    }
}
