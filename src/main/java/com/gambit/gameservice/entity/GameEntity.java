package com.gambit.gameservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "GAME_ENTITY_T01")
public class GameEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID")
    private UUID id;

    @Column(name = "WHITE_PLAYER_ID")
    private UUID whitePlayerId;

    @Column(name = "BLACK_PLAYER_ID")
    private UUID blackPlayerId;

    @Column(name = "MOVES", columnDefinition = "TEXT")
    private String moves;

    @Column(name = "MOVE_TIMES", columnDefinition = "TEXT")
    private String moveTimes;

    @Column(name = "GAME_TIME")
    private LocalDateTime gameTime;

    @Column(name = "METADATA", columnDefinition = "TEXT")
    private String metadata;
}
