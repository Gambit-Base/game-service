package com.gambit.gameservice.service;

import com.gambit.gameservice.entity.GameEntity;
import com.gambit.gameservice.entity.MoveModel;
import com.gambit.gameservice.enums.MetadataKey;
import com.gambit.gameservice.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public GameEntity saveGame(UUID whiteUserId, UUID blackUserId, List<MoveModel> moveList,
                               Map<MetadataKey, String> metadataMap) {
        String moves = moveList.stream()
                .map(MoveModel::getMove)
                .collect(Collectors.joining(", "));

        String moveTimes = moveList.stream()
                .map(MoveModel::getTime)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        String gameDate = metadataMap.get(MetadataKey.UTC_DATE);
        String gameTime = metadataMap.get(MetadataKey.UTC_TIME);
        LocalDate localDate = LocalDate.parse(gameDate, DATE_FORMATTER);
        LocalTime localTime = LocalTime.parse(gameTime, TIME_FORMATTER);
        LocalDateTime fullGameTime = LocalDateTime.of(localDate, localTime);

        String metadata = metadataMap.toString();

        GameEntity gameEntity = createGameEntity(whiteUserId, blackUserId, moves, moveTimes,
                fullGameTime, metadata);
        return gameRepository.save(gameEntity);
    }

    public Optional<GameEntity> getGameById(UUID id) {
        return gameRepository.findById(id);
    }

    public void deleteGameById(UUID id) {
        gameRepository.deleteById(id);
    }


    private GameEntity createGameEntity(UUID whiteUserId, UUID blackUserId, String moves, String moveTimes,
                                        LocalDateTime gameTime, String metadata) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setWhitePlayerId(whiteUserId);
        gameEntity.setBlackPlayerId(blackUserId);
        gameEntity.setMoves(moves);
        gameEntity.setMoveTimes(moveTimes);
        gameEntity.setGameTime(gameTime);
        gameEntity.setMetadata(metadata);
        return gameEntity;
    }
}

