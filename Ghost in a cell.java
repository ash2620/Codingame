import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int count=0;
        int c=0;
        int cmaxid=0;
        int max=0;
        boolean played=false;
        int pmax=0;
        int factoryCount = in.nextInt(); // the number of factories
        int linkCount = in.nextInt(); // the number of links between factories
        for (int i = 0; i < linkCount; i++) {
            int factory1 = in.nextInt();
            int factory2 = in.nextInt();
            int distance = in.nextInt();
        }
        int[][]factory=new int[factoryCount][6];
        // game loop
        while (true) {
            int entityCount = in.nextInt(); // the number of entities (e.g. factories and troops)
            for (int i = 0; i < entityCount; i++) {
                int entityId = in.nextInt();
                String entityType = in.next();
                int arg1 = in.nextInt();
                int arg2 = in.nextInt();
                int arg3 = in.nextInt();
                int arg4 = in.nextInt();
                int arg5 = in.nextInt();
                if(entityType.equals("FACTORY")&&count<factoryCount){
                    factory[count][0]=entityId;
                    factory[count][1]=arg1;
                    factory[count][2]=arg2;
                    factory[count][3]=arg3;
                    factory[count][4]=arg4;
                    factory[count][5]=arg5;
                    count++;
                }
                if(count==factoryCount-1){
                    count=0;    
                }
            }
            for(int i=0;i<factoryCount;i++){
                if(factory[i][1]==1&&factory[i][2]>max){
                    cmaxid=factory[i][0];
                    max=factory[i][2];
                    pmax=factory[i][3];
                }    
            }
            for(int i=0;i<factoryCount;i++){
                if(factory[i][1]!=1&&factory[i][2]<max){
                    System.out.println("MOVE "+cmaxid+" "+factory[i][0]+" "+(factory[i][2]+1));
                    played=true;
                    break;
                }
                
                    
            }
            if(!played){
                System.out.println("WAIT");    
            }
            played=false;
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            max=0;

            // Any valid action, such as "WAIT" or "MOVE source destination cyborgs"
        }
    }
}