package com.example.demo.controller.member;

import com.example.demo.controller.member.request.ArtistAuthRequest;
import com.example.demo.controller.member.response.ConcertRequestResponse;
import com.example.demo.service.artistAuth.ConcertRequestService;
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

@Slf4j
@Controller
@RequestMapping("/member/concertRegister")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ArtistAuthController {

    @Autowired
    ConcertRequestService concertRequestService;

    @PostMapping("/sendPic")
    @ResponseBody
    public String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("requestUploadFile(): " + fileList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자
            for (MultipartFile multipartFile : fileList) {
                //File file = new File("c:/java_work/test.jpg");
                log.info("requestUploadFile(): Make File");

                FileOutputStream writer = new FileOutputStream("src/main/java/com/example/demo/controller/member/images/" + multipartFile.getOriginalFilename());
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

    @PostMapping("/request")
    public ResponseEntity<Void> request(@Validated @RequestBody ArtistAuthRequest artistAuthRequest) throws Exception {
        log.info("request(): artistAuthRequest - " + artistAuthRequest);

        concertRequestService.regRequest(artistAuthRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getName/{memberNo}")
    public ResponseEntity<String> getName(@PathVariable ("memberNo") Integer memberNo) throws Exception {
        log.info("getName(): " + memberNo);

        String userName = concertRequestService.getUserName(memberNo);

        return new ResponseEntity<String>(userName, HttpStatus.OK);
    }

    @GetMapping("/getConcertRequest")
    public ResponseEntity<List<ConcertRequestResponse>> getConcertRequestList() throws Exception {

        List<ConcertRequestResponse> list = concertRequestService.getConcertRequestList();

        return new ResponseEntity<List<ConcertRequestResponse>>(list, HttpStatus.OK);
    }

    @GetMapping("/approveOrDenyRequest/{concertRequestNo}")
    public ResponseEntity<Void> approveOrDenyRequest(@PathVariable ("concertRequestNo") Integer concertRequestNo) throws Exception {

        concertRequestService.updateApproveOrNot(concertRequestNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
