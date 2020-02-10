import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int integerOne = scanner.nextInt();
    int integerTwo = scanner.nextInt();
    scanner.close();

    int totalNumber_carryDigits = calculate_numberOfTimes_to_carryDigit(integerOne, integerTwo);
    System.out.println(totalNumber_carryDigits);
  }
  
/**
  * Finds the number of times to carry a digit when adding two integers. 
  */
  public static int calculate_numberOfTimes_to_carryDigit(int integerOne, int integerTwo) {
    int value_carryDigit = 0;
    int totalNumber_carryDigits = 0;

    while (integerOne > 0 && integerTwo > 0) {

      int sum = (integerOne % 10) + (integerTwo % 10) + value_carryDigit;

      if (sum >= 10) {
     /** value_carryDigit: 
       * If sum > 10 => (difference) + (0); 
       * If sum = 10 => (0) + (1); 
       */
        value_carryDigit = (sum - 10) + (10 / sum);
        totalNumber_carryDigits++;
      }
      integerOne = integerOne / 10;
      integerTwo = integerTwo / 10;
    }
    return totalNumber_carryDigits;
  }
}
