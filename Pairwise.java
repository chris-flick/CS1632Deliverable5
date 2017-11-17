public class Pairwise{
	
	public static void main(String args []){
		if (!checkInput(args))
			System.exit(1);

		int numParams = args.length;

		String [] params = new String [numParams];
		for (int i = 0; i < numParams; i++){
			params[i] = truncateParameter(args[i]);
		}
	}


	/*
	*	checks to make sure at least two parameters were entered
	*/
	public static boolean checkInput(String args []){
		if (args.length != 2){
			System.out.println("Need to input at least two or more parameters!");
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