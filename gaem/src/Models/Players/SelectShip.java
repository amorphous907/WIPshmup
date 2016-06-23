package Models.Players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import Models.MoveableEntity;
import Models.Weapons.LaserDEF;
import Models.Weapons.SpreadDEF;
import Models.Weapons.VanillaDEF;
import View.World;

public class SelectShip extends MoveableEntity{
	public boolean leave;
	public boolean enter;
	
	
	public SelectShip(Vector2 position, int aI) {
		super(position, 60, 60, 60, 60);
		this.AI = aI;
		switch(aI){
		case 0:
			subObjects.add(new vanillaDECAL(new Vector2(), 1, this));
			texture = "vanilla";
			setHeight(60);// = 60;
			setWidth(60);// = 60;
			bounds.width = 45;
			bounds.height = 45;
			break;
		case 1:
			subObjects.add(new laserDECAL(new Vector2(), 1, this));
			texture = "laser";
			setHeight(60);// = 60;
			setWidth(90);// = 60;
			bounds.width = 60;
			bounds.height = 45;
			break;
		case 2:
			subObjects.add(new spreadDECAL(new Vector2(), 1, this));
			texture = "spread";
			setHeight(70);// = 60;
			setWidth(40);// = 60;
			bounds.width = 30;
			bounds.height = 50;
			break;
		case 3:
			subObjects.add(new medicDECAL(new Vector2(), 1, this));
			texture = "medic";
			setHeight(70);// = 60;
			setWidth(60);// = 60;
			bounds.width = 60;
			bounds.height = 50;
			break;
		case 4:
			subObjects.add(new DroneBodyDECAL(new Vector2(), 1, this));
			//subObjects.add(new DroneArm(new Vector2(25,-25), 1, 0, 0, 0, 1, this));
			//subObjects.add(new DroneArm(new Vector2(-25,-25), 1, 0, 0, 0, 2, this));
			//subObjects.add(new DroneArm(new Vector2(25,25), 1, 0, 0, 0, 3, this));
			//subObjects.add(new DroneArm(new Vector2(-25,25), 1, 0, 0, 0, 4, this));
			texture = "DroneBody";
			setHeight(30);// = 60;
			setWidth(45);// = 60;
			bounds.width = 60;
			bounds.height = 50;
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			break;
		}
	}
	
	@Override
	public void update (World world){
		super.update(world);
		if(leave){
			world.moving = true;
			leaving(world);
		}
		if(enter){
			world.moving = true;
			entering(world);
		}
	}
	
	
	private void leaving(World world){
		if(position.y >= -100){
			velocity.y = -1000;
		} else{
			leave = false;
			velocity.y = 0;
			position.y = 1000;
			world.moving = false;
		}
	}
	
	private void entering(World world){
		if(position.y >= 320){
			velocity.y = -1000;
		} else {
			enter = false;
			velocity.y = 0;
			world.moving = false;
		}
	}
	
}
