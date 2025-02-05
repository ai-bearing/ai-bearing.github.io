import java.util.*;
public class BinarySearch{
  public static void main(String[] args){
    int[] numbers = {2, 4, 7, 10, 11, 32, 45, 87};
    System.out.println("The array is {2, 4, 7, 10, 11, 32, 45, 87}");
    Scanner input = new Scanner(System.in);
    int upperIndex = numbers.length - 1;
    int lowerIndex = 0;

    System.out.print("Please specify a search key: ");
    int key = input.nextInt();
    System.out.println();
    boolean notFound = true;

    while(notFound && (upperIndex >= lowerIndex)){ //need greater than or equal to
      int searchIndex = (upperIndex + lowerIndex)/2; // initialize search index to be average of lower and upper values
      System.out.println("Searching for key value " + key + " at index " + searchIndex + "...");
      if(key == numbers[searchIndex]){
        System.out.println("Found key value " + key + " at index " + searchIndex);
        notFound = false;
      } else if (key > numbers[searchIndex]){
        lowerIndex = searchIndex + 1;
      } else if (key < numbers[searchIndex]){
        upperIndex = searchIndex - 1;
      }
      // Assistance of ChatGPT was used to troubleshoot errors in previous version of code
    }
    if(notFound == true){
      System.out.println("Key value not found.");
    }
    // while(notFound && notAtEdgeIndex){
    //   if(searchIndex == numbers.length-1 || searchIndex == 0){
    //     notAtEdgeIndex = false;
    //   }
    //   System.out.println("Searching for key value " + key + " at index " + searchIndex + "...");
    //   if(key == numbers[searchIndex]){
    //     notFound = false;
    //   } else if (key > numbers[searchIndex]){
    //     searchIndex = boundaryIndex - (boundaryIndex - searchIndex)/2;
    //   } else if (key < numbers[searchIndex]){
    //     boundaryIndex = boundaryIndex / 2;
    //     searchIndex = searchIndex / 2;
    //   }
    // }
  }
}
