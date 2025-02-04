import java.util.*;
public class LinearSearch{
  public static void main(String[] args){
    int[] numbers = {2, 4, 7, 10, 11, 32, 45, 87};
    System.out.println("The array is {2, 4, 7, 10, 11, 32, 45, 87}");
    Scanner input = new Scanner(System.in);
    System.out.print("Please specify a search key: ");
    int key = input.nextInt();
    System.out.println();
    int targetIndex = -1;
    for(int i = 0; i < numbers.length; i++){
      System.out.println("Searching for key value " + key + " at index " + i + "...");
      if(numbers[i] == key){
        targetIndex = i;
        break;
      }
    }
    if(targetIndex == -1){
      System.out.println("Key value not found");
    } else{
      System.out.println("Found key value " + key + " at index " + targetIndex);
    }
  }
}
