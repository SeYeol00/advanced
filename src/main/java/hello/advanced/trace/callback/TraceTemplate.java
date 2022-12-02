package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class TraceTemplate {

    // 로그 추적기 주입받기
    private final LogTrace trace;



    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try{
            status = trace.begin(message);

            // 로직 호출, 이 부분은 상속으로 처리할 것
            T result = callback.call();

            trace.end(status);

            return result;
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }
    }
}
