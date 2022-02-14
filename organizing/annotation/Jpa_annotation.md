# JPA Annotation 

## 기본 Annotation

- ### <span style="color:yellow">@Entity</span> 

    클레스에 @Entity를 선언하면 그 클레스는 JPA가 관리한다.  
    그러므로 DB 테이블이나 DTO같은 클레스와 맵핑해야 한다.

    - name 속성 : Entity의 이름을 지정해준다. 

- ### <span style="color:yellow">@Id</span> 
    
    JPA가 객체 관리할 때 식별할 기본키를 지정한다.   
    DB 테이블의 PrimaryKey와 맵핑해준다.

---

## <span style="color:yellow">@EnableJpaAuditing </span>

    엔트리 포인트인 Application class에 주입해준다.
    spring date jpa 기능중에 자동으로 값을 설정해주는 기능인 Auditing을 사용 가능하게 하는 annotation.
    선언시 아래의 어노테이션 사용 가능.

- ### <span style="color:yellow">@EntityListeners</span>(AuditingEntityListener.<span style="color:orange">class</span>)
    
    Auditing 기능을 사용하기 위해서 Entity에 선언해야만 한다.

- ### <span style="color:yellow">@CreatedDate</span> : 생성 시점

- ### <span style="color:yellow">@LastModifiedDate</span> : 마지막 수정 시점