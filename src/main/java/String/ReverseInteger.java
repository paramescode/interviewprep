package String;

public class ReverseInteger {

    public static int reverse(int x) {
        int res = 0;
        // record least significant digit in max/min Value
        int max_lsd = Integer.MAX_VALUE % 10;
        int min_lsd = Integer.MIN_VALUE % 10;

        System.out.println(max_lsd);
        System.out.println(min_lsd);

        while (x != 0){
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10){
                return 0;
            }
            res *= 10;

            if (res % 10 > Integer.MAX_VALUE - max_lsd || res < Integer.MIN_VALUE - min_lsd){
                return 0;
            };
            res += x % 10;
            x /= 10;
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(2147483647));
    }
}
