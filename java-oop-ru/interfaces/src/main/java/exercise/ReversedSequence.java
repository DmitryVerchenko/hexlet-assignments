package exercise;

import java.util.stream.IntStream;

// BEGIN
public class ReversedSequence implements CharSequence {
    String text;

    public ReversedSequence(String text) {
        this.text = text;
    }


    public String toString() {
        return reverseString(text);
    }

    @Override
    public int length() {
        return reverseString(text).length();
    }

    @Override
    public char charAt(int index) {
        return reverseString(text).charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reverseString(text).subSequence(start, end);
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }
    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
}

// END
