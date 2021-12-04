package com.example.FirstProject.service;

import com.example.FirstProject.entity.Map;
import com.example.FirstProject.repository.MapRepository;
import com.example.FirstProject.request.MapDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
@Slf4j
public class MapServiceImpl implements MapService{

    @Autowired
    MapRepository repository;

    @Override
    public Map add(MapDto mapDto) throws Exception {
        Map map = repository.save(mapDto.toEntity());

        return map;
    }

    @Override
    public Map read(Long boardNo) throws Exception {
        Map map = repository.findByBoardNo(boardNo).orElse(null);

        return map;
    }

    @Override
    public List<Map> list() throws Exception {
        List<Map> maps = repository.findAll();

        return maps;
    }

    @Override
    public void modify(Map map, MapDto mapDto) throws Exception {
        map.updateMap(mapDto);

        repository.save(map);
    }

    @Override
    public void remove(Map map) throws Exception {
        repository.delete(map);
    }
}
