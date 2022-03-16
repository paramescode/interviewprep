package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWord {

        public static String replaceWords(List<String> dict, String sentence) {

            Node trie = new Node('0');

            populateRoot(trie, dict);

            String[] arr  = sentence.split(" ");

            Set<String> ndict = getShortestRoot(trie, dict);
            for(String s : ndict){
                for(int i=0; i < arr.length; i++){
                    if(arr[i].startsWith(s)){
                        arr[i] = new String(s);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String s : arr){
                sb.append(s);
                sb.append(" ");
            }

            return sb.toString().trim();
        }

        static class Node{
            Node[] child;
            char c ;
            boolean isRoot;

            Node(char c){
                this.c = c;
                child = new Node[26];
                isRoot = false;
            }
        }

        private static void populateRoot(Node trie, List<String> dict){


            for(String s : dict){
                Node root = trie;
                for(char c : s.toCharArray()){
                    if(root.child[c - 'a'] == null){
                        Node n = new Node(c);
                        root.child[c - 'a'] = n;
                        root = n;
                        //System.out.print(c);
                    }else
                        root = root.child[c - 'a'];
                }
                System.out.println(root.c);
                root.isRoot = true;
            }
        }

        private static Set<String> getShortestRoot(Node trie, List<String> dict){
            Set<String> res = new HashSet<>();
            for(String s : dict){
                Node t = trie.child[s.charAt(0) - 'a'];
                StringBuilder sb = new StringBuilder();
                for(char c : s.toCharArray()){
                    if(t.child[c - 'a']!= null)
                        t = t.child[c - 'a'];
                    sb.append(c);
                    //System.out.println(c);
                    if(t.isRoot){
                        res.add(sb.toString());
                        System.out.println(sb.toString());
                        break;
                    }


                }
            }
            System.out.println(res.size());
            return res;
        }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("bat");
        words.add("rat");
        words.add("ca");

        System.out.println(replaceWords(words, "the cattle was rattled by the battery"));
    }

}
