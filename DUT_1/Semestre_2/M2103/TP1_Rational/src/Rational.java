	/**
	* Operation on a rational object 
	* @author S.LEBERRE - Decembre 2016
  	* @version 1.0
  	* @since JDK 1.8
	*/
	public class Rational {
		// the numerator
		private int numerator;
		// the denominator
		private int denominator;
		
		/** 
		 * Constructor
		 * @param n the numerator of the fraction
		 * @param d the denominator of the fraction
		 */
		Rational (int n, int d) {
			this.numerator = n;
			if(d != 0){
				this.denominator = d;
			} else {
				this.denominator = -1;
				System.out.println("A fraction can't have 0 in denominator we replace it by -1");
			}
		}
		
		/** 
		 * Give to us the numerator
		 * @return the numerator
		 */ 
		public int getNumerator(){
			return this.numerator;
		}
		
		/** 
		 * Replace the old numerator by the new
		 * @param numerator the new numerator
		 */
		public void setNumerator(int numerator) {
			this.numerator =  numerator;
		}
		
		/** 
		 * Give to us the denominator
		 * @return the denominator
		 */
		public int getDenominator() {
			return this.denominator;
		}
		
		/** 
		 * Replace the old denominator by the new
		 * @param denominator the new denominator
		 */
		public void setDenominator( int denominator) {
			if (denominator != 0){
				this.denominator = denominator;
			} else {
				this.denominator = -1;
			}
		}
		
		/** 
		 * Reduce the fraction
		 */
		private void reduce() {
			if (pgcd(this) != 1 && pgcd(this) != 0){
				this.numerator  = this.numerator / pgcd(this);
				this.denominator = this.denominator / pgcd(this);
			} else {
				System.out.println("You can't reduce this fraction");
			}
		}
		
		/** 
		 * Reverse the fraction. If the fraction have 0 in numerorator, it return -1 in numerator and 1 in denominator.
		 * @return the inverse of the fraction
		 */
		public Rational reverse() {
			if(this.numerator != 0){
				int tmp;
				tmp = this.numerator;
				this.numerator = this.denominator;
				this.denominator = tmp;
			} else {
				this.numerator = -1;
				this.denominator = 1;
				System.out.println("A fraction can't have 0 in denominator");
			}
			return this;
		}
		
		/** 
		 * Add a rational number to another one
		 * @param oneRN a rational number
		 * @return the new rational number
		 */
		public Rational add(Rational oneRN) {
			if(oneRN.denominator != this.denominator){
				this.denominator = this.denominator * oneRN.denominator;
				this.numerator = this.numerator * oneRN.denominator;
				oneRN.numerator = oneRN.numerator * this.denominator;
			} 		
			this.numerator = this.numerator + oneRN.numerator;
			return this;
		}
		
		/** 
		 * Substracted a rational number with another one
		 * @param oneRN a rational number
		 * @return the new rational number
		 */
		public Rational subtracted(Rational oneRN) {
			if(oneRN.denominator != this.denominator){
				this.denominator = this.denominator * oneRN.denominator;
				this.numerator = this.numerator * oneRN.denominator;
				oneRN.numerator = oneRN.numerator * this.denominator;
			} 		
			this.numerator = this.numerator - oneRN.numerator;
			return this;
		}
		
		/** 
		 * Multiplies a rational number by another one
		 * @param oneRN a rational number
		 * @return the new rational number
		 */
		public Rational multiplies(Rational oneRN) {
			this.numerator = this.numerator * oneRN.numerator;
			this.denominator = this.denominator * oneRN.denominator;
			return this;
		}
		
		/** 
		 * See if a rational number is the same as another rational number
		 * @param oneRN a rational number
		 * @return true if it's the same rational number
		 */
		public boolean equals(Rational oneRN) {
			boolean result = false;
			this.reduce();
			oneRN.reduce();
			if(this.denominator == oneRN.denominator && this.numerator == oneRN.numerator){
				result = true;
			}
			return result;
		}
		
		/**
		 * Give a little aspect of the fraction
		 */
		public String toString(){
			String ret = "The numerator of the fraction is " + this.numerator +" . \nThe denominator of the fraction is " + this.denominator + " . \nThe fraction is equals to " + this.numerator + "/" + this.denominator + " .";
			return ret;
		}
		
		/** 
		 * Calculation of the highest common factor
		 * @param oneRN the rational we want to reduce
		 * @return the highest common factor
		 */
		public int pgcd(Rational oneRN){
			int pgcd = 1;
			int rest = 1; //all the number can be divided by 1
			int big;
			int small;
			if(oneRN.numerator >= oneRN.denominator){
				big = oneRN.numerator;
				small = oneRN.denominator;
			} else {
				big = oneRN.denominator;
				small = oneRN.numerator;
			}
			while (rest != 0) {
				rest = big - small;
				big = small;
				small = rest;
				pgcd = big;
			}
			return pgcd;
		}
	}
