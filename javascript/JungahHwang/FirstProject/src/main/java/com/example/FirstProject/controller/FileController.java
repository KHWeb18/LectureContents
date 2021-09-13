package com.example.FirstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fileUpload")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileController {

    @PostMapping("/recommend")
    @ResponseBody
    public String recommendFileUpload (@RequestParam(value = "fileList", required = false) List<MultipartFile> fileList,
                              @RequestParam("boardNo") Long boardNo, @RequestParam("id") String id) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/recommend/" + boardNo + "_" + id + ".jpg");
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Recommend File Upload Fail";
        }
        return "Recommend File Upload Success";
    }

    @PostMapping("/together")
    @ResponseBody
    public String togetherFileUpload (@RequestParam(value = "fileList", required = false) List<MultipartFile> fileList,
                              @RequestParam("boardNo") Long boardNo, @RequestParam("id") String id) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/together/" + boardNo + "_" + id + ".jpg");
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Together File Upload Fail";
        }
        return "Together File Upload Success";
    }
}
