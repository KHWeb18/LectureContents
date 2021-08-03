// service 어떤 서비스인지

package com.example.miniProject.service;
import com.example.miniProject.entity.Membership;

import java.util.List;

public interface VueMembershipService {
    public void register(Membership membership) throws Exception;

    public void login(Membership membership) throws Exception;

    public List<Membership> list() throws Exception;
}
