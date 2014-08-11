package Models.Enemies;


import Models.MoveableEntity;
import Models.Players.Player;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class EnemyMissile extends Enemy
{
	
	public EnemyMissile(Vector2 position)
	{
		super(position, 20, 50, 15, 40);
		health = 50;
		score = 50;
		texture = "enemyMissile";
		actorID = 42;
		rotation = 0;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		world.timer.scheduleTask(new Task() 
		{
			@Override
			public void run()
			{
				velocity.y += 1;
				if(velocity.x > 0) velocity.x -= 2;
				if(velocity.x < 0) velocity.x += 2;
			}
		} , 0.5f);
		rotation = velocity.angle()-90;
		if(position.y <= 0)
			remove = true;
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		//damage enemy
		if(e instanceof Player)
		{
			((Player) e).damage(200);
			world.game.audio.playSound("Player1Explosion", 1);
			//kill itself
			remove = true;
		}
	}

}
