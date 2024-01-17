/**
 * orders the cards in the linked list according to selected action
 * @author Sreya Srinidhi
 */
public class OrderingCards extends CardShuffler{
  
  /**linked list of person cards in the game*/
  private LinkedList<Cards> personCards = new LinkedList<Cards>();
  
  /**stores the array of shuffled cards from the CardShuffler class*/
  private Cards[] personCardsArray = new Cards[20];  
  
  /**stores the number of cards that the player wants the game to initially have*/
  private final int numCards;
  
  /**
   * constructor that stores the initial number of cards, shuffled cards array and linked list of shuffled cards\
   * @param numCards number of cards the player wants to start with
   */
  public OrderingCards (int numCards) {
    this.numCards = numCards;
    personCardsArray = CardShuffler.getCardsArray();
    personCards = initialPersonCardArrangement();
  }
  
  /**
   * Returns the linked list of shuffles person cards
   * @return linked list of shuffled person cards
   */
  public LinkedList<Cards> getPersonCards(){
    return this.personCards;
  }
  
  /** 
   * Returns the array with shuffled person cards
   * @return the array method with shuffled person cards
   */
  public Cards[] getPersonCardsArray(){
    return this.personCardsArray;
  }
  
  
  /**
   * Returns the number of cards the game starts with
   * @return the number of cards the game starts with
   */
  public int getNumCards(){
    return this.numCards;
  }
  
  /**
   * creates a linked list in the order of the cards in the personCardsArray
   * @return the linked list of shuffled cards
   */
  protected LinkedList<Cards> initialPersonCardArrangement(){
    for (int i = 0; i < this.getNumCards(); i++){
      if (personCards.isEmpty()){
        personCards.addToFront(personCardsArray[i]);
      }
      else{
        personCards.addToEnd(personCardsArray[i]);
      }        
    }
    return personCards;
  }
  
  /**
   * moves the front card back by the number of places inputted
   * @param numPlaces the number of places that the first card moves back by
   * @return the modified linked list with the desired order of cards
   */
  protected LinkedList<Cards> moveCardBack(int numPlaces){
    LLNode<Cards> nodeptr = personCards.getFirstNode();
    for (int i = 0; i <= numPlaces; i++){
      if (i < personCards.length()){
        if(nodeptr != null && i != numPlaces){
          nodeptr = nodeptr.getNext();
        }
        else if (i == numPlaces){
          Cards save = personCards.removeFromFront();
          LLNode<Cards> insert = new LLNode<Cards> (save, null);
          insert.setNext(nodeptr.getNext());
          nodeptr.setNext(insert);
          break;
        }
      }
    }
    return this.personCards;
  }
  
  /**
   * moves the last card in the linked list to the front
   * @return the modified linked list with the last node as the first node
   */
  protected LinkedList<Cards> moveLastToFront(){
    LLNode<Cards> nodeptr = personCards.getFirstNode();
    for (int i = 0; i < personCards.length() - 2; i++) {
      nodeptr = nodeptr.getNext();
    }
    LLNode<Cards> insert = new LLNode<>(nodeptr.getNext().getElement(), personCards.getFirstNode());
    personCards.setFirstNode(insert);
    nodeptr.setNext(null);
    return this.personCards;
  }
  
  /**
   * reverses the linked list of the person cards
   * @return the reversed linked list of person cards
   */
  protected LinkedList<Cards> reverseCardLine(){
    this.moveLastToFront();
    LLNode<Cards> nodeptr = personCards.getFirstNode();
    for (int i = 0; i < personCards.length() - 2; i++){
      LLNode<Cards> nodeptr2 = personCards.getFirstNode();
      for (int j = 0; j < personCards.length() - 2; j++){
        nodeptr2 = nodeptr2.getNext();
      }
      LLNode<Cards> insert = new LLNode<>(nodeptr2.getNext().getElement(), nodeptr.getNext());
      nodeptr2.setNext(null);
      nodeptr.setNext(insert);
      nodeptr = nodeptr.getNext();
    }
    return this.personCards;
  }
 
  /**
   * reverses the first 5 cards of the linked list
   * @return the linked list with the first 5 cards reversed
   */
  protected LinkedList<Cards> reverseFirst5() {
    if (personCards.length() > 5){
      LLNode<Cards> nodeptr = personCards.getFirstNode();
      for(int i = 0; i < 3; i++){
        nodeptr = nodeptr.getNext();
      }
      LLNode<Cards> firstNode = new LLNode<Cards>(nodeptr.getNext().getElement(), personCards.getFirstNode());
      personCards.setFirstNode(firstNode);
      nodeptr.setNext(nodeptr.getNext().getNext());
      
      nodeptr = personCards.getFirstNode();
      for (int i = 0; i < 3; i++){
        LLNode<Cards> nodeptr2 = personCards.getFirstNode();
        for (int j = 0; j < 3; j++){
          nodeptr2 = nodeptr2.getNext();
        }
        LLNode<Cards> insert = new LLNode<>(nodeptr2.getNext().getElement(), nodeptr.getNext());
        nodeptr2.setNext(nodeptr2.getNext().getNext());
        nodeptr.setNext(insert);
        nodeptr = nodeptr.getNext();
      }
    }
    else {
      this.reverseCardLine();
    }
    return personCards;
  }
}
