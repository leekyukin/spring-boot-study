# Validation annotation

## DTO

- @NotNull : Null ❌ 
- @Min() : 정수형 변수의 **최소값**이 ()안의 수
- @Max() : 정수형 변수의 **최대값**이 ()안의 수
- @Size(min = 0, max = 10, message = "???") : 0 ~ 10 까지. 범위 이탈시 메세지 "???"
- @Valid : 변수에 값을 저장할 때 위와 같은 어노테이션이 동작하게끔 한다.
