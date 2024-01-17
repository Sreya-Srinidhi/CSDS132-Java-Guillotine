import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class InitializingCards {
  
  /**Stores the order of the person cards and does not change*/
  final static String[] cards = new String[20];
  
  /**
   * constructor that randomizes cards when called
   */
  public InitializingCards () {
    InitializingCards.randomizingCards();
  }
  
  /**
   * retrieves that array of cards
   * @return the array of ordered cards
   */
  public static String[] getCardsArray(){
    return cards;
  }
  
  /**
   * shuffles the cards
   * @return an array of shuffled cards
   */
  private static String[] randomizingCards(){
    
    //creating an array with all persons cards
    String[] array = {"King Louis XIV", "Marie Antoinette", "Regent", "Duke", "Baron", "Count", "Countess", "Lord", "Lady", "Cardinal", "Archbishop", "Nun", "Bishop", "Priest", "Heretic", "Governor", "Mayor", "Councilman", "Judge", "Judge", "Tax Collector", "Sheriff", "Sheriff", "Palace Guard", "Palace Guard", "Palace Guard", "Palace Guard", "Palace Guard", "General", "Colonel", "Captain", "Lieutenant", "Lieutenant", "Tragic Figure", "Heroic Figure", "Student", "Student", "Student", "Student"};
    
    //creating a list
    List<String> list = Arrays.asList(array);
    
    //shuffling person cards
    Collections.shuffle(list);
    
    for (int i = 0; i < 20; i++){
      cards[i] = list.get(i);
    }
    return cards;
  }
}