class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start a new island if not visited and grid[i][j] > 0
                if (!visited[i][j] && grid[i][j] > 0) {
                    int sum = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        sum += grid[x][y];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d], ny = y + dy[d];
                            if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                                !visited[nx][ny] && grid[nx][ny] > 0) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }

                    // Check if island sum is divisible by k
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
        
    }
}
