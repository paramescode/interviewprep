package Trie;

class Trie {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;

        Node tcrwal = root;
        for(int i=0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            Node child  = tcrwal.child[index];
            if( child == null){
                child = new Node();
                child.c = word.charAt(i);
                tcrwal.child[index] = child;
            }
            tcrwal = child;
        }
        tcrwal.isWord = true;
        return;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0 || root == null)
            return false;

        Node tcrwal = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node child = tcrwal.child[index];
            if (child == null || child.c != word.charAt(i))
                return false;
            tcrwal = child;
        }
        if (tcrwal != null && tcrwal.isWord)
            return true;

        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        if (word == null || word.length() == 0 || root == null)
            return false;

        Node tcrwal = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node child = tcrwal.child[index];
            if (child == null || child.c != word.charAt(i))
                return false;
            tcrwal = child;
        }

        return true;
    }

    class Node {
        public char c;
        public Node[] child;
        public boolean isWord;

        Node() {
            child = new Node[26];
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));

        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}