package Design;

//https://leetcode.com/problems/design-compressed-string-iterator/submissions/

/*
* Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

*
* */

public class CompressedStringIterator {

        int index;
        int count;
        String compressedString;
        char c ;

        public CompressedStringIterator(String compressedString) {
            this.compressedString = compressedString;
            this.index =0;
            this.count = 0;
        }

        public char next() {
            if(count ==0){
                if(index >= compressedString.length())
                    return ' ';
                c = compressedString.charAt(index);
                index++;
                while(index < compressedString.length() && Character.isDigit(compressedString.charAt(index))){
                    count = count * 10 + compressedString.charAt(index) -'0';
                    index++;
                }
            }
            count --;
            return c;
        }

        public boolean hasNext() {
            return index < compressedString.length() || count > 0;
        }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


