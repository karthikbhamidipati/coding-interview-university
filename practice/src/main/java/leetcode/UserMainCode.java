package leetcode;

public class UserMainCode {
    public String processWords(String input1, int input2) {
        String[] words = input1.split(" ");
        String number = Integer.toString(input2);
        StringBuilder result = new StringBuilder();
        for (char c : number.toCharArray()) {
            int index = c - '1';
            result.append(transformString(words[index]));
            result.append(" ");
        }
        return result.toString().trim();
    }

    private String transformString(String word) {
        int left, right;
        if (word.length() % 2 != 0) {
            left = right = word.length() / 2;
        } else {
            right = word.length() / 2;
            left = right - 1;
        }
        StringBuilder transformedString = new StringBuilder();
        transformedString.append(word, 0, left + 1);
        transformedString.reverse();
        transformedString.append(word.substring(right));

        return transformedString.toString();
    }

    public static void main(String[] args) {
        UserMainCode obj = new UserMainCode();
        System.out.println(obj.processWords("Today is a nice day", 41));
    }
}
