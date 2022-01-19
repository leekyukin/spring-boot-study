# @Transactional

    method나 class 앞뒤에 transaction 시작, 커밋 혹은 rollback을 넣어준다.  
    AOP기반의 ACID 특성을 입힐 수 있다.

## 특성 ACID

1. <span style="color:red">A</span>tomic (원자성) 🏦 💰 

    내가 상대방의 계좌로 돈을 보냈는데 오류 발생으로 인해 내 계좌에서 빠져나간 돈이  
    상대방의 계좌로 입금되지 않는다면 매우 당황스러울 것이다.  
    이때 돈을 넣고 빼는 행위가 하나의 트렌젝션으로 묶인다면 해결될 수 있다.  
    둘 중 하나만 실패하면 모두 실패로 모두 성공시에만 성공 트렌젝션이 수행된다.  

2. <span style="color:red">C</span>onsistency (일관성) 🌅 

    커밋이 끝난 시점에서는 DB에 일관성이 갖춰져야한다.

3. <span style="color:red">I</span>solation (고립성)  🕳 🐸

    DB의 고립성을 높이면 서버에서 많은 요청을 받을 수 없고,   
    DB의 고립성이 낮아지면 데이터의 정확성이 떨어지는 Trade off 관계  

4. <span style="color:red">D</span>urability (지속성) ⏲ 

    한 번 커밋된 이력은 무조권 남아 있어야 함.