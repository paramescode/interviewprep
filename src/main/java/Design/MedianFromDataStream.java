package Design;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/

/*Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.



Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2



Follow up:

    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?


* */

public class MedianFromDataStream {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeapLeft;
    PriorityQueue<Integer> minHeapRight;

    public MedianFromDataStream() {
        maxHeapLeft = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        minHeapRight = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeapLeft.isEmpty() && minHeapRight.isEmpty()){
            maxHeapLeft.add(num);
            return;
        }
        if(num <= maxHeapLeft.peek())
            maxHeapLeft.add(num);
        else
            minHeapRight.add(num);

        balance();
    }

    private void balance(){
        int diff = Math.abs(maxHeapLeft.size() - minHeapRight.size());

        if(diff <=1 ){
            return ;
        }
        if(maxHeapLeft.size() > minHeapRight.size())
            minHeapRight.add(maxHeapLeft.remove());
        else
            maxHeapLeft.add(minHeapRight.remove());
    }

    public double findMedian() {
        int size = maxHeapLeft.size() + minHeapRight.size();
        if(size % 2 == 0){
            return (1d * maxHeapLeft.peek() + minHeapRight.peek()) / 2;
        }

        return maxHeapLeft.size() > minHeapRight.size() ?  maxHeapLeft.peek() :minHeapRight.peek();
    }

    public static void main(String[] args) {

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */