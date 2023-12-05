package com.gambit.gameservice.enums;

import lombok.Getter;

@Getter
public enum MetadataKey {
    EVENT("Event"),
    SITE("Site"),
    DATE("Date"),
    WHITE("White"),
    BLACK("Black"),
    RESULT("Result"),
    UTC_DATE("UTCDate"),
    UTC_TIME("UTCTime"),
    WHITE_ELO("WhiteElo"),
    BLACK_ELO("BlackElo"),
    WHITE_RATING_DIFF("WhiteRatingDiff"),
    BLACK_RATING_DIFF("BlackRatingDiff"),
    VARIANT("Variant"),
    TIME_CONTROL("TimeControl"),
    ECO("ECO"),
    OPENING("Opening"),
    TERMINATION("Termination"),
    ANNOTATOR("Annotator");

    private final String key;

    MetadataKey(String key) {
        this.key = key;
    }

}
