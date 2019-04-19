import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] grid = new int[6][3][3];
        for(int k = 0; k < 6; k++) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    grid[k][i][j] = sc.nextInt();
                }
            }
        }

        Rubik r1 = new Rubik(grid);

        while(sc.hasNext()) {
            switch(sc.next()) {
                case "F":   r1 = r1.frontfaceRight();
                            break;
                case "R":   r1 = r1.rightfaceRight();
                            break;
                case "U":   r1 = r1.upfaceRight();
                            break;
                case "L":   r1 = r1.leftfaceRight();
                            break;
                case "B":   r1 = r1.backfaceRight();
                            break;
                case "D":   r1 = r1.downfaceRight();
                            break;
                case "F'":  r1 = r1.frontfaceLeft();
                            break;
                case "R'":  r1 = r1.rightfaceLeft();
                            break;
                case "U'":  r1 = r1.upfaceLeft();
                            break;
                case "L'":  r1 = r1.leftfaceLeft();
                            break;
                case "B'":  r1 = r1.backfaceLeft();
                            break;
                case "D'":  r1 = r1.downfaceLeft();
                            break;
                case "F2":  r1 = r1.frontfaceHalf();
                            break;
                case "R2":  r1 = r1.rightfaceHalf();
                            break;
                case "U2":  r1 = r1.upfaceHalf();
                            break;
                case "L2":  r1 = r1.leftfaceHalf();
                            break;
                case "B2":  r1 = r1.backfaceHalf();
                            break;
                case "D2":  r1 = r1.downfaceHalf();
                            break;
            }    
        }

        System.out.println(r1);
    }
}
