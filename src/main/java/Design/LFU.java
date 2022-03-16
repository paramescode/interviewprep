package Design;

import java.util.HashMap;
import java.util.Map;

public class LFU {

    class Node{
        int key;
        int value;
        int count;

        Node next;
        Node prev;

        Node(int  k, int v){
            this.key = k;
            this.value = v;
            count =1;
        }
    }

    class DLL{

        Node head;
        Node tail;
        int size;

        DLL(){

            head= new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            head.prev =tail;
            tail.next = head;
            tail.prev = head;
            size =0;
        }

        public void addHead(Node node){
            Node next = head.next;
            node.next = next;
            node.prev = head;
            next.prev = node;
            head.next = node;
            size++;

        }

        public void remove(Node node){
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public void removeTail(){
            remove(tail.prev);
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLL> freqMap;
    int capacity;
    int size;
    int maxFreq;

    LFU(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();

        size =0;
        maxFreq = 0;
    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null)
            return -1;

        int currFreq = node.count;
        DLL currFreqList  = freqMap.get(currFreq);
        currFreqList.remove(node);

        int nextFreq = currFreq + 1;
        node.count++;
        DLL nextFreqList = freqMap.getOrDefault(nextFreq, new DLL());
        nextFreqList.addHead(node);
        map.put(key, node);

        freqMap.put(currFreq, currFreqList);
        freqMap.put(nextFreq, nextFreqList);

        maxFreq = Math.max(maxFreq, nextFreq);

        return node.value;

    }

    public void put(int key, int value){

        if(this.capacity == 0)
            return;

        Node node = new Node(key, value);
        Node curr = map.get(key);
        if(curr != null){
            int currFreq = curr.count;
            DLL currFreqList = freqMap.getOrDefault(currFreq, new DLL());
            currFreqList.remove(curr);
            curr.count++;
            curr.value = value;

            int nextFreq = currFreq  +1;
            DLL nextFreqList = freqMap.getOrDefault(nextFreq, new DLL());
            nextFreqList.addHead(curr);

            map.put(key, curr);
            freqMap.put(currFreq, currFreqList);
            freqMap.put(nextFreq, nextFreqList);
            return;
        }

        DLL list = freqMap.getOrDefault(1, new DLL());
        list.addHead(node);
        map.put(key, node);
        freqMap.put(1, list);
        size++;

        if(size > capacity){
            if(list.size >  1){
                Node tail = list.tail.prev;
                list.removeTail();
                map.remove(tail.key);
            }else{
                for(int i=2; i <=maxFreq; i++){
                    DLL nextFreqList = freqMap.get(i);
                    if(nextFreqList != null && nextFreqList.size > 0){
                        Node tail = nextFreqList.tail.prev;
                        nextFreqList.removeTail();
                        map.remove(tail.key);
                        break;
                    }

                }
            }
            size --;
        }


    }

    public static void main(String[] args) {
        LFU cache = new LFU( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
