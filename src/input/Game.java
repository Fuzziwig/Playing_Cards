package input;

/**
 * The type Game.
 *
 * @author Jakob Madsen
 * @version 1.0
 */
public class Game {

    private Player p1 = new Player();
    private Player p2 = new Player();
    private Deck d1;

    /**
     * Instantiates a new Game.
     */
    public Game() {
    }

    /**
     * Instantiates a new Game.
     *
     * @param player1 the player 1
     * @param player2 the player 2
     */
    public Game(String player1, String player2) {
        this.p1.setName(player1);
        this.p2.setName(player2);
        System.out.println("Player1 " + player1+" is ready");
        System.out.println("Player2 " + player2+" is ready");
        this.d1 = new Deck();
        System.out.println("Deck is presented");
        System.out.println(d1.toString());
        this.d1.shuffleCards();
        System.out.println("Deck is shuffled");
        Deck validationDeck = new Deck();
        System.out.println("Deck is validated against a fresh Deck to see if it has been shuffled properly");
        System.out.println("Validation passed : "+!validationDeck.equals(d1));
        System.out.println("Let the game begin\n");
    }

    /**
     * Initialize the game.
     */
    public void init (){
        String p1name = p1.getName();
        String p2name = p2.getName();
        Card c1 = this.d1.drawTopCard();
        Card c2 = this.d1.drawTopCard();
        while (!c1.isEmpty() || !c2.isEmpty()){
            System.out.println("2 Cards are drawn from the top");
            System.out.println(p1name +" draws "+c1.toString());
            System.out.println(p2name +" draws "+c2.toString());
            if (c1.compareTo(c2)>0) {
                this.p1.setScore(this.p1.getScore()+1);
                System.out.println(p1name + " wins the round\n");
            }
            else {
                this.p2.setScore(this.p2.getScore()+1);
                System.out.println(p2name + " wins the round\n");
            }
            c1 = this.d1.drawTopCard();
            c2 = this.d1.drawTopCard();
            if (c1.isEmpty()) { break;}
            System.out.println("next round !");
        }
        if (p1.getScore()> p2.getScore()) {
            System.out.println(p1name+ " wins the game with "+p1.getScore()+ " points");
        }
        else if (p1.getScore()< p2.getScore()) {
            System.out.println(p2name+ " wins the game with "+p2.getScore()+ " points");
        }
        else {
            System.out.println("It's a tie !");
        }
    }

}
