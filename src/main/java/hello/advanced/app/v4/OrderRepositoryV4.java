package hello.advanced.app.v4;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;


    public void save(String itemId){

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {

                // 여기가 비즈니스 로직
                // 저장 로직
                if(itemId.equals("ex")){
                    throw new IllegalStateException("예외 발생");
                }
                sleep(100);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
