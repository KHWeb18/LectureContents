package com.example.demo.controller.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
// value는 생략가능
@RequestMapping(value = "/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Controller0820File {

    @PostMapping("/upload")
    @ResponseBody
    public String requestUploadFile(
            @RequestParam(value = "fileList", required = false) List<MultipartFile> fileList) {
        try {
            // 저장되는 위치: 'image/파일명.확장자'
            // 같은 이름의 파일을 올릴경우 'image/아이디/파일명.확장자' 로 저장할 수 있도록 수정하기
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
























