package Models.Enemies;

import Models.MoveableEntity;
import Models.Players.Player;
import Models.Weapons.Projectiles.EnemyBullet;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EnemyMines extends Enemy 
{
	Vector2 aim;

	public EnemyMines(Vector2 position, float width, float height, float hitX, float hitY) 
	{
		super(position, width, height, hitX, hitY);
		health = 300;
		tick = 0;
		velocity = new Vector2(0,150);
		actorID = 10;
		texture = "enemyG";
		score = 300;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		
		if(health == 0)
		{
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(300,300)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(0,400)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-300,300)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-400,0)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(400,0)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(300,-300)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(0,-400)));
			world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-300,-300)));
		} 
	}
	
	public void collidesWith(MoveableEntity e, World world) 
	{
		if(e instanceof Player)
		{
			((Player) e).damage(5);
			
			health = 0;
		}
			
	}
}