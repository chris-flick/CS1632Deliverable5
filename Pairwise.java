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

	public static boolean checkInput(String args []){
		if (args.length != 2){
			System.out.println("Need to input at least two or more paramters!");
			return false;
		}

		return true;
	}

	public static String truncateParameter(String param){
		if (param.length() <= 10)
			return param;

		return param.substring(0, 9);
	}
}