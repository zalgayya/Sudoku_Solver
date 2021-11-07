package Main;

public class SudokuSolver {

    public static final int SIZE = 9;

    private static boolean solveBored(int[][] sudokuBored){
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (sudokuBored[r][c] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (checkPlacement(sudokuBored, i, c, r)) {
                            sudokuBored[r][c] = i;
                            if(solveBored(sudokuBored)){
                                return true;
                            }
                            else {
                                sudokuBored[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean ifExistsRow(int[][] sudokuBored, int num, int row){
        for(int i = 0; i < SIZE; i++){
            if(sudokuBored[row][i] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean ifExistsColumn(int[][] sudokuBored, int num, int column){
        for(int i = 0; i < SIZE; i++){
            if(sudokuBored[i][column] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean ifExistsInBox(int[][] sudokuBored, int num, int column, int row){
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;

        for (int i = boxRow; i < boxRow + 3; i++){
            for (int j = boxColumn; j < boxColumn + 3; j++){
                if(sudokuBored[i][j] == num){
                    return  true;
                }
            }
        }
        return  false;
    }

    private static boolean checkPlacement(int[][] sudokuBored, int num, int column, int row){
        return !ifExistsRow(sudokuBored,num,row) &&
                !ifExistsColumn(sudokuBored,num,column) &&
                !ifExistsInBox(sudokuBored,num,column,row);
    }

    public static void main(String[] args) {
        int[][] sudokuBored = {{1, 0, 3, 0, 2, 0, 6, 7, 0},
                {5, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 1, 7, 0, 4, 5, 0},
                {4, 0, 0, 0, 0, 2, 1, 0, 7},
                {2, 0, 1, 0, 0, 6, 0, 8, 0},
                {8, 0, 0, 4, 1, 7, 3, 0, 2},
                {7, 0, 4, 0, 8, 0, 0, 3, 0},
                {9, 0, 0, 7, 0, 3, 8, 0, 0},
                {0, 0, 8, 6, 9, 1, 0, 0, 5}  };

        System.out.println("BEFORE SOLVED");
        for(int i = 0; i < SIZE; i++){
            if(i % 3 == 0){
                System.out.println("____________");
            }
            for(int j = 0; j < SIZE; j++){
                if(j % 3 == 0 && j != 0){
                    System.out.print("|");
                }
                System.out.print(sudokuBored[i][j]);
            }
            System.out.println();
        }

        if(solveBored(sudokuBored)){
            System.out.println("SOLVED");
        }
        else{
            System.out.println("INVALID BORED");
        }

        for(int i = 0; i < SIZE; i++){
            if(i % 3 == 0){
                System.out.println("____________");
            }
            for(int j = 0; j < SIZE; j++){
                if(j % 3 == 0 && j != 0){
                    System.out.print("|");
                }
                System.out.print(sudokuBored[i][j]);
            }
            System.out.println();
        }
    }



}
