

### Generate All Subsets Of A Set

'''java
  static ArrayList<String> generate_all_subsets(String s) {
        ArrayList<String> result = new ArrayList<String>();
        
        helper(s, new StringBuilder(), 0, result);
        
        return result;
    }

    static void helper(String s, StringBuilder prefix, int idx, ArrayList<String> result){
        if (idx == s.length()){
            result.add(prefix.toString());
            return;
        }
        
        //general worker
        helper(s, prefix, idx+1, result);
        helper(s, prefix.append(s.charAt(idx)), idx+1, result);
        prefix.deleteCharAt(prefix.length()-1);

    }
'''

### Palindromic Decomposition Of A String
Find all palindromic decompositions of a given string s.

A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.

Example
```json
{
"s": "abracadabra"
}
```
Output:

["a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a", "a|b|r|a|c|a|d|a|b|r|a"]


```java
static ArrayList<String> generate_palindromic_decompositions(String s) {
        ArrayList<String> result = new ArrayList<String>();
        helper(s, new StringBuilder(s.substring(0,1)), 1, "" + s.charAt(0), result);
        return result;
    }
    
    static void helper(String s, StringBuilder slate, int idx, String lastString, ArrayList<String> result){
        if (idx == s.length()){
            if (isPalindrom(lastString))
                result.add(slate.toString());
            return;
        }
        
        helper(s, slate.append(s.charAt(idx)),idx+1, lastString+s.charAt(idx), result);
        slate.deleteCharAt(slate.length()-1);
        
        if( isPalindrom(lastString)){
            helper(s, slate.append("|").append(s.charAt(idx)), idx+1, "" + s.charAt(idx), result);
            slate.deleteCharAt(slate.length()-1);
            slate.deleteCharAt(slate.length()-1);
        }
    }
    
    static boolean isPalindrom(String s){
        int n = s.length();
        for (int i=0; i<n; i++){
            if (s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    
    ```



### Possible To Achieve Target Sum
Given a set of integers and a target value k, find whether there is a non-empty subset that sums up to k.

##### Example One

```json
{
"arr": [2, 4, 8],
"k": 6
}
```
Output:
1
Because 2 + 4 = 6.

```java
    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {

        return helper(arr, k, 0);
    }
    
    static Boolean helper(ArrayList<Long> arr, Long k, int idx){
        if (idx == arr.size()){
            return false;
        }
        
        if (k.equals(arr.get(idx))){
            return true;
        }
        
        if (helper(arr, k, idx+1))
            return true;
        
        return helper(arr, k-arr.get(idx), idx+1);
    }

```

### Find All Well-formed Brackets

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


```java
  static ArrayList<String> find_all_well_formed_brackets(Integer n) {
        ArrayList<String> result = new ArrayList<String>();
        helper(n, n, 0,"", result);
        return result;
    }
    
    static void helper(Integer n, int left, int right, String slate, ArrayList<String> result){
        if (left == 0 && right == 0){
            result.add(slate);
            return;
        }
        
        if (left > 0){
            helper(n, left-1, right+1, slate + "(", result);
        }
        
        if (right > 0)
            helper(n, left, right-1, slate+")", result);
    }


```

### How Many Binary Search Trees With N Nodes

Write a function that returns the number of distinct binary search trees that can be constructed with n nodes. For the purpose of this exercise, do solve the problem using recursion first even if you see some non-recursive approaches.

Example
```json
{
"n": 2
}
```
Output:

2
Suppose the values are 1 and 2, then the two trees that are possible are

   (2)            (1)
  /       and       \
(1)                  (2)

```java
    static Long how_many_bsts(Integer n) {
        if (n == 0 || n == 1) return 1l;
        
        Long bsts = 0l;
        for (int i=1; i<=n; i++){
            bsts += how_many_bsts(i-1) * how_many_bsts(n-i);
        }
        return bsts;
    }

```

