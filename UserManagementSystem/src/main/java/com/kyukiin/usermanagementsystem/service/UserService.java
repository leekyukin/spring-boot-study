package com.kyukiin.usermanagementsystem.service;

import com.kyukiin.usermanagementsystem.dto.JoinUser;
import com.kyukiin.usermanagementsystem.entity.User;
import com.kyukiin.usermanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public JoinUser.Response joinUser(JoinUser.Request request) {
        User user = User.builder()
                .userDepartment(request.getUserDepartment())
                .userSkillType(request.getUserSkillType())
                .email(request.getEmail())
                .pw(request.getPw())
                .grade(request.getGrade())
                .age(request.getAge())
                .name(request.getName())
                .introduction(request.getIntroduction())
                .nickName(request.getNickName())
                .build();

        userRepository.save(user);
        
        return JoinUser.Response.fromEntity(user);
    }
}
