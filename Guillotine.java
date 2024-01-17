import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;
import java.lang.Math;
import java.lang.Integer;

/**
 * runs the game Guillotine
 * @author Sreya Srinidhi
 */
public class Guillotine extends Application{
  
  /**creates an instance of OrderingCards to help manipulate the person cards linked list*/
  private static OrderingCards c;
  
  /**creates a VBox to arrange the unpicked person card buttons*/
  private static VBox unpickedTiles;
  
  /**variable to track which player is playing*/
  private boolean p1 = true;
  
  /**variable to check if the game is over or not*/
  private boolean gameOver = false;
  
  /**creates an instance of BorderPane so that the buttons and labels can be arranged as desired*/
  BorderPane layout = new BorderPane();
  
  /**creates an instance of VBox to arrange the action buttons of player 1*/
  VBox p1Buttons = new VBox(10);
  
  /**creates an instance of VBox to arrange the action buttons of player 2*/
  VBox p2Buttons = new VBox(10);

  
  /**
   * This method creates the use interface for the Guillotine game
   * @param primaryStage the main window of the user interface
   */
  public void start (Stage primaryStage){
    PointsCalculator points = new PointsCalculator(); //creates an instance to calculate the points of each player
    
    //creating buttons for each action of player 1
    Button p1button1 = new Button ("Move Front Back 4");
    Button p1button2 = new Button ("Move Front Back 3");
    Button p1button3 = new Button ("Move Front Back 2");
    Button p1button4 = new Button ("Move Front Back 1");
    Button p1button5 = new Button ("Move Front To End");
    Button p1button6 = new Button ("Move Last Person to Front");
    Button p1button7 = new Button ("Reverse Line");
    Button p1button8 = new Button ("Reverse First 5");
    Button p1button9 = new Button ("Skip Turn");
    Button p1button10 = new Button ("Take Front Person");
    Label p1Description = new Label ("Player 1");
    Label p1Points = new Label ("Points: " + points.getP1Points());
    Label p1Label = new Label("Player 1's cards");
    
    //creating buttons for each action of player 2
    Button p2button1 = new Button ("Move Front Back 4");
    Button p2button2 = new Button ("Move Front Back 3");
    Button p2button3 = new Button ("Move Front Back 2");
    Button p2button4 = new Button ("Move Front Back 1");
    Button p2button5 = new Button ("Move Front To End");
    Button p2button6 = new Button ("Move Last Person to Front");
    Button p2button7 = new Button ("Reverse Line");
    Button p2button8 = new Button ("Reverse First 5");
    Button p2button9 = new Button ("Skip Turn");
    Button p2button10 = new Button ("Take Front Person");
    Label p2Description = new Label ("Player 2");
    Label p2Points = new Label ("Points: " + points.getP2Points());
    Label p2Label = new Label("Player 2's cards");
    
    //creates event handlers for each action button of player 1
    p1button1.setOnAction(e -> {if (p1 == true && gameOver == false){c.moveCardBack(4); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button1.setDisable(true);}});
    p1button2.setOnAction(e -> {if (p1 == true && gameOver == false){c.moveCardBack(3); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button2.setDisable(true);}});
    p1button3.setOnAction(e -> {if (p1 == true && gameOver == false){c.moveCardBack(2); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button3.setDisable(true);}});
    p1button4.setOnAction(e -> {if (p1 == true && gameOver == false){c.moveCardBack(1); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button4.setDisable(true);}});
    p1button5.setOnAction(e -> {if (p1 == true && gameOver == false){c.moveCardBack(c.getPersonCards().length() - 1); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button5.setDisable(true);}});
    p1button6.setOnAction(e -> {if (p1 == true && gameOver == false){c.moveLastToFront(); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button6.setDisable(true);}});
    p1button7.setOnAction(e -> {if (p1 == true && gameOver == false){c.reverseCardLine(); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button7.setDisable(true);}});
    p1button8.setOnAction(e -> {if (p1 == true && gameOver == false){c.reverseFirst5(); unpickedTiles.getChildren().clear(); Guillotine.printList(); p1button8.setDisable(true);}});
    p1button9.setOnAction(e -> {if (gameOver == false) {p1 = false; p1button9.setDisable(true);}});
    p1button10.setOnAction(e -> {
      if (p1 == true && gameOver == false){
        Cards save = c.getPersonCards().removeFromFront();
        c.getPersonCards().setFirstNode(c.getPersonCards().getFirstNode());
        p1Buttons.getChildren().add(new Button (save.getCardName() + ", " + save.getCardsGroup() + ": " + save.toString()));
        unpickedTiles.getChildren().clear(); 
        Guillotine.printList();
        points.add(save, "p1");
        p1Points.setText("Points: " + points.getP1Points());
        p1 = false;
        if (c.getPersonCards().length() == 0)
          gameOver = true;
      }
    });
    
    //creates event handlers for each action button of player 2
    p2button1.setOnAction(e -> {if (p1 == false && gameOver == false){c.moveCardBack(4); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button1.setDisable(true);}});
    p2button2.setOnAction(e -> {if (p1 == false && gameOver == false){c.moveCardBack(3); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button2.setDisable(true);}});
    p2button3.setOnAction(e -> {if (p1 == false && gameOver == false){c.moveCardBack(2); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button3.setDisable(true);}});
    p2button4.setOnAction(e -> {if (p1 == false && gameOver == false){c.moveCardBack(1); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button4.setDisable(true);}});
    p2button5.setOnAction(e -> {if (p1 == false && gameOver == false){c.moveCardBack(c.getPersonCards().length() - 1); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button5.setDisable(true);}});
    p2button6.setOnAction(e -> {if (p1 == false && gameOver == false){c.moveLastToFront(); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button6.setDisable(true);}});
    p2button7.setOnAction(e -> {if (p1 == false && gameOver == false){c.reverseCardLine(); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button7.setDisable(true);}});
    p2button8.setOnAction(e -> {if (p1 == false && gameOver == false){c.reverseFirst5(); unpickedTiles.getChildren().clear(); Guillotine.printList(); p2button8.setDisable(true);}});
    p2button9.setOnAction(e -> {if (gameOver == false) {p1 = true; p2button9.setDisable(true);}});
    p2button10.setOnAction(e -> {
      if (p1 == false && gameOver == false){
        Cards save = c.getPersonCards().removeFromFront();
        c.getPersonCards().setFirstNode(c.getPersonCards().getFirstNode());
        p2Buttons.getChildren().add(new Button (save.getCardName() + ", " + save.getCardsGroup() + ": " + save.toString()));
        unpickedTiles.getChildren().clear(); 
        Guillotine.printList();
        points.add(save, "p2");
        p2Points.setText("Points: " + points.getP2Points());
        p1 = true;
        if (c.getPersonCards().length() == 0)
          gameOver = true;
      }
    });
    
    p1Buttons.getChildren().addAll(p1Description, p1Points, p1button1, p1button2, p1button3, p1button4, p1button5, p1button6, p1button7, p1button8, p1button9, p1button10, p1Label); //adds all player 1 action buttons, description and points labels to the VBox
    p2Buttons.getChildren().addAll(p2Description, p2Points, p2button1, p2button2, p2button3, p2button4, p2button5, p2button6, p2button7, p2button8, p2button9, p2button10, p2Label); //adds all player 2 action buttons, description and points labels to the VBox
    
    unpickedTiles = new VBox(); //creates an instance of VBox where all the unpicked person card buttons are arranged
    Guillotine.printList(); //prints the linked list of person cards
    
    layout.setLeft(p1Buttons); //sets the action buttons and labels of player 1 on the left of the border pane
    layout.setRight(p2Buttons); //sets the action buttons and labels of player 2 on the right of the border pane
    layout.setCenter(unpickedTiles); //sets the unpicked person cards in the center of the border pane
    
    Scene scene = new Scene (layout, 625, 1000); //the border pane is added to the scene
    primaryStage.setScene(scene); //the scene is added to the stage
    primaryStage.show(); //displays the stage
  }
  
