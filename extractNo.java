import java.util.*;
import java.util.regex.*;
class extractNo {


  public static void main(String[] args) {
    Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("i45love14you690");
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0;
        while(m.find()) {
            //System.out.println(m.group());
            arr.add(Integer.parseInt(m.group()));
            i++;
        }

        for(int num : arr)
        System.out.println(num);
  }
}


