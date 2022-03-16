import java.time.DayOfWeek;
import java.util.Date;

public class EnumTest {

    public enum Operation {
        PLUS,
        MINUS,
        TIMES,
        DIVIDE;

        double calculate(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }

    }


    public enum WhoisRIR {
        ARIN("whois.arin.net"),
        RIPE("whois.ripe.net"),
        APNIC("whois.apnic.net"),
        AFRINIC("whois.afrinic.net"),
        LACNIC("whois.lacnic.net"),
        JPNIC("whois.nic.ad.jp"),
        KRNIC("whois.nic.or.kr"),
        CNNIC("ipwhois.cnnic.cn"),
        UNKNOWN("");

        private String url;

        WhoisRIR(String url) {
            this.url = url;
        }

        public String url() {
            return url;
        }
    }

    public enum DAYS{
        SUNDAY(0), MONDAY(1);

        private int day;

        DAYS(int day){
            this.day=day;
        }

        public int getDay(){
            return day;
        }

    }

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.calculate(1,2));
        DAYS day = DAYS.valueOf("MONDAY");
        System.out.println(day.getDay() + day.toString());


    }

}
