package intervals;



    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
    class Rally {
        public static int solution(String S) {
            // write your code in Java SE 8
            String[] weekDays = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat" , "Sun"};

            int res = 0;
            String[] meetings = S.split("\\n");
            //System.out.println(meetings.length);
            //System.out.println(meetings[0]);

            Map<String, List<Meeting>> calendar = new HashMap<>();
            for(String meeting : meetings){
                String[] values = meeting.split(" ");
                calendar.putIfAbsent(values[0], new ArrayList<>());
                calendar.get(values[0]).add(new Meeting(values[1]));
            }

            for(String key : weekDays ){
                if(calendar.get(key) == null)
                    continue;

                Collections.sort(calendar.get(key), new Comparator<Meeting>(){
                    public int compare(Meeting m1, Meeting m2){
                        
                        return m1.startMin - m2.startMin;
                    }

                });
            }

            int preMeetingEnd = 0, freeTime =0, ftInStart = 0, ftInEnd =0;
            for(String key : weekDays){
                List<Meeting> meetingsOnDay = calendar.get(key);


                if(meetingsOnDay == null || meetingsOnDay.size() ==0){
                    ftInEnd += 1440;
                }
                int size  =meetingsOnDay.size();

                for(int i=0; i < size; i++){
                    Meeting m = meetingsOnDay.get(i);
                    if(i == 0){
                        ftInStart =  m.startMin;
                        preMeetingEnd = m.endMin;
                        res = Math.max(res, ftInStart + ftInEnd);
                        if(size -1 == 0)
                            ftInEnd = 1440 - m.endMin;
                        else
                            ftInEnd =0;
                        continue;
                    }

                    freeTime = m.startMin - preMeetingEnd;
                    preMeetingEnd = m.endMin;
                    res = Math.max(res, freeTime);

                    if(i == size -1){
                        ftInEnd =  1440 - m.endMin;
                        preMeetingEnd = m.endMin;
                        res = Math.max(res, ftInEnd);
                    }

                }

            }

            return res;
        }

        static class Meeting{

            int startHr;
            int startMin;
            int endHr;
            int endMin;
            int totalMins ;

            Meeting(String meeting){
                String[] hrs = meeting.split("-");
                String[] startTime = hrs[0].split(":");
                String[] endTime = hrs[1].split(":");

                this.startHr = Integer.parseInt(startTime[0]);
                this.startMin = (startHr * 60 ) + Integer.parseInt(startTime[1]);

                this.endHr = Integer.parseInt(endTime[0]);
                this.endMin = ((endHr) * 60 ) + Integer.parseInt(endTime[1]);

                //System.out.println(meeting + " " + startMin + " " + endMin);

            }
        }

        public static void main(String[] args) {

            String s = "Mon 01:00-23:00\n" +
                    "Tue 01:00-23:00\n" +
                    "Wed 01:00-23:00\n" +
                    "Thu 01:00-23:00\n" +
                    "Fri 01:00-23:00\n" +
                    "Sun 01:00-21:00";
            System.out.println(solution(s));
        }


}
