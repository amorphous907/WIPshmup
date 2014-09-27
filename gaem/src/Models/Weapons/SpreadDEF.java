package Models.Weapons;

import Models.MoveableEntity;
import Models.Weapons.Projectiles.Bullet;
import View.World;

import com.badlogic.gdx.math.Vector2;

public class SpreadDEF extends Gun{
	public SpreadDEF(int fireRate, int damage, int ammo)
	{
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = ammo;
	}
	
	public SpreadDEF(int fireRate, int damage)
	{
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = -1;
	}
	
	public SpreadDEF(){  
		fireRate = 0.163f;
		damage = 1;
		ammo = -1;
		name = "LASERS";
		slingable = false;
	}
	
	@Override
	protected void fire(World world, MoveableEntity entity){
		projectiles.add(new Bullet(new Vector2(entity.centerLocation.x-12, entity.centerLocation.y), new Vector2(-100,-900)));
		projectiles.add(new Bullet(new Vector2(entity.centerLocation.x-6, entity.centerLocation.y), new Vector2(-50,-900)));
		projectiles.add(new Bullet(new Vector2(entity.centerLocation.x+6, entity.centerLocation.y), new Vector2(50,-900)));
		projectiles.add(new Bullet(new Vector2(entity.centerLocation.x+12, entity.centerLocation.y), new Vector2(100,-900)));
		
		world.getRender().addParticles(4, 2, 2, new Vector2(entity.centerLocation.x-10, entity.centerLocation.y-10));
		world.getRender().addParticles(4, 2, 2, new Vector2(entity.centerLocation.x+10, entity.centerLocation.y-10));
		int x = com.badlogic.gdx.math.MathUtils.random(0, 3);
		world.game.audio.playSound("PlayerLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		super.fire(world, entity);
	}
}
