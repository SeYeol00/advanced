package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId){
        // 템플릿 콜백 패턴 -> 람다식 이용한 클린 코드
        template.execute("OrderRepository.save()",
                () -> {
                    // 여기가 비즈니스 로직
                    // 저장 로직
                    if(itemId.equals("ex")){
                        throw new IllegalStateException("예외 발생");
                    }
                    sleep(100);
                    return null;
                });
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
