package leetcode;

public class BackSpaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int iCounter = 0;
        int j = T.length() - 1;
        int jCounter = 0;
        while (i - iCounter >= 0 && j - jCounter >= 0) {
            if (S.charAt(i - iCounter) == '#') {
                iCounter++;
                continue;
            } else if (iCounter != 0) {
                i = i - (iCounter * 2);
                iCounter = 0;
                continue;
            }

            if (T.charAt(j - jCounter) == '#') {
                jCounter++;
                continue;
            } else if (jCounter != 0) {
                j = j - (jCounter * 2);
                jCounter = 0;
                continue;
            }

            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }

        while (i - iCounter >= 0) {
            if (S.charAt(i - iCounter) == '#') {
                iCounter++;
            } else if (iCounter == 0) {
                return false;
            } else {
                i = i - (iCounter * 2);
                iCounter = 0;
            }
        }

        while (j - jCounter >= 0) {
            if (T.charAt(j - jCounter) == '#') {
                jCounter++;
            } else if (jCounter == 0) {
                return false;
            } else {
                j = j - (jCounter * 2);
                jCounter = 0;
            }
        }

        return true;
    }
}
