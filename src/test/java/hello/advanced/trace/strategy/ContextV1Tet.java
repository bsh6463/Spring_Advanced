package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Tet {
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

    /**
     * 전략패턴 사용
     */
    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }


}