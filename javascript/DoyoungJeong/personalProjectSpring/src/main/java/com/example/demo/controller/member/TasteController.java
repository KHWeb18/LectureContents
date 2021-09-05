package com.example.demo.controller.member;

import com.example.demo.controller.member.request.TasteRequest;
import com.example.demo.entity.member.MemberTaste;
import com.example.demo.service.member.TasteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("/member/taste")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TasteController {

    @Autowired
    TasteService tasteService;

    @PostMapping("/postTaste")
    public ResponseEntity<Void> postTaste(@Validated @RequestBody TasteRequest tasteRequest) throws Exception {
        log.info("postTaste(): " + tasteRequest);

        boolean isNotDecidedYet = tasteService.isDecidedOrNot(tasteRequest.getMemberNo());

        if(isNotDecidedYet) {
            tasteService.addTaste(tasteRequest);
        } else if(!isNotDecidedYet) {
            tasteService.updateTaste(tasteRequest);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/alreadyDecidePref/{memberNo}")
    public ResponseEntity<Boolean> getDecidedOrNot(@PathVariable ("memberNo") Integer memberNo) throws Exception {
        log.info("getDecidedOrNot(): " + memberNo);

        boolean isNotDecidedYet = tasteService.isDecidedOrNot(memberNo);

        return new ResponseEntity<Boolean>(isNotDecidedYet, HttpStatus.OK);
    }

    @GetMapping("/getTaste/{memberNo}")
    public ResponseEntity<MemberTaste> getTaste(@PathVariable ("memberNo") Integer memberNo) throws Exception {
        log.info("getTaste(): " + memberNo);

        try {
            MemberTaste memberTaste = tasteService.getTaste(memberNo).get();

            return new ResponseEntity<MemberTaste>(memberTaste, HttpStatus.OK);

        } catch (NoSuchElementException noSuchElementException) {

            return null;
        }
    }

    @PostMapping("/uploadImg")
    @ResponseBody
    public String requestUploadFile(
            // @RequestParam("fileList") List<MultipartFile> fileList) {
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("requestUploadFile(): " + fileList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("./imgFiles/" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }

            /*
            FileOutputStream writer = new FileOutputStream("./images/" + fileList.getOriginalFilename());
            writer.write(fileList.getBytes());
            writer.close();
             */
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }
}
