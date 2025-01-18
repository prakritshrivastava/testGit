import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {

    public static void main(String[] args) {

        ArrayList<String> al1 = new ArrayList<>();
        al1.add("abcd");
        al1.add("1234");

        ArrayList<String> al2 = new ArrayList<>();
        al2.add("jklm");
        al2.add("5678");

        al2.addAll(1,al1);

        for(String element:al2){
            System.out.println("Elements : "+element);
        }

        ArrayList<String> cloneList = (ArrayList<String>)al1.clone();
        System.out.println("Clone List:"+cloneList);

        System.out.println(al1.contains("abcd"));
        System.out.println(al2.indexOf("5678")>0);

        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(numberList.removeIf(sum->sum%2==0));
        System.out.println("Number list: "+numberList);

        ArrayList<String> nameslist = new ArrayList<>(Arrays.asList("Naveen","Tom","Peter","Lisa","Tom"));
        nameslist.retainAll(Collections.singleton("Tom"));
        System.out.println("Names List: "+nameslist);

        Object[] arr = nameslist.toArray();
        for (Object a: arr){
            System.out.println("Element:"+a.toString());
        }
    }

}