  /**
   * prints the linked list of unpicked person cards
   */
  public static void printList() {
    if (c.getPersonCards().length() == 0){
      unpickedTiles.getChildren().add(new Label ("Game Over"));
    }
    LLNode<Cards> nodeptr = c.getPersonCards().getFirstNode();
    for (int i = 0; i < c.getPersonCards().length(); i++){
      unpickedTiles.getChildren().add(new Button(nodeptr.getElement().getCardName() + ", " + nodeptr.getElement().getCardsGroup() + ": " + nodeptr.getElement().toString()));
      nodeptr = nodeptr.getNext();
    }
  }
  
  
  /**
   * helper class the calculates the points of each player
   */
  private class PointsCalculator {
    
    /**stores the points of player1*/
    private int p1Points = 0;
    
    /**stores the points of player2*/
    private int p2Points = 0;
    
    /**checks if the count or countess is collected by player 1*/
    private boolean p1CountCouple = false;
    
    /**checks if the count or countess is collected by player 2*/
    private boolean p2CountCouple = false;
    
    /**checks if the lord or lady is collected by player 1*/
    private boolean p1LordCouple = false;
    
    /**checks if the lord or lady is collected by player 2*/
    private boolean p2LordCouple = false;
    
    /**checks if the heretic card has been collected by player 1*/
    private boolean p1Heretic = false;
    
