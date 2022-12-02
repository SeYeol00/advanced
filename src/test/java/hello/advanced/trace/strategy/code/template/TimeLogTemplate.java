package hello.advanced.trace.strategy.code.template;


import hello.advanced.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;


// 스프링에서 jdbcTemplate, RedisTemplate 등등 많은 템플릿들이
// 바로 이런 방식이다.

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        callback.call(); // 위임
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }
}
