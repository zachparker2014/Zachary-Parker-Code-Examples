/**
   Program #1
 
   Function: Simple Java application to demonstrate the behavior of
             different data types, arithmetic, concatenation, and
             output of results.
 
   Programmed By: Zachary Parker, March 22, 2020
 
   Code Practice Problems Taken From: "Java Programming (Fourth Edition" by Joyce Farrell, Figure 2-26, page 61
 
*/
public class BasicJavaOperations
{
   public static void main(String[] args)
   {
    //initialization of variables  
    int oneInt = 315;
      short oneShort = 23;
      long oneLong = 1234567876543L;
      int value1 = 43, value2 = 10, sum, difference,
          product, quotient, modulus;
      boolean isProgrammingFun = true;
      double doubNum1 = 2.3, doubNum2 = 14.8, doubResult;
      char myGrade = 'A', myFriendsGrade = 'C';

      //Printing out original values
      System.out.println("Our grades are " + myGrade + " and " + myFriendsGrade);
      System.out.println("The value of isProgrammingFun is " + isProgrammingFun);
      System.out.println("The int is " + oneInt);
      System.out.println("The short is " + oneShort);
      System.out.println("The long is " + oneLong);

      //performing basic operations
      sum = value1 + value2;
      doubResult = doubNum1 + doubNum2;
      difference = value1 - value2;
      product = value1 * value2;
      quotient = value1 / value2;
      modulus = value1 % value2;

      //printing out the end values
      System.out.println("Sum is " + sum);
      System.out.println("The sum of the doubles is " + doubResult);
      System.out.println("Difference is " + difference);
      System.out.println("Product is " + product);
      System.out.println("Quotient is " + quotient);
      System.out.println("Modulus is " + modulus);
      System.out.println("\nThis is on one line\nThis on another");
      System.out.println("This shows\thow\ttabs\twork");
   } // end method main
}  // end class Parker
