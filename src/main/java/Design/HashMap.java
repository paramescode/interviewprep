package Design;

import java.util.*;

class HashMap {

    /** Initialize your data structure here. */

    class Element{
        int key;
        int value;

        Element(int k, int v){
            this.key = k;
            this.value  =v;
        }
    }

    private Element[] elements ;
    public HashMap() {
        elements = new Element[100];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        if(key >=  elements.length){
            elements = Arrays.copyOf(elements, key  +5);
        }

        if(elements[key] != null){
            elements[key].value = value;
        }else{
            Element e = new Element(key, value);
            elements[key] =e;
        }


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key > elements.length || elements[key] == null)
            return -1;
        return elements[key].value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(key > elements.length || elements[key] == null)
            return ;
        elements[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
