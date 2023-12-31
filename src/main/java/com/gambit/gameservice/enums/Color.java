package com.gambit.gameservice.enums;

import lombok.Getter;

@Getter
public enum Color {
    WHITE("white"),
    BLACK("black");

    private final String color;

    Color(String color) {
        this.color = color;
    }
}

