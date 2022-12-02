package hello.advanced.trace.callback;


// 반환타입이 다 다를 수 있어서 제네릭을 씁시다.
public interface TraceCallback<T> {
    T call();
}
