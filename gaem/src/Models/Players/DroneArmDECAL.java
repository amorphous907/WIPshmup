package Models.Players;

import Models.MoveableEntity;
import Models.subObject;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class DroneArmDECAL extends subObject{
	public Vector2 aim;
	
	public DroneArmDECAL(Vector2 offset, int Pcolor, int arm_num,  MoveableEntity Parent) {
		super(offset, 91, 61, 45, 45, Parent);
		actorID = 12;
		if(arm_num == 1)
		{
			texture = "Drone arm1 DECAL";
		}
		if(arm_num == 2)
		{
			texture = "Drone arm2 DECAL";
		}
		if(arm_num == 3)
		{
			texture = "Drone arm3 DECAL";
		}
		if(arm_num == 4)
		{
			texture = "Drone arm4 DECAL";
		}
		
		
		if(Pcolor == 1)
		{
			baseColor = Color.BLUE;
		}
		if(Pcolor == 2)
		{
			baseColor = Color.RED;
		}
		if(Pcolor == 3)
		{
			baseColor = Color.GREEN;
		}
		if(Pcolor == 4)
		{
			baseColor = Color.YELLOW;
		}
		color = baseColor;
	}
}