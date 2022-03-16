package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalenderAvailabilityII {

    //https://leetcode.com/problems/my-calendar-ii/submissions/

        enum Type{
            START, END
        }

        class Point {
            int val;
            Type type;

            Point(int v, Type type){
                this.val = v;
                this.type = type;
            }

        }

        List<Point> events;

        public CalenderAvailabilityII() {
            this.events = new ArrayList<>();
        }

        class PointsComparator implements Comparator<Point> {

            public int compare(Point a, Point b){

                if(a.val == b.val){
                    if(a.type == b.type)
                        return 0;
                    else
                        return a.type == Type.END? -1 : 1;
                }

                return (a.val - b.val);
            }
        }

        public boolean book(int start, int end) {
            List<Point> points = new ArrayList<>(events);
            points.add(new Point(start, Type.START));
            points.add(new Point(end, Type.END));
            Collections.sort(points, new PointsComparator());
            int count = 0;
            for(Point p : points){
                if(p.type == Type.START)
                    count++;
                else
                    count--;
                if(count >=3)
                    return false;
            }
            events = points;
            return true;
        }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
