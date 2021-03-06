package github.zzzzbw.aspect;

import com.github.zzzzbw.aop.advice.AroundAdvice;
import com.github.zzzzbw.aop.annotation.Aspect;
import com.github.zzzzbw.aop.annotation.Order;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author zzzzbw
 * @since 2018/6/6 17:00
 */
@Aspect(pointcut = "@within(com.github.zzzzbw.core.annotation.Controller)")
@Order(1)
@Slf4j
public class ControllerAspect implements AroundAdvice {

    @Override
    public void before(Class<?> clz, Method method, Object[] args) throws Throwable {
        log.info("-----------before  ControllerAspect-----------");
        log.info("class: {}, method: {}", clz.getName(), method.getName());
    }

    @Override
    public void afterReturning(Class<?> clz, Object returnValue, Method method, Object[] args) throws Throwable {
        log.info("-----------after  ControllerAspect-----------");
        log.info("class: {}, method: {}", clz, method.getName());
    }

    @Override
    public void afterThrowing(Class<?> clz, Method method, Object[] args, Throwable e) {
        log.info("-----------error  ControllerAspect-----------");
        log.info("class: {}, method: {}, exception: {}", clz, method.getName(), e.getMessage());
    }
}
