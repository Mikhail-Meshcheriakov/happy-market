package ru.geekbrains.happy.market.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Aspect
@Component
@RequiredArgsConstructor
@Data
public class AppProfilingAspect {
    private HashMap<String, Integer> numberOfMethodsRuns;
    private String controllerName;
    private long maxMethodExecutionTime;

    @Before("execution(public * ru.geekbrains.happy.market.*.*.*(..))")
    public void beforeAnyMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        if (numberOfMethodsRuns.containsKey(methodName)) {
            numberOfMethodsRuns.replace(methodName, numberOfMethodsRuns.get(methodName) + 1);
        } else {
            numberOfMethodsRuns.put(methodName, 1);
        }
    }

    @Around("execution(public * ru.geekbrains.happy.market.controllers.*.*(..))")
    public Object beforeAnyMethodInControllers(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        if (duration > maxMethodExecutionTime) {
            maxMethodExecutionTime = duration;
            controllerName = methodSignature.getDeclaringTypeName();
        }
        return out;
    }

    @PostConstruct
    public void init() {
        numberOfMethodsRuns = new HashMap<>();
    }
}
