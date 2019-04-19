public class Face {
    private int[][] grid = new int[3][3];

    public Face(int[][] gd) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = gd[i][j];    
            }    
        }
    }

    public Face rotateRight() {
        int rowTrans;
        int colTrans;
        int[][] newGrid = new int[3][3];
        for(int i = 0; i < 3; i++) {
            rowTrans = i;
            if(i == 0) {
                rowTrans = 2;
            } else if(i == 1) {
                rowTrans = 1;
            } else if(i == 2) {
                rowTrans = 0;
            }
            for(int j = 0; j < 3; j++) {
                colTrans = j;
                newGrid[colTrans][rowTrans] = grid[i][j];
            }
        }

        return new Face(newGrid);
    }

    public Face rotateLeft() {
        return this.rotateRight().rotateRight().rotateRight();
    }

    public Face rotateHalf() {
        return this.rotateRight().rotateRight();
    }

    public int[][] getGrid() {
        int[][] newGrid = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                newGrid[i][j] = grid[i][j]; 
            }
        }
        return newGrid;
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                output += String.format("%02d", grid[i][j]);
            }
            if(i != 2) {
                output += "\n";
            }
        }
        output += "\n";
        return output;
    }

}
