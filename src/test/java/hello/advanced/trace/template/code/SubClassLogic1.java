package hello.advanced.trace.template.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate{
    // 변하는 부분인 비즈니스 로직을 처리하는 클래스
    @Override
    protected void call() {// 오버라이딩
        log.info("비즈니스 로직1 실행");
    }
}
