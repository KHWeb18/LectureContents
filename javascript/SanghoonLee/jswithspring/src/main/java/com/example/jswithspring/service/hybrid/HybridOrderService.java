package com.example.jswithspring.service.hybrid;

import com.example.jswithspring.controller.hybrid.request.RequestHybridOrder;

public interface HybridOrderService {
    public Boolean registerOrder(RequestHybridOrder order) throws Exception;
    public void notice(RequestHybridOrder order) throws Exception;
}
