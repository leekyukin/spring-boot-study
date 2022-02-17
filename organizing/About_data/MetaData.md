# metadat란?
    데이터에 관한 구조화된 데이터 데이터로, 데이터를 설명하는 데이터다.
    흔히 데이터를 위한 데이터라고 한다.
    많은 데이터 중에 찾고 있는 데이터를 효율적으로 관리하기 위해서 일정한 규칙에 따라 콘텐츠에 대하여 부여되는 데이터이다. 
------
## 응답시에는 Entity -> Response 형태의 DTO

### Entity
```java
public class User {
    Long id;

    private String name;
    private String email;
    private String password;
    private String nickName;
    private String phoneNumber;
    private Date Birthday;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
```

이렇게 Entity에서 Response DTO 로 변환 시켜서 사용자에게 보여줄 필요가 없는 메타데이터인 생성된 시간, 수정된 시간, 데이터베이스에서 사용할 Id 등과 개인정보인 생일, 전화번호, 비밀번호는 걸러서 응답해준다.

### Response DTO

```java
public class UserResponse {

    // User에서 사용자에게 보여주고 싶은 정보만
    // 선정해서 변수를 만들어준다.

    private String name;
    private String email;
    private String nickName;
}
```



