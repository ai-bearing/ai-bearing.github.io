import java.util.*;
public class PlayingWithArrays{
  public static void main(String[] args){
    List<Integer> a = new ArrayList<>();
    a.add(10);
    a.add(11);
    a.add(12);
    System.out.println(a);
    a.set(0,20);
    System.out.println(a.get(0));

    int[] b = {30,31,32};
    System.out.println(b[0]);
    System.out.println(Arrays.toString(b));
  }
}
