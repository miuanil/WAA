package com.anilozmen.miu.lab4.aspect;

import com.anilozmen.miu.lab4.domain.Logger;
import com.anilozmen.miu.lab4.repository.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerRepository loggerRepository;

    @Pointcut("execution( * com.anilozmen.miu.lab4.controller.*.*(..))")
    public void saveLog() {
    }

    @After("saveLog()")
    public void logAfter(JoinPoint joinPoint) {
        Logger logger = new Logger();
        logger.setPrinciple("ANIL ÖZMEN");
        logger.setOperation(joinPoint.getSignature().getName());
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        loggerRepository.save(logger);
    }


}
