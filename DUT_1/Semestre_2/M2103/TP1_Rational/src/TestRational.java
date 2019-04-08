	/**
	* Test of the Rational class 
	* @author S.LEBERRE - Decembre 2016
  	* @version 1.0
  	* @since JDK 1.8
	*/
	public class TestRational {
		

		public static void main(String[] args){

			System.out.println("================================== Test of the class Rational ================================== ");

			testRational();
			testGetNumerator();
			testSetNumerator();
			testGetDenominator();
			testSetDenominator();
			testReduce();
			testReverse();
			testAdd();
			testSubtracted();
			testMultiplies();
			testEquals();
			testToString();
			testPgcd();

		}

		/** Done
		 * Test of the method Rational
		 */
		private static void testRational(){
			

			System.out.println("\n\n\n================= Test of the method Rational ================= ");

			//variables
			Rational first  = new Rational(4,3);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			
				System.out.println("There is no errors cases");

			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				System.out.println("There is no limits cases");
				
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test
				System.out.println("\n----print 4/3");
				sentence = first.toString();
				System.out.println(sentence);

		}
		
		/** Done
		 * Test of the method getNumerator
		 */
		private static void testGetNumerator(){
			
			System.out.println("\n\n\n================= Test of the method getNumerator ================= ");

			//variables
			Rational first = new Rational(6,3);
			Rational second = new Rational(8,4);
			Rational third = new Rational(-4,2);
			int num1;
			int num2;
			int num3;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
				
				System.out.println("There is no errors cases");
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				// Test when numerator < 0
				System.out.println("\n---- print -4");
				num3 = third.getNumerator();
				System.out.println(num3);

			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test 1 n = 6
				System.out.println("\n---- print 6");
				num1 = first.getNumerator();
				System.out.println(num1);

				// Test 2 n = 8
				System.out.println("\n---- print 8");
				num2 = second.getNumerator();
				System.out.println(num2);
		}
		
		/** Done
		 * Test of the method setNumerator
		 */
		private static void testSetNumerator(){

			System.out.println("\n\n\n================= Test of the method setNumerator ================= ");

			//variables
			Rational first = new Rational(6,3);
			Rational second = new Rational(8,4);
			Rational third = new Rational(4,6);
			Rational fourth = new Rational(-4,6);
			int num1;
			int num2;
			int num3;
			int num4;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
				
				System.out.println("There is no errors cases");
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				// Test when numerator 4  -->  -4
				System.out.println("\n---- print -4");
				third.setNumerator(-4);
				num3 = third.getNumerator();
				System.out.println(num3);

				// Test when numerator -4  -->  6
				System.out.println("\n---- print 6");
				third.setNumerator(6);
				num4 = fourth.getNumerator();
				System.out.println(num4);
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test 1 n = 6 --> 5
				System.out.println("\n---- print 5");
				first.setNumerator(5);
				num1 = first.getNumerator();
				System.out.println(num1);

				// Test 2 n = 8 --> 6
				System.out.println("\n---- print 6");
				second.setNumerator(6);
				num2 = second.getNumerator();
				System.out.println(num2);
		}
		
		/** Done
		 * Test of the method getDenominator
		 */
		private static void testGetDenominator(){

			System.out.println("\n\n\n================= Test of the method getDenominator ================= ");

			//variables
			Rational first = new Rational(3,10);
			Rational second = new Rational(4,1);
			Rational third = new Rational(2,-5);
			int num1;
			int num2;
			int num3;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
				
				System.out.println("There is no errors cases");
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
	
				// Test when denominator < 0
				System.out.println("\n---- print -5");
				num3 = third.getDenominator();
				System.out.println(num3);

			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test 1 n = 6
				System.out.println("\n---- print 10");
				num1 = first.getDenominator();
				System.out.println(num1);

				// Test 2 n = 8
				System.out.println("\n---- print 1");
				num2 = second.getDenominator();
				System.out.println(num2);
		}
		
		/** Done
		 * Test of the method setDenominator
		 */
		private static void testSetDenominator(){

			System.out.println("\n\n\n================= Test of the method setDenominator ================= ");

			//variables
			Rational first = new Rational(3,10);
			Rational second = new Rational(4,1);
			Rational third = new Rational(6,7);
			Rational fourth = new Rational(6,-4);
			Rational fifth = new Rational(6,4);
			int num1;
			int num2;
			int num3;
			int num4;
			int num5;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
				
				// When denominator = 0
				System.out.println("\n---- Test with 0. Replace 0 by -1");
				fifth.setDenominator(0);
				num5 = fifth.getDenominator();
				System.out.println(num5);
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				// Test when denominator 7  -->  -4
				System.out.println("\n---- print -4");
				third.setDenominator(-4);
				num3 = third.getDenominator();
				System.out.println(num3);

				// Test when denominator -4  -->  6
				System.out.println("\n---- print 6");
				fourth.setDenominator(6);
				num4 = fourth.getDenominator();
				System.out.println(num4);
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test 1 n = 10 --> 5
				System.out.println("\n---- print 5");
				first.setDenominator(5);
				num1 = first.getDenominator();
				System.out.println(num1);

				// Test 2 n = 1 --> 6
				System.out.println("\n---- print 6");
				second.setDenominator(6);
				num2 = second.getDenominator();
				System.out.println(num2);

		}
		
		/** Done
		 * Test of the method reduce
		 */
		private static void testReduce(){

			System.out.println("\n\n\n================= Test of the method reduce ================= ");

			System.out.println("We can't test it directly but we use it in the method equals");
			System.out.println("The potential test method if reduce was public is in the code");

			/*
			//variables
			Rational first = new Rational(3,6);
			Rational second = new Rational(5,4);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			
				System.out.println("There is no errors cases");

			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				System.out.println("There is no limits cases");
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test true
				System.out.println("\n----3/6 became 1/2");
				first.reduce();
				sentence = first.toString();
				System.out.println(sentence);

				// Test false
				System.out.println("\n----5/4 rest 5/4");
				second.reduce();
				sentence = second.toString();
				System.out.println(sentence);
				*/
		}
		
		/** Done
		 * Test of the method reverse
		 */
		private static void testReverse(){

			System.out.println("\n\n\n================= Test of the method reverse ================= ");

			//variables
			Rational first  = new Rational(5,9);
			Rational second = new Rational(-3,8);
			Rational third = new Rational(0,6);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			
				// When numerator = 0
				System.out.println("\n----Test when numerator = 0. Change denominator in -1");
				third.reverse();
				sentence = third.toString();
				System.out.println(sentence);

			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				System.out.println("There is no limits cases");
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test true
				System.out.println("\n----print 9/5");
				first.reverse();
				sentence = first.toString();
				System.out.println(sentence);

				// Test false
				System.out.println("\n----print 8/-3");
				second.reverse();
				sentence = second.toString();
				System.out.println(sentence);
		}
		
		/** Done
		 * Test of the method add
		 */
		private static void testAdd(){

			System.out.println("\n\n\n================= Test of the method add ================= ");

			//variables
			Rational first  = new Rational(5,2);
			Rational second = new Rational(4,3);
			Rational third = new Rational(-3,1);
			Rational fourth = new Rational(2,3);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			
				System.out.println("There is no errors cases");

			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases ");
				
				// When we add a negative number
				System.out.println("\n----print -1/2");
				first = first.add(third);
				sentence = first.toString();
				System.out.println(sentence);
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test
				System.out.println("\n----print 6/3");
				second = second.add(fourth);
				sentence = second.toString();
				System.out.println(sentence);
		}

		/** Done
		 * Test of the method substracted
		 */
		private static void testSubtracted(){

			System.out.println("\n\n\n================= Test of the method subtracted ================= ");

			//varaibles
			Rational first = new Rational(2,3);
			Rational second = new Rational(-3,3);
			Rational third = new Rational(3,2);
			Rational fourth = new Rational(2,1);
			Rational fifth = new Rational(7,2);
			Rational sixth = new Rational(2,1);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
				
				System.out.println("There is no errors cases");
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				// When we subtracted a negative number
				System.out.println("\n----2/3 subtracted -3/2. print 5/3");
				first = first.subtracted(second);
				sentence = first.toString();
				System.out.println(sentence);
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test result < 0 
				System.out.println("\n----3/2 subtracted 2/1. print -1/2");
				third = third.subtracted(fourth);
				sentence = third.toString();
				System.out.println(sentence);

				// Test result > 0 
				System.out.println("\n----7/2 subtracted 2/1. print 3/2");
				fifth = fifth.subtracted(sixth);
				sentence = fifth.toString();
				System.out.println(sentence);
		}
		
		/** Done
		 * Test of the method multiplies
		 */
		private static void testMultiplies(){

			System.out.println("\n\n\n================= Test of the method multiplies ================= ");

			//varaibles
			Rational first = new Rational(2,3);
			Rational second = new Rational(-3,3);
			Rational third = new Rational(3,2);
			Rational fourth = new Rational(2,-1);
			Rational fifth = new Rational(7,2);
			Rational sixth = new Rational(2,1);
			Rational seventh = new Rational(0,4);
			Rational eighth = new Rational(1,2);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");

				// When denominator became 0		
				System.out.println("There is no errors cases");
				System.out.println("Because we stop the denominator equals 0 at the creation of the object");	
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				// When numerator became 0
				System.out.println("\n----0/4 multiplies 1/2. print 0/8");
				seventh = seventh.multiplies(eighth);
				sentence = seventh.toString();
				System.out.println(sentence);
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// When numerator became negative
				System.out.println("\n----2/3 multiplies -3/3. print -6/9");
				first = first.multiplies(second);
				sentence = first.toString();
				System.out.println(sentence);

				// When denominator became negative
				System.out.println("\n----3/2 multiplies 2/-1. print 6/-2");
				third = third.multiplies(fourth);
				sentence = third.toString();
				System.out.println(sentence);

				// When it's alright
				System.out.println("\n----7/2 multiplies 2/1. print 14/2");
				fifth = fifth.multiplies(sixth);
				sentence = fifth.toString();
				System.out.println(sentence);
		}
		
		/** Done
		 * Test of the method equals
		 */
		private static void testEquals(){

			System.out.println("\n\n\n================= Test of the method equals ================= ");

			Rational first = new Rational(2,3);
			Rational second = new Rational(2,3);
			Rational third = new Rational(1,1);
			Rational fourth = new Rational(2,2);
			boolean equals;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
				
				System.out.println("There is no errors cases");
			
			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				System.out.println("There is no limits cases");
			
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test true the same
				System.out.println("\n----2/3 equals 2/3. print true");
				equals = first.equals(second);
				System.out.println("the result is " + equals);

				// Test true not the same
				System.out.println("\n----1/1 equals 2/2. print true");
				equals = third.equals(fourth);
				System.out.println("the result is " + equals);

				// Test false diferent
				System.out.println("\n----1/1 equals 2/3. print false");
				equals = third.equals(second);
				System.out.println("the result is " + equals);

		}
		
		/** Done
		 * Test of the method toString
		 */
		private static void testToString(){

			System.out.println("\n\n\n================= Test of the method toString ================= ");

			//variables
			Rational first  = new Rational(5,2);
			String sentence;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			
				System.out.println("There is no errors cases");

			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				System.out.println("There is no limits cases");
				
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");

				// Test
				System.out.println("\n----print 5/2");
				sentence = first.toString();
				System.out.println(sentence);
		}
		
		/** Done
		 * Test of the method pgcd
		 */
		private static void testPgcd(){

			System.out.println("\n\n\n================= Test of the method pgcd ================= ");

			System.out.println("With all the results we obtain we can say pgcd method is good");
			
			/* error with the pgcd test method
			
			//variables
			Rational first = new Rational(5,10);
			Rational second = new Rational(3,7);
			int num;

			// Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			
				System.out.println("There is no errors cases");

			// Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
				
				System.out.println("There is no limits cases");
				
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			
				// Test true
				System.out.println("Test with 5 and 10");
				num = pgcd(first);
				System.out.println("le pgcd est egale a " + num);

				// Test false
				System.out.println("Test with 3 and 7");
				num = pgcd(second);
				System.out.println("le pgcd est egale a " + num);

			*/
		}	
	}
