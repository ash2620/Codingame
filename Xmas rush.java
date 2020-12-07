import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Help the Christmas elves fetch presents in a magical labyrinth!
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[][]board=new int[7][7];//stores position of quest item and players
        int[]tile_direction= new int[4];//possible movement directions on tile
        // game loop
        while (true) {
            int turnType = in.nextInt();
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    String tile = in.next();
                }
            }
            for (int i = 0; i < 2; i++) {
                int numPlayerCards = in.nextInt(); // the total number of quests for a player (hidden and revealed)
                int playerX = in.nextInt();
                int playerY = in.nextInt();
                String playerTile = in.next();
            }
            int numItems = in.nextInt(); // the total number of items available on board and on player tiles
            for (int i = 0; i < numItems; i++) {
                String itemName = in.next();
                int itemX = in.nextInt();
                int itemY = in.nextInt();
                int itemPlayerId = in.nextInt();
            }
            int numQuests = in.nextInt(); // the total number of revealed quests for both players
            for (int i = 0; i < numQuests; i++) {
                String questItemName = in.next();
                int questPlayerId = in.nextInt();
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            
        }
    }
}