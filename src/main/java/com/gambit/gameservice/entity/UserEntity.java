package com.gambit.gameservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "USER_ENTITY_T01")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID")
    private UUID id;

    @Column(name = "USER_NAME", columnDefinition = "TEXT")
    private String userName;

    @Column(name = "EMAIL", columnDefinition = "TEXT")
    private String email;

    @Lob
    @Column(name = "AVATAR_BASE64")
    private String avatarBase64;

    @Column(name = "PASSWORD_HASH", columnDefinition = "TEXT")
    private String passwordHash;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "BALANCE")
    private BigDecimal balance;
}
