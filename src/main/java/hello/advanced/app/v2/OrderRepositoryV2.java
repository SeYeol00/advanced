package hello.advanced.app.v2;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId){

        TraceStatus status = null;
        // status를 쓰려면 블록 밖에서 선언을 해야한다.
        try{
            status = trace.beginSync(traceId,"OrderRepository.save()");
            // 저장 로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            sleep(100);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
