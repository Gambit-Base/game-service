package com.gambit.gameservice.entity;

import com.gambit.gameservice.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoveModel {
    private String move;
    private Color color;
    private double time;
}

