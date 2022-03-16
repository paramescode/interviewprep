package Design;


/*
* You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.

Design a log storage system to implement the following functions:

void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.

int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

Example 1:

put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.

Note:

    There will be at most 300 operations of Put or Retrieve.
    Year ranges from [2000,2017]. Hour ranges from [00,23].
    Output for Retrieve has no order required.

*
* */
import java.util.*;
import java.util.HashMap;
class LogSystem {

    List<LogElement> logs ;
    Map<String, Integer> map;

    public LogSystem() {
        logs =  new ArrayList<>();
        map = new HashMap<>();

        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second" , 19);


    }

    public void put(int id, String timestamp) {
        LogElement le = new LogElement(id, timestamp);
        logs.add(le);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        List<Integer> res = new ArrayList<>();
        for(LogElement log : logs){
            if(log.timestamp.substring(0, index).compareTo(s.substring(0, index)) >=0 &&
                    log.timestamp.substring(0, index).compareTo(e.substring(0, index)) <= 0)
                res.add(log.id);
        }

        return res;
    }

    class LogElement{
        int id;
        String timestamp;

        LogElement(int id, String timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {

    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */