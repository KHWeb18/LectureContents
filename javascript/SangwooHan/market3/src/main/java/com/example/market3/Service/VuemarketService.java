package com.example.market3.Service;

import com.example.market3.Entity.Market;
import com.example.market3.Entity.Signup;

import java.util.List;

public interface VuemarketService {
    public void register(Market market)throws Exception;
    public List<Market> list() throws Exception;

    public  Market read(Integer productNo) throws  Exception;


    public void remove(Integer productNo) throws  Exception;

    public  void modify(Market market) throws  Exception;
    public void signup(Signup signup);

    public void login  (Signup signup) throws  Exception;

    public List<Signup> memberList() throws Exception;

    public Signup memberRead(Integer bulletinNo) throws Exception;

    public  void memberRemove(Integer bulletinNo) throws Exception;

    public  void memberModify(Signup signup) throws Exception;



}
