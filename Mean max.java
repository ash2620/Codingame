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
        int[][]reaper=new int[3][9];
        int[][]doof=new int[3][10];
        int[][]destroyer=new int[3][10];
        int[][]wreck=new int[10][5];
        int[][]tanker=new int[10][2];   
        int a=0;
        int b=0;
        int thrust=300;
        boolean dmove=false;
        boolean detank=false;
        // game loop
        while (true) {
            int myScore = in.nextInt();
            int enemyScore1 = in.nextInt();
            int enemyScore2 = in.nextInt();
            int myRage = in.nextInt();
            int enemyRage1 = in.nextInt();
            int enemyRage2 = in.nextInt();
            int unitCount = in.nextInt();
            for (int i = 0; i < unitCount; i++) {
                int unitId = in.nextInt();
                int unitType = in.nextInt();
                int player = in.nextInt();
                float mass = in.nextFloat();
                int radius = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                int vx = in.nextInt();
                int vy = in.nextInt();
                int extra = in.nextInt();
                int extra2 = in.nextInt();
                if(unitType==0){
                    reaper[player][0]=unitId;
                    reaper[player][1]=player;
                    reaper[player][2]=radius;
                    reaper[player][3]=x;
                    reaper[player][4]=y;
                    reaper[player][5]=vx;
                    reaper[player][6]=vy;
                    reaper[player][7]=extra;
                    reaper[player][8]=extra2;
                }
                if(unitType==1){
                    destroyer[player][0]=unitId;
                    destroyer[player][1]=player;
                    destroyer[player][2]=radius;
                    destroyer[player][3]=x;
                    destroyer[player][4]=y;
                    destroyer[player][5]=vx;
                    destroyer[player][6]=vy;
                    destroyer[player][7]=extra;
                    destroyer[player][8]=extra2;
                }
                if(unitType==2){
                    doof[player][0]=unitId;
                    doof[player][1]=player;
                    doof[player][2]=radius;
                    doof[player][3]=x;
                    doof[player][4]=y;
                    doof[player][5]=vx;
                    doof[player][6]=vy;
                    doof[player][7]=extra;
                    doof[player][8]=extra2;
                }
                else if(unitType==3&&b<9){
                    tanker[b][0]=x;
                    tanker[b][1]=y;
                }
                else if(unitType==4&&a<9){
                   wreck[a][0]=unitId;
                   wreck[a][1]=radius;
                   wreck[a][2]=x;
                   wreck[a][3]=y;
                   wreck[a][4]=extra;
                }
                if(a>=9){
                 a=0;   
                }
                if(b>=9){
                    b=0;
                }
            }
            thrust=thr(wreck,reaper);
            if(reaper[0][3]==wreck[0][2]&&reaper[0][4]==wreck[0][3]){
                if(wreck[0][4]!=0){
                    System.out.println("WAIT");
                    for (int i=0;i<10;i++) {
                        if(tanker[i][0]<=6000&&tanker[i][0]>=-6000&&tanker[i][1]<=6000&&tanker[i][1]>=-6000){
                            System.out.println(tanker[i][0]+" "+tanker[i][1]+" 200");
                            detank=true;
                            break;
                        }
                    }
                    if(!detank){
                        System.out.println("WAIT");
                    }
                    System.out.println(dmove?"6000 0 300":"-6000 0 300");

                }
                else{
                    System.out.println(wreck[1][2]+" "+wreck[1][3]+" 200");
                    for (int i=0;i<10;i++) {
                        if(tanker[i][0]<=6000&&tanker[i][0]>=-6000&&tanker[i][1]<=6000&&tanker[i][1]>=-6000){
                            System.out.println(tanker[i][0]+" "+tanker[i][1]+" 200");
                            detank=true;
                            break;
                        }
                    }
                    if(!detank){
                        System.out.println("WAIT");
                    }
                    System.out.println(dmove?"6000 0 300":"-6000 0 300");
                }
            }
            else if(reaper[0][3]!=wreck[0][2]||reaper[0][4]!=wreck[0][3]){
                System.out.println(wreck[0][2]+" "+wreck[0][3]+" 200");
                for (int i=0;i<10;i++) {
                        if(tanker[i][0]<=6000&&tanker[i][0]>=-6000&&tanker[i][1]<=6000&&tanker[i][1]>=-6000){
                            System.out.println(tanker[i][0]+" "+tanker[i][1]+" 200");
                            detank=true;
                            break;
                        }
                    }
                    if(!detank){
                        System.out.println("WAIT");
                    }
                System.out.println(dmove?"6000 0 300":"-6000 0 300");
                
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if(doof[0][3]>5500){
                dmove=true;
            }
            else if(doof[0][3]<-5500){
                dmove=false;
            }
            
        }
    }
    public static int thr(int[][]wreck,int[][]reaper){
        int dist=(int)Math.sqrt(Math.pow(wreck[0][2]-reaper[0][3],2)+Math.pow(wreck[0][3]-reaper[0][4],2));
        if(dist>=1500)
            return 300;
        else if(dist>=400)
        return 250;
        else if(dist>=200){
            return 100;    
        }
        else
        return 50;
    }
   
}