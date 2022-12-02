package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;

    private final TraceTemplate template;

    // 자체 의존관계 주입도 된다.
    // 콜백을 념겨주면 콜백 함수는 뒤에서 실행된다.
    // 템플릿 콜백 패턴 핵심
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(@RequestParam String itemId){

        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                // 여기가 비즈니스 로직
                orderService.orderItem(itemId);
                return "ok";
            }
        });

    }

}
