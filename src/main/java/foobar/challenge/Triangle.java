package foobar.challenge;

/***
 * Bunny Prisoner Locating
 =======================

 Keeping track of Commander Lambda's many bunny prisoners is starting to get tricky. You've been tasked with writing a program to match bunny prisoner IDs to cell locations.

 The LAMBCHOP doomsday device takes up much of the interior of Commander Lambda's space station, and as a result the prison blocks have an unusual layout. They are stacked in a triangular shape, and the bunny prisoners are given numerical IDs starting from the corner, as follows:

 | 7
 | 4 8
 | 2 5 9
 | 1 3 6 10

 Each cell can be represented as points (x, y), with x being the distance from the vertical wall, and y being the height from the ground.

 For example, the bunny prisoner at (1, 1) has ID 1, the bunny prisoner at (3, 2) has ID 9, and the bunny prisoner at (2,3) has ID 8. This pattern of numbering continues indefinitely (Commander Lambda has been taking a LOT of prisoners).

 Write a function solution(x, y) which returns the prisoner ID of the bunny at location (x, y). Each value of x and y will be at least 1 and no greater than 100,000. Since the prisoner ID can be very large, return your solution as a string representation of the number.

 Languages
 =========

 To provide a Java solution, edit Solution.java
 To provide a Python solution, edit solution.py

 Test cases
 ==========
 Your code should pass the following test cases.
 Note that it may also be run against hidden test cases not shown here.

 -- Java cases --
 Input:
 Solution.solution(3, 2)
 Output:
 9

 Input:
 Solution.solution(5, 10)
 Output:
 96
 *
 *
 *
 *
 */
public class Triangle {

    public static String solution(long x, long y){

        //long[] xAxis = new long[1000];
        //xAxis[0] = 0;
        long xpos = 0;
        long preValue = 0;
        for (int index = 1; index <= x; index++) {
          //  xAxis[index] = xAxis[index - 1] + index;
            preValue = xpos;
            xpos += index;

        }

       /* for (Long value: xAxis) {
            //System.out.print(value + " ");
        }*/

        //long xpos = xAxis[x];
        long diff = xpos - preValue;

        for(int yPos= 1; yPos < y ; yPos ++){ // xaixs is at position so , starts from 1
            xpos = diff+ xpos;
            diff++;
        }

        System.out.println(xpos);

        return String.valueOf(xpos);
    }

    public static void main(String[] args) {
        solution(3,2);
    }
}
