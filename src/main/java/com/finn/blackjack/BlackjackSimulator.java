package com.finn.blackjack;

import java.io.IOException;

public class BlackjackSimulator {

    private GameOfBlackjackBuilder gameOfBlackjackBuilder;
    private GameOfBlackjack gameOfBlackjack;
    private Logger logger;

    public BlackjackSimulator() {
        logger = new Logger();
        gameOfBlackjackBuilder = new GameOfBlackjackBuilder();
    }

    public void initializeGame(String... args) throws IOException {
        if(args.length > 0) {
            gameOfBlackjack = createGameWithImportedDeck(args[0]);
        } else {
            gameOfBlackjack = createGameWithRandomDeck();
        }
    }

    public void playGame() {
        gameOfBlackjack.deal();
        while (gameOfBlackjack.getWinner() == null) {
            gameOfBlackjack.dealNextCard();
        }
        logger.print(gameOfBlackjack.getWinner().getName());
        logger.print(gameOfBlackjack.getSam().getName() + ": " + gameOfBlackjack.getSam().getHandString());
        logger.print(gameOfBlackjack.getTheDealer().getName() + ": " + gameOfBlackjack.getTheDealer().getHandString());
    }

    public GameOfBlackjack createGameWithRandomDeck() {
        return gameOfBlackjackBuilder.createGameWithRandomDeck();
    }

    public GameOfBlackjack createGameWithImportedDeck(String pathToDeckFile) throws IOException {
        return gameOfBlackjackBuilder.createGameWithParsedDeck(pathToDeckFile);
    }

    public void setGameOfBlackjackBuilder(GameOfBlackjackBuilder gameOfBlackjackBuilder) {
        this.gameOfBlackjackBuilder = gameOfBlackjackBuilder;
    }

    public GameOfBlackjack getGameOfBlackjack() {
        return gameOfBlackjack;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
