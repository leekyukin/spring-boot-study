package com.group.librayapp.service.user;

import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.service.user.UserService;
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository
) {
    @Test
    fun saveUserTest() {
        // given
        val request = UserCreateRequest("이규진", null)

        // when
        userService.saveUser(request)

        // then 
        val results = userRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("이규진")
//        assertThat(results[0].age).isNull()
    }
}
