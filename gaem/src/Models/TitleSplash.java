package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class TitleSplash extends MoveableEntity{
	boolean fuckimbad = true;
	int ransplash = com.badlogic.gdx.math.MathUtils.random(1,5);
	
	public TitleSplash(Vector2 position)
	{
		super(position, 0, 0, 0, 0);
		actorID = 14;
	}
	

	public void update(World world)
	{
		super.update(world);
		if(fuckimbad)
		{
			if(ransplash == 1)
			{
				texture = "Title Splash vanilla";
				width = -860;
				height = 220;
				position.x = 950;
				position.y = 50;
			}
			if(ransplash == 2)
			{
				texture = "Title Splash laser";
				width = -866;
				height = 289;
				position.x = 950;
				position.y = 0;
			}
			if(ransplash == 3)
			{
				texture = "Title Splash spread";
				width = -944;
				height = 107;
				position.x = 1000;
				position.y = 80;
			}
			if(ransplash == 4)
			{
				texture = "Title Splash medic";
				width = -904;
				height = 253;
				position.x = 950;
				position.y = 15;
			}
			if(ransplash == 5)
			{
				texture = "Title Splash drone";
				width = -860;
				height = 389;
				position.x = 880;
				position.y = -50;
			}
			fuckimbad = false;
		}
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
	}

}
