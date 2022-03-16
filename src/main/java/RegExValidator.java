import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExValidator {

    public static void main(String args[]){

        String input = "apt_2";
        // Regexe to be matched
        String regexe = "^[a-zA-Z0-9\\.\\ \\-\\'\\#\\/]+";

        // Step 1: Allocate a Pattern object to compile a regexe
        Pattern pattern = Pattern.compile(regexe);
        //Pattern pattern = Pattern.compile(regexe, Pattern.CASE_INSENSITIVE);  // case-insensitive matching

        // Step 2: Allocate a Matcher object from the compiled regexe pattern,
        //         and provide the input to the Matcher
        Matcher matcher = pattern.matcher(input);

        System.out.println(matcher.matches());

        System.out.println(formatAmountForDisplay("$2,370.60", true));
        System.out.println(formatAmountForDisplay("2,370.60", false));

    }

    public static double formatAmountForDisplay(String amount, boolean noFractionDigits) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(2);
        if (null != amount ) {
            if (noFractionDigits) {
                numberFormat.setMaximumFractionDigits(0);
            }
            //return numberFormat.format(Double.parseDouble(amount));

            try{
                return numberFormat.parse(amount).doubleValue();
            }catch (ParseException pe){
                pe.printStackTrace();
            }
        }

        return 0;
    }
}
