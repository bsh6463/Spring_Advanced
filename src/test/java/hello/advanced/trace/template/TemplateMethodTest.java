package hello.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    /**
     * 시간을 찍는 로직과, 비즈니스 로직이 섞여있음.
     */
    private void logic1(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 시행
        log.info("비즈니스 로직1 실행");

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }

    /**
     * 시간을 찍는 로직과, 비즈니스 로직이 섞여있음.
     */
    private void logic2(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 시행
        log.info("비즈니스 로직2 실행");

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }

}