    /**checks if the heretic card has been collected by player 2*/
    private boolean p2Heretic = false;
    
    /**checks if the tax collector card has been collected by player 1*/
    private boolean p1TaxCollector = false;
    
    /**checks if the tax collector card has been collected by player 2*/
    private boolean p2TaxCollector = false;
    
    /**checks if the tragic figure card has been collected by player 1*/
    private boolean p1TragicFigure = false;
    
    /**checks if the tragic figure card has been collected by player 2*/
    private boolean p2TragicFigure = false;
    
    /**keeps track of the number of palace guards player 1 has collected*/
    private int p1PGCount = 0;
    
    /**keeps track of the number of palace guards player 2 has collected*/
    private int p2PGCount = 0;
    
    /**keeps track of the number of civic group cards player 1 has collected*/
    private int p1CivicCount = 0;
    
    /**keeps track of the number of civic group cards player 2 has collected*/
    private int p2CivicCount = 0;
    
    /**keeps track of the number of church group cards player 1 has collected*/
    private int p1ChurchCount = 0;
    
    /**keeps track of the number of church group cards player 2 has collected*/
    private int p2ChurchCount = 0;
    
    /**keeps track of the number of commoner group cards player 1 has collected*/
    private int p1CommonerCount = 0;
    
    /**keeps track of the number of commoner group cards player 2 has collected*/
    private int p2CommonerCount = 0;
    
    
    /**
     * returns the points player 1 has
     * @return the points player 1 has
     */
    protected int getP1Points(){
      return this.p1Points;
    }
    
    /**
     * returns the points player 2 has
     * @return the points player 2 has
     */
    protected int getP2Points(){
      return this.p2Points;
    }
    
