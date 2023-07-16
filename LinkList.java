
/**
 *
 * This class implements the Link List data structure
 */
public class LinkList {

    private Node head;
    private int size;

    public LinkList() {
        head = null;
        size = 0;
    }

    //Wrapper function for printing
    public void print() {
        print(head);
    }

    //Recursive helper function for printing
    public void print(Node currElement) {

        if (currElement == null) {
            return;
        } else {
            currElement.getPlayer().print();
            print(currElement.getNext());
        }

    }

    //This method sorts the list alphabetically by name
    void sort() {

        //Using selection sort algorithm
        Node temp = this.head;

        while (temp != null) {
            Node min = temp;

            Node temp2 = temp;

            while (temp2 != null) {
                if (temp2.getPlayer().getName().compareTo(min.getPlayer().getName()) < 0) {
                    min = temp2;
                }
                temp2 = temp2.getNext();
            }

            //Swapping minimum with current element
            Player temp3 = min.getPlayer();
            min.setPlayer(temp.getPlayer());
            temp.setPlayer(temp3);

            temp = temp.getNext();
        }

    }

    //This method adds a new node to the list
    void add(Node newData) {

        if (head == null) {
            head = newData;
        } else {

            Node temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newData);
        }

        this.size++;
    }

    //This method finds a node based on name variable.
    //It returns null if no such node exists
    Node find(String name) {
        Node temp = head;

        Node found = null;

        while (temp != null && found == null) {

            if (temp.getPlayer().getName().equals(name)) {
                found = temp;
            }

            temp = temp.getNext();
        }

        return temp;

    }

    //This method finds and prints the leaders of Batting Average
    void printBALeaders() {

        Node temp = this.head;

        int printedPlayers = 0;

        double max1 = -1;
        double max2 = -1;
        double max3 = -1;

        if (temp != null) {
            max1 = temp.getPlayer().battingAverage();

            temp = temp.getNext();
        } else {
            return;
        }

        while (temp != null) {

            if (temp.getPlayer().battingAverage() > max1) {

                max2 = max1;
                max1 = temp.getPlayer().battingAverage();
            } else if (temp.getPlayer().battingAverage() > max2 && temp.getPlayer().battingAverage() != max1) {

                max2 = temp.getPlayer().battingAverage();
            }

            temp = temp.getNext();
        }

        temp = this.head;

        while (temp != null) {

            if (temp.getPlayer().battingAverage() > max3 && temp.getPlayer().battingAverage() < max2) {
                max3 = temp.getPlayer().battingAverage();
            }

            temp = temp.getNext();
        }

        System.out.print(String.format("%.3f", (max1)));
        temp = this.head;

        boolean firstTime = true;
        while (temp != null) {

            if (temp.getPlayer().battingAverage() == max1) {
                if (!firstTime) {
                    System.out.print(", ");
                } else {
                    System.out.print("\t");
                }
                firstTime = false;
                System.out.print(temp.getPlayer().getName());
                printedPlayers++;
            }
            temp = temp.getNext();
        }

        System.out.println();

        if (printedPlayers < 3) {
            temp = this.head;
            firstTime = true;
            System.out.print(String.format("%.3f", (max2)));

            while (temp != null) {

                if (temp.getPlayer().battingAverage() == max2) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

        if (printedPlayers < 3) {

            temp = this.head;

            firstTime = true;

            System.out.print(String.format("%.3f", (max3)));
            while (temp != null) {

                if (temp.getPlayer().battingAverage() == max3) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

    }

    //This method finds and prints top 3 on base percentage leader
    void printOBLeaders() {
        Node temp = this.head;

        int printedPlayers = 0;

        double max1 = -1;
        double max2 = -1;
        double max3 = -1;

        if (temp != null) {
            max1 = temp.getPlayer().onBasePercentage();

            temp = temp.getNext();
        } else {
            return;
        }

        while (temp != null) {

            if (temp.getPlayer().onBasePercentage() > max1) {

                max2 = max1;
                max1 = temp.getPlayer().onBasePercentage();
            } else if (temp.getPlayer().onBasePercentage() > max2 && temp.getPlayer().onBasePercentage() != max1) {

                max2 = temp.getPlayer().onBasePercentage();
            }

            temp = temp.getNext();
        }

        temp = this.head;

        while (temp != null) {

            if (temp.getPlayer().onBasePercentage() > max3 && temp.getPlayer().onBasePercentage() < max2) {
                max3 = temp.getPlayer().onBasePercentage();
            }

            temp = temp.getNext();
        }

        System.out.print(String.format("%.3f", (max1)));
        temp = this.head;

        boolean firstTime = true;
        while (temp != null) {

            if (temp.getPlayer().onBasePercentage() == max1) {
                if (!firstTime) {
                    System.out.print(", ");
                } else {
                    System.out.print("\t");
                }
                firstTime = false;
                System.out.print(temp.getPlayer().getName());
                printedPlayers++;
            }
            temp = temp.getNext();
        }

        System.out.println();

        if (printedPlayers < 3) {
            temp = this.head;
            firstTime = true;
            System.out.print(String.format("%.3f", (max2)));

            while (temp != null) {

                if (temp.getPlayer().onBasePercentage() == max2) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

        if (printedPlayers < 3) {

            temp = this.head;

            firstTime = true;

            System.out.print(String.format("%.3f", (max3)));
            while (temp != null) {

                if (temp.getPlayer().onBasePercentage() == max3) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    //This method finds and prints top 3 hits leader
    void printHitsLeaders() {
        Node temp = this.head;

        int printedPlayers = 0;

        int max1 = -1;
        int max2 = -1;
        int max3 = -1;

        if (temp != null) {
            max1 = temp.getPlayer().getHits();

            temp = temp.getNext();
        } else {
            return;
        }

        while (temp != null) {

            if (temp.getPlayer().getHits() > max1) {

                max2 = max1;
                max1 = temp.getPlayer().getHits();
            } else if (temp.getPlayer().getHits() > max2 && temp.getPlayer().getHits() != max1) {

                max2 = temp.getPlayer().getHits();
            }

            temp = temp.getNext();
        }

        temp = this.head;

        while (temp != null) {

            if (temp.getPlayer().getHits() > max3 && temp.getPlayer().getHits() < max2) {
                max3 = temp.getPlayer().getHits();
            }

            temp = temp.getNext();
        }

        System.out.print(max1);
        temp = this.head;

        boolean firstTime = true;
        while (temp != null) {

            if (temp.getPlayer().getHits() == max1) {
                if (!firstTime) {
                    System.out.print(", ");
                } else {
                    System.out.print("\t");
                }
                firstTime = false;
                System.out.print(temp.getPlayer().getName());
                printedPlayers++;
            }
            temp = temp.getNext();
        }

        System.out.println();

        if (printedPlayers < 3) {
            temp = this.head;
            firstTime = true;
            System.out.print(max2);

            while (temp != null) {

                if (temp.getPlayer().getHits() == max2) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

        if (printedPlayers < 3) {

            temp = this.head;

            firstTime = true;

            System.out.print(max3);
            while (temp != null) {

                if (temp.getPlayer().getHits() == max3) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    //This method finds and prints top 3 walks leader
    void printWalksLeaders() {
        Node temp = this.head;

        int printedPlayers = 0;

        int max1 = -1;
        int max2 = -1;
        int max3 = -1;

        if (temp != null) {
            max1 = temp.getPlayer().getWalks();

            temp = temp.getNext();
        } else {
            return;
        }

        while (temp != null) {

            if (temp.getPlayer().getWalks() > max1) {

                max2 = max1;
                max1 = temp.getPlayer().getWalks();
            } else if (temp.getPlayer().getWalks() > max2 && temp.getPlayer().getWalks() != max1) {

                max2 = temp.getPlayer().getWalks();
            }

            temp = temp.getNext();
        }

        temp = this.head;

        while (temp != null) {

            if (temp.getPlayer().getWalks() > max3 && temp.getPlayer().getWalks() < max2) {
                max3 = temp.getPlayer().getWalks();
            }

            temp = temp.getNext();
        }

        System.out.print(max1);
        temp = this.head;

        boolean firstTime = true;
        while (temp != null) {

            if (temp.getPlayer().getWalks() == max1) {
                if (!firstTime) {
                    System.out.print(", ");
                } else {
                    System.out.print("\t");
                }
                firstTime = false;
                System.out.print(temp.getPlayer().getName());
                printedPlayers++;
            }
            temp = temp.getNext();
        }

        System.out.println();

        if (printedPlayers < 3) {
            temp = this.head;
            firstTime = true;
            System.out.print(max2);

            while (temp != null) {

                if (temp.getPlayer().getWalks() == max2) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

        if (printedPlayers < 3) {

            temp = this.head;

            firstTime = true;

            System.out.print(max3);
            while (temp != null) {

                if (temp.getPlayer().getWalks() == max3) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    //This method finds and prints strikeouts leader
    void printStrikeoutsLeaders() {
        Node temp = this.head;

        int printedPlayers = 0;

        int min1 = -1;
        int min2 = -1;
        int min3 = -1;

        if (temp != null) {
            min1 = temp.getPlayer().getStrikeouts();

            temp = temp.getNext();
        } else {
            return;
        }

        while (temp != null) {

            if (temp.getPlayer().getStrikeouts() < min1) {

                min2 = min1;
                min1 = temp.getPlayer().getStrikeouts();
            } else if (temp.getPlayer().getStrikeouts() < min2 && temp.getPlayer().getStrikeouts() != min1) {

                min2 = temp.getPlayer().getStrikeouts();
            }

            temp = temp.getNext();
        }

        temp = this.head;

        while (temp != null) {

            if (temp.getPlayer().getStrikeouts() < min3 && temp.getPlayer().getStrikeouts() > min2) {
                min3 = temp.getPlayer().getStrikeouts();
            }

            temp = temp.getNext();
        }

        System.out.print(min1);
        temp = this.head;

        boolean firstTime = true;
        while (temp != null) {

            if (temp.getPlayer().getStrikeouts() == min1) {
                if (!firstTime) {
                    System.out.print(", ");
                } else {
                    System.out.print("\t");
                }
                firstTime = false;
                System.out.print(temp.getPlayer().getName());
                printedPlayers++;
            }
            temp = temp.getNext();
        }

        System.out.println();

        if (printedPlayers < 3) {
            temp = this.head;
            firstTime = true;
            System.out.print(min2);

            while (temp != null) {

                if (temp.getPlayer().getStrikeouts() == min2) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

        if (printedPlayers < 3) {

            temp = this.head;

            firstTime = true;

            System.out.print(min3);
            while (temp != null) {

                if (temp.getPlayer().getStrikeouts() == min3) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    //This method finds and prints top 3 leader of hitsByPitch
    void printHitByPitchLeaders() {
        Node temp = this.head;

        int printedPlayers = 0;

        int max1 = -1;
        int max2 = -1;
        int max3 = -1;

        if (temp != null) {
            max1 = temp.getPlayer().getHitByPitch();

            temp = temp.getNext();
        } else {
            return;
        }

        while (temp != null) {

            if (temp.getPlayer().getHitByPitch() > max1) {

                max2 = max1;
                max1 = temp.getPlayer().getHitByPitch();
            } else if (temp.getPlayer().getHitByPitch() > max2 && temp.getPlayer().getHitByPitch() != max1) {

                max2 = temp.getPlayer().getHitByPitch();
            }

            temp = temp.getNext();
        }

        temp = this.head;

        while (temp != null) {

            if (temp.getPlayer().getHitByPitch() > max3 && temp.getPlayer().getHitByPitch() < max2) {
                max3 = temp.getPlayer().getHitByPitch();
            }

            temp = temp.getNext();
        }
        System.out.print(max1);
        temp = this.head;

        boolean firstTime = true;
        while (temp != null) {

            if (temp.getPlayer().getHitByPitch() == max1) {
                if (!firstTime) {
                    System.out.print(", ");
                } else {
                    System.out.print("\t");
                }
                firstTime = false;
                System.out.print(temp.getPlayer().getName());
                printedPlayers++;
            }
            temp = temp.getNext();
        }

        System.out.println();

        if (printedPlayers < 3) {
            temp = this.head;
            firstTime = true;
            System.out.print(max2);

            while (temp != null) {

                if (temp.getPlayer().getHitByPitch() == max2) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

        if (printedPlayers < 3) {

            temp = this.head;

            firstTime = true;

            System.out.print(max3);
            while (temp != null) {

                if (temp.getPlayer().getHitByPitch() == max3) {
                    if (!firstTime) {
                        System.out.print(", ");
                    } else {
                        System.out.print("\t");
                    }
                    firstTime = false;
                    System.out.print(temp.getPlayer().getName());
                    printedPlayers++;
                }
                temp = temp.getNext();
            }
            System.out.println();
        }

    }

}
