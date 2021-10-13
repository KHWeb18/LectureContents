package com.example.cholongtest.service.hybrid;

import com.example.cholongtest.controller.hybrid.request.RequestHybridOrder;

public interface HybridOrderService {
    public Boolean registerOrder(RequestHybridOrder order) throws Exception;
    public String notice(RequestHybridOrder order) throws Exception;
}
