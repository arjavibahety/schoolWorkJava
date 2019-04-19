import java.util.*;

public class Point {
    private double _x;
    private double _y;
    private double _xmid;
    private double _ymid;
    private double _angle;
    private double _distance;
    private double _circleX;
    private double _circleY;


    public Point(double x, double y) {
        _x = x;
        _y = y;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getXmid() {
        return _xmid;
    }

    public double getYmid() {
        return _ymid;
    }

    public double getAngle() {
        return _angle;
    }

    public Point getCircleCord() {
        Point _circleCord = new Point(_circleX, _circleY);
        return _circleCord;
    }

    public Point getMidPoint() {
        Point _midPointCord = new Point(_xmid, _ymid);
        return _midPointCord;
    }

    public String printPoint() {
        String print = "(" + String.format("%.3f", _x) + ", " + String.format("%.3f", _y) + ")";
        return print;
    }

    public String midPoint(Point another) {
        _xmid = (another.getX() + _x) / 2;
        _ymid = (another.getY() + _y) / 2;
        String result = "(" + String.format("%.3f", _xmid) + ", " + String.format("%.3f", _ymid) + ")";
        return result;
    }

    public double angleTo(Point another) {
        _angle = Math.atan2(another.getY() - _y, another.getX() - _x);
        return _angle;
    }


    public String circleCentre(Point another) {

        _distance = Math.sqrt(1- (Math.pow(_x - _xmid, 2) + Math.pow(_y - _ymid, 2)));
        double new_angle = (Math.PI / 2) + angleTo(another); 
        _circleX = _xmid + (_distance * Math.cos (new_angle));
        _circleY = _ymid + (_distance * Math.sin( new_angle));
        //	Circle c = new Circle(getCircleCord());
        if(Double.isNaN(_circleX) || Double.isNaN(_circleY)) {
            return "";
        } else {
            String result = "(" + String.format("%.3f",_circleX) + ", " + String.format("%.3f",_circleY) + ")";
            return result;
        }
    }





}
