package com.gambit.gameservice.repository;

import com.gambit.gameservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByEmailAndPasswordHash(String email, String passwordHash);
}
