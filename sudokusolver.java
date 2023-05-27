import java.util.*;
public class sudokusolver{
    public static boolean isValidnum(int[][] board, int row, int coloumn,int num){
        int max[] = {2,2,2,5,5,5,8,8,8};
        int min[] = {0,0,0,3,3,3,6,6,6};
        for(int i = 0; i<9; i++){
            if(board[row][i] == num) return false;
        }
        for(int j = 0; j<9; j++){
            if(board[j][coloumn] == num) return false;
        }
        for(int i = min[row]; i<=max[row]; i++){
            for(int j = min[coloumn]; j<=max[coloumn]; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
    public static boolean Sudoku(int board[][]){
        for(int row=0; row<=8; row++){
        for(int coloumn=0; coloumn<=8; coloumn++){
            if(board[row][coloumn]==0){
                for(int val=1; val<=9; val++){
                    if(isValidnum(board,row,coloumn,val)){
                        board[row][coloumn] = val;
                        if(Sudoku(board)){
                            return true;
                        }
                        board[row][coloumn] = 0; //Backtracking
                    }
                }
                return false;
            }
        }
    }
    return true;  
    }
    public static void main(String args[]){
        int boardlength = 9;
        int[][]  board = new int[boardlength][boardlength];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i< boardlength; i++){
            for(int j = 0; j<boardlength; j++){
                board[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        System.out.print("Grid");
        System.out.println();
        for(int i = 0; i<boardlength; i++){
            for(int j = 0; j<boardlength; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("Solution");
        if(Sudoku(board)){
        for(int i = 0; i<boardlength; i++){
            for(int j = 0; j<boardlength; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        }
    }
}
// 5 3 0 0 7 0 0 0 0
// 6 0 0 1 9 5 0 0 0
// 0 9 8 0 0 0 0 6 0
// 8 0 0 0 6 0 0 0 3
// 4 0 0 8 0 3 0 0 1
// 7 0 0 0 2 0 0 0 6
// 0 6 0 0 0 0 2 8 0
// 0 0 0 4 1 9 0 0 5
// 0 0 0 0 8 0 0 7 9