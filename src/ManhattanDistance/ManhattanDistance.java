package ManhattanDistance;

import java.util.Vector;

public class ManhattanDistance {

	public static Vector<Integer> computeEnemies(int M, int N, Vector<Pair<Integer, Integer>> iP){
		Vector<Vector<Pair<Integer, Boolean>>> matrix = new Vector<Vector<Pair<Integer, Boolean>>>();

		//test
	    //Initialize my matrix with (0, false)
	    for(int i = 0; i < M; i++){
	    	Vector<Pair<Integer, Boolean>> vector = new Vector<Pair<Integer, Boolean>>();
	        for(int j = 0; j < N; j++){
	        	Pair<Integer, Boolean> pair = new Pair<Integer, Boolean>(0, false);
	        	vector.add(pair);
	        }
	        matrix.add(i, vector);
	    }
	    //Set the values of point of interest as (0, true) in the matrix
	    for(int i = 0; i < iP.size(); i++){
	    	matrix.get(iP.get(i).getFirst()).set(iP.get(i).getSecond(), new Pair<Integer, Boolean>(0,Boolean.TRUE));
	    }

	    //Increases only first neighbours
	    for(int i = 0; i < iP.size(); i++){
	        incrementNeighbours(matrix, iP.get(i).getFirst(), iP.get(i).getSecond());
	    }

	    int checkIncrements;
	    int level = 1;
	    do{
	        checkIncrements = 0;
	        for(int i = 0; i < matrix.size(); i++){
	            for(int j = 0; j < matrix.get(i).size(); j++){
	                if (matrix.get(i).get(j).getFirst() == level){
	                    matrix = incrementNeighbours(matrix, i, j);
	                    checkIncrements++;
	                }
	            }
	        }
	        level++;
	    }while(checkIncrements !=0);

	    MatrixAuxiliars.printMatrix(matrix);

	    Vector<Integer> vec = new Vector<Integer>();

	    for(int i = 0; i < matrix.size(); i++){
	        for(int j = 0; j < matrix.get(i).size(); j++){
	            vec.add(matrix.get(i).get(j).getFirst());
	        }
	    }

	    VectorAuxiliars.printVector(vec);

	    return vec;
	}
	
	public static Vector<Vector<Pair<Integer, Boolean>>> incrementNeighbours(Vector<Vector<Pair<Integer, Boolean>>> matrix, int row, int col){
	    //Checks for out of bounds and Points of interest before incrementing
	    if(row-1 >= 0){
	        if(MatrixAuxiliars.checkIfZero(matrix, row-1, col) && !MatrixAuxiliars.checkIfNeighbourIsPOI(matrix, row-1, col))
	        	matrix.get(row-1).get(col).setFirst(matrix.get(row).get(col).getFirst() + 1);
	    }
	    if(row+1 < matrix.size()){
	        if(MatrixAuxiliars.checkIfZero(matrix, row+1, col) && !MatrixAuxiliars.checkIfNeighbourIsPOI(matrix, row+1, col))
	        	matrix.get(row+1).get(col).setFirst(matrix.get(row).get(col).getFirst() + 1);
	    }
	    if(col-1 >= 0){
	        if(MatrixAuxiliars.checkIfZero(matrix, row, col-1) && !MatrixAuxiliars.checkIfNeighbourIsPOI(matrix, row, col-1))
	        	matrix.get(row).get(col-1).setFirst(matrix.get(row).get(col).getFirst() + 1);
	    }
	    if(col+1 < matrix.get(row).size()){
	        if(MatrixAuxiliars.checkIfZero(matrix, row, col+1) && !MatrixAuxiliars.checkIfNeighbourIsPOI(matrix, row, col+1))
	        	matrix.get(row).get(col+1).setFirst(matrix.get(row).get(col).getFirst() + 1);
	    }
	    return matrix;
	}
	
	
}
