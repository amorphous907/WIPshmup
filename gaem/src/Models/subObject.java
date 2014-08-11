package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class subObject extends MoveableEntity{
	private MoveableEntity Parent;
	public Vector2 offset;
	public Vector2 offsetVelocity;
	private boolean subFade = false;
	
	public subObject(Vector2 offset, float width, float height, float hitX,
			float hitY, MoveableEntity Parent) {
		super(new Vector2(Parent.position.x + (offset.x + width/2), Parent.position.y + (offset.y + height/2)), width, height, hitX, hitY);
		this.Parent = Parent;
		this.offset = offset;
		offsetVelocity = new Vector2(0,0);
	}
	

	public void update(World world, MoveableEntity Parent){
		offset.add(offsetVelocity.cpy().scl(Gdx.graphics.getDeltaTime()));
		velocity.x = 0;
		velocity.y = 0;
		position = new Vector2((Parent.position.x + Parent.width/2) + (offset.x - width/2), (Parent.position.y + Parent.height/2) + (offset.y - height/2));
		bounds.x = position.x+width/2-bounds.getWidth()/2;
		bounds.y = position.y+height/2-bounds.getHeight()/2;
		
		if(subFade){
			color.lerp(Color.WHITE, Gdx.graphics.getDeltaTime()*4);
			if(color.r >= 0.95f && color.g >= 0.95f && color.b >= 0.95f)
				fadeToWhite = false;
		}
		
		update(world);
	}
	
	
	public void subDamage(int i){
		health -= i;
		subHit();
	}
	
	public void subHit(){
		color = new Color(damageColor);
		subFade = true;
	}
}
