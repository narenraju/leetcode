//Reference : https://leetcode.com/problems/super-palindromes/discuss/174835/tell-you-how-to-get-all-super-palindrome(detailed-explanation)
// Intuition behind logic
// we can construct in two steps:

// Get all palindrome number < 10^9 in res(because the input < 10^18)
// Traverse each number in res,determin whether the square is a palindrome
// The first question is how to approach the first step, apparently we cannot traverse all number because 10^9 is too large. The key is 'construct it' instead of 'judge it one by one'.

// Every palindrome number can be divided into 3 part, I call it left part, middle part and right part. For instance, 12121 can be divided into '12', '1', '21', corresponding left part, middle part, right part. As for 123321, it can be divided into '123', '', '321'.

// For each single number x, we can construct 11 palindrome number, which are xx,x0x,x1x,..,x9x, and that is what we need.


class Solution {
    public int superpalindromesInRange(String L, String R) {
        List<Long> palindromes = new ArrayList<>();
        long low = Long.parseLong(L);
        long high = Long.parseLong(R);
        int res = 0;
        for (long i = 1; i <= 9; i++) {
            palindromes.add(i);
        }
        for (long i = 1; i < 10000; i++) {
            String left = Long.toString(i);
            String right = new StringBuilder(left).reverse().toString();
            palindromes.add(Long.parseLong(left + right));
            for (long d = 0; d < 10; d++) {
                palindromes.add(Long.parseLong(left + d + right));
            }
        }
        for (long palindrome : palindromes) {
            long square = palindrome * palindrome;
            if (!isPalindrome(Long.toString(square))) {
                continue;
            }
            if (low <= square && square <= high) {
                res++;
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
