package Models.Weapons.Projectiles;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Enemies.Enemy;
import Models.Enemies.LightTiny;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class DroneBullet extends MoveableEntity
{
	public boolean explode = false;
	int zig = 1;
	int side = com.badlogic.gdx.math.MathUtils.random(1, 2);
	int trag = com.badlogic.gdx.math.MathUtils.random(25, 35);

	public DroneBullet(Vector2 position, Vector2 velocity)
	{
		super(position, 10, 10, 5, 5);
		this.velocity = velocity;
		actorID = 28;
		texture = "DroneBullet";
		hasLight = true;
		lightMap = "vanillaBullet_L";
		lightMapScale = 10;
		lightColor = new Color(0,0,1,1);
		rotation = velocity.angle()-90;
		if(side == 1)
		{
			zig = 0;
			velocity.x = 275;
		}
		else
		{
			velocity.x = -275;
		}
	}
	
	@Override
	public void update(World world){
		super.update(world);
		if(position.y <= 0)
			remove = true;
		boolean my_dick = true;
		if(my_dick)
		{
			if(zig == 1)
			{
				velocity.x = velocity.x + trag;
				world.timer.scheduleTask(new Task() 
				{
					@Override
					public void run()
					{
						zig = 0;
					}	
				} , 0.25f);
			}
			
			if(zig == 0)
			{
				velocity.x = velocity.x - trag;
				world.timer.scheduleTask(new Task() 
				{
					@Override
					public void run()
					{
						zig = 1;
					}	
				} , 0.25f);
			}
		}
		//if(remove)
			//world.entities.add(new Explosion(this.getPosition(), 300, 300, 0, 0));
		
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		//damage enemy
		if(e instanceof Enemy || e instanceof subObjectEnemy)
		{
			e.damage(3);
			explode = true;
			//kill itself
			remove = true;
		}
		if(e instanceof subObjectEnemy){
			((Models.subObject) e).subDamage(3);
			explode = true;
			//kill itself
			remove = true;
		}
	}
	@Override
	public void render(WorldRender render){
		if(explode){
			//render.BulletImpact(new Vector2((this.getPosition().x+this.getWidth()/2), (this.getPosition().y+this.getHeight()/2)));
			render.addParticles(2, 0, -3f, new Vector2(centerLocation.x, centerLocation.y+15));
		}
		super.render(render);
	}

}
