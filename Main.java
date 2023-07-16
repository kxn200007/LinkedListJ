
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class acts as the driver class. The program starts execution from
 * the main method inside it
 *
 */
public class Main {

    private static final int MAX_PLAYERS = 30;

    /**
     * The parseBattingRecord method parses a single line It adds a new node in
     * the link list or updates an existing one if the name already exists
     *
     */
    public static void parseBattingRecord(String battingRecord, LinkList linkList) {

        String splitted[] = battingRecord.split(" ");

        String name = splitted[0];

        Node player = linkList.find(name);

        int H = 0;
        int O = 0;
        int K = 0;
        int S = 0;
        int W = 0;
        int P = 0;

        if (splitted.length > 1) {

            for (int i = 0; i < splitted[1].length(); i++) {

                if (splitted[1].charAt(i) == 'H') {
                    H++;
                } else if (splitted[1].charAt(i) == 'O') {
                    O++;
                } else if (splitted[1].charAt(i) == 'K') {
                    K++;
                } else if (splitted[1].charAt(i) == 'W') {
                    W++;
                } else if (splitted[1].charAt(i) == 'P') {
                    P++;
                } else if (splitted[1].charAt(i) == 'S') {
                    S++;
                }

            }

            if (player == null) {
                player = new Node(new Player(name, W, P, H, K, S, O));
                linkList.add(player);
            } else {
                player.getPlayer().setHits(player.getPlayer().getHits() + H);
                player.getPlayer().setStrikeouts(player.getPlayer().getStrikeouts() + K);
                player.getPlayer().setHitByPitch(player.getPlayer().getHitByPitch() + P);
                player.getPlayer().setWalks(player.getPlayer().getWalks() + W);
                player.getPlayer().setSacrifices(player.getPlayer().getSacrifices() + S);
                player.getPlayer().setOuts(player.getPlayer().getOuts() + O);

            }

        }
    }

    /**
     * This method reads the file and updates link list accordingly
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    static LinkList readFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner fileInput = new Scanner(file);

        //An empty link list to hold the data
        LinkList linkList = new LinkList();

        //Getting a single line from file in each iteration
        while (fileInput.hasNextLine()) {

            String singleLine = fileInput.nextLine();

            if (!singleLine.isEmpty()) {
                parseBattingRecord(singleLine, linkList);
            }

        }

        fileInput.close();

        return linkList;

    }

    public static void main(String args[]) throws FileNotFoundException, IOException {

        //Getting input for file name
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the input file: ");
        String fileName = input.nextLine();

        LinkList list = readFile(fileName);

        list.sort();

        list.print();

        System.out.println("");
        System.out.println("BATTING AVERAGE");
        list.printBALeaders();

        System.out.println("");
        System.out.println("ON-BASE PERCENTAGE");
        list.printOBLeaders();

        System.out.println("");
        System.out.println("HITS");
        list.printHitsLeaders();

        System.out.println("");
        System.out.println("WALKS");
        list.printWalksLeaders();

        System.out.println("");
        System.out.println("STRIKEOUTS");
        list.printStrikeoutsLeaders();

        System.out.println("");
        System.out.println("HIT BY PITCH");
        list.printHitByPitchLeaders();
    }

}
