package Models.Players;

import Models.MoveableEntity;
import Models.subObject;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class VanillaDECAL extends subObject{
	public Vector2 aim;
	
	public VanillaDECAL(Vector2 offset, int Pcolor,  MoveableEntity Parent) {
		super(offset, 61, 61, 45, 45, Parent);
		actorID = 12;
		texture = "vanillaDECAL";
		hasLight = true;
		lightMap = "vanillaDECAL";
		
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