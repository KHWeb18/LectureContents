package com.example.jswithspring.service.hybrid;

import com.example.jswithspring.controller.hybrid.request.RequestHybridOrder;
import com.example.jswithspring.entity.hybrid.HybridOrder;
import com.example.jswithspring.repository.hybrid.HybridOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HybridOrderServiceImpl implements HybridOrderService {

    @Autowired
    HybridOrderRepository repository;

    @Override
    public Boolean registerOrder(RequestHybridOrder order) throws Exception {

        HybridOrder hybridOrder = new HybridOrder(order.getName(), order.getCost());
        repository.save(hybridOrder);

        return true;
    }

    @Override
    public void notice(RequestHybridOrder order) throws Exception {

    }
}
