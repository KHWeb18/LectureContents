package com.example.wonkimproj.service;

import com.example.wonkimproj.entity.Login;
import com.example.wonkimproj.entity.Register;

import java.util.List;

public interface RegisterService {
    public void register(Register register) throws Exception;

    public List<Register> list() throws Exception;

    public Register read(Integer userNo) throws Exception;

    public void remove(Integer userNo) throws Exception;

    public void modify(Register register) throws Exception;

    //public void idChk(Integer userNo) throws Exception;

}
