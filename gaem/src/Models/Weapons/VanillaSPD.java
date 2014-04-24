package Models.Weapons;

import Models.MoveableEntity;
import Models.Weapons.Projectiles.Bullet;
import View.World;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class VanillaSPD extends Gun {
	private boolean slow = true;
	public VanillaSPD(int fireRate, int damage, int ammo){
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = ammo;
	}
	
	public VanillaSPD(int fireRate, int damage){
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = -1;
	}
	
	public VanillaSPD(){
		fireRate = 0.2f;
		maxSpread = 10;
		damage = 100;
		ammo = -1;
		name = "CHAIN GUN";
	}
	
	@Override
	protected void fire(World world, MoveableEntity entity)
	{
		projectiles.add(new Bullet(new Vector2(entity.centerLocation.x, entity.centerLocation.y-10), new Vector2(0,-900).rotate(spread))); //.rotate(spread) is the bullet spread parameter
		applyVelocity(entity);
		world.getRender().addParticles(4, 2, 2, new Vector2(entity.centerLocation.x, entity.centerLocation.y-10));
		if(slow && fireRate > 0.04f){
			fireRate -= 0.009;
			world.timer.scheduleTask(new Task()
			{

				@Override
				public void run() 
				{
					slow = true;
				}
				
			}, 0.1f);
			slow = false;
		}
		int x = com.badlogic.gdx.math.MathUtils.random(0, 3);
		world.game.audio.playSound("PlayerLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		super.fire(world, entity);
	}
}
