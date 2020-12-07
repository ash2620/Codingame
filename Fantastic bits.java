import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Grab Snaffles and try to throw them through the opponent's goal!
 * Move towards a Snaffle and use your team id to determine where you need to throw it.
 **/
class Player {

    private static int entities=0;
    private static int x=0;
    private static int y=0;
    private static int cx=0;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int myTeamId = in.nextInt(); // if 0 you need to score on the right of the map, if 1 you need to score on the left
        int[][]Wizard=new int[2][6];
        int[][]oppWizard=new int[2][6];
        int[][]Snaffle=new int[7][2];
        int sc=0;
        boolean clear0=false;//helps in the clear function of wizard 1
        boolean clear1=false;//helps in the clear function of wizard 1
        // game loop
        while (true) {
            int myScore = in.nextInt();
            int myMagic = in.nextInt();
            int opponentScore = in.nextInt();
            int opponentMagic = in.nextInt();
                entities = in.nextInt(); // number of entities still in game
            for (int i = 0; i < entities; i++) {
                int entityId = in.nextInt(); // entity identifier
                String entityType = in.next(); // "WIZARD", "OPPONENT_WIZARD" or "SNAFFLE" (or "BLUDGER" after first league)
                    x = in.nextInt(); // position
                    y = in.nextInt(); // position
                int vx = in.nextInt(); // velocity
                int vy = in.nextInt(); // velocity
                int state = in.nextInt(); // 1 if the wizard is holding a Snaffle, 0 otherwise
                if(entityType.equals("WIZARD")){
                    Wizard[entityId][0]=x;
                    Wizard[entityId][1]=y;
                    Wizard[entityId][2]=vx;
                    Wizard[entityId][3]=vy;
                    Wizard[entityId][4]=state;
                    Wizard[entityId][5]=entityId;
                }
                else if(entityType.equals("OPPONENT_WIZARD")){
                    oppWizard[entityId-2][0]=x;
                    oppWizard[entityId-2][1]=y;
                    oppWizard[entityId-2][2]=vx;
                    oppWizard[entityId-2][3]=vy;
                    oppWizard[entityId-2][4]=state;
                    oppWizard[entityId-2][5]=entityId;
                }
                else if(entityType.equals("SNAFFLE")&&sc<entities-4){
                    Snaffle[sc][0]=x;
                    Snaffle[sc][1]=y;
                    sc++;
                }
            }
            ClosestSnaffle(Wizard[0][0],Wizard[0][1],Snaffle);
            boolean inpath=obs(Wizard,myTeamId,oppWizard)
            for (int i = 0; i < 2; i++) {
                if(Wizard[0][4]==0&&i==0&&){}
                    if(!inpath)
                    System.out.println("MOVE "+Snaffle[cx][0]+" "+Snaffle[cx][1]+" 100");
                    else
                    System.out.println("MOVE "+Wizard[0][0]+" "+(Wizard[0][1]>3250?7500:0)+" 100");
                }
                else if(Wizard[0][4]==1&&i==0){
                    if(myTeamId==0)
                        System.out.println("THROW 16000 3750 500");
                    else
                        System.out.println("THROW 0 3750 500");
                }
                else if(i==1){
                    if(myTeamId==0){
                        int ny=oWizardY(oppWizard);
                        if(Wizard[1][0]==0&&Wizard[1][1]==ny&&Wizard[1][4]==0)
                            System.out.println("MOVE 0 "+ny+" 0");
                        else if((Wizard[1][0]!=0||Wizard[1][1]!=ny)&&Wizard[1][4]==0)
                            System.out.println("MOVE 0 "+ny+" 100");
                        else if(Wizard[1][4]==1){
                            if(clear0){
                             System.out.println("THROW 3000 7400 500");
                             clear0=false;
                            }
                            else{
                                System.out.println("THROW 3000 0 500");
                                clear0=true;
                            }
                        }
                    }
                    if(myTeamId==0){
                        int ny=oWizardY(oppWizard);
                        if(Wizard[1][0]==16000&&Wizard[1][1]==ny&&Wizard[1][4]==0)
                            System.out.println("MOVE 16000 "+ny+" 0");
                        else if((Wizard[1][0]!=16000||Wizard[1][1]!=ny)&&Wizard[1][4]==0)
                            System.out.println("MOVE 16000 "+ny+" 100");
                        else if(Wizard[1][4]==1){
                            if(clear1){
                             System.out.println("THROW 13000 7400 500");
                             clear1=false;
                            }
                            else{
                                System.out.println("THROW 13000 0 500");
                                clear1=true;
                            }
                        }
                    }

                }

            }
        }
    }
    public static int oWizardY(int[][]oppWizard){
        for(int i=0;i<2;i++){
            if(oppWizard[i][4]==1){
                return oppWizard[i][1];
            }
        }
        return 3750;
    }
    public static void ClosestSnaffle(int wx,int wy,int[][]Snaffle){
        int check=Integer.MAX_VALUE();
        int ci=0;
        for(int i=0;i<entities-4;i++){
                if(Math.sqrt(Math.abs(Math.pow(wx-Snaffle[i][0],2))+Math.abs(Math.pow(wy-Snaffle[i][1],2)))<check){
                    check=Math.sqrt(Math.abs(Math.pow(wx-Snaffle[i][0],2))+Math.abs(Math.pow(wy-Snaffle[i][1],2)));
                    ci=i;
                }

        }
        cx=ci;
    }
    public static boolean obs(int[][]Wizard,int myTeamId,int[][]oppWizard){
        int centrex=myTeamId==0?16000:0;
        int index=500;
        for (int i=0;i<2 ;i++ ) {
            if(oppWizard[i][0]>Wizard[0][0]){
                index=i;
            }
            
        }
        double wslope=(Wizard[0][1]-oppWizard[index][1])/(Wizard[0][0]-oppWizard[index][0]);
        double gslope=(oppWizard[index][1]-3750)/(oppWizard[index][0]-centrex);
        if(wslope+1>=gslope&&wslope-1<=gslope){
            return true;
        }
        else{
            return false;
        }
    }
}