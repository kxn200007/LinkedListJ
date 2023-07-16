
//The batsman class has the data for a batsman
public class Player {

    private String name;
    private int walks;
    private int hitByPitch;
    private int hits;
    private int strikeouts;
    private int sacrifices;
    private int outs;

    //Constructor
    public Player(String name, int walks, int hitByPitch, int hits, int strikeouts, int sacrifices, int outs) {
        this.name = name;
        this.walks = walks;
        this.hitByPitch = hitByPitch;
        this.hits = hits;
        this.strikeouts = strikeouts;
        this.sacrifices = sacrifices;
        this.outs = outs;
    }

    //This method calculates and returns the batting average
    public double battingAverage() {

        //Making sure that division by zero cannot occur
        double denom = atBats();
        if (denom == 0) {
            return 0;
        } else {
            return hits / denom;
        }

    }

    //This method calculates and returns the on base percentage
    public double onBasePercentage() {
        double denom = plateAppearances();
        if (denom == 0) {
            return 0;
        } else {
            return (hits + walks + hitByPitch) / denom;
        }
    }

    //This method returns at bats
    public double atBats() {

        return hits + outs + strikeouts;

    }

    //This method returns total plate appearances
    public double plateAppearances() {
        return hits + outs + hitByPitch + strikeouts + walks + sacrifices;
    }

    public void print() {


        System.out.println(this.name + "\t" + (int)this.atBats() + "\t" + 
                this.hits + "\t" + this.walks + "\t" + this.strikeouts + "\t" + this.hitByPitch + "\t"
                + this.sacrifices + "\t" + String.format("%.3f", battingAverage()) + "\t" + String.format("%.3f", onBasePercentage()));
       

    }

    //Getters
    public String getName() {
        return name;
    }

    public int getWalks() {
        return walks;
    }

    public int getHitByPitch() {
        return hitByPitch;
    }

    public int getHits() {
        return hits;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public int getSacrifices() {
        return sacrifices;
    }

    public int getOuts() {
        return outs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public void setHitByPitch(int hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }

    public void setSacrifices(int sacrifices) {
        this.sacrifices = sacrifices;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }    
    
}
