package gravity.lib;

import java.util.ArrayList;

public class Galaxy
{
	private ArrayList<Star> stars = new ArrayList<Star>();
	
	public void addStar(String name, Point center, double mass, double radius)
	{
		Star star = new Star();
		star.setName(name);
		star.setCenter(center);
		star.setMass(mass);
		star.setRadius(radius);
		
		stars.add(star);
	}

	public int starCount()
	{
		return stars.size();
	}
	
	public void destroy()
	{
		stars = null;
	}
	
	public Force getForce(Force initialForce, Star tempStar)
	{
		Force resultant = initialForce;
		Force tempForce = null;
		
		for(int i = 0; i < starCount(); i++)
		{
			Star s = stars.get(i);
			tempForce = s.getForce(tempStar);
			resultant = Utils.getResultant(resultant, tempForce);
		}
		
		return resultant;
	}
	
	public boolean isColliding(Star tempStar)
	{
		for(int i = 0; i < starCount(); i++)
		{
			Star s = stars.get(i);
			if(s.distanceFrom(tempStar.getCenter()) <= (1.2 * (s.getRadius() + tempStar.getRadius())))
				return true;
		}
		
		return false;
	}

	//Force is overwritten with the new force
	public boolean animate(Force force, Star tempStar)
	{
		if(isColliding(tempStar))
		{
			return false;
		}
		
		Force newForce = getForce(force, tempStar);
		double forceFactor = 10;
		if(newForce.getMagnitude() > 100)
		{
			forceFactor = 0.5;
		}
		
		Point tempCenter = new Point();
		tempCenter.setX(tempStar.getCenter().getX() + newForce.getX() * forceFactor);
		tempCenter.setY(tempStar.getCenter().getY() + newForce.getY() * forceFactor);
		
		tempStar.setCenter(tempCenter);
		force.setX(newForce.getX());
		force.setY(newForce.getY());
		
		return true;
	}
}
