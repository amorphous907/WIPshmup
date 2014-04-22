package Models.Enemies.Bosses;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Players.Player;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BOSS1shield extends subObjectEnemy{
	public Vector2 aim;

	public BOSS1shield(Vector2 offset, float width, float height,
			float hitX, float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		actorID = 25;
		texture = "boss1Shield";
		health = 999999999;
	}
	
	public void collidesWith(MoveableEntity e, World world) 
	{	
		if(e instanceof Player)
		{
			((Player) e).damage(50);
		}
		super.collidesWith(e, world);
	}
	
	public void damage(int i) 
	{
		health -= i;
		
	}

	@Override
	public void update(World world, MoveableEntity Parent){
		super.update(world, Parent);
		if(health <= 0)
			remove = true;
	}
}
