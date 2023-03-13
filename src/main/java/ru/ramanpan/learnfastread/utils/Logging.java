package ru.ramanpan.learnfastread.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Logging {
    public static void logInfoMessage(String message) {
        log.info(message);
    }
    public static void logWarningMessage(String message) {
        log.warn(message);
    }

    public static void logDebugMessage(String message) {
        log.debug(message);
    }
    public static void logErrorMessage(String message) {
        log.error(message);
    }
}