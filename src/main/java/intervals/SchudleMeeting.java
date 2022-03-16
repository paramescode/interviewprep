package intervals;

import java.util.*;

/**
 *Given M busy-time slots of N people, You need to print all the available time slots when all the N people can schedule a meeting for a duration of K minutes.

 Event time will be of form HH MM ( where 0 <= HH <= 23 and 0 <= MM <= 59 ), K will be in the form minutes.

 Input Format:

 M K [ M number of busy time slots , K is the duration in minutes ]

 Followed by M lines with 4 numbers on each line.

 Each line will be of form StartHH StartMM EndHH EndMM  [ Example 9Am-11Am time slot will be given as 9 00 11 00 ]

 An event time slot is of form [Start Time, End Time ) . Which means it inclusive at start time but doesn’t include the end time.

 So an event of form 10 00  11 00 => implies that the meeting start at 10:00 and ends at 11:00, so another meeting can start at 11:00.

 Sample Input:

 5 120

 16 00 17 00

 10 30 14 30

 20 45 22 15

 10 00 13 15

 09 00 11 00

 Sample Output:

 00 00 09 00

 17 00 20 45

 Sample Input:

 8 60

 08 00 10 15

 22 00 23 15

 17 00 19 00

 07 00 09 45

 09 00 13 00

 16 00 17 45

 12 00 13 30

 11 30 12 30

 Sample Output:

 00 00 07 00

 13 30 16 00

 19 00 22 00

 Constraints :

 1 <= M <= 100

 **Note: **24 00 has to be presented as 00 00.
 * */

public class SchudleMeeting {

    static class Meeting{
        int startMin;
        int endMin;

        Meeting(int s, int e){
            this.startMin = s;
            this.endMin = e;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        List<int[]> inputs = new ArrayList<>();
        while(N > 0){
            int[] m = new int[4];
            m[0] = scanner.nextInt();
            m[1] = scanner.nextInt();
            m[2] = scanner.nextInt();
            m[3] = scanner.nextInt();
            inputs.add(m);
            N--;
        }

        List<Meeting> meetings = new ArrayList<>();
        for(int[] in : inputs){
            System.out.println(in[0] + " " + in[1] + "-" + in[2] + " " + in[3] );
            Meeting meeting = new Meeting(60 * in[0] + in[1], 60 * in[2] + in[3]);
            meetings.add(meeting);
        }

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.startMin - o2.startMin;
            }
        });

        int freeTime = Integer.MAX_VALUE;
        N  = meetings.size();

        List<int[]> res = new ArrayList<>();

        int diff =0;
        for(int i=0; i < meetings.size() ; i++){
            if(i ==0){
                diff = meetings.get(0).startMin;
                if(diff >= K){
                    int[] r = new int[4];
                    r[2] = meetings.get(0).startMin / 60;
                    r[3] = meetings.get(0).startMin % 60;
                    res.add(r);
                }
                continue;
            }


            diff = meetings.get(i).startMin - meetings.get(i -1).endMin;
            if(diff >= K){
                int[] r = new int[4];
                r[0] = meetings.get(i -1).endMin / 60;
                r[1] = meetings.get(i -1).endMin % 60;
                r[2] = meetings.get(i).startMin / 60;
                r[3] = meetings.get(i).startMin % 60;
                res.add(r);
            }

            if(i == N -1){
                diff = 1440 - meetings.get(N -1).endMin;
                if(diff >= K){
                    int[] r = new int[4];
                    r[0] = meetings.get(N -1).endMin / 60;
                    r[1] = meetings.get(N -1).endMin % 60;

                    res.add(r);
                }

            }

        }


        for(int[] r : res){

            System.out.print(r[0] < 10 ? ("0"+r[0] + " ") : r[0] +" ");
            System.out.print(r[1] < 10 ? ("0"+r[1] + " ") : r[1] +" ");
            System.out.print(r[2] < 10 ? ("0"+r[2] + " ") : r[2] +" ");
            System.out.print(r[3] < 10 ? ("0"+r[3] + " ") : r[3] +" ");
            System.out.println();
        }
        //System.out.println(N + " " + K);
    }


}
