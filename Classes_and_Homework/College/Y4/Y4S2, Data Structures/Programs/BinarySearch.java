import java.util.*;
public class BinarySearch{
  public static void main(String[] args){
    int[] numbers = {2, 4, 7, 10, 11, 32, 45, 87};
    System.out.println("The array is {2, 4, 7, 10, 11, 32, 45, 87}");
    Scanner input = new Scanner(System.in);
    int boundaryIndex = numbers.length - 1;
    int searchIndex = boundaryIndex/2;
    /* Start at searchIndex, check value of input vs. numbers[searchIndex].
     * If input = numbers[SearchIndex], break.
     * If input > numbers[searchIndex], then change searchIndex to boundaryIndex - (boundaryIndex - searchIndex)/2
     * if input < numbers[searchIndex], then change boundaryIndex to boundaryIndex/2, searchIndex to searchIndex/2
     */
    System.out.print("Please specify a search key: ");
    int key = input.nextInt();
    System.out.println();
    boolean notFound = true;
    boolean notAtEdgeIndex = true;
    while(notFound && notAtEdgeIndex){
      if(searchIndex == numbers.length-1 || searchIndex == 0){
        notAtEdgeIndex = false;
      }
      System.out.println("Searching for key value " + key + " at index " + searchIndex + "...");
      if(key == numbers[searchIndex]){
        notFound = false;
      } else if (key > numbers[searchIndex]){
        searchIndex = boundaryIndex - (boundaryIndex - searchIndex)/2;
      } else if (key < numbers[searchIndex]){
        boundaryIndex = boundaryIndex / 2;
        searchIndex = searchIndex / 2;
      }
    }
    if(notFound){
      System.out.println("Key value not found");
    } else{
      System.out.println("Found key value " + key + " at index " + searchIndex);
    }
  }
}
