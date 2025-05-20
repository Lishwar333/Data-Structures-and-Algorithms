package DSA;

import java.util.*;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Directions for adjacent cells: up, down, left, right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If land and not visited
                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(grid, visited, r, c, directions);
                    islandCount++;  // One whole island traversed
                }
            }
        }

        return islandCount;
    }

    private void bfs(char[][] grid, boolean[][] visited, int startRow, int startCol, int[][] directions) {
       
    	Queue<int[]> queue = new LinkedList<>();
        
    	queue.offer(new int[]{startRow, startCol});
        
    	visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];

            // Check all 4 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries and if it's land and not visited
                if (newRow >= 0 && newRow < grid.length && 
                    newCol >= 0 && newCol < grid[0].length && 
                    grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {

                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    // For testing
    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();

        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        System.out.println("Number of islands (grid1): " + solver.numIslands(grid1)); // Output: 1
        System.out.println("Number of islands (grid2): " + solver.numIslands(grid2)); // Output: 3
    }
}
