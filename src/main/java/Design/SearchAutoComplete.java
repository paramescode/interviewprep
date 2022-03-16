package Design;

// https://leetcode.com/problems/design-search-autocomplete-system/submissions/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SearchAutoComplete {

    class Trie{
        Trie[] childs;
        int count;

        Trie(){
            this.childs = new Trie[27];
            this.count = 0;
        }

    }

    class Element{
        String sentence;
        int times;

        Element(String sentence, int times){
            this.sentence = sentence;
            this.times = times;
        }
    }

    StringBuilder query ;
    Trie root;
    Trie previous;

    public SearchAutoComplete(String[] sentences, int[] times) {
        root = new Trie();
        previous = root;
        query = new StringBuilder();

        for(int i=0; i < sentences.length;i++){
            insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c == '#'){
            insert(query.toString(), 1);
            query = new StringBuilder();
            previous = null;
            return res;
        }else{
            query.append(c);
            List<Element> elements = lookup(c);
            Collections.sort(elements, new Comparator<Element>(){

                public int compare(Element e1, Element e2){
                    if(e1.times == e2.times){
                        return e1.sentence.compareTo(e2.sentence);
                    }

                    return e2.times - e1.times;
                }
            });

            for(int i=0; i < Math.min(3, elements.size()); i++){
                res.add(elements.get(i).sentence);
            }
        }

        return res;
    }

    private List<Element> lookup(char c){
        List<Element> res = new ArrayList<>();

        if(previous == null && query.length() > 1){
            return res;
        }

        int index = c == ' ' ? 26 : c -'a';
        Trie current = previous == null ? root : previous;
        if(current.childs[index] == null){
            previous = null;
            return res;
        }
        previous = current.childs[index];
        traverse(query.toString(), res, previous);
        return res;
    }

    private void traverse(String qry, List<Element> res, Trie node){
        if(node.count > 0){
            res.add(new Element(qry, node.count));
        }

        for(int i=0;i < 27; i ++){
            if(node.childs[i] != null){
                String next = qry + (i == 26 ? ' ' : (char) ('a' + i) );
                //System.out.println(next);
                traverse(next, res, node.childs[i]);
            }
        }
    }

    private void insert(String sentence, int count){
        Trie t = root;
        for(int i=0; i < sentence.length(); i++){
            int index = sentence.charAt(i) == ' ' ? 26 : sentence.charAt(i) - 'a';
            if(t.childs[index] == null){
                Trie node = new Trie();
                t.childs[index] = node;
            }
            t = t.childs[index];
        }
        t.count += count;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */