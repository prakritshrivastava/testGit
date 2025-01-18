import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class syncTest {

    public static void main(String[] args) {

        List<String> syncList1 = Collections.synchronizedList(new ArrayList<>());

        //Sync not required for adding or removing
        syncList1.add("ABC");
        syncList1.add("123");
        syncList1.add("ABC123");

        //Synchronization is only required for iterating
        synchronized (syncList1){

            for(String ele:syncList1){
                System.out.println("Element:"+ele);
            }
        }


        //below type is same as arraylist and no need to explicitly specify synchronization for the same
        CopyOnWriteArrayList<String> arrList2 = new CopyOnWriteArrayList<String>();
        arrList2.add("ret");
        arrList2.add("ter");
        arrList2.forEach(ele-> System.out.println(ele));

    }


}
