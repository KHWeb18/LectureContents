package com.example.market3.Rapository;

import com.example.market3.Entity.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class VueSignupRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void create(Signup signup) {
        String query = "insert into vuesignup (userid, password, name, birthday, gender, address, phoneNo) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, signup.getUserid(), signup.getPassword(),
                signup.getName(), signup.getBirthday(), signup.getGender(), signup.getAddress(), signup.getPhoneNo());
    }


}
