import java.util.*;
public class Main{

		static Scanner sc = new Scanner(System.in);
		static int[][] board = new int[9][9];
           
		

		public static void main(String[] args) {
			initialise();
			solve();
			System.out.println("\n");
			for (int i = 0;i < 9 ;i++ ) {
				for (int j = 0; j < 9 ;j++ ) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}		
			
		}

		public static boolean solve(){
			int row = -1;
			int col = -1;
			boolean flag = true;
			for (int i = 0;i < 9 ;i++ ) {
				for (int j = 0; j < 9 ;j++ ) {
					if (board[i][j] == 0) {
						row = i;
						col = j;
						flag = false;
						break;
					}
				}
				if (!flag) {
					break;
				}
			}

			if (flag) {
				return true;
			}

			for (int i = 1;i <= 9 ;i++ ) {
				//if (checkRow(i,empty[0]) && checkColumn(i,empty[1]) && checkGrid(i, (empty[0] - (empty[0]%3)), (empty[1] - (empty[1]%3)))) {
				if(check(i,row,col)){
					board[row][col] = i;
					if (solve()) {
						return true;
					}
					else{
						board[row][col] = 0;
					}
				}
			}
			return false;

		}

		public static void initialise(){
			String [] cell = new String[9];
			System.out.println("Enter grid row by row(Empty cell is 0)");
			for (int i = 0;i<9 ;i++ ) {
				String row = sc.nextLine();
				row = row.trim();
				cell = row.split(" ",9);
				for (int j = 0; j<9 ; j++ ) {
					board[i][j] = Integer.parseInt(cell[j]);
				}
			}
			/*for (int i = 0;i<9 ;i++ ) {
				for (int j =0;j<9 ;j++ ) {
					System.err.print(board[i][j]+" ");
				}
				System.err.println();
			}
			*/
		}

		public static boolean check(int a, int b, int c){

	        for (int d = 0; d <9; d++) { // row check
	            
	            if (board[b][d] == a) { 
	                return false; 
	            } 
	        } 
	          
	          for (int r = 0; r < 9; r++) { // column check
	  
	            if (board[r][c] == a) { 
	                return false; 
	            
	            } 

	        } 
	  		
	  		int s = 3; // grid check
	        int rs = b - b % s; 
	        int cs = c - c % s; 
	  
	        for (int r = rs;   r < rs + s; r++) { 
	            for (int d = cs;  d < cs + s; d++) { 
	                if (board[r][d] == a) { 
	                    return false; 
	                } 
	            } 
	        } 
	  
	        return true; 
	    } 
  

/*		public static boolean checkRow(int a, int b){
			for (int i =0; i < 9  ; i++ ) {
				if (board[b][i] == a) {
					return false;
				}
			}
			return true;
		}

		public static boolean checkColumn(int a, int b){
			for (int i = 0 ; i < 9 ;i++ ) {
				if (board[i][b] == a) {
					return false;
				}
			}
			return true;

		}

		public static boolean checkGrid(int a, int b, int c){
			for (int i = b;i < b+3 ; i++ ) {
				for (int j = c;j < c+3 ;j++ ) {
					if (board[i][j] == a) {
						return false;
					}
				}
			}
			return true;

		}
		*/
	}