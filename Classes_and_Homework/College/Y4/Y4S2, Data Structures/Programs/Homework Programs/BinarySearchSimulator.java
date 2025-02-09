import java.util.*;
//public class BinarySearchSimulator {
//  public static int binarySearch(int[] numbers, int key){
//    int upperIndex = numbers.length - 1;
//    int lowerIndex = 0;
//    // Assistance of ChatGPT was used to troubleshoot errors in previous version of code
//    int searchCounter = 0;
//    while(upperIndex >= lowerIndex){
//      searchCounter += 1;
//      int searchIndex = (lowerIndex + upperIndex)/2;// we want to search the middle of the two indices
//      String searchString = "Is the number less than "; // the search string is what we will print; need a special case for when we're at "end game" so to speak
//      if(searchCounter < 3){
//        searchString = searchString + "or equal to ";
//        searchString = searchString + numbers[searchIndex] + "?";
//      } else if(upperIndex < 7){ // what the heck do I do here? I have no idea how to deal with this
//        searchString = searchString + numbers[upperIndex + 1] + "?";
//        System.out.println(searchString);
//      } else{
//        searchString = searchString + numbers[upperIndex] + "?";
//        System.out.println(searchString);
//      }
//      //this code allows us to distinguish between "less than" (in the case where we're distinguishing between two numbers in the final stage of the searc) and "less than or equal to" (when we're narrowing down to the final two cases);
//      if(key > numbers[searchIndex]){
//        System.out.println(searchString);
//        lowerIndex = searchIndex + 1;
//        System.out.println("No");
//      } else if (key < numbers[searchIndex]){
//        System.out.println(searchString);
//        upperIndex = searchIndex - 1;
//        System.out.println("Yes");
//      } else{
//        return searchIndex;
//      }
//
//    }
//    return -1;
//  }
//  public static void main(String[] args){
//    int[] numbers = {1,2,3,4,5,6,7,8};
//    Scanner input = new Scanner(System.in);
//    int upperIndex = numbers.length - 1;
//    int lowerIndex = 0;
//
//    int key = -1;
//    while(key < 0 || key > 8){
//      System.out.print("Please specify a search key: ");
//      key = input.nextInt();
//      System.out.println();
//    }
//    int keyIndex = binarySearch(numbers,key);
//    System.out.println("Your number is " + numbers[keyIndex]);
//  }
//}

public class BinarySearchSimulator {
  public static int binarySearch(int[] numbers, int key) {
    int upperIndex = numbers.length - 1;
    int lowerIndex = 0;

    while (upperIndex >= lowerIndex) {
      int searchIndex = (lowerIndex + upperIndex) / 2;
      String searchString;
      System.out.println("Upper index: " + upperIndex + ", lower index: " + lowerIndex + ", search index: " + searchIndex);
      // Determine what question to ask
      if (upperIndex - lowerIndex <= 1) {
        if(upperIndex == numbers.length - 1){
        searchString = "Is the number less than " + numbers[upperIndex] + "?";
        } else{
        searchString = "Is the number less than " + numbers[upperIndex + 1] + "?";
        }
        // Final step: Ask if the number is less than the upper bound
      } else {
        // Regular step: Ask if the number is less than or equal to the midpoint
        searchString = "Is the number less than or equal to " + numbers[searchIndex] + "?";
      }

      // Print the question
      System.out.println(searchString);

      // Check the key against the current midpoint or upper bound
      if (upperIndex - lowerIndex == 1) {
        if (key < numbers[upperIndex]) {
          System.out.println("Yes");
          upperIndex = lowerIndex;  // The key must be at lowerIndex
          return lowerIndex;
        } else {
          System.out.println("No");
          lowerIndex = upperIndex;  // The key must be at upperIndex
          return upperIndex;
        }
      } else if (key > numbers[searchIndex]) {
        System.out.println("No");
        lowerIndex = searchIndex + 1;
      } else if (key < numbers[searchIndex]) {
        System.out.println("Yes");
        upperIndex = searchIndex - 1;
      } else {
        // Key found at searchIndex
        return searchIndex;
      }
    }

    return lowerIndex;  // Return the final index
  }

  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
    Scanner input = new Scanner(System.in);

    int key = -1;
    while (key < 1 || key > 8) {
      System.out.print("Please specify a search key (1–8): ");
      key = input.nextInt();
      System.out.println();
    }

    int keyIndex = binarySearch(numbers, key);
    System.out.println("Your number is " + numbers[keyIndex] + ".");
  }
}
