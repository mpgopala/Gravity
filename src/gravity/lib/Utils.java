package gravity.lib;

public class Utils
{
	public static Force getResultant(Force f1, Force f2)
	{
		Force resultant = new Force();
		resultant.setX(f1.getX() + f2.getX());
		resultant.setY(f1.getY() + f2.getY());
		return resultant;
	}
	
	public static double getSlopeAngle(Point p1, Point p2)
	{
		double slope = 0;
		if(p1.getX() == p2.getX())
			slope = Constants.PIBY2;
		else
			slope = Math.atan((p1.getY() - p2.getY()) / (p1.getX() - p2.getX()));
		
		if((p1.getX() < p2.getX()) && (p1.getY() >= p2.getY()))
			slope = Math.abs(slope) + Constants.PIBY2;
		else if((p1.getX() < p2.getX()) && (p1.getY() < p2.getY()))
			slope = slope + Constants.PI;
		
		return slope;
	}
	
	public static double getSlope(Point p1, Point p2)
	{
		if(p1.getX() == p2.getX())
		{
			return Constants.HUGE_VALUE;
		}
		
		return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
	}
}
