package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;

    private int level;


    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        // UUID를 생성하여 앞 8자리만 사용
        return UUID.randomUUID().toString().substring(0,8);
    }

    private TraceId createNextId(){
        return new TraceId(id,level+1);
    }
}
