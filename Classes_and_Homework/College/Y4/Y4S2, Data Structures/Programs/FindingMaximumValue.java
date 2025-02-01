import java.util.*;
public class Main {
  public static void main(String[] args) {
    int[] main_array = new int[6];
    Scanner input = new Scanner(System.in);
    for(int i = 0; i < main_array.length; i++){
      System.out.print("Please provide an integer to go into the array: ");
      main_array[i] = input.nextInt();
      System.out.println();

    }
    int currentMax = main_array[0];
    for(int i = 0; i < main_array.length; i++){
      if(main_array[i] > currentMax){
        currentMax = main_array[i];
      }
      System.out.println("Current maximum value: " + currentMax);
    }
    System.out.println("The maximum value of the array is "+ currentMax);
  }
}
