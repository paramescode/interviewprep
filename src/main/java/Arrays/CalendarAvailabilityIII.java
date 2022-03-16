package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//https://leetcode.com/problems/my-calendar-iii/submissions/
public class CalendarAvailabilityIII {


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

        public CalendarAvailabilityIII() {
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

        public int book(int start, int end) {
            int res = 0;
            List<Point> points = new ArrayList<>(events);
            points.add(new Point(start, Type.START));
            points.add(new Point(end, Type.END));
            Collections.sort(points, new PointsComparator());
            int count =0;
            for(Point p : points){
                if(p.type == Type.START)
                    count++;
                else
                    count--;
                if(count > 0)
                    res = Math.max(res, count);
            }
            events = points;
            return res;
        }
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

