package Models;

import Models.Players.Player;
import View.World;

import com.badlogic.gdx.math.Vector2;

public class subObjectEnemy extends subObject {
	public subObjectEnemy(Vector2 offset, float width, float height,
			float hitX, float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		health = 100;
	}
	
	public void damage(int i) 
	{
		health -= i;
		world.game.audio.playSound("EnemyHurt"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.2f);
		
	}
	
	@Override
	public void update(World world, MoveableEntity parent){
		if(health <= 0)
			remove = true;
		super.update(world, parent);
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
		if(e instanceof Player){
			e.damage(1);
		}
	}

}
