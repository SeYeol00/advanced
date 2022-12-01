package hello.advanced.trace.strategy.code.strategy;


import lombok.extern.slf4j.Slf4j;


/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
public class ContextV1 {
    // 템플릿 역할을 한다.
    // 스프링에서 주구장창 의존관계 주입하는게 전략 패턴이다.

    private Strategy strategy;

    // 의존 관계 주입으로 전략을 받는다.
    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call(); // 위임
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }
}
