import java.util.*;
public class MaximumValues{
  public static void main(String[] args){
    // want to find the n maximum values of an array.
    int[] numbers = new int[6];
    Scanner input = new Scanner(System.in);
    for(int i = 0; i < numbers.length; i++){
      System.out.print("Please provide an integer to go into the array (from highest to lowest): ");
      numbers[i] = input.nextInt();
      System.out.println();
    }
    System.out.print("Please provide how many maximum values you wish to retrieve: ");
    int inputLength = input.nextInt();
    System.out.println();
    System.out.println(outputValues(numbers,inputLength));
  }
  public static String outputValues(int[] inputArray, int inputIndex){
    String outputString = "The maximum ";
    if(inputIndex <= 1){
      outputString = outputString + " value of the array is " + inputArray[0];
      return outputString;
    } else{
      int arrayIndex = inputIndex;
      if(inputIndex > inputArray.length){
        arrayIndex = inputArray.length;
      }
      outputString = outputString + arrayIndex + " values of the array are ";
      String valueString = "";
      for(int i = 0; i < arrayIndex; i++){
        valueString = valueString + inputArray[i] +", ";
      }
      valueString = valueString.substring(0,valueString.length()-2);
      outputString = outputString + valueString;
      return outputString;
    }
  }
}
