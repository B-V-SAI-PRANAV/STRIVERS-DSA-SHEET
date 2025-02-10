class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        return helper(arr);
    }

    private boolean helper(char[] arr) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                min = min + 1;
                max = max + 1;
            } else if (arr[i] == ')') {
                min = min - 1;
                max = max - 1;
            } else {
                min = min - 1;
                max = max + 1;
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }

        return min == 0;
    }
}
