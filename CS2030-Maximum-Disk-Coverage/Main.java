import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int coverage = 0;
        Point[] points = new Point[count];
        Circle[] circles = new Circle[count * count];
        int k = 0;
        for(int i = 0; i < count; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }
        for(int i = 0; i < count;  i++) {
            for(int j = i + 1; j < count; j++) {

                String midpoint = points[j].midPoint(points[i]);
                String centreString = points[j].circleCentre(points[i]);
                //System.out.println(centreString);
                if(centreString.equals("")){
                    k++;								
                } else {
                    Point centreCord = points[j].getCircleCord();
                    circles[k] = new Circle(centreCord);
                    k++;
                }

            }
        }

        int max = 0;

        for(int i= 0; i < count * count; i++) {
            for (int j = 0; j < count; j++) {
                if(circles[i] == null) {
                    //System.out.println("skip");
                    continue;
                } else{
                    circles[i].isInside(points[j]);										
                    if(max < circles[i].getNoOfPoints()) {
                        max = circles[i].getNoOfPoints();
                    }
                }
            }
        }

        System.out.println("Maximum Disc Coverage: " + max);


    }
}
