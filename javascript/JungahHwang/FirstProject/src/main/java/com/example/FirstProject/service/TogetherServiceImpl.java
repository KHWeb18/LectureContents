package com.example.FirstProject.service;

import com.example.FirstProject.entity.Together;
import com.example.FirstProject.repository.TogetherRepository;
import com.example.FirstProject.request.TogetherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class TogetherServiceImpl implements TogetherService {

    @Autowired
    private TogetherRepository repository;

    @Override
    public Together register(TogetherDto togetherDto) throws Exception {
        Together together = repository.save(togetherDto.toEntity());

        return together;
    }

    @Override
    public List<Together> list() throws Exception {
        List<Together> togethers = repository.findAll();

        return  togethers;
    }

    @Override
    public Together read(Long boardNo) throws Exception {
        Together together = repository.findById(boardNo).orElseThrow();

        return together;
    }

    @Override
    public void modify(Together together, TogetherDto togetherDto) throws Exception {
        together.updateTogether(togetherDto);

        repository.save(together);
    }

    @Override
    public void remove(Together together) throws Exception {
        repository.delete(together);
    }

    @Override
    public List<Together> userRead(String id) throws Exception {
        List<Together> togethers = repository.userRead(id);

        return togethers;
    }
}
