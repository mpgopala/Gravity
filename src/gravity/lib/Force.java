package gravity.lib;

//F = x + iy
public class Force 
{
	private double x;
	private double y;
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	public void setX(double v) { x = v; }
	public void setY(double v) { y = v; }
	
	public double getMagnitude()
	{
		return Math.sqrt(x * x + y * y);
	}
	
	public void reset()
	{
		x = y = 0;
	}
	
	public void setFromPolar(double magnitude, double direction)
	{
		x = magnitude * Math.cos(direction);
		y = magnitude * Math.sin(direction);
	}
	
	
	
}
