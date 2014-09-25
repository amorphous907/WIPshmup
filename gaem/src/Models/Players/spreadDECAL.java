package Models.Players;

import Models.MoveableEntity;
import Models.subObject;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class spreadDECAL extends subObject{
	public Vector2 aim;
	private spreadDECAL Pcolor;
	
	public spreadDECAL(Vector2 offset, int Pcolor,  MoveableEntity Parent) {
		super(offset, 41, 71, 45, 45, Parent);
		actorID = 12;
		texture = "spreadDECAL";
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