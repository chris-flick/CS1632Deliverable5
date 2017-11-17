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

	/*
	*	 the row {0 0 0} and {1 0 1} has been added to final table.
	*	Checking to see if we can find a pair of (1 1) between first param and third param
	*	Should return true
	*/
	@Test
	public void testCheckFinalArray3(){
		ArrayList<boolean []> finalTable = new ArrayList<boolean []>();
		boolean [] row1 = {false, false, false};
		boolean [] row2 = {true, false, true};
		finalTable.add(row1);
		finalTable.add(row2);

		int param1 = 0;
		int param2 = 2;
		boolean [] rowToCheck = {true, true};

		assertTrue(Pairwise.checkFinalArray(finalTable, param1, param2, rowToCheck));

	}

	/*
	*	 the row {0 0 0} and {1 0 1} has been added to final table.
	*	Checking to see if we can find a pair of (0 1) between second param and third param
	*	Should return true
	*/
	@Test
	public void testCheckFinalArray4(){
		ArrayList<boolean []> finalTable = new ArrayList<boolean []>();
		boolean [] row1 = {false, false, false};
		boolean [] row2 = {true, false, true};
		finalTable.add(row1);
		finalTable.add(row2);

		int param1 = 1;
		int param2 = 2;
		boolean [] rowToCheck = {false, true};

		assertTrue(Pairwise.checkFinalArray(finalTable, param1, param2, rowToCheck));

	}

	/*
	*	finds first row that contains pair (0, 0) for first and third param.
	*	Found row should be (0, 0, 0)
	*/
	@Test
	public void testFindCoveringRow1(){
		boolean [][] tt = Pairwise.createTruthTable(8, 3);
		int rows = 8;

		int param1 = 0;
		int param2 = 2;
		boolean[] row = {false, false};

		boolean [] foundRow = Pairwise.findCoveringRow(tt, rows, param1, param2, row);

		assertFalse(foundRow[0]);
		assertFalse(foundRow[1]);
		assertFalse(foundRow[2]);
	}

	/*
	*	finds first row that contains pair (1, 1) for first and third param.
	*	Found row should be (1, 0, 1)
	*/
	@Test
	public void testFindCoveringRow2(){
		boolean [][] tt = Pairwise.createTruthTable(8, 3);
		int rows = 8;

		int param1 = 0;
		int param2 = 2;
		boolean[] row = {true, true};

		boolean [] foundRow = Pairwise.findCoveringRow(tt, rows, param1, param2, row);

		assertTrue(foundRow[0]);
		assertFalse(foundRow[1]);
		assertTrue(foundRow[2]);
	}

	/*
	*	finds first row that contains pair (1, 1) for second and third param.
	*	Found row should be (0, 1, 1)
	*/
	@Test
	public void testFindCoveringRow3(){
		boolean [][] tt = Pairwise.createTruthTable(8, 3);
		int rows = 8;

		int param1 = 1;
		int param2 = 2;
		boolean[] row = {true, true};

		boolean [] foundRow = Pairwise.findCoveringRow(tt, rows, param1, param2, row);

		assertFalse(foundRow[0]);
		assertTrue(foundRow[1]);
		assertTrue(foundRow[2]);
	}

}