import java.util.*;

public class Pairwise{
	
	public static void main(String args []){
		if (!checkInput(args))
			System.exit(1);

		int numParams = args.length;
		int rows = (int) Math.pow(2, numParams);

		String [] params = new String [numParams];
		for (int i = 0; i < numParams; i++){
			params[i] = truncateParameter(args[i]);
		}

		boolean [][] truthTable = createTruthTable(rows, numParams);
		//printTruthTable(truthTable, rows, numParams);

		ArrayList<boolean []> finalTable = new ArrayList<boolean []>();
		boolean [][] miniTruthTable = createTruthTable(4, 2);

		for (int i = 0; i < numParams; i++){
			for (int j = i + 1; j < numParams; j++){
				for (int z = 0; z < 4; z++){
					boolean result = checkFinalArray(finalTable, i, j, miniTruthTable[z]);

					// result returns false then we need to find the first row in that covers this pair
					if (!result){
						boolean [] newRow = findCoveringRow(truthTable, rows, i, j, miniTruthTable[z]);
						finalTable.add(newRow);
					}
				}
			}
		}

		printFinalTable(params, finalTable);

	}

	public static void printFinalTable(String [] params, ArrayList<boolean []> finalTable){
		for (int i = 0; i < params.length; i++)
			System.out.print(params[i] + "\t");

		System.out.println();

		for (int i = 0; i < finalTable.size(); i++){
			boolean [] row = finalTable.get(i);

			for (int j = 0; j < row.length; j++){
				if (row[j])
					System.out.print("1\t");
				else
					System.out.print("0\t");
			}

			System.out.println();
		}
	}

	/*
	*	iterates through each row in the exhaustive truth table and searchs for a row that covers the current pair
	*/
	public static boolean[] findCoveringRow(boolean[][] truthTable, int rows, int param1, int param2, boolean[] row){
		for (int i = 0; i < rows; i++){
			boolean[] currentRow = truthTable[i];

			if (currentRow[param1] == row[0] && currentRow[param2] == row[1]){
				return currentRow;
			}
		}

		return new boolean[0];
	}

	/*
	*	row contains values from mini truth table. It can be one of these values:
	*			i j
	*
	*			0 0
	*			0 1
	*			1 0
	*			1 1
	*	This method searches each entry in the finalTable and grabs the row of boolean values.
	*	It then compares the boolean value at i with the value at row[0] and then compares the boolean value
	*	at j with the value at row[1]. If both are matched, then the finalTable contains a row that covers this combination,
	*	so we can move on
	*/
	public static boolean checkFinalArray(ArrayList<boolean []> finalTable, int param1, int param2, boolean[] row){
		for (int i = 0; i < finalTable.size(); i++){
			boolean[] currentRow = finalTable.get(i);

			if (currentRow[param1] == row[0] && currentRow[param2] == row[1])
				return true;
		}

		return false;
	}


	/*
	*	creates exhaustive truth table
	*/
	public static boolean[][] createTruthTable(int rows, int n){

		boolean[][] tt = new boolean[rows][n];

		// sequence keeps track of how many 0's or 1's to insert before flipping to the other value
		int seq = 1;

		// currentSeq tracks how far down the sequence we are
		int currentSeq = 0;

		// bool keeps track of whether a 0 or 1 should be inserted into current index
		boolean bool = false;
		for (int j = n - 1; j >= 0; j--){
			for (int i = 0; i < rows; i++){
				tt[i][j] = bool;

				currentSeq++;

				// if these two are equal, then need to flip the bit and start sequence over
				if (currentSeq == seq){
					currentSeq = 0;

					bool = !bool;
				}
			}

			// multiply sequence by two to replicate the behavior of a truth table
			seq = seq * 2;
			currentSeq = 0;
			bool = false;
		}

		return tt;
	}

	/*
	*	prints truth table 
	*/
	public static void printTruthTable(boolean [][] tt, int rows, int n){
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < n; j++){
				if (tt[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}


	/*
	*	checks to make sure at least two parameters were entered
	*/
	public static boolean checkInput(String args []){
		if (args.length < 2){
			System.out.println("Please enter at least two parameters!");
			return false;
		}

		return true;
	}

	/*
	*	truncates the string if it is greater than 10 characters long
	*/
	public static String truncateParameter(String param){
		if (param.length() <= 10)
			return param;

		return param.substring(0, 10);
	}
}