package Arrays.inplace;

import com.ibm.db2.jcc.am.li;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoList {


    public static void main(String[] args) {
        List<Character> l1 = new ArrayList<>();
        l1.add('a');
        l1.add('b');
        l1.add('c');
        l1.add('d');


        List<Character> l2 = new ArrayList<>();
        l2.add('1');
        l2.add('2');
        l2.add('3');
        l2.add('4');

        merge(l1,l2);

        l1.stream().forEach(x-> System.out.print(x + " "));
        System.out.println();
        l2.stream().forEach(x-> System.out.print(x + " "));

    }

    private static void merge(List<Character> l1, List<Character> l2){

        if(l1 == null || l1.size() ==0){
            return;
        }

        if(l2 == null || l2.size() ==0){
            return;
        }

        for(int i =1; i <= l1.size(); i = i +2){
            l1.add(i, l2.remove(0));

            if(l2.size() == 0)
                break;
        }


        return;

    }
}
