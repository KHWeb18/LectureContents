package com.example.projectTest.service;

import com.example.projectTest.controller.request.SaveUserRequest;
import com.example.projectTest.controller.request.SessionKey;
import com.example.projectTest.controller.request.SignInForm;
import com.example.projectTest.entity.Account;
import com.example.projectTest.repository.JpaAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private JpaAccountRepository repository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean signIn(SignInForm form) {
        final String email = form.getEmail();

        log.info("email: " + email);

        final Optional<Account> maybeAccount = repository.findByEmail(email);

        log.info("get maybeAccount: " + maybeAccount.isPresent());

        if (maybeAccount.isPresent()) {
            log.info("Find E-mail Address Success!!!");

            Account account = maybeAccount.get();
            if (!isRightPassword(form.getPassword(), account.getPassword())) {
                log.info("Wrong Password!");
                return false;
            }
            sessionService.save(new SaveUserRequest(account.getEmail()));

            return true;
        }

        log.info("You are not a registered user!");
        return false;
    }

    public boolean isRightPassword(String requestPassword, String accountPassword) {

        if (!passwordEncoder.matches(requestPassword, accountPassword))
        {
            return false;
        }

        return true;
    }
}