class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toLowerCase().toCharArray()) {
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        int i = 0;
        int j = sb.length() - 1;
        while(i <= j) {
            if(sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            } else return false;
        }

        return true;
    }
}