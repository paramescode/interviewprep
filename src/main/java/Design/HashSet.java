package Design;


class HashSet {

    class Element{
        int value;
        Element next;

        Element(int val){
            this.value = val;
        }
    }
    /** Initialize your data structure here. */

    private Element[] elements ;
    public HashSet() {
        elements = new Element[1000];
    }

    public void add(int key) {

        if(contains(key))
            return ;
        int index = hashCode(key);
        Element e = new Element(key);
        Element head = elements[index];
        if(head == null){
            elements[index] = e;
            return;
        }

        while(head.next != null){
            head = head.next;
        }
        head.next = e;
        return;

    }

    public void remove(int key) {
        if(!contains(key))
            return;

        int index = hashCode(key);
        Element head = elements[index];
        if(head.value == key){
            elements[index] = head.next;
            return;
        }
        Element t = head;
        while(t.next != null){
            if(t.next.value == key){
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
        //elements[index] = head;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashCode(key);
        Element head = elements[index];

        if(head == null)
            return false;

        if(head.value == key)
            return true;

        while(head.next != null){
            if(head.next.value == key)
                return true;
            head = head.next;
        }

        return false;
    }

    private int hashCode(int key){
        return key % 1000;
    }


}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
