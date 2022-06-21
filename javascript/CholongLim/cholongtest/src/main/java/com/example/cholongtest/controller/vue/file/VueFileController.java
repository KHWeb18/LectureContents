package com.example.cholongtest.controller.vue.file;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RequestMapping(value = "/file")
// 데이터 처리
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueFileController {
    @PostMapping("/uploadImg")
    @ResponseBody
    // RequestParam로 해당 정보가 들어옴
    public String requestUploadFile(
            @RequestParam("fileList")  List<MultipartFile> fileList) {

        log.info("requestUploadFile(): Processing");

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // 뷰에서 넘겨줄때 images/아이디/사진파일명/확장자 (아이디를 추가시킨다)
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail...;(";
        }

        return "Upload Success:)";
    }
}
