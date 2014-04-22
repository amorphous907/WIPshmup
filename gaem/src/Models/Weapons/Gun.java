package Models.Weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

import Models.MoveableEntity;
import Models.Weapons.Projectiles.Bullet;
import View.World;

public class Gun {
	protected float fireRate;
	protected float spread;
	protected float maxSpread;
	protected int damage;
	protected World world;

	protected int ammo;
	protected int fireTick = 0;
	public String name = "NONE";
	public boolean fire;
	private boolean loaded = true;
	
	public Gun(float fireRate, int damage, int ammo){
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = ammo;
	}
	
	public Gun(float fireRate, int damage){
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = -1;
	}
	
	public Gun(){  
		fireRate = 0.16f;
		damage = 1;
		ammo = -1;
	}
	
	public void update(World world, MoveableEntity entity){
		this.world = world;
		if(fire && loaded){
			spread = com.badlogic.gdx.math.MathUtils.random(maxSpread*-1, maxSpread);
			fire(world, entity);
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					loaded = true;
				}
				
			}, fireRate);
			loaded = false;
		}
	}
	
	protected void fire(World world, MoveableEntity entity){
		
	}
	
}
