import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 11:07
 */
class Card {
    public String suit;
    public int rank;
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]",suit,rank);
    }
}
class CardDemo {
    public static final String[] SUITS = {"♠","♦","♣","♥"};
    //买牌
    public List<Card> buyDeck() {
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = SUITS[i];
                //int rank = j;
                Card card  = new Card(suit,j);
                list.add(card);
            }
        }
        return list;
    }

    private void swap(List<Card> cards,int i,int index) {
        Card temp = cards.get(i);
        cards.set(i,cards.get(index)) ;
        cards.set(index,temp);
    }
    //洗牌
    public void shuffle(List<Card> cards) {
        Random random = new Random();
        for(int i = cards.size()-1; i > 0; i++) {
            int index = random.nextInt(i);
            swap(cards,i,index);
        }
    }

}

public class TestDemo3 {
    public static void main(String[] args){
        CardDemo desk = new CardDemo();
        //买牌
        List<Card> list = desk.buyDeck();
        System.out.println(list);
        //洗牌
        desk.shuffle(list);
        System.out.println(list);
    }
}
