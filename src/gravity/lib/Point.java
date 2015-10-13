package gravity.lib;

public class Point 
{
	private double x;
	private double y;
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	public void setX(double v) { x = v; }
	public void setY(double v) { y = v; }
	
	public double distanceFrom(Point p)
	{
		return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}
}
