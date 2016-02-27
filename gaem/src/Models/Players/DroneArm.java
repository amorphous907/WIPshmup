package Models.Players;

import Models.MoveableEntity;
import Models.subObject;
import Models.Players.Player;
import Models.Weapons.Gun;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class DroneArm extends subObject{
	public Gun gun;
	public boolean fire;
	public Player player;
	
	public DroneArm(Vector2 offset, float width, float height, float hitX, float hitY,int arm_num, MoveableEntity Parent) 
	{
		super(offset, 30, 20, hitX, hitY, Parent);
		actorID = 0;
		if(arm_num == 1)
		{
			texture = "Drone arm1";
			subObjects.add(new DroneArmDECAL(new Vector2(), 1, 1, this));
		}
		if(arm_num == 2)
		{
			texture = "Drone arm2";
			subObjects.add(new DroneArmDECAL(new Vector2(), 1, 2, this));
		}
		if(arm_num == 3)
		{
			texture = "Drone arm3";
			subObjects.add(new DroneArmDECAL(new Vector2(), 1, 3, this));
		}
		if(arm_num == 4)
		{
			texture = "Drone arm4";
			subObjects.add(new DroneArmDECAL(new Vector2(), 1, 4, this));
		}
		this.player = (Player) Parent;
		gun = new Gun();
	}
	
	@Override
	public void update(World world, MoveableEntity Parent){
		super.update(world, Parent);
			player = (Player) Parent;
			gun.fire = player.gun.fire;
			gun.update(world, this);
	}

}
