package com.gruppe21.game.board.Deck;
import java.util.Random;

import com.gruppe21.ResponsTime;
import com.gruppe21.game.board.chancecard.ChanceCard;
import com.gruppe21.utils.BoardLoader;
import com.gruppe21.utils.arrayutils.OurArrayList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Deck {
    private final boolean SHUFFLE_CARDS;
    private final int CARDS_BEFORE_SHUFFLE;
    private int lastShuffle = 0;
    private OurArrayList <ChanceCard> cards;
    private final Random rand = new Random();

    public Deck(){
        SHUFFLE_CARDS = true; //Should be read from file.
        CARDS_BEFORE_SHUFFLE = 20; //should be read from file.
        try {
            cards = BoardLoader.loadCards("cards");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    public void shuffleDeck() {
        long timerStart = System.currentTimeMillis();

        lastShuffle = 0;
        for(int i = 1; i < cards.size(); i++) {
            int rand_int = rand.nextInt(6);
            ChanceCard temp;
            temp = cards.get(i);
            cards.set(i, cards.get(rand_int));
            cards.set(rand_int, temp);

            long timerEnd = System.currentTimeMillis();
            long totalTime = timerEnd-timerStart;
            if(totalTime > ResponsTime.getMAX_shuffle()) ResponsTime.setMAX_shuffle(totalTime);
            System.out.println("Respons time: "+ totalTime + "ms for shuffleDeck() | Current max: "+ ResponsTime.getMAX_shuffle()+"ms");
            return;
        }
      }

    /**
     * Draws the top card.
     * @return
     */
    public ChanceCard drawCard(){
        long timerStart = System.currentTimeMillis();

        if (lastShuffle == CARDS_BEFORE_SHUFFLE) shuffleDeck();
         lastShuffle++;
         ChanceCard Chance = cards.get(0);
         cards.removeIndex(0);

        long timerEnd = System.currentTimeMillis();
        long totalTime = timerEnd-timerStart;
        if(totalTime > ResponsTime.getMAX_draw()) ResponsTime.setMAX_draw(totalTime);
        System.out.println("Respons time: "+ totalTime + "ms for drawCard() | Current max: "+ ResponsTime.getMAX_draw()+"ms");
        return Chance;
    }

    public void returnCard(ChanceCard putBack){
        long timerStart = System.currentTimeMillis();

        cards.add(putBack);

        long timerEnd = System.currentTimeMillis();
        long totalTime = timerEnd-timerStart;
        if(totalTime > ResponsTime.getMAX_return()) ResponsTime.setMAX_return(totalTime);
        System.out.println("Respons time: "+ totalTime + "ms for returnCard() | Current max: " +ResponsTime.getMAX_return()+"ms");
    }
}

//Der er add, get, remove and size