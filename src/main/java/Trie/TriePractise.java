package Trie;

public class TriePractise {

    private int CHILDREN_SIZE = 26;

    class Node{

        Node children[] ;


        boolean isWord ;

        Node(){
            this.isWord = false;
            this.children = new Node[CHILDREN_SIZE];
        }
    }

    private Node root;

    public TriePractise(){
        this.root = new Node();
    }

    public  void insert(String s){

        if(s.isEmpty())
            return ;

        Node tCrawl = root;

        for(int l=0; l < s.length() ; l ++){

            int index = s.charAt(l) - 'a';
            if(tCrawl.children[index] == null)
                tCrawl.children[index] = new Node();

            tCrawl = tCrawl.children[index];
        }
        tCrawl.isWord = true;

    }

    public boolean search(String s){

        if(s == null || s.isEmpty())
            return false;

        Node tCrawl = root;

        for(int i=0; i < s.length() ; i ++){
            int index = s.charAt(i)  - 'a';
            if(tCrawl.children[index] == null)
                return false;
            tCrawl = tCrawl.children[index];

        }

        return (tCrawl != null && tCrawl.isWord);

    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        TriePractise trieNode = new TriePractise();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            trieNode.insert(keys[i]);

        // Search for different keys
        if(trieNode.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(trieNode.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(trieNode.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(trieNode.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }






}
