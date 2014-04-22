package com.amorphous.gaem;

import Models.Players.Player;
import View.World;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor{
	
	World world;
	
	Vector3 touch = new Vector3();
	Vector2 touch2 = new Vector2();

	public InputHandler(World world){
		this.world = world;
	}

	@Override
	public boolean keyDown(int keycode) {
		world.keys[keycode] = true;
		/*switch(keycode){
			case Keys.W:
				world.player1.getVelocity().y += -Player.SPEED;
				break;
			case Keys.A:
				world.player1.getVelocity().x += -Player.SPEED;
				break;
			case Keys.S:
				world.player1.getVelocity().y += Player.SPEED;
				break;
			case Keys.D:
				world.player1.getVelocity().x += Player.SPEED;
				break;
			case Keys.SHIFT_LEFT:
				if(world.player1.isPlaying())
					world.player1.fire(true);
				else
					world.respawn(world.player1);
				break;
			default:
				break;
			
		}*/
		System.out.println(keycode);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		world.keys[keycode] = false;
		/*switch(keycode){
		case Keys.W:
			world.player1.getVelocity().y -= -Player.SPEED;
			break;
		case Keys.A:
			world.player1.getVelocity().x -= -Player.SPEED;
			break;
		case Keys.S:
			world.player1.getVelocity().y -= Player.SPEED;
			break;
		case Keys.D:
			world.player1.getVelocity().x -= Player.SPEED;
			break;
		case Keys.SHIFT_LEFT:
			world.player1.fire(false);
			break;
		case Keys.PAGE_UP:
			if(world.game.audio.getMusic(0).isPlaying())
				world.game.audio.stopMusic(0);
			else
				world.game.audio.playMusic(0);
			break;
		default:
			break;
	}*/
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//System.out.println("Button "+button);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		//touch.set(screenX, screenY, 0);
		//world.getRender().getCamera().unproject(touch);
		//touch2.set(touch.x, touch.y);
		//System.out.println(touch2.x+" "+touch2.y);
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		//System.out.println("Scrolled: "+amount);
		return true;
	}

}
