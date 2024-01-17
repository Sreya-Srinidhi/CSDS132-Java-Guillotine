import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class GuillotineTester {
  
  /**
   * Tests the toString() method in the Cards Class
   */
  @Test
  public void testToString() {
    Cards c = new Cards ("King Louis XIV", "Royal", 5);
    Cards c1 = new Cards("Count", "Royal", 2);
    Cards c2 = new Cards("Heretic", "Church", 0);
    Cards c3 = new Cards("Tax Collector", "Civic", 0);
    Cards c4 = new Cards("Palace Guard", "Military", 0);
    
    assertEquals("5", c.toString());
    assertEquals("2", c1.toString());
    assertEquals("*", c2.toString());
    assertEquals("*", c3.toString());
    assertEquals("*", c4.toString());
  }
  
  /**
   * Tests the getCardName() method in the Cards Class
   */
  @Test
  public void testGetCardName() {
    Cards c = new Cards ("King Louis XIV", "Royal", 5);
    Cards c1 = new Cards("Tragic Figure", "Commoner", 2);
    Cards c2 = new Cards("Heretic", "Church", 0);
    Cards c3 = new Cards("Tax Collector", "Civic", 0);
    Cards c4 = new Cards("Palace Guard", "Military", 0);
    
    assertEquals("King Louis XIV", c.getCardName());
    assertEquals("Tragic Figure", c1.getCardName());
    assertEquals("Heretic", c2.getCardName());
    assertEquals("Tax Collector", c3.getCardName());
    assertEquals("Palace Guard", c4.getCardName());
  }
  
  /**
   * Tests the getCardsGroup() method in the Cards Class
   */
  @Test
  public void testGetCardsGroup() {
    Cards c = new Cards ("King Louis XIV", "Royal", 5);
    Cards c1 = new Cards("Tragic Figure", "Commoner", 2);
    Cards c2 = new Cards("Heretic", "Church", 0);
    Cards c3 = new Cards("Tax Collector", "Civic", 0);
    Cards c4 = new Cards("Palace Guard", "Military", 0);
    
    assertEquals("Royal", c.getCardsGroup());
    assertEquals("Commoner", c1.getCardsGroup());
    assertEquals("Church", c2.getCardsGroup());
    assertEquals("Civic", c3.getCardsGroup());
    assertEquals("Military", c4.getCardsGroup());
  }
  
  /**
   * Tests the getCardsPoints() method in the Cards Class
   */
  @Test
  public void testGetCardPoints() {
    Cards c = new Cards ("King Louis XIV", "Royal", 5);
    Cards c1 = new Cards("Tragic Figure", "Commoner", 2);
    Cards c2 = new Cards("Heretic", "Church", 0);
    Cards c3 = new Cards("Tax Collector", "Civic", 0);
    Cards c4 = new Cards("Palace Guard", "Military", 0);
    
    assertEquals(5, c.getCardPoints());
    assertEquals(2, c1.getCardPoints());
    assertEquals(0, c2.getCardPoints());
    assertEquals(0, c3.getCardPoints());
    assertEquals(0, c4.getCardPoints());
  }
  
  /**
   * Tests the randomizingCards() method in the CardShuffler Class
   */
  @Test
  public void testRandomizingCards() {
    CardShuffler c = new CardShuffler();
    CardShuffler c1 = new CardShuffler();
    CardShuffler c2 = new CardShuffler();
    
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
    Cards[] array = {kingLouisXIV, marieAntoinette, regent, duke, baron, count, countess, lord, lady, cardinal, archbishop, nun, bishop, priest1, priest2, heretic, governor, mayor, councilman, judge1, judge2, taxCollector, sheriff1, sheriff2, palaceGuard1, palaceGuard2, palaceGuard3, palaceGuard4, palaceGuard5, general, colonel, captain, lieutenant1, lieutenant2, tragicFigure, heroicFigure, student1, student2, student3, student4};
    
    assertFalse(array.equals(c));
    assertFalse(array.equals(c1));
    assertFalse(array.equals(c2));    
  }
}