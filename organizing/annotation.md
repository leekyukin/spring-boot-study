# Annotation organizing 

<sup>(하나씩 채워나갈 예정)</sup> :trollface:

--------------------------------

## ComponentScan

----

- @controller : contoller 임을 명시
- @service :   service 임을 명시
- @ResponseBody : 메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body에 쓰임
- @Restcontoller : @controller + @ReqsponesBody

## Lombok

---

### @Getter : getter 생성

### @Setter : setter 생성

### @ToString : class의 Object안에 있는 기본 ToString 생성. {className}{field1=value, field2=value, ...) 형태

    ToString이란?  
    System.out.println([class의 이름]);
    을 실행시 class의 해쉬코드 값이 나온다.  
    그러나 이런 값은 개발자에게 아무런 의미가 없다.  
    그래서 class의 이름을 호출시 class의 변수와 값을 반환한다.  

### @NoArgsConstructor : argument가 없는 기본 생성자를 생성

### @AllArgsConstructor : 모든 argument가 있는 생성자를 생성

### @RequiredArgsConstructor : 필수 argument가 있는 생성자를 생성

### @Data : @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode가 모두 있는 annotation

### @Builder : 빌더패턴 사용 가능

    빌더패턴 <sup>Builder pattern</sup>이란?  
    복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서  
     서로 다른 표현 결과를 만들 수 있게 하는 패턴.  
    생성자에 인자가 많을 때 빌더 패턴을 사용함으로써 setter보다 간편하게 사용 가능.

### @Slf4j : 간편한 로깅 사용을 돕는다.

    로깅<sup>logging</sup> 이란?
    프로그램 개발 중이나 완료 후 발생할 수 있는 오류에 대해   
    디버깅하거나 운영 중인 프로그램 상태를 모니터링 하기 위해  
    필요한 정보(로그)를 기록하는 것

### @UtilityClass : 유틸리티 클래스에 적용하는 annotation