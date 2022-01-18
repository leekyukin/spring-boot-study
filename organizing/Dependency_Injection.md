# Dependency injection (의존성 주입)

## @RequiredArgsConstructor와 final을 이용한 의존성 주입 (ex] controller에 service)

```java
@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
}
``` 

@Autowired
@InjectService
두 어노테이션 사용시 너무 어노테이션에 종속되어 버리기 떄문에  
@RequiredArgsConstructor 를 class 상단에 선언하고 주입할 class 를 final 로 선언한다.  
final 은 나중에 수정이 불가능하기 떄문에 무조건 생성자를 만들어 주어야 하므로  
@RequiredArgsConstructor 사용시 자동으로 생성자가 만들어진다.  

<br>
<br>

## 생성자 선언을 이용한 주입

```java
    public DMakerService(DeveloperRepository developerRepository) {
         this.developerRepository = developerRepository;
    }
```

@RequiredArgsConstructor 를 선언 후 Delombok 을 해보면 위와 같은 생성자가 생성되어 있다.  
테스트에 용이한 코드를 짜기 위해서 생성자를 사용하였으나 많은 클레스를 관리해야  
할 때 비효율적이다.

---