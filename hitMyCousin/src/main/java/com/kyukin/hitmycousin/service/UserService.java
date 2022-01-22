package com.kyukin.hitmycousin.service;

import com.kyukin.hitmycousin.dto.LoginUser;
import com.kyukin.hitmycousin.entity.User;
import com.kyukin.hitmycousin.exception.UserErrorCode;
import com.kyukin.hitmycousin.exception.UserException;
import com.kyukin.hitmycousin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void join(LoginUser.Request request) {

        validateLoginUserRequest(request);

        User user = User.builder()
                .name(request.getName())
                .id(request.getId())
                .pw(request.getPw())
                .build();

        userRepository.save(user);
    }

    private void validateLoginUserRequest(LoginUser.Request request) {
        userRepository.findByUserId(request.getId())
                .ifPresent((developer -> {
                    throw new UserException(UserErrorCode.DUPLICATE_ID);
                }));
    }
}
