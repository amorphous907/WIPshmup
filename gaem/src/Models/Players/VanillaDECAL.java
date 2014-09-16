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
	private VanillaDECAL Pcolor;
	
	public VanillaDECAL(Vector2 offset, int Pcolor,  MoveableEntity Parent) {
		super(offset, 61, 61, 45, 45, Parent);
		actorID = 12;
		texture = "vanillaDECAL";
		this.Pcolor = this;
		
		if(Pcolor == 1)
		{
			color = color.BLUE;
		}
		if(Pcolor == 2)
		{
			color = color.RED;
		}
		if(Pcolor == 3)
		{
			color = color.GREEN;
		}
		if(Pcolor == 4)
		{
			color = color.YELLOW;
		}
	}
}