package com.example.FirstProject.service;

import com.example.FirstProject.entity.Map;
import com.example.FirstProject.request.MapDto;

import java.util.List;
import java.util.Optional;

public interface MapService {
    Map add(MapDto mapDto) throws Exception;
    Optional<Map> read(Long boardNo) throws Exception;
    List<Map> list() throws Exception;
    void modify(Map map, MapDto mapDto) throws Exception;
    void remove(Map map) throws Exception;
}
