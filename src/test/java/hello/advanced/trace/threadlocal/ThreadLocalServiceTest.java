package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");

        //Ruunable 인터페이스의 run() 구현.
        //Thread는 Thread 클래스를 상속 받거나, Runnable 인터페이스를 구현하거나,
        //Runnable 인터페이스 구현 후 Thread에 주입하는 방식으로 사용 가능.
        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
       // sleep(2000); //동시성 문제 발생 안하는 조건.
        sleep(100); //동시성 문제 발생하는 조건.
        threadB.start();

        sleep(2000); //메인 Thread 종료 대기
        log.info("main exit");

    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
