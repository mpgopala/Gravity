package gravity.lib;

public class Star 
{
	private Point center;
	private double radius;
	private double mass;
	private String name;
	public Point getCenter()
	{
		return center;
	}
	public void setCenter(Point center)
	{
		this.center = center;
	}
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	public double getMass()
	{
		return mass;
	}
	public void setMass(double mass)
	{
		this.mass = mass;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Force getForce(Star tempStar)
	{
		Force retVal = new Force();
		double magnitude = 0, direction = 0;
		
		double distance = center.distanceFrom(tempStar.center);
		if(distance < Constants.DISTANCE_EPSILON)
		{
			retVal.setFromPolar(Constants.HUGE_VALUE, 0);
			return retVal;
		}
		
		magnitude = (Constants.G * mass * tempStar.mass) / (distance * distance);
		if(Math.abs(center.getX() - tempStar.center.getX()) <= Constants.MIN_VALUE)
			direction = Constants.PIBY2;
		else
			direction = Math.atan((center.getY() - tempStar.center.getY()) / (center.getX() - tempStar.center.getX()));
		
		if((center.getX() < tempStar.center.getX()) && (center.getY() >= tempStar.center.getY()))
			direction = Math.abs(direction) + Constants.PIBY2;
		else if((center.getX() < tempStar.center.getX()) && (center.getY() < tempStar.center.getY()))
			direction = direction + Constants.PI;
		
		retVal.setFromPolar(magnitude, direction);
		return retVal;
	}
	
	public double distanceFrom(Point pt)
	{
		return center.distanceFrom(pt);
	}
	
	public double distanceFromLine(int x1, int y1, int x2, int y2)
	{
		if(x2 == x1)
		{
			return Math.abs(center.getX() - x1);
		}
		
		double m = (y2 - y1) / (x2 - x1);
		double c = y1 - m * x1;
		double distance = (m * center.getX() - center.getY() + c) / (Math.sqrt(m * m + 1));
		return distance;
	}
}
