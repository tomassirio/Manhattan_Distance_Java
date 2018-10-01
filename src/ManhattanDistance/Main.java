package ManhattanDistance;

import java.util.Vector;
import java.lang.Math;

public class Main {
	
	private static final int MAX_X = 60;
	private static final int MAX_Y = 50;

	public static void main(String[] args) {
		Vector<Pair<Integer, Integer>> poiVector = new Vector<Pair<Integer, Integer>>();

		    for(int i = 0; i < 10; i++){
		    	Integer x = (int) (Math.random() * MAX_X);
		        Integer y = (int) (Math.random() * MAX_Y);
		        Pair<Integer , Integer> pair = new Pair<Integer , Integer>(x,y);
		        poiVector.add(pair);
		    }
		    ManhattanDistance.computeEnemies(MAX_X, MAX_Y, poiVector);
	}
}
