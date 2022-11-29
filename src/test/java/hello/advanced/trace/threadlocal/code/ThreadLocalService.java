package hello.advanced.trace.threadlocal.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    // 스레드 로컬, 이것이 스레드가 객체를 동시성 문제 없이 저장할 수 있는 방법이다.
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name){
        log.info("저장 name = {} -> nameStore = {}",name, nameStore.get());

        // 세터로 저장
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore = {}", nameStore.get());

        // 게터로 꺼낸다.
        return nameStore.get();

        // 해당 스레드가 스레드로컬을 다 사용하면 리무즈를 해주어야한다.
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
