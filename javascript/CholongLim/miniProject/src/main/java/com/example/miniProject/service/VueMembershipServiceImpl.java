package com.example.miniProject.service;

import com.example.miniProject.entity.Membership;
import com.example.miniProject.repository.VueMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMembershipServiceImpl implements VueMembershipService {

    @Autowired
    private VueMembershipRepository repository;

    @Override
    public void register(Membership membership) throws Exception {
        repository.create(membership);
    }

    @Override
    public void login(Membership membership) throws Exception {
        repository.login(membership);
    }

    @Override
    public List<Membership> list() throws Exception {
        return repository.list();
    }
}

