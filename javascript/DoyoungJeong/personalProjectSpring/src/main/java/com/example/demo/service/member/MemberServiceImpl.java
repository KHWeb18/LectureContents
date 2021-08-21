package com.example.demo.service.member;

import com.example.demo.controller.concert.request.ConcertDeleteRequest;
import com.example.demo.controller.concert.request.ConcertRequest;
import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.entity.member.LikedConcert;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberIdentity;
import com.example.demo.repository.concert.ConcertRepository;
import com.example.demo.repository.member.LikedConcertRepository;
import com.example.demo.repository.member.MemberIdentityRepository;
import com.example.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberIdentityRepository memberIdentityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LikedConcertRepository likedConcertRepository;

    @Autowired
    private ConcertRepository concertRepository;

    @Override
    @Transactional
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberIdentity memberIdentity = new MemberIdentity(memberRequest.getIdentity());
        Member member = new Member(memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(),
                memberRequest.getLocation(), memberRequest.getBirthDay(), memberRequest.getPhoneNo());

        LikedConcert likedConcert = new LikedConcert();
        likedConcert.setConcertNo(new Long(0));
        likedConcert.setConcertName("default");
        likedConcert.setConcertArtist("default");
        likedConcert.setConcertVenue("default");
        likedConcert.setConcertPrice("default");
        likedConcert.setConcertDate("default");
        likedConcert.setConcertInfo("default");

        member.addIdentity(memberIdentity);
        member.addLikedConcert(likedConcert);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public Member login(MemberRequest memberRequest) throws Exception {
        boolean noSuchElem = false;
        try {
            Optional<Member> requestedId = memberRepository.findByMemberId(memberRequest.getId()); //null포인트 익셉션이 안나옴

            log.info("confirmed ID: " + requestedId.get().getId() + ", confirmed PW: " + requestedId.get().getPassword() +
                    ", memberRequestPW: " + memberRequest.getPassword());

            if (passwordEncoder.matches(memberRequest.getPassword(), requestedId.get().getPassword())) {
                log.info("Valid ID");

                Member confirmedMember = requestedId.get();

                return confirmedMember;
            } else {
                log.info("Wrong Password has been input!");
                Member noMember = new Member();
                noMember.setId("no");

                return noMember;
            }

        } catch (NoSuchElementException noSuchElementException) {
            log.info("Not Existed ID!");

        } finally {
            ;
        }
        Member noMember = new Member();
        noMember.setId("no");

        return noMember;
    }

    @Override
    public boolean checkSessionValidation(String memberId) throws Exception {

        return true;
    }

    @Override
    public List<Member> getList() throws Exception {
        return memberRepository.getList();
    }

    @Override
    public void delete(Long memberNo) throws Exception {
        memberIdentityRepository.delete(memberNo); //자식 먼저 지워주고 뒤에 부모를 지워줌
        //likedConcert.delete도 만들어줘야한다
        memberRepository.delete(memberNo);
    }

    @Override
    public void modify(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberIdentity memberIdentity = new MemberIdentity(memberRequest.getIdentity());
        Member member = new Member(memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(),
                memberRequest.getLocation(), memberRequest.getBirthDay(), memberRequest.getPhoneNo());

        member.addIdentity(memberIdentity);
        Long memberNo = new Long(memberRequest.getMemberNo());

        memberRepository.modify(member, memberNo);
//        memberRepository.modify(memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(),
//                memberRequest.getLocation(), memberRequest.getBirthDay(), memberRequest.getPhoneNo(), memberNo);
    }

    @Override
    public void addLiked(ConcertRequest concertRequest) throws Exception {

        LikedConcert likedConcert = new LikedConcert(concertRequest.getConcertNo(), concertRequest.getConcertName(),
                concertRequest.getConcertArtist(), concertRequest.getConcertVenue(), concertRequest.getConcertPrice(), concertRequest.getConcertDate(),
                concertRequest.getConcertInfo());

        likedConcert.setMemberNo(concertRequest.getMemberNo());

        if(isNotAlreadyLiked(likedConcert.getMemberNo(), likedConcert.getConcertNo())) {
            likedConcertRepository.save(likedConcert);
            concertRepository.plusNumberOfLikes(new Long(concertRequest.getConcertNo()));
        } else {
            log.info("isAlreadyLiked!");
        }
    }

    @Override
    public boolean isNotAlreadyLiked(Long memberNo, Long concertNo) {
        return likedConcertRepository.findByMemberNoAndConcertNo(memberNo, concertNo).isEmpty();
    }

    @Override
    public void deleteLiked(ConcertDeleteRequest concertDeleteRequest) throws Exception {
        likedConcertRepository.deleteByConcertNo(new Long(concertDeleteRequest.getConcertNo()), new Long(concertDeleteRequest.getMemberNo()));
        concertRepository.minusNumberOfLikes(new Long(concertDeleteRequest.getConcertNo())); //concert테이블에 number_of_likes가 1씩 감소
    }
}
