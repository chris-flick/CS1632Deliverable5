import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class PairwiseTest{

	/*
	*	Testing that true is returned when a list of two arguments is passed
	*/
	@Test
	public void checkInputTest1(){
		String args[] = {"one", "two"};

		assertTrue(Pairwise.checkInput(args));
	}

	/*
	*	Testing that false is returned when a list of one argument is passed
	*/
	@Test
	public void checkInputTest2(){
		String args[] = {"one"};

		assertFalse(Pairwise.checkInput(args));
	}

	/*
	* Testing that string is returned when string length is less than 10
	*/
	@Test
	public void truncateParametersTest1(){
		String newString = Pairwise.truncateParameter("boo");

		assertEquals("boo", newString);
	}

	/*
	*	Testing that correct string is returned when string entered is 10 characters long
	*/
	@Test
	public void truncateParametersTest2(){
		String newString = Pairwise.truncateParameter("aaaaaaaaaa");

		assertEquals("aaaaaaaaaa", newString);
	}

	/*
	*	Testing that correct string is returned when string entered is 15 characters long
	*/
	@Test
	public void truncateParametersTest3(){
		String newString = Pairwise.truncateParameter("abababababababab");

		assertEquals("ababababab", newString);
	}

	/*
	*	 the row {0 0 0} has been added to final table.
	*	Checking to see if we can find a pair of (0 0) between first param and third param
	*/
	@Test
	public void testCheckFinalArray1(){
		ArrayList<boolean []> finalTable = new ArrayList<boolean []>();
		boolean [] row1 = {false, false, false};
		finalTable.add(row1);

		int param1 = 0;
		int param2 = 2;
		boolean [] rowToCheck = {false, false};

		assertTrue(Pairwise.checkFinalArray(finalTable, param1, param2, rowToCheck));

	}

	/*
	*	 the row {0 0 0} has been added to final table.
	*	Checking to see if we can find a pair of (0 1) between first param and third param
	*	Should return false
	*/
	@Test
	public void testCheckFinalArray2(){
		ArrayList<boolean []> finalTable = new ArrayList<boolean []>();
		boolean [] row1 = {false, false, false};
		finalTable.add(row1);

		int param1 = 0;
		int param2 = 2;
		boolean [] rowToCheck = {false, true};

		assertFalse(Pairwise.checkFinalArray(finalTable, param1, param2, rowToCheck));

	}

}