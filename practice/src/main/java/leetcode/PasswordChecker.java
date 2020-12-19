package leetcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PasswordChecker {
    /**
     *
     * karthik
     *
     * num_cont_vowels
     * num_cont_cons
     *
     * prev_char
     *
     */

    public static void main(String[] args) {
        PasswordChecker checker = new PasswordChecker();
        System.out.println(checker.validatePasswords("C:\\Users\\vamsh\\IdeaProjects\\coding-interview-university\\file"));
    }


    private String validatePasswords(String path) {
        StringBuilder result = new StringBuilder();
        try {
            List<String> passwords = Files.readAllLines(Paths.get(path));
            for (String password : passwords) {
                if (password.toLowerCase().equals("end")) {
                    break;
                } else if (validatePassword(password.toLowerCase())) {
                    result.append(String.format("<%s> is acceptable.", password));
                } else {
                    result.append(String.format("<%s> is not acceptable.", password));
                }
                result.append("\n");
            }
        } catch (IOException ie) {
            System.out.println("Invalid path : " + path);
            ie.printStackTrace();
        }
        return result.toString();
    }

    private boolean validatePassword(String password) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int num_cont_vowels = vowels.contains(password.charAt(0)) ? 1 : 0; // 0
        int num_cont_cons = num_cont_vowels == 0 ? 1 : 0; // 1
        for (int i = 1; i < password.length(); i++) {
            char curr = password.charAt(i);
            if (curr == password.charAt(i - 1) && curr != 'e' && curr != 'o') {
                return false;
            } else if (vowels.contains(curr)) {
                num_cont_vowels++;
                num_cont_cons = 0;
            } else {
                num_cont_cons++;
                num_cont_vowels = 0;
            }

            if (num_cont_vowels >= 3 || num_cont_cons >= 3) {
                return false;
            }
        }
        return true;
    }
}
