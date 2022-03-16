import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by m655222 on 1/3/2018.
 */
public class ListTest {

    public static void main(String args[]){

        List list = new ArrayList<String>();

        //list.add("1");
        list.add("2");
       // list.add("3");
       // list.add("4");

        Iterator ite = list.iterator();
        while(ite.hasNext()){
            String s = (String)ite.next();
            if(s.equalsIgnoreCase("2")){
                ite.remove();
            }

        }
        System.out.println("Size ::: "+ list.size());


    }
}
