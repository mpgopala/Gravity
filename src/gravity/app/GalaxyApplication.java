package gravity.app;

import gravity.lib.*;

public class GalaxyApplication
{
	Galaxy galaxy;
	double speed;
	Force earthForce;
	int score;
	int level;
	boolean drawStars;
	Star earth;
	
	public void startGame()
	{
		galaxy = new Galaxy(); 
		score = 0;
		level = 0;
		earth = new Star();
		earth.setName("Earth");
		earth.setRadius(10);
	}
	
	public void startLevel()
	{
		drawStars = true;
		level = level + 1;
		if(level > Constants.MAX_LEVEL)
			level = Constants.MAX_LEVEL;
		galaxy.destroy();
		earthForce = new Force();
	}
	
	public void endLevel()
	{
		drawStars = false;
		startLevel();
	}
	
	public static void main(String[] args)
	{
		GalaxyApplication app = new GalaxyApplication();
		app.startGame();
	}
}
