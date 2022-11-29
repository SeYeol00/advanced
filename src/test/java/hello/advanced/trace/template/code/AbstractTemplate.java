package hello.advanced.trace.template.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    // 템플릿 매서드 패턴은 말 그대로 템플릿을 만드는 것
    // jsp, 타임리프 등이 템플릿이다.
    // 템플릿이라는 틀에 변하지 않는 부분을 몰아 둔다.
    // 변하는 부분을 별도로 호출해서 해결한다.

    public void execute(){
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        call(); // 상속
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    // 템플릿 매서드 패턴 상속
    protected abstract void call();
}
