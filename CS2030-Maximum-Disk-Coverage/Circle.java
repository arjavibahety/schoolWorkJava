public class Circle {
	private Point _p;
	private double _radius = 1;
	private double _distance;
	private int _noOfPoints = 0;


	public Circle(Point p) {
		_p = p;
	}

	public Point getPoint() {
		return _p;
	}

	public int getNoOfPoints() {
		return _noOfPoints;
	}

	public void isInside(Point p) {
		_distance = Math.sqrt(Math.pow(_p.getX() - p.getX(), 2) + Math.pow(_p.getY() - p.getY(), 2));
		if(_distance <= _radius) {
			_noOfPoints++;
		}
	}

}
