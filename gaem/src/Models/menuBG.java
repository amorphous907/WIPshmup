package Models;

import View.World;

import com.badlogic.gdx.math.Vector2;

public class menuBG extends MoveableEntity{
	boolean fuckimbad = true;
	int ransplash = com.badlogic.gdx.math.MathUtils.random(1, 5);
	
	public menuBG(Vector2 position)
	{
		super(position, -700, 900, 0, 0);
		actorID = 14;
		texture = "menuBG";
	}
	

	public void update(World world)
	{
		super.update(world);
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
	}

}
