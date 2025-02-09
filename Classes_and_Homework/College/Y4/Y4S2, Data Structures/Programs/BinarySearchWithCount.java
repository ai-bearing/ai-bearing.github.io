import java.util.*;
public class BinarySearchWithCount{
  public static int binarySearchCount(int[] numbers, int key){
    int lowIndex = 0;
    int highIndex = numbers.length-1;
    boolean notFound = true;
    int searchCount = 0;
    while(notFound && highIndex >= lowIndex){
      int searchIndex = (highIndex + lowIndex)/2;
      searchCount += 1;
      if(key > numbers[searchIndex]){
        lowIndex = searchIndex + 1;
      } else if (key < numbers[searchIndex]){
        highIndex = searchIndex - 1;
      } else{
        System.out.println("Search count: " + searchCount);
        notFound = false;
        return searchIndex;
      }
    }
    System.out.println("Search count: " + searchCount);
    return -1;
  }
  public static int binarySearchCount2(int[] numbers, int key){
    int lowIndex = 0;
    int highIndex = numbers.length-1;
    boolean notFound = true;
    int searchCount = 0;
    while(notFound && highIndex >= lowIndex){
      int searchIndex = (highIndex + lowIndex)/2;
      searchCount += 1;
      if(key < numbers[searchIndex]){
        lowIndex = searchIndex + 1;
      } else if (key > numbers[searchIndex]){
        highIndex = searchIndex - 1;
      } else{
        System.out.println("Search count: " + searchCount);
        notFound = false;
        return searchIndex;
      }
    }
    System.out.println("Search count: " + searchCount);
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
    }
    System.out.println();
    
    System.out.print("Enter a value: ");
    int key = scnr.nextInt();
    
    //int keyIndex = binarySearchCount(numbers, key);
    int keyIndex1 = binarySearchCount(numbers, key);
    
    if (keyIndex1 == -1) {
      System.out.println(key + " was not found.");
    }
    else {
      System.out.println("Found " + key + " at index " + keyIndex1 + ".");
    }
    int keyIndex2 = binarySearchCount2(numbers, key);
    
    if (keyIndex2 == -1) {
      System.out.println(key + " was not found.");
    }
    else {
      System.out.println("Found " + key + " at index " + keyIndex2 + ".");
    }
  }
}
