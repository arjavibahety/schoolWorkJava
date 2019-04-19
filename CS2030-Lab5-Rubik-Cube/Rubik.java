public class Rubik {
    private int[][][] grid = new int[6][3][3];
    private Face fRight;
    private Face fLeft;
    private Face fTop;
    private Face fFront;
    private Face fBack;
    private Face fDown;

    public Rubik(int[][][] grid) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    this.grid[i][j][k] = grid[i][j][k];    
                }    
            }     
        }
        fTop = new Face(grid[0]);
        fLeft = new Face(grid[1]);
        fFront = new Face(grid[2]);
        fRight = new Face(grid[3]);
        fDown = new Face(grid[4]);
        fBack = new Face(grid[5]);
    }

    public Rubik viewRight() {

        int[][][] newGrid = {fTop.rotateRight().getGrid(), fFront.getGrid(), fRight.getGrid(), 
            fBack.rotateHalf().getGrid(), fDown.rotateLeft().getGrid(), fLeft.rotateHalf().getGrid()};

        Rubik newRubik = new Rubik(newGrid);

        return newRubik;
    }

    public Rubik viewLeft() {
        return this.viewRight().viewRight().viewRight();
    }

    public Rubik viewUp() {

        int[][][] newGrid = {fBack.getGrid(), fLeft.rotateRight().getGrid(), fTop.getGrid(), 
            fRight.rotateLeft().getGrid(), fFront.getGrid(), fDown.getGrid()};

        Rubik newRubik = new Rubik(newGrid);

        return newRubik;

    }

    public Rubik viewDown() {
        Rubik r1 = new Rubik(grid);
        return r1.viewUp().viewUp().viewUp();
    }

    public Rubik frontfaceRight() {
        Face fFrontTemp = fFront.rotateRight();
        int[][] fTopTemp = fTop.getGrid();
        int[][] fLeftTemp = fLeft.getGrid();
        int[][] fRightTemp = fRight.getGrid();
        int[][] fDownTemp = fDown.getGrid();

        for(int k = 0; k < 3; k++) {

            //initialise all the temp variables
            int tempRight = fRightTemp[k][0];
            int tempDown = fDownTemp[0][2 - k];
            int tempLeft = fLeftTemp[2 - k][2];
            int tempTop = fTopTemp[2][k];

            //do the swapping
            fRightTemp[k][0] = tempTop;
            fDownTemp[0][2 - k] = tempRight;
            fLeftTemp[2 - k][2] = tempDown;
            fTopTemp[2][k] = tempLeft;
        }

        int[][][] newGrid = {fTopTemp, fLeftTemp, fFrontTemp.getGrid(), fRightTemp,
            fDownTemp, fBack.getGrid()};

        return (new Rubik(newGrid));
    }

    public Rubik frontfaceLeft() {
        return this.frontfaceRight().frontfaceRight().frontfaceRight();
    }

    public Rubik frontfaceHalf() {
        return this.frontfaceRight().frontfaceRight();    
    }

    public Rubik rightfaceRight() {
        return this.viewRight().frontfaceRight().viewLeft();    
    }

    public Rubik rightfaceLeft() {
        return this.viewRight().frontfaceLeft().viewLeft();    
    }

    public Rubik rightfaceHalf() {
        return this.rightfaceRight().rightfaceRight();    
    }

    public Rubik leftfaceRight() {
        return this.viewLeft().frontfaceRight().viewRight();    
    }

    public Rubik leftfaceLeft() {
        return this.viewLeft().frontfaceLeft().viewRight();    
    }

    public Rubik leftfaceHalf() {
        return this.leftfaceRight().leftfaceRight();    
    }

    public Rubik upfaceRight() {
        return this.viewUp().frontfaceRight().viewDown();    
    }

    public Rubik upfaceLeft() {
        return this.viewUp().frontfaceLeft().viewDown();   
    }

    public Rubik upfaceHalf() {
        return this.upfaceRight().upfaceRight();    
    }

    public Rubik downfaceRight() {
        return this.viewDown().frontfaceRight().viewUp();    
    }

    public Rubik downfaceLeft() {
        return this.viewDown().frontfaceLeft().viewUp();    
    }

    public Rubik downfaceHalf() {
        return this.downfaceRight().downfaceRight();    
    }

    public Rubik backfaceRight() {
        return this.viewUp().viewUp().frontfaceRight().viewDown().viewDown();    
    }

    public Rubik backfaceLeft() {
        return this.viewUp().viewUp().frontfaceLeft().viewDown().viewDown();    
    }

    public Rubik backfaceHalf() {
        return this.backfaceRight().backfaceRight();    
    }


    public String toString() {
        String output = "";
        String dots = "......";
        for(int i = 0; i < 6; i++) {
            if((i == 0 || i == 4 || i == 5)) {
                for(int j = 0; j < 3; j++) {
                    output += dots;    
                    for(int k = 0; k < 3; k++) {
                        output += String.format("%02d", grid[i][j][k]);
                    }
                    output = output + dots + "\n";
                }
            }
            else {
                if(i == 2 || i == 3) {
                    continue;
                } else {
                    for(int j = 0; j < 3; j++) {
                        for(int k = 0; k < 3; k++) {
                            output += String.format("%02d", grid[i][j][k]);
                        }

                        for(int k = 0; k < 3; k++) {
                            output += String.format("%02d", grid[i + 1][j][k]);
                        }

                        for(int k = 0; k < 3; k++) {
                            output += String.format("%02d", grid[i + 2][j][k]);
                        }

                        output += "\n";
                    }
                }
            }               

        }
        return output;
    }


}
