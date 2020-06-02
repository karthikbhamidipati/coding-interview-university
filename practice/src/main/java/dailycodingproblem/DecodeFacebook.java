package dailycodingproblem;

/**
 * Number of ways to decode a string
 * a -> 1
 * b -> 2
 * c -> 3
 * .
 * .
 * .
 * z -> 26
 * <p>
 * Given a number print the number of ways to decode the string
 */
public class DecodeFacebook {

    public int ways(String number) {
        if (number == null || number.trim().equals("") || number.trim().equals("0")) {
            return 0;
        }
        int var1 = 1;
        int var2 = 1;
        int num = number.charAt(number.length() - 1) - '0';
        for (int i = number.length() - 2; i >= 0; i--) {
            num = num + ((number.charAt(i) - '0') * 10);
            if (num > 0 && num < 10) {
                var1 = var2;
            } else if (num <= 26) {
                int temp = var1 + var2;
                var1 = var2;
                var2 = temp;
            } else if (num % 10 == 0) {
                return 0;
            } else {
                var1 = var2;
            }
            num = num / 10;
        }
        return var2;
    }
}
