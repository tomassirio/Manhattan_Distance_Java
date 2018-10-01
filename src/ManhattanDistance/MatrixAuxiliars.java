package ManhattanDistance;

import java.util.Vector;

public class MatrixAuxiliars {
	
	public static void printMatrix(Vector<Vector<Pair<Integer, Boolean>>> matrix){
	    for(int i = 0; i < matrix.size() ; i++){
	        for (int j = 0; j < matrix.get(i).size() ; j++){
	        	System.out.printf("%-3s", matrix.get(i).get(j).getFirst());
	        }
	        System.out.println();
	    }

        System.out.println();

	    for(int i = 0; i < matrix.size() ; i++){
	        for (int j = 0; j <matrix.get(i).size() ; j++){
	        	System.out.print(matrix.get(i).get(j).getSecond().toString() + '\t');
	        }
	        System.out.println();
	    }
        System.out.println();
	}
	
	public static boolean checkIfZero(Vector<Vector<Pair<Integer, Boolean>>> matrix, int row, int col){
	    return matrix.get(row).get(col).getFirst() == 0;
	}
	
	public static boolean checkIfNeighbourIsPOI(Vector<Vector<Pair<Integer, Boolean>>> matrix, int row, int col){
	    return matrix.get(row).get(col).getSecond();
	}

	

}
