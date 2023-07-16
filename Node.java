
/**
 *
 * Node class represents a node of data that can be inserted in a link list
 */
public class Node {


    private Player player;
    private Node next;

    //Constructor
    public Node(Player player) {

        this.next = null;
        this.player = player;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
    
    public Player getPlayer(){
        return player;
    }
    
    
    public void setPlayer(Player p){
        
        this.player = p;
        
    }
    
    
    
    
    
    



}
