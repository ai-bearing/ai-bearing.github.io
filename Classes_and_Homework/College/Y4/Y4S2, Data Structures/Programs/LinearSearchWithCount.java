import java.util.*;
public class LinearSearchWithCount{
  public static int linearSearchCount(int[] numbers, int key){
    for(int i = 0; i < numbers.length; i++){
      if(numbers[i] == key){
        System.out.println("Search count: " + (i+1));
        return i;
      }
    }
    System.out.println("Search count: " + numbers.length);
    return -1;
  }
  public static void main(String[] args) {
    //int[] numbers = {9, 16, 27, 35, 49, 52, 61, 70, 88, 93, 104};
    //int[] numbers = {104, 93, 88, 70, 61, 52, 49, 35, 27, 16, 9};
    int[] numbers = {88, 27, 49, 93, 104, 9, 61, 70, 52, 49, 16};
    Scanner scnr = new Scanner(System.in);

    System.out.print("NUMBERS: ");
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    } //prints numbers
    System.out.println();

    System.out.print("Enter a value: ");
    int key = scnr.nextInt(); //key value entry

    int keyIndex = linearSearchCount(numbers, key); //run key index method

    if (keyIndex == -1) {
      System.out.println(key + " was not found.");
    }
    else {
      System.out.println("Found " + key + " at index " + keyIndex + ".");
    }
  }
}
