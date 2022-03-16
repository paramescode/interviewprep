package Hashtable;

public class Hastable {

    public class HashEntry{

        public String key;
        public String value;
        public HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;

        }
    }

    private final int MAX_ELEMENTS = 10;
    private HashEntry [] entries = new HashEntry[MAX_ELEMENTS];
    private int size ;

    public void put(String key, String value){

        if (key == null)
            return;

        int hashCode = getHashCode(key);

        if(entries[hashCode] == null)
            entries[hashCode] = createHashEntry(key, value);
        else{

            HashEntry head = entries[hashCode];
            while(head.next != null){
                head = head.next;

            }
            head.next = createHashEntry(key, value);
        }

    }

    public HashEntry get(String key){

        if (key == null || entries[getHashCode(key)] == null)
            return null;

        HashEntry entry = entries[getHashCode(key)];
        while( ! entry.key.equalsIgnoreCase(key)){
            entry = entry.next;

        }
        return entry;
    }

    private int getHashCode(String key){

        int hashCode = key.hashCode();
        hashCode = hashCode % MAX_ELEMENTS;
        return hashCode;

    }

    private HashEntry createHashEntry(String key, String value){
        HashEntry hashEntry = new HashEntry(key, value);
        return hashEntry;
    }

}
