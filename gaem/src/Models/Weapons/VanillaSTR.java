package Models.Weapons;

import Models.MoveableEntity;
import Models.Weapons.Projectiles.Missile;
import View.World;

import com.badlogic.gdx.math.Vector2;

public class VanillaSTR extends Gun{
	int swap = 0;
	
	public VanillaSTR(int fireRate, int damage, int ammo){
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = ammo;
	}
	
	public VanillaSTR(int fireRate, int damage){
		this.fireRate = fireRate;
		this.damage = damage;
		this.ammo = -1;
	}
	
	public VanillaSTR(){
		fireRate = 0.5f;
		damage = 100;
		ammo = -1;
		name = "MISSILES";
		slingable = false;
	}
	
	@Override
	protected void fire(World world, MoveableEntity entity)
	{
		projectiles.add(new Missile(new Vector2(entity.centerLocation.x ,entity.centerLocation.y), 10,20,5,10, new Vector2(0, 200)));
		world.getRender().addParticles(4, 2, 2, new Vector2(entity.centerLocation.x, entity.centerLocation.y-10));
		int x = com.badlogic.gdx.math.MathUtils.random(0, 3);
		world.game.audio.playSound("PlayerLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		super.fire(world, entity);
	}
}
