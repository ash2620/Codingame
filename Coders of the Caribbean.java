import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    static String entityType="";
    static int entityId=0;
    static int x=0;
    static int y=0;
    static int arg1=0,arg2=0,arg3=0,arg4=0;
    static int myShipCount=0;
    static int number=0;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[]myShip=new int[2];
        
        
          int xy=0;
          
        int count=0;
        
        int[]entId=new int[3];
        
        int[][]barrels=new int[6][2];
        
        int barrel_count=0;
        
        int diff=Integer.MAX_VALUE;
        int fx=0;
        int fy=0;
        while (true) {
            
            myShipCount = in.nextInt(); // the number of remaining ships
            
            int[][]myShips=new int[myShipCount][3];//my ships positions and rum quantity
            
            boolean[]opp_ships=new boolean[myShipCount];//whether opponent ship is within range
            
            int[][]oppShips=new int[myShipCount][2];//opponents ships positions
            
            int entityCount = in.nextInt(); // the number of entities (e.g. ships, mines or cannonballs)
            
            
            for (int i = 0; i < entityCount; i++) {
                entityId = in.nextInt();
                if(i<myShipCount){
                 entId[i]=entityId;    
                }
                entityType = in.next();
                
                x = in.nextInt();
                
                y = in.nextInt();
                
                arg1 = in.nextInt();
                
                arg2 = in.nextInt();
                
                arg3 = in.nextInt();
                
                arg4 = in.nextInt();//amount of rum if entity is barrel
                
                
                System.err.println(entityType+" "+entityId+" "+x+" "+y+" "+arg1+" "+arg2+" "+arg3+" "+arg4);
                
                
                if(entityType.equals("BARREL")&&barrel_count<3){
                    barrels[barrel_count][0]=x;
                    barrels[barrel_count][1]=y;
                    barrel_count++;
                }
                
                if(entityType.equals("SHIP")&&arg4==1){
                    myShips[i][0]=x;
                    myShips[i][1]=y;
                    myShips[i][2]=arg3;
                    
                    }
                
                else if(entityType.equals("SHIP")&&arg4==0){
                for(int v=0;v<myShipCount;v++){
                    if(myShips[v][0]+9>=x && myShips[v][0]-9<=x && myShips[v][1]+9>=y && myShips[v][1]-9<=y){
                        opp_ships[v]=true;
                        oppShips[v][0]=x;
                        oppShips[v][1]=y;
                        }
                    
                    }
                }
                if(entityType.equals("BARREL")){
                    if(diff<Math.abs(x-y)){
                        diff=Math.abs(x-y); 
                        fx=x;
                        fy=y;
                    }
                }
                    
                
            }
            
            if(diff<Math.abs(barrels[0][1]-barrels[0][0])){
              barrels[0][0]=fx;
              barrels[0][1]=fy;
            }
            if(diff<Math.abs(barrels[1][1]-barrels[1][0])){
              barrels[1][0]=fx;
              barrels[1][1]=fy;    
            }
            if(diff<Math.abs(barrels[2][1]-barrels[2][0])){
              barrels[2][0]=fx;
              barrels[2][1]=fy;    
            }
            for (int i = 0; i < myShipCount; i++) {
               
                 
                System.err.println("myShip x "+myShip[0]+" myShip y "+myShip[1]);
                
                if(myShips[i][2]<48){
                    System.out.println("MOVE "+barrels[i][0]+" "+barrels[i][1]);   
                }
                else{
                if(opp_ships[i] && xy<=3){
                        System.out.println("FIRE "+oppShips[i][0]+" "+oppShips[i][1]);
                        xy++;
                        
                    }
                
                else if(barrels[0][0]!=0){
                    System.out.println("MOVE "+barrels[i][0]+" "+barrels[i][1]);
                    barrel_count=i;
                    xy=0;
                    }
                else if(barrels[0][0]==0){
                    System.out.println("MOVE "+oppShips[i][0]+" "+oppShips[i][1]);
                }
                if(xy>=3){
                    System.out.println("MOVE "+fx+" "+fy); 
                    xy=0;
                }
                }   
                    
            }
        }
    }
}