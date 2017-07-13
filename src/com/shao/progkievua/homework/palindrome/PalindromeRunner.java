package com.shao.progkievua.homework.palindrome;

import java.util.Arrays;
import java.util.Random;

public class PalindromeRunner {
    public static void main(String[] args) {
        int[] nums = generateNumbersArray();
        int palindrome = getPalindrome(nums);

        System.out.println(Arrays.toString(nums));
        if (palindrome >= 0) System.out.println("Palindrome: " + palindrome);
        else System.out.println("No palindromes");
    }

    private static boolean isPalindrome(int num) {
        StringBuilder str1 = new StringBuilder().append(num);
        StringBuilder str2 = new StringBuilder().append(str1).reverse();
        return str1.toString().equals(str2.toString());
    }

    private static int[] generateNumbersArray() {
        Random random = new Random();
        int[] nums = new int[random.nextInt(20) + 5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        return nums;
    }

    private static int getPalindrome(int[] nums) {
        int palindromes = 0;
        int palindromeIndex = 0;
        int i = 0;
        while (i < nums.length && palindromes < 2) {
            if (isPalindrome(nums[i])) {
                palindromeIndex = i;
                palindromes++;
            }
            i++;
        }
        if (palindromes > 0) return nums[palindromeIndex];
        else return -1;
    }
}
