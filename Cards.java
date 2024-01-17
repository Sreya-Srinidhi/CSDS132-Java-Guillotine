/**
 * stores the name, group and points of a card
 * @author Sreya Srinidhi
 */ 
public class Cards {
  
 
  /**Stores the name of the card*/
  private final String cardName;
  
  /**Stores the group of the card*/
  private final String cardGroup;
  
  /**Stores the points of the card*/
  private int cardPoints;
  
  /**
   * constructor that inputs and stores the name, group and points of the card
   */
  public Cards (String name, String group, int points) {
    this.cardName = name;
    this.cardGroup = group;
    this.cardPoints = points;
  }
  
  
  /**
   * retrieves the name of the card
   * @return the name of the card
   */
  public String getCardName() {
    return this.cardName;
  }
    
  /**
   * retrieves the group of the card
   * @return the group of the card
   */
  public String getCardsGroup(){
    return this.cardGroup;
  }
    
  /**
   * retrieves the points of the card
   * @return the points of the card
   */
  public int getCardPoints(){
    return this.cardPoints;
  }
  
  /**
   * strings the points of the cards
   * @return String of the points of the card
   */
  public String toString(){
    if (this.getCardPoints() == 0)
      return "*";
    else 
      return String.valueOf(this.getCardPoints());
  }
}
