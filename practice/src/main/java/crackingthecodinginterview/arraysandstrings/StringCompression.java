package crackingthecodinginterview.arraysandstrings;

public class StringCompression {
    public String compress(String str) {
        if (str == null || str.length() <= 2) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (prev == curr) {
                count++;
            } else {
                sb.append(prev);
                sb.append(count);
                count = 1;
                prev = curr;
            }
        }
        sb.append(prev);
        sb.append(count);

        return sb.length() >= str.length() ? str : sb.toString();
    }
}
