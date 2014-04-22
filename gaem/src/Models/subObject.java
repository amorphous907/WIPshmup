package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class subObject extends MoveableEntity{
	private MoveableEntity Parent;
	public Vector2 offset;
	public Vector2 offsetVelocity;
	
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
		update(world);
	}
	
}
