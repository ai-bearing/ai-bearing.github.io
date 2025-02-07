import java.util.*;
public class LinearSearchSimulator{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int[] nums = {1,2,3,4,5,6,7,8};
    boolean isInvalid = true;
    int validKey = -1;
    while(isInvalid){
      System.out.print("Please enter a number between 1 and 8: ");
      int key = input.nextInt();
      if (key <= 8 && key >= 1){
        validKey = key;
        isInvalid = false;
      }
      System.out.println();
    }
    int targetNum = -1;
    for(int i = 0; i < nums.length; i++){
      System.out.println("Is the number " + nums[i] + "?");
      if(nums[i] == validKey){
        System.out.println("Yes");
        targetNum = validKey;
        break;
      } else{
        System.out.println("No");
      }
    }
    if(targetNum > 0){
      System.out.println("Your number is " + targetNum);
    } else{
      System.out.println("Your number was not found.");
    }
  }
}
