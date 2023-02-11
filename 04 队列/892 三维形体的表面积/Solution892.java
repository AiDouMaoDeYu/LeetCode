public class Solution892{
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{3,4}};
        System.out.println(new Solution892().surfaceArea(grid));
        
    }

    public int surfaceArea(int[][] grid) {
        int surfaceArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0){
                    surfaceArea += (grid[i][j] * 4 + 2);

                }
                if(j != grid[i].length - 1){
                    surfaceArea -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
                }
                if(i != grid.length - 1){
                    surfaceArea -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                }               
            }           
        }

        return surfaceArea;

    }
}