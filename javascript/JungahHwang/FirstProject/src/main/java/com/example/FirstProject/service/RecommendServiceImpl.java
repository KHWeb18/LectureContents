package com.example.FirstProject.service;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.repository.RecommendRepository;
import com.example.FirstProject.request.RecommendDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendRepository repository;

    @Override
    public Recommend register(RecommendDto recommendDto) throws Exception {
        Recommend recommend = repository.save(recommendDto.toEntity());

        return recommend;
    }

    @Override
    public List<Object[]> lists() throws Exception {
        return  repository.lists();
    }

    @Override
    public List<Object[]> read(Long boardNo) throws Exception {
        return repository.read(boardNo);
    }

    @Override
    public Recommend findByBoardNo(Long boardNo) throws Exception {
        Recommend recommend = repository.findById(boardNo).orElseThrow();

        return recommend;
    }

    @Override
    public void modify(Recommend recommend, RecommendDto recommendDto) throws Exception {
        recommend.updateRecommend(recommendDto);

        repository.save(recommend);
    }

    @Override
    public void remove(Recommend recommend) throws Exception {
        repository.delete(recommend);
    }

    @Override
    public List<Object[]> mapList() throws Exception {
        return repository.mapList();
    }

    @Override
    public List<Recommend> userRead(String id) throws Exception {
        List<Recommend> recommends = repository.userRead(id);

        return recommends;
    }
}
