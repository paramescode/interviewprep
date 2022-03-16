package Arrays;

public class CalenderAvailability {


    //          930 -------------- 1230
 //800 --- 845
 // 800 --------930
 // 800 -------------1000
     //         930 ----- 1000
    //              935----------1225
    //                             1230 ----- 1330
    //                         1215 --------1300
                                                    //1400 -- 1500

    public static boolean isAvailable(int[][] meetings, int startTime, int endTime){

      // iterate over the schduled meetings
        //for each meeting compare the
        // startTime < schduledStartTime && enfTime <= schduledStartTime
        //startTime >= schduledStartTime && (endTime <= schduledEndTime  ||  endTime >= schduledEndTime)-- return false
        //startTime >= schduledEndTime

        for(int[] meeting : meetings){
            if(startTime < meeting[0] && endTime > meeting[0] &&
                    (endTime < meeting[1] || endTime > meeting[1])){
                return false;
            }

            if(startTime >= meeting[0] && (endTime <= meeting[1]))
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        int[][] meetings = { {1300, 1330}, {1330, 1430}, {900, 1130} };

        System.out.println(isAvailable(meetings, 1000, 1100));

        System.out.println(isAvailable(meetings, 1345, 1400));

        System.out.println(isAvailable(meetings, 800, 1000));

        System.out.println(isAvailable(meetings, 800, 900));

        System.out.println(isAvailable(meetings, 800, 1200));

        System.out.println(isAvailable(meetings, 1500, 1600));

        System.out.println(isAvailable(meetings, 730, 1300));




    }
}
