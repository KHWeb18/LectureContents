package com.example.personalProject.service;
import com.example.personalProject.eutity.VueJPAMember;
import com.example.personalProject.repository.VueJPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시함
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class VueJPAMemberSeviceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueJPAMember member) throws Exception {
        repository.save(member);
    }

}