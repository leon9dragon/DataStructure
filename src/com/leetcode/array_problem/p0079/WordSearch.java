package com.leetcode.array_problem.p0079;

public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCB";
        boolean res = exist(board, word);
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {
        //define a 2D array to store the visit status of each letter
        //'0' is unvisited; '1' is visited.
        int[][] status = new int[board.length][board[0].length];

        //store the result
        boolean[] res = new boolean[1];

        //loop to find the right first letter
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                recursion(board[i][j], 0, word, board, i, j, status, res);
            }
        }

        //return the result
        return res[0];
    }

    public static void recursion(char c, int index, String word, char[][] board, int row, int col, int[][] visited, boolean[] res) {
        //we should make sure whether the word is existed in the matrix,
        //once the word is occurred then it's no need to continue the recursion.
        if (res[0]) return;

        //update the status of current char
        visited[row][col] = 1;

        //define the way out of recursion
        if (index == word.length() - 1) {
            if (c == word.charAt(index)) {
                res[0] = true;
            }
            return;
        }

        //start recursion
        //the next point's index shouldn't be out of the bound
        //and it must not be visited cuz the same letter cell may not be used more than once.
        if (c == word.charAt(index)) {
            //up
            if (row - 1 >= 0 && visited[row - 1][col] == 0)
                recursion(board[row - 1][col], index + 1, word, board, row - 1, col, visited, res);

            //down
            if (row + 1 < board.length && visited[row + 1][col] == 0)
                recursion(board[row + 1][col], index + 1, word, board, row + 1, col, visited, res);

            //left
            if (col - 1 >= 0 && visited[row][col - 1] == 0)
                recursion(board[row][col - 1], index + 1, word, board, row, col - 1, visited, res);

            //right
            if (col + 1 < board[0].length && visited[row][col + 1] == 0)
                recursion(board[row][col + 1], index + 1, word, board, row, col + 1, visited, res);
        }

        //backtrack, reset the status
        visited[row][col] = 0;
    }
}
