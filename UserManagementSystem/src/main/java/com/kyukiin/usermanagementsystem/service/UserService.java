package com.kyukiin.usermanagementsystem.service;

import com.kyukiin.usermanagementsystem.dto.JoinUser;
import com.kyukiin.usermanagementsystem.dto.LoginDto;
import com.kyukiin.usermanagementsystem.entity.User;
import com.kyukiin.usermanagementsystem.enums.LoginCode;
import com.kyukiin.usermanagementsystem.enums.StatusCode;
import com.kyukiin.usermanagementsystem.enums.UserDepartment;
import com.kyukiin.usermanagementsystem.exception.UserErrorCode;
import com.kyukiin.usermanagementsystem.exception.UserException;
import com.kyukiin.usermanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public JoinUser.Response joinUser(JoinUser.Request request) {
        validateJoinUserRequest(request);

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
                .statusCode(StatusCode.EXISTING)
                .build();

        userRepository.save(user);

        return JoinUser.Response.fromEntity(user);
    }

    private void validateJoinUserRequest(JoinUser.Request request) throws UserException {
        // business validation
        validateUserDepartment(request.getUserDepartment(), request.getGrade());

        userRepository.findByEmail(request.getEmail())
                .ifPresent((user -> {
                    throw new UserException(UserErrorCode.DUPLICATED_USER_EMAIL);
                }));
        userRepository.findByNickName(request.getNickName())
                .ifPresent((user -> {
                    throw new UserException(UserErrorCode.DUPLICATE_USER_NICKNAME);
                }));
    }

    private void validateUserDepartment(UserDepartment userDepartment, Integer grade) {
        if (grade == 1 && userDepartment != UserDepartment.UNDEFINED) {
            throw new UserException(UserErrorCode.DEPARTMENT_GRADE_NOT_MATCHED);
        }
    }

    @Transactional
    public List<User> MgetAll() {
        return userRepository.findAll();
    }

    @Transactional
    public List<User> getStatusUser(StatusCode status) {
        return userRepository.findByStatusCode(status);
    }

    public LoginDto.Response login(LoginDto.Request request) {
        LoginCode status;
        if(userRepository.findByEmail(request.getEmail()) == null) {
            status = LoginCode.NO_EMAIL;
            return LoginDto.Response.fromEntity(null, status);
        }
        else if (
                request.getEmail()
                                .equals(userRepository
                                .findByEmail(request.getEmail()))
                        && request.getPw()
                                .equals(userRepository
                                        .findByPw(request.getPw()))
        ) {
            status = LoginCode.SUCCESS;
            User user = userRepository.findByEmail(request.getEmail());
            return LoginDto.Response.fromEntity(user, status);
        }
        else {
            status = LoginCode.FAIL;
            return LoginDto.Response.fromEntity(null, status);
        }
    }
}
