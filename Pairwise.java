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

		int [][] truthTable = createTruthTable(rows, numParams);
		printTruthTable(truthTable, rows, numParams);
	}

	/*
	*	creates exhaustive truth table
	*/
	public static int[][] createTruthTable(int rows, int n){

		int[][] tt = new int[rows][n];

		// sequence keeps track of how many 0's or 1's to insert before flipping to the other value
		int seq = 1;

		// currentSeq tracks how far down the sequence we are
		int currentSeq = 0;

		// bool keeps track of whether a 0 or 1 should be inserted into current index
		int bool = 0;
		for (int j = n - 1; j >= 0; j--){
			for (int i = 0; i < rows; i++){
				tt[i][j] = bool;

				currentSeq++;

				// if these two are equal, then need to flip the bit and start sequence over
				if (currentSeq == seq){
					currentSeq = 0;

					if (bool == 0)
						bool = 1;
					else
						bool = 0;
				}
			}

			// multiply sequence by two to replicate the behavior of a truth table
			seq = seq * 2;
			currentSeq = 0;
			bool = 0;
		}

		return tt;
	}

	/*
	*	prints truth table 
	*/
	public static void printTruthTable(int [][] tt, int rows, int n){
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < n; j++){
				System.out.print(tt[i][j] + " " );
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