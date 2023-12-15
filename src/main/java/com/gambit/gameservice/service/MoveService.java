package com.gambit.gameservice.service;

import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class MoveService {
    public Duration recalculateTime(Duration usedTime, Duration remainingTime) {
        Duration updatedTime = remainingTime.minus(usedTime);
        if (updatedTime.isNegative()) {
            updatedTime = Duration.ZERO;
        }
        return updatedTime;
    }

}