    /**
     * adds the points of the card collected to the player's points
     * @param card the card that was collected by the player
     * @param player the player that collected the card
     */
    protected void add(Cards card, String player){
      if (player.equals("p1")){    //players 1's points are being calculated
        if (card.getCardName().equals("Count") || card.getCardName().equals("Countess")) //checks if the card is a count or countess to account for exception points
          p1Points += this.countCoupleCheck(player);
        else if (card.getCardName().equals("Lord") || card.getCardName().equals("Lady")) //checks if the card is a lord or lady to account for exception points
          p1Points += this.lordCoupleCheck(player);
        else if (card.getCardName().equals("Palace Guard")) //checks if the card is a palace guard to account for exception points
          p1Points += this.palaceGuardCountCheck(player);        
        else if (card.getCardsGroup().equals("Church")) //checks if the card is a church group card to account for exception points
          p1Points += this.churchCardsCheck(card, player);
        else if (card.getCardsGroup().equals("Civic")) //checks if the card is a civic group to account for exception points
          p1Points += this.civicCardsCheck(card, player);
        else if (card.getCardsGroup().equals("Commoner")) //checks if the card is a commoner group to account for exception points
          p1Points += this.commonerCardsCheck(card, player);
        else
          p1Points += card.getCardPoints();
      }
      if (player.equals("p2")){   //players 2's points are being calculated
        if (card.getCardName().equals("Count") || card.getCardName().equals("Countess")) //checks if the card is a count or countess to account for exception points
          p2Points += this.countCoupleCheck(player);
        else if (card.getCardName().equals("Lord") || card.getCardName().equals("Lady")) //checks if the card is a lord or lady to account for exception points
          p2Points += this.lordCoupleCheck(player);
        else if (card.getCardName().equals("Palace Guard")) //checks if the card is a palace guard to account for exception points
          p2Points += this.palaceGuardCountCheck(player);       
        else if (card.getCardsGroup().equals("Church")) //checks if the card is a church group card to account for exception points
          p2Points += this.churchCardsCheck(card, player);
        else if (card.getCardsGroup().equals("Civic")) //checks if the card is a civic group to account for exception points
          p2Points += this.civicCardsCheck(card, player);     
        else if (card.getCardsGroup().equals("Commoner")) //checks if the card is a commoner group to account for exception points
          p2Points += this.commonerCardsCheck(card, player);
        else
          p2Points += card.getCardPoints();
      }
    }
    
    /**
     * calculates the points if the card is a count or countess
     * @param player the player that collected the card
     * @return the number of points that resulted from collecting the card
     */
    protected int countCoupleCheck(String player){
      if (player.equals("p1") && this.p1CountCouple == true){   //checks which player collected the card and if a count or countess was collected by that player before
        return 6;
      }
      else if (player.equals("p1")){  //checks which player collected the count or countess
        this.p1CountCouple = true;    //updates the boolean to indicate true for future calculations
        return 2;
      }
      else if (player.equals("p2") && this.p2CountCouple == true){  //checks which player collected the card and if a count or countess was collected by that player before
        return 6;
      }
      else{
        this.p2CountCouple = true;   //updates the boolean to indicate true for future calculations
        return 2;
      }
    }
    
    /**
     * calculates the points if the card is a lord or lady
     * @param player the player that collected the card
     * @return the number of points that resulted from collecting the card
     */
    protected int lordCoupleCheck(String player){
      if (player.equals("p1") && this.p1LordCouple == true){    //checks which player collected the card and if a lord or lady was collected by that player before
        return 6;
      }
      else if (player.equals("p1")){   //checks which player collected the card
        this.p1LordCouple = true;      //updates the boolean to indicate true for future calculations
        return 2;
      }
      else if (player.equals("p2") && this.p2LordCouple == true){ //checks which player collected the card and if a lord or lady was collected by that player before
        return 6;
      }
      else{
        this.p2LordCouple = true;     //updates the boolean to indicate true for future calculations
        return 2;
      }
    }
    
    /**
     * calculates the points if the card is a palace guard
     * @param player the player that collected the card
     * @return the number of points that resulted from collecting the card
     */
    protected int palaceGuardCountCheck(String player){
      if (player.equals("p1")){    //checks which player collected the card
        p1PGCount += 1;
        if (p1PGCount > 1)         //checks if the number of palace guards collected by player 1 is greater than 1 to modify the points accordingly
          return (int) (Math.pow(p1PGCount, 2) - (Math.pow(p1PGCount - 1, 2)));
        else
          return 1;
      }
      if (player.equals("p2")){    //checks which player collected the card
        p2PGCount += 1;
        if (p2PGCount > 1)         //checks if the number of palace guards collected by player 2 is greater than 1 to modify the points accordingly
          return (int) (Math.pow(p2PGCount, 2) - (Math.pow(p2PGCount - 1, 2)));
        else
          return 1;
      }
      return 0;
    }
    
    /**
     * calculates the points if the card group is church
     * @param card the card that was collected
     * @param player the player that collected the card
     * @return the number of points that resulted from collecting the card
     */
    protected int churchCardsCheck(Cards card, String player){
      int points = 0;
      if (player.equals("p1")){
        p1ChurchCount += 1;
        if (this.p1Heretic == true){   //checks if player 1 has already collected heretic so the points can be modified accordingly
          points += 1;
        }
        if (card.getCardName().equals("Heretic")){  //checks if the card collected is the heretic so the points can be modified accordingly
          this.p1Heretic = true;
          points += this.p1ChurchCount;
        }
        else
          points += card.getCardPoints(); //adds the points of the card to player 1's points
      }
      else {
        p2ChurchCount += 1;
        if (this.p2Heretic == true){   //checks if player 2 has already collected heretic so the points can be modified accordingly
          points += 1;
        }
        if (card.getCardName().equals("Heretic")){  //checks if the card collected is the heretic so the points can be modified accordingly
          this.p2Heretic = true;
          points += this.p2ChurchCount;
        }
        else
          points += card.getCardPoints(); //adds the points of the card to player 2's points
      }
      return points;
    }
    
    /**
     * calculates the points if the card group is civic
     * @param card the card that was collected
     * @param player the player that collected the card
     * @return the number of points that resulted from collecting the card
     */
    protected int civicCardsCheck(Cards card, String player){
      int points = 0;
      if (player.equals("p1")){  
        p1CivicCount += 1;
        if (this.p1TaxCollector == true){  //checks if player 1 has already collected the tax collector so the points can be modified accordingly
          points += 1;
        }
        if (card.getCardName().equals("Tax Collector")){   //checks if player 1 has collected the tax collector so the points can be modified accordingly
          this.p1TaxCollector = true;
          points += this.p1CivicCount;
        }
        else
          points += card.getCardPoints();  //adds the points of the card to player 1's points
      }
      else{
        p2CivicCount += 1;
        if (this.p2TaxCollector == true){  //checks if player 2 has already collected the tax collector so the points can be modified accordingly
          points += 1;
        }
        if (card.getCardName().equals("Tax Collector")){  //checks if player 2 has collected the tax collector so the points can be modified accordingly
          this.p2TaxCollector = true;
          points += this.p2CivicCount;
        }
        else
          points += card.getCardPoints();  //adds the points of the card to player 2's points
      }
      return points;
    }
    
    /**
     * calculates the points if the card group is commoner
     * @param card the card that was collected
     * @param player the player that collected the card
     * @return the number of points that resulted from collecting the card
     */
    protected int commonerCardsCheck(Cards card, String player){
      int points = 0;
      if (player.equals("p1")){
        p1CommonerCount += 1;
        if (this.p1TragicFigure == true){   //checks if player 1 has already collected the tragic figure so the points can be modified accordingly
          points -= 1;
        }
        if (card.getCardName().equals("Tragic Figure")){  //checks if the card collected is the tragic figure so the points can be modified accordingly
          this.p1TragicFigure = true;
          points -= this.p1CommonerCount;
        }
        else
          points += card.getCardPoints();  //adds the points of the card to player 1's points
      }
      else{
        p2CommonerCount += 1;
        if (this.p2TragicFigure == true){  //checks if player 1 has already collected the tragic figure so the points can be modified accordingly
          points += 1;
        }
        if (card.getCardName().equals("Tragic Figure")){  //checks if the card collected is the tragic figure so the points can be modified accordingly
          this.p2TragicFigure = true;
          points -= this.p2CommonerCount;
        }
        else
          points += card.getCardPoints();  //adds the points of the card to player 2's points
      }
      return points;
    }
  }

  
  /**
   * main method that launches the Guillotine game
   * @param args array of string that indicates how many cards the players want the game to start with
   */
  public static void main (String[] args){
    int numCards;
    if (args.length > 0){
      numCards = Integer.parseInt(args[0]);
      if (numCards >= 2 && numCards <= 20){
        c = new OrderingCards(numCards);
        Application.launch(args);
      }
      else 
        System.out.println ("incorrect number of cards");
    }
    else
      System.out.println ("Enter the number of cards");
  }
}