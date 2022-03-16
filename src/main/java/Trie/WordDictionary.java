class WordDictionary {

    /** Initialize your data structure here. */
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(root == null || word == null || word.length() ==0)
            return;

        Node tcrwal = root;
        for(int i=0; i < word.length();i++){
            int index = word.charAt(i) - 'a';
            Node child = tcrwal.child[index];
            if(child == null){
                child = new Node();
                child.c = word.charAt(i);
                tcrwal.child[index] = child;
            }
            tcrwal = child;
        }

        tcrwal.isWord = true;
        return;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() ==0)
            return false;

        return search(word, root);
    }

    private boolean search(String word, Node node){
        if(word == null || word.length() ==0 || node == null)
            return false;

        Node tcrwal = node;
        //System.out.println(word);
        for(int i =0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                //System.out.println(i + " " + word.charAt(i));
                for(Node n : tcrwal.child){
                    if(n == null)
                        continue;
                    if(word.length() -1 == i )
                    {
                        if(n.isWord)
                            return true;
                        else
                            continue;
                    }else{
                        boolean res =  search(word.substring(i+1), n);
                        if(res)
                            return true;
                    }

                }
                return false;
            }
            int index = word.charAt(i) - 'a';
            Node child = tcrwal.child[index];
            //if(child != null)
            //System.out.println(child.c);

            if(child == null || child.c != word.charAt(i))
                return false;
            tcrwal = child;
        }

        if(tcrwal != null && tcrwal.isWord)
            return true;

        return false;
    }

    class Node{
        public char c;
        public Node[] child;
        public boolean isWord;

        Node(){
            child = new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */