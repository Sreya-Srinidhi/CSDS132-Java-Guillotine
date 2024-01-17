import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 * shuffles the person cards in the game
 * @author Sreya Srinidhi
 */
public class CardShuffler {

  /**Stores the order of the person cards to be used in the game*/
  final static Cards[] cards = new Cards[20];
  
  /**
   * constructor that shuffles the cards when the class is called
   */
  public CardShuffler() {
    this.randomizingCards();
  }
  
  /**
   * retrieves the array of cards
   * @return the array of ordered cards
   */
  public static Cards[] getCardsArray(){
    return cards;
  }
  
  /**
   * creating instances of each person card in the game
   */
  Cards kingLouisXIV = new Cards("King Louis XIV", "Royal", 5);
  Cards marieAntoinette = new Cards("Mary Antoinette", "Royal", 5);
  Cards regent = new Cards("Regent", "Royal", 4);
  Cards duke = new Cards("Duke", "Royal", 3);
  Cards baron = new Cards("Baron", "Royal", 3);
  Cards count = new Cards("Count", "Royal", 2);
  Cards countess = new Cards("Countess", "Royal", 2);
  Cards lord = new Cards("Lord", "Royal", 2);
  Cards lady = new Cards("Lady", "Royal", 2);
  Cards cardinal = new Cards("Cardinal", "Church", 5);
  Cards archbishop = new Cards("Archbishop", "Church", 4);
  Cards nun = new Cards("Nun", "Church", 3);
  Cards bishop = new Cards("Bishop", "Church", 2);
  Cards priest1 = new Cards("Priest", "Church", 1);
  Cards priest2 = new Cards("Priest", "Church", 1);
  Cards heretic = new Cards("Heretic", "Church", 0);
  Cards governor = new Cards("Governor", "Civic", 4);
  Cards mayor = new Cards("Mayor", "Civic", 3);
  Cards councilman = new Cards("Councilman", "Civic", 3);
  Cards judge1 = new Cards("Judge", "Civic", 2);
  Cards judge2 = new Cards("Judge", "Civic", 2);
  Cards taxCollector = new Cards("Tax Collector", "Civic", 0);
  Cards sheriff1 = new Cards("Sheriff", "Civic", 1);
  Cards sheriff2 = new Cards("Sheriff", "Civic", 1);
  Cards palaceGuard1 = new Cards("Palace Guard", "Military", 0);
  Cards palaceGuard2 = new Cards("Palace Guard", "Military", 0);
  Cards palaceGuard3 = new Cards("Palace Guard", "Military", 0);
  Cards palaceGuard4 = new Cards("Palace Guard", "Military", 0);
  Cards palaceGuard5 = new Cards("Palace Guard", "Military", 0);
  Cards general = new Cards("General", "Military", 4);
  Cards colonel = new Cards("Colonel", "Military", 3);
  Cards captain = new Cards("Captain", "Military", 2);
  Cards lieutenant1 = new Cards("Lieutenant", "Military", 1);
  Cards lieutenant2 = new Cards("Lieutenant", "Military", 1);
  Cards tragicFigure = new Cards ("Tragic Figure", "Commoner", 0);
  Cards heroicFigure = new Cards ("Heroic Figure", "Commoner", -3);
  Cards student1 = new Cards ("Student", "Commoner", -1);
  Cards student2 = new Cards ("Student", "Commoner", -1);
  Cards student3 = new Cards ("Student", "Commoner", -1);
  Cards student4 = new Cards ("Student", "Commoner", -1);
  
  /**
   * shuffles the cards
   * @return an array of shuffled cards
   */
  private Cards[] randomizingCards(){
    
    //creating an array with all persons cards
    Cards[] array = {kingLouisXIV, marieAntoinette, regent, duke, baron, count, countess, lord, lady, cardinal, archbishop, nun, bishop, priest1, priest2, heretic, governor, mayor, councilman, judge1, judge2, taxCollector, sheriff1, sheriff2, palaceGuard1, palaceGuard2, palaceGuard3, palaceGuard4, palaceGuard5, general, colonel, captain, lieutenant1, lieutenant2, tragicFigure, heroicFigure, student1, student2, student3, student4};
    
    //creating a list
    List<Cards> list = Arrays.asList(array);
    
    //shuffling person cards
    Collections.shuffle(list);
    
    for (int i = 0; i < 20; i++){
      cards[i] = list.get(i);
    }
    return cards;
  }  
}