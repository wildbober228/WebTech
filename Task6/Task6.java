package com.wildbober.Task6;

public class Task6 {
    public static final int length = 10;
    static int[][] matrix = new int [length][length];
    static int[][] originalMatrix = new int [length][length];

    private static void showMatrix(){

        for(int i = 0; i < length; i++){
            
            for(int j = 0; j < length; j++){
               System.out.print(originalMatrix[i][j] + " ");
            }

            System.out.println(" ");
        }

    }

    private static void startFill(){

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                matrix[i][j] = j;
                originalMatrix[i][j] = j;
            }
        }
    }

    private static void roleRow(int indexRow, int count){
            int helpCount = 0;

            for(int j = 0; j < length; j++){
                if(j+count < length) {
                    originalMatrix[indexRow][j] = matrix[indexRow][j + count];
                } else {
                    for(int k = j + count; k > j;){
                        k--;
                        helpCount++;
                        int firstElement = 0;
                        if(count-helpCount > 0)
                        firstElement = matrix[indexRow][count-helpCount];
                        originalMatrix[indexRow][k] = firstElement;
                    }
                    break;
                }
            }

    }

    private static void roleMatrix(){
        for(int i = 1; i < length; i++){
            roleRow(i,i);
        }

    }

    public static void fillMatrix(){
        startFill();
        roleMatrix();
        showMatrix();
    }
}
