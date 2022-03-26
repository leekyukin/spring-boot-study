package com.study.jpaquerymethodstudy.repository;

import com.study.jpaquerymethodstudy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public interface UserRepository extends JpaRepository<User, Long> {

    // 기본 select
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
    // User findByByEmail(String email);

    // DB 에서 데이터 조회시 갯수를 지정하는 limit 을 Top, First 와 같은 키워드로 구현할 수 있다.

    // 위에서부터 1개
    User findTop1ByEmail(String email);
    // 위에서부터 2개
    List<User> findTop2ByEmail(String email);


    // 위에서부터 1게
    User findFirst1ByEmail(String email);
    // 위에서부터 2개
    List<User> findFirst2ByEmail(String email);


    // where 문 추가

    // and
    List<User>  findByEmailAndName(String email,String name);

    // or
    List<User> findByEmailOrName(String email, String name);

    // 초과 ( > ?)
    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    // 초과
    List<User> findByIdAfter(Long id);

    // 초과 ( > ?) 위의 findByIdAfter 과 쿼리문이 같음
    List<User> findByIdGreaterThan(Long id);

    // 이상 ( >= ? )
    List<User> findByIdGreaterThanEqual(Long id);

    // between
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    // 이상 & 이하 ( <= ? <=) 아래와 같은 뜻, 같은 쿼리문
    List<User> findByIdBetween(Long n1, Long n2);
    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long n1, Long n2);

    //   값 중 일치하는 것을 반환
    List<User> findByNameIn(ArrayList<String> newArrayList);

    // like
    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    // (파라미터 : %?%) = Contains
    // (파라미터 : ?%) = StringWith
    // (파라미터 : %?) = EndingWith
    // oracle 쿼리문과 같음
    List<User> findByNameLike(String name);
}
