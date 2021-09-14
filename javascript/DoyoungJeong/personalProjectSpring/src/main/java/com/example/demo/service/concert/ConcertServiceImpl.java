package com.example.demo.service.concert;

import com.example.demo.controller.concert.request.BookingRequest;
import com.example.demo.controller.concert.response.BookedConcertResponse;
import com.example.demo.entity.concert.Concert;
import com.example.demo.entity.member.BookedConcert;
import com.example.demo.entity.member.LikedConcert;
import com.example.demo.repository.concert.ConcertRepository;
import com.example.demo.repository.member.BookedConcertRepository;
import com.example.demo.repository.member.LikedConcertRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ConcertServiceImpl implements ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private LikedConcertRepository likedConcertRepository;

    @Autowired
    private BookedConcertRepository bookedConcertRepository;

    @Override
    public Optional<Concert> findByConcertNo(Long concertNo) {
        return concertRepository.findByConcertNo(concertNo);
    }

    @Override
    public List<LikedConcert> getLikedList(Long memberNo) {
        return likedConcertRepository.findByMemberNo(memberNo);
    }

    @Override
    public void makeBooking(BookedConcert bookedConcert) {

        Integer numOfVisitors = bookedConcert.getNumOfVisitors();
        concertRepository.minusVenueCapacity(numOfVisitors, new Long(bookedConcert.getConcertNo()));

        bookedConcertRepository.save(bookedConcert);
    }

    @Override
    public boolean isNotAlreadyBooked(Long memberNo, Long concertNo) {
        return bookedConcertRepository.findByMemberNoAndConcertNo(memberNo, concertNo).isEmpty();
    }

    @Override
    public List<BookedConcertResponse> getBookedConcertList(Long memberNo) {

        List<BookedConcertResponse> bookedConcertResponseList = new ArrayList<BookedConcertResponse>();
        BookedConcertResponse bookedConcertResponse = null;

        List<BookedConcert> tmpBookedConcertList = bookedConcertRepository.findByMemberNo(memberNo);

        String regDate;
        SimpleDateFormat regDateFormat = new SimpleDateFormat("20yy-MM-dd hh:mm");

        for(int i=0; i<tmpBookedConcertList.size(); i++) {
            regDate = regDateFormat.format(tmpBookedConcertList.get(i).getRegDate());

            bookedConcertResponse = new BookedConcertResponse(tmpBookedConcertList.get(i).getBookedConcertNo(), tmpBookedConcertList.get(i).getConcertNo(),
                    tmpBookedConcertList.get(i).getName(), tmpBookedConcertList.get(i).getConcertName(), tmpBookedConcertList.get(i).getPhoneNumber(),
                    tmpBookedConcertList.get(i).getNumOfVisitors(),
                    tmpBookedConcertList.get(i).getMessage(), regDate);

            bookedConcertResponseList.add(bookedConcertResponse);
        }
        return bookedConcertResponseList;
    }

    @Override
    public BookedConcertResponse getBookedConcert(Long bookedConcertNo) {

        Optional<BookedConcert> tmpBookedConcert = bookedConcertRepository.findByBookedConcertNo(bookedConcertNo);

        Long tmpBookedConcertNo = tmpBookedConcert.get().getBookedConcertNo();
        Long tmpConcertNo = tmpBookedConcert.get().getConcertNo();
        String tmpName = tmpBookedConcert.get().getName();
        String tmpConcertName = tmpBookedConcert.get().getConcertName();
        String tmpPhoneNumber = tmpBookedConcert.get().getPhoneNumber();
        Integer tmpNumOfVisitors = tmpBookedConcert.get().getNumOfVisitors();
        String tmpMessage = tmpBookedConcert.get().getMessage();

        SimpleDateFormat regDateFormat = new SimpleDateFormat("20yy-MM-dd hh:mm");
        String tmpRegDate = regDateFormat.format(tmpBookedConcert.get().getRegDate());

        BookedConcertResponse bookedConcertResponse = new BookedConcertResponse(tmpBookedConcertNo, tmpConcertNo, tmpName, tmpConcertName,
                tmpPhoneNumber, tmpNumOfVisitors, tmpMessage, tmpRegDate);

        return bookedConcertResponse;
    }

    @Override
    public void alterBooking(BookedConcert bookedConcert) {

        //log.info("bookedConcert: " + bookedConcert);
        Long bookedConcertNo = bookedConcert.getBookedConcertNo();
        Optional<BookedConcert> tmpBookedConcert = bookedConcertRepository.findByBookedConcertNo(new Long(bookedConcertNo));

        Integer numOfVisitorsForPlus = tmpBookedConcert.get().getNumOfVisitors();
        Long concertNo = tmpBookedConcert.get().getConcertNo();
        concertRepository.plusVenueCapacity(numOfVisitorsForPlus, concertNo);

        String name = bookedConcert.getName();
        String phoneNumber = bookedConcert.getPhoneNumber();
        Integer numOfVisitors = bookedConcert.getNumOfVisitors();
        String message = bookedConcert.getMessage();

        concertRepository.minusVenueCapacity(numOfVisitors, concertNo);

        bookedConcertRepository.alterBooking(name, phoneNumber, numOfVisitors, message, bookedConcert.getBookedConcertNo());
    }

    @Override
    public void deleteBooking(Integer bookedConcertNo) {

        Optional<BookedConcert> tmpBookedConcert = bookedConcertRepository.findByBookedConcertNo(new Long(bookedConcertNo));
        Integer numOfVisitors =  tmpBookedConcert.get().getNumOfVisitors();
        Long concertNo = tmpBookedConcert.get().getConcertNo();

        concertRepository.plusVenueCapacity(numOfVisitors, concertNo);

        bookedConcertRepository.deleteByBookedConcertNo(new Long(bookedConcertNo));
    }
}
