package com.kujin.japfkpractice.repository;

import com.kujin.japfkpractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    // 아래 모두 동일한 쿼리문과 동일한 결과값이 나온다.
    // 이중 가독성이 높은 것을 골라 사용하면 된다.

    Set<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    // find{ entity 의 이름 }ByEmail : 원래는 entity 이름을 넣어줘야하지만 사실은 무시되는 부분이다.
    // 때문에 아무거나 넣어도 상관없다.
    User findSomethingByEmail(String email);

    // 이렇게 ByBy 라는 문법적 오류를 야기하면 당장은 에러가 발생하지 않지만
    // 메서드가 사용될때 RunTimeError 가 발생한다.
    User findByByEmail(String email);

    // DB 에서 데이터 조회시 갯수를 지정하는 limit 을 Top, First 와 같은 키워드로 구현할 수 있다.

    // 위에서부터 1개
    User findTop1ByEmail(String email);
    // 위에서부터 2개
    List<User> findTop2ByEmail(String email);


    // 위에서부터 1게
    User findFirst1ByEmail(String email);
    // 위에서부터 2개
    List<User> findFirst2ByEmail(String email);

}
