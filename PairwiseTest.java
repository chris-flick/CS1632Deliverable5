import static org.junit.Assert.*;

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

}