public class Points {
  
  private String cardName;
  
  private int cardPoints;
  
  private int p1Points;
  
  private int p2Points;
  
  private String player;

  public Points (Cards card, String player){
    this.cardPoints = card.getCardPoints();
    this.cardName = card.getCardName();
    this.player = player;
  }
  
  public String getCardName() {
    return this.cardName;
  }
  
  public int getCardPoints() {
    return this.cardPoints;
  }
  
  public int getP1Points() {
    return this.p1Points;
  }
  
  public int getP2Points() {
    return p2Points;
  }
  
  public String getPlayer() {
    return this.player;
  }
  
  public int add()
}