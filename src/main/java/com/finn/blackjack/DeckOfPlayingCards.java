package com.finn.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfPlayingCards {

    private List<PlayingCard> playingCards;

    public DeckOfPlayingCards() {
        playingCards = new ArrayList<>();
        for(PlayingCard.Suite suite : PlayingCard.Suite.values()) {
            for(int i = 1; i<14; i++) {
                playingCards.add(new PlayingCard(i, suite));
            }
        }
    }

    public List<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void shuffle(long seed) {
        Random random = new Random(seed);
        Collections.shuffle(playingCards, random);
    }

    public void shuffle() {
        shuffle(System.currentTimeMillis());
    }

}