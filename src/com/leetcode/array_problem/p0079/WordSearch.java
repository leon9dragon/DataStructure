package com.leetcode.array_problem.p0079;

public class WordSearch {
    public static void main(String[] args) {
        String str = "leo";
        //System.out.println(str.charAt(0));
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCESEEEFS";
        boolean res = exist(board, word);
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {

        int R = board.length;
        int C = board[0].length;

        boolean[] res = new boolean[1];
        int[][] status = new int[R][C];


        return res[0];
    }

    public static boolean recursion(char c, int index, String str) {
        if (index == str.length() - 1) {
            if (c == str.charAt(index)) return true;
            else return false;
        } else {
            if (c == str.charAt(index)) {
                
            }
        }
        return false;
    }
}
