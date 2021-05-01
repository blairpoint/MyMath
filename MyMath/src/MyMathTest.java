import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath mt;

	@BeforeEach
	public void initialize() {
		mt = new MyMath();

	}

	public static Collection addTestData1() { // Test case combinations for addition
		return Arrays.asList(new Object[][] { { 2, 2, 4 }, // + +
				{ 5, -2, 3 }, // + -
				{ -20, 10, -10 }, // - +
				{ -8, -10, -18 }, // - -
				{ 5, 0, 5 }, // + 0
				{ 0, 10, 10 }, // 0 +
				{ -5, 0, -5 }, // - 0
				{ 0, -12, -12 }, // 0 -
				{ 0, 0, 0 } // 0 0

		});
	}

	@ParameterizedTest(name = "{index}: subTest({0},{1})= {2}")
	@MethodSource("addTestData1")
	public void addTest1(int v1, int v2, int exp) {
		assertEquals(exp, mt.add(v1, v2));

	}

	public static Collection subTestData1() { // Test case combinations for subtraction
		return Arrays.asList(new Object[][] { { 2, 2, 0 }, // + +
				{ 5, -2, 7 }, // + -
				{ -20, 10, -30 }, // - +
				{ -8, -10, 2 }, // - -
				{ 5, 0, 5 }, // + 0
				{ 0, 10, -10 }, // 0 +
				{ -5, 0, -5 }, // - 0
				{ 0, -12, 12 }, // 0 -
				{ 0, 0, 0 } // 0 0

		});
	}

	@ParameterizedTest(name = "{index}: subTest({0},{1})= {2}")
	@MethodSource("subTestData1")
	public void subTest1(int v1, int v2, int exp) {
		assertEquals(exp, mt.subtract(v1, v2));
	}

	public static Collection mulTestData1() { // Test case combinations for multiplication
		return Arrays.asList(new Object[][] { { 2, 2, 4 }, // + +
				{ 5, -2, -10 }, // + -
				{ -20, 10, -200 }, // - +
				{ -8, -10, 80 }, // - -
				{ 5, 0, 0 }, // + 0
				{ 0, 10, 0 }, // 0 +
				{ -5, 0, 0 }, // - 0
				{ 0, -12, 0 }, // 0 -
				{ 0, 0, 0 } // 0 0

		});
	}

	@ParameterizedTest(name = "{index}: mulTest({0},{1})= {2}")
	@MethodSource("mulTestData1")
	public void mulTest1(int v1, int v2, int exp) {
		assertEquals(exp, mt.multiply(v1, v2));
	}
	public static Collection divTestData2() { 
		return Arrays.asList(new Object[][] {
			{2,0,"Error cannot divide by zero"},
			{ -5, 0, "Error cannot divide by zero" }, // - 0
			{ 0, 0, "Error cannot divide by zero" } // 0 0
		
		});

	

	}
	public static Collection divTestData1() { // Test case combinations for division
		return Arrays.asList(new Object[][] { { 2, 2, 1 }, // + +
				{ 5, -2, -2.5 }, // + -
				{ -20, 10, -2 }, // - +
				{ -8, -10, 0.8 }, // - -
				{ 1, 3, 0.33333 }, // + * ????????
				{ 0, 10, 0 }, // 0 +
				{ 0, -12, 0 } // 0 -
				
				
		});
	}
	@ParameterizedTest(name = "{index}: divTest2({0},{1})= {2}")
	@MethodSource("divTestData2")
	public void divTest2(int v1, int v2, String exp) {
		assertThrows(Exception.class, ()->mt.divide(v1, v2));
//		try {
//			mt.divide(v1, v2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			assertEquals(e.getMessage(),exp);		}
	}
	
	@ParameterizedTest(name = "{index}: divTest({0},{1})= {2}")
	@MethodSource("divTestData1")
	public void divTest1(int v1, int v2, double exp) {
		try {
			assertEquals(exp, mt.divide(v1, v2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}
	}

	@ParameterizedTest(name = "{index}: mulvecTest({0}, {1}), {2}=")
	@MethodSource("mulvec")
	static Stream<Arguments> mulvecTestcases() {
		return Stream.of(
				Arguments.of(Arrays.asList(1, 2).toArray(), Arrays.asList(3, 2).toArray(),
						Arrays.asList(3, 4).toArray()),
				Arguments.of(Arrays.asList(3, 4).toArray(), Arrays.asList(3, 6).toArray(),
						Arrays.asList(9, 24).toArray()),
				Arguments.of(Arrays.asList(1, 2, 4).toArray(), Arrays.asList(1, 2, 4).toArray(),
						Arrays.asList(1, 4, 16).toArray()),
				Arguments.of(Arrays.asList(1, 2).toArray(), Arrays.asList(1, 2).toArray(),
						Arrays.asList(1, 4).toArray()),
				Arguments.of(Arrays.asList(-1, 2, 4).toArray(), Arrays.asList(1, 2, 4).toArray(),
						Arrays.asList(-1, 4, 16).toArray()),
				Arguments.of(Arrays.asList(1, -2).toArray(), Arrays.asList(1, 2).toArray(),
						Arrays.asList(1, -4).toArray()),
				Arguments.of(Arrays.asList(1, 2, 4).toArray(), Arrays.asList(-1, 2, 4).toArray(),
						Arrays.asList(-1, 4, 16).toArray()),
				Arguments.of(Arrays.asList(1, 2).toArray(), Arrays.asList(1, -2).toArray(),
						Arrays.asList(1, -4).toArray()),
				Arguments.of(Arrays.asList(3, 4, 5, 6).toArray(), Arrays.asList(0, 1, 1, 2).toArray(),
						Arrays.asList(0, 4, 5, 12).toArray())

		);
	}

	@ParameterizedTest(name = "{index}: mulvecTest({0},{1})= {2}")
	@MethodSource("mulvecTestcases")
	public void mulvecTest1(Object[] v1, Object[] v2, Object[] exp) throws Exception {
		assertArrayEquals(xArr(exp), mt.mulvec(xArr(v1), xArr(v2)));
	}

	private int[] xArr(Object[] v1) {
		int result[] = new int[v1.length];
		for (int i = 0; i < v1.length; i++) {
			result[i] = (Integer) v1[i];
		}
		return result;
	}

	static Stream<Arguments> maxtrixXvectorTestCases() {
		return Stream
				.of		(Arguments.of(new int[][] { { 1, -1, 2 }, { 0, -3, 1 } }, new int[] { 2, 1, 0 }, new int[] { 1, -3 }),
						(Arguments.of(new int[][] { { 1 } }, new int[] { 1 }, new int[] {1})),
						(Arguments.of(new int[][] { { 1, 2, 3 }, { 1, 2, 3 },{1,2,3} }, new int[] { 1, 2, 3 }, new int[] { 14, 14, 14 })),
						(Arguments.of(new int[][] { { -1, -2, -3 }, { -1, -2, -3 },{-1,-2,-3} }, new int[] { -1, -2, -3 }, new int[] { 14, 14, 14 })),
						(Arguments.of(new int[][] { { -1, -2, -3 }, { -1, -2, -3 },{-1,-2,-3} }, new int[] { 1, 2, 3 }, new int[] { -14, -14, -14 })),
						(Arguments.of(new int[][] { { 1, 2, 3 }, { 1, 2, 3 },{1,2,3} }, new int[] { -1, -2, -3 }, new int[] { -14, -14, -14 }))
												
				);
	}

	@ParameterizedTest(name = "{index}: matXvecTest({0}, {1})= {2}")
	@MethodSource("maxtrixXvectorTestCases")
	public void matXvecTest(int[][] m, int[] v, int[] exp) throws Exception {
		assertArrayEquals(exp, mt.matXvec(m, v));
	}
	
	static Stream<Arguments> maxtrixXvectorTestCases2() {
		return Stream
				.of		(Arguments.of(new int[][] { { 2, 3, -4, 2 }, { 11, 8, 7,6},{2,5,3} }, new int[] { 3, 5, 7 }, new int[] { 1, -3 }),
						(Arguments.of(new int[][] { { }, { },{ } }, new int[] { }, new int[] { })),
						(Arguments.of(new int[][] { { }, { },{ } }, new int[] { 1,2,3}, new int[] { })),
						(Arguments.of(new int[][] { { 1}, {2 },{3 } }, new int[] { }, new int[] { }))
				);
	}

	@ParameterizedTest(name = "{index}: matXvecTest2({0}, {1})= {2}")
	@MethodSource("maxtrixXvectorTestCases2")
	public void matXvecTest2(int[][] m, int[] v) throws Exception {
		assertThrows(Exception.class, ()->mt.matXvec(m,v));
	}

	static Stream<Arguments> idmatrixTestCases() {
		return Stream
				.of		(Arguments.of(new int[][] { { 1, 0, 0 }, { 0, 1, 0 } ,{ 0, 0, 1 }}, true),
						(Arguments.of(new int[][] { { 1, 0, 0 }, { 0, 1, 0 } ,{ 0, 0, 0 }}, false))

				);
	}

	@ParameterizedTest(name = "{index}: idmatrixTest({0})= {1}")
	@MethodSource("idmatrixTestCases")
	public void idmatrixTest(int[][] m, boolean exp) throws Exception {
		assertEquals(exp,mt.idmatrix(m));
	}
	
	static Stream<Arguments> idmatrixTestCases2() {
		return Stream
				.of		(Arguments.of(new int[][] { { 1, 0, 0 }, { 0, 1, 0 } ,{ 0, 0 }}, "Length of 2's column is not right"),
						(Arguments.of(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }}, "not a squared matrix"))


				);
	}

	@ParameterizedTest(name = "{index}: idmatrixTest2({0})= {1}")
	@MethodSource("idmatrixTestCases2")
	public void idmatrixTest2(int[][] m, String exp) throws Exception {
		assertThrows(Exception.class, ()->mt.idmatrix(m));
	}
	
	
	
	
	static Stream<Arguments> transposeTestCases() {
		return Stream
				.of		(Arguments.of(new int[][] { { 1, 0, 9 }, { 5, 1, 0 } ,{ 0, 0, 1 }}, new int[][] {{1,5,0},{0,1,0},{9,0,1}}),
						(Arguments.of(new int[][] { {1}}, new int[][] {{1}}))

				);
	}

	@ParameterizedTest(name = "{index}: transposeTestCases({0})= {1}")
	@MethodSource("transposeTestCases")
	public void transposeTestCases(int[][] m, int[][] exp) throws Exception {
		int[][] res = mt.transpose(m);
		for(int i = 0; i < res.length; i++) {
			assertArrayEquals(exp[i], res[i]);
		}
	}
	static Stream<Arguments> transposeTestCases2() {
		return Stream
				.of		(Arguments.of(new int[][] { { 1, 0, 9 }, { 5, 1, 0 } ,{ 0, 0 }}, "Length of 2's column is not right"),
						(Arguments.of(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }}, "not a squared matrix"))


				);
	}

	@ParameterizedTest(name = "{index}: transposeTest2({0})= {1}")
	@MethodSource("transposeTestCases2")
	public void transposeTest2(int[][] m, String exp) throws Exception {
		assertThrows(Exception.class, ()->mt.transpose(m));
	}
	

	static Stream<Arguments> matByMatTestCases() {
		return Stream
				.of		(Arguments.of(new int[][] { { 1, 2, }, { 1, 2 },{1,2} }, new int[][] {{ 9}, {6}}, new int[][] {{ 21}, {21},{21} })

												
				);
	}

	@ParameterizedTest(name = "{index}: matByMatTest({0}, {1})= {2}")
	@MethodSource("matByMatTestCases")
	public void matByMatTest(int[][] m, int[][] v, int[][] exp) throws Exception {
		int[][] res = mt.matByMat(m,v);
		for(int i = 0; i < res.length; i++) {
			assertArrayEquals(exp[i], res[i]);
		}
	}	
	
	
	
}
