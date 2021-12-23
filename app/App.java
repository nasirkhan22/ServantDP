/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author kHaN
 */
import java.util.ArrayList;
public class App {

    /**
     * @param args the command line arguments
     */
    static Servant jenkins = new Servant("Jenkins");
  static Servant travis = new Servant("Travis");
    public static void main(String[] args) {
        scenario(jenkins, 1);
    scenario(travis, 0);
  }

  /**
   * Can add a List with enum Actions for variable scenarios
   */
  public static void scenario(Servant servant, int compliment) {
    King k = new King();
    Queen q = new Queen();

    ArrayList<Royalty> guests = new ArrayList<>();
    guests.add(k);
    guests.add(q);

    // feed
    servant.feed(k);
    servant.feed(q);
    // serve drinks
    servant.giveWine(k);
    servant.giveWine(q);
    // compliment
    servant.giveCompliments(guests.get(compliment));

    // outcome of the night
    for (Royalty r : guests) {
      r.changeMood();
    }

    // check your luck
    if (servant.checkIfYouWillBeHanged(guests)) {
      System.out.println(servant.name + " will live another day");
    } else {
      System.out.println("Poor " + servant.name + ". His days are numbered");
    }

    }
    
}
