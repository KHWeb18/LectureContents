package com.example.market3.Service;

import com.example.market3.Entity.Market;
import com.example.market3.Entity.Signup;
import com.example.market3.Rapository.MarketRepository;
import com.example.market3.Rapository.VueMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VuemarketServiceImp implements  VuemarketService {
  int num = 0;
  @Autowired
  private VueMarketRepository repository;

  @Override
  public void register(Market market) throws Exception{
    repository.create(market);
  }

  @Override
  public List<Market> list() throws Exception {
    return repository.list();
  }

  @Override
  public Market read(Integer productNo) throws Exception {
    return repository.read(productNo);
  }

  @Override
  public void remove(Integer productNo) throws Exception {
    repository.delete(productNo);
  }

  @Override
  public void modify(Market market) throws Exception {
    repository.update(market);
  }

  @Override
  public void signup(Signup signup) {
    repository.create2(signup);
  }

  @Override
  public void login(Signup signup) throws Exception {
    repository.login (signup);
  }

  @Override
  public List<Signup> memberList() throws Exception {
    return repository.memberlist();
  }

  @Override
  public Signup memberRead(Integer bulletinNo) throws Exception {
    return repository.memberRead(bulletinNo);
  }

  @Override
  public void memberRemove(Integer bulletinNo) throws Exception {
    repository.memberDelete(bulletinNo);
  }

  @Override
  public void memberModify(Signup signup) throws Exception {
    repository.memberupdate(signup);
  }
}



