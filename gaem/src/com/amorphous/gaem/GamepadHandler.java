package com.amorphous.gaem;

import View.World;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

public class GamepadHandler implements ControllerListener{
	public static final int XBOX_A = 0;
	public static final int XBOX_B = 1;
	public static final int XBOX_X = 2;
	public static final int XBOX_Y = 3;
	public static final int XBOX_LB = 4;
	public static final int XBOX_RB = 5;
	public static final int XBOX_SELECT = 6;
	public static final int XBOX_START = 7;
	public static final int XBOX_LSTICK_CLICK = 8;
	public static final int XBOX_RSTICK_CLICK = 9;
	public static final int XBOX_LSTICK_Y = 0;
	public static final int XBOX_LSTICK_X = 1;
	public static final int XBOX_RSTICK_Y = 2;
	public static final int XBOX_RSTICK_X = 3;
	public static final int XBOX_TRIGGER = 4;
	
	public static final int PLAYER_ONE_A = 0;
	public static final int PLAYER_ONE_B = 1;
	public static final int PLAYER_ONE_X = 2;
	public static final int PLAYER_ONE_Y = 3;
	public static final int PLAYER_ONE_LB = 4;
	public static final int PLAYER_ONE_RB = 5;
	public static final int PLAYER_ONE_SELECT = 6;
	public static final int PLAYER_ONE_START = 7;
	public static final int PLAYER_ONE_LSTICK_CLICK = 8;
	public static final int PLAYER_ONE_RSTICK_CLICK = 9;
	public static final int PLAYER_ONE_LSTICK_Y = 0;
	public static final int PLAYER_ONE_LSTICK_X = 1;
	public static final int PLAYER_ONE_RSTICK_Y = 2;
	public static final int PLAYER_ONE_RSTICK_X = 3;
	public static final int PLAYER_ONE_TRIGGER = 4;
	public static final int PLAYER_ONE_POV_UP = 0;
	public static final int PLAYER_ONE_POV_RIGHT = 1;
	public static final int PLAYER_ONE_POV_DOWN = 2;
	public static final int PLAYER_ONE_POV_LEFT = 3;
	
	public static final int PLAYER_TWO_A = 10;
	public static final int PLAYER_TWO_B = 11;
	public static final int PLAYER_TWO_X = 12;
	public static final int PLAYER_TWO_Y = 13;
	public static final int PLAYER_TWO_LB = 14;
	public static final int PLAYER_TWO_RB = 15;
	public static final int PLAYER_TWO_SELECT = 16;
	public static final int PLAYER_TWO_START = 17;
	public static final int PLAYER_TWO_LSTICK_CLICK = 18;
	public static final int PLAYER_TWO_RSTICK_CLICK = 19;
	public static final int PLAYER_TWO_LSTICK_Y = 5;
	public static final int PLAYER_TWO_LSTICK_X = 6;
	public static final int PLAYER_TWO_RSTICK_Y = 7;
	public static final int PLAYER_TWO_RSTICK_X = 8;
	public static final int PLAYER_TWO_TRIGGER = 9;
	public static final int PLAYER_TWO_POV_UP = 4;
	public static final int PLAYER_TWO_POV_RIGHT = 5;
	public static final int PLAYER_TWO_POV_DOWN = 6;
	public static final int PLAYER_TWO_POV_LEFT = 7;
	
	public static final int PLAYER_THREE_A = 20;
	public static final int PLAYER_THREE_B = 21;
	public static final int PLAYER_THREE_X = 22;
	public static final int PLAYER_THREE_Y = 23;
	public static final int PLAYER_THREE_LB = 24;
	public static final int PLAYER_THREE_RB = 25;
	public static final int PLAYER_THREE_SELECT = 26;
	public static final int PLAYER_THREE_START = 27;
	public static final int PLAYER_THREE_LSTICK_CLICK = 28;
	public static final int PLAYER_THREE_RSTICK_CLICK = 29;
	public static final int PLAYER_THREE_LSTICK_Y = 10;
	public static final int PLAYER_THREE_LSTICK_X = 11;
	public static final int PLAYER_THREE_RSTICK_Y = 12;
	public static final int PLAYER_THREE_RSTICK_X = 13;
	public static final int PLAYER_THREE_TRIGGER = 14;
	public static final int PLAYER_THREE_POV_UP = 8;
	public static final int PLAYER_THREE_POV_RIGHT = 9;
	public static final int PLAYER_THREE_POV_DOWN = 10;
	public static final int PLAYER_THREE_POV_LEFT = 11;
	
	public static final int PLAYER_FOUR_A = 30;
	public static final int PLAYER_FOUR_B = 31;
	public static final int PLAYER_FOUR_X = 32;
	public static final int PLAYER_FOUR_Y = 33;
	public static final int PLAYER_FOUR_LB = 34;
	public static final int PLAYER_FOUR_RB = 35;
	public static final int PLAYER_FOUR_SELECT = 36;
	public static final int PLAYER_FOUR_START = 37;
	public static final int PLAYER_FOUR_LSTICK_CLICK = 38;
	public static final int PLAYER_FOUR_RSTICK_CLICK = 39;
	public static final int PLAYER_FOUR_LSTICK_Y = 15;
	public static final int PLAYER_FOUR_LSTICK_X = 16;
	public static final int PLAYER_FOUR_RSTICK_Y = 17;
	public static final int PLAYER_FOUR_RSTICK_X = 18;
	public static final int PLAYER_FOUR_TRIGGER = 19;
	public static final int PLAYER_FOUR_POV_UP = 12;
	public static final int PLAYER_FOUR_POV_RIGHT = 13;
	public static final int PLAYER_FOUR_POV_DOWN = 14;
	public static final int PLAYER_FOUR_POV_LEFT = 15;
	
	private World world;
	private int player;
	public GamepadHandler(World world, int player){
		this.world = world;
		this.player= player;
	}

	public GamepadHandler(World world){
		this.world = world;
		this.player= -1;
	}

	@Override
	public void connected(Controller controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnected(Controller controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean buttonDown(Controller controller, int buttonCode) {
		if(player == -1)
			System.out.println(controller.getName()+""+buttonCode);
		switch(player){
		case 1:
			world.controllerButtons[buttonCode] = true;
			break;
		case 2:
			world.controllerButtons[buttonCode+10] = true;
			break;
		case 3:
			world.controllerButtons[buttonCode+20] = true;
			break;
		case 4:
			world.controllerButtons[buttonCode+30] = true;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean buttonUp(Controller controller, int buttonCode) {
		switch(player){
		case 1:
			world.controllerButtons[buttonCode] = false;
			break;
		case 2:
			world.controllerButtons[buttonCode+10] = false;
			break;
		case 3:
			world.controllerButtons[buttonCode+20] = false;
			break;
		case 4:
			world.controllerButtons[buttonCode+30] = false;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value) {
		if(value > 0.15f || value < - 0.15f){
			if(player== -1)
				System.out.println(controller.getName()+"AXIS "+axisCode+"  "+value);
			switch(player){
			case 1:
				world.controllerAxis[axisCode] = value;
				break;
			case 2:
				world.controllerAxis[axisCode + 5] = value;
				break;
			case 3:
				world.controllerAxis[axisCode + 10] = value;
				break;
			case 4:
				world.controllerAxis[axisCode + 15] = value;
				break;
			default:
				break;
			}
		} else{
			switch(player){
			case 1:
				world.controllerAxis[axisCode] = 0;
				break;
			case 2:
				world.controllerAxis[axisCode + 5] = 0;
				break;
			case 3:
				world.controllerAxis[axisCode + 10] = 0;
				break;
			case 4:
				world.controllerAxis[axisCode + 15] = 0;
				break;
			default:
				break;
			}
		}
		return false;
	}

	@Override
	public boolean povMoved(Controller controller, int povCode,
			PovDirection value) {
		if(player==-1)
			System.out.println(controller.getName()+"POV "+povCode+"  "+value);
		int temp = 0;
		 if(value.equals(PovDirection.center))
			 temp = 0;
		 else if(value.equals(PovDirection.north))
			 temp = 1;
		 else if(value.equals(PovDirection.northEast))
			 temp = 2;
		 else if(value.equals(PovDirection.east))
			 temp = 3;
		 else if(value.equals(PovDirection.southEast))
			 temp = 4;
		 else if(value.equals(PovDirection.south))
			 temp = 5;
		 else if(value.equals(PovDirection.southWest))
			 temp = 6;
		 else if(value.equals(PovDirection.west))
			 temp = 7;
		 else if(value.equals(PovDirection.northWest))
			 temp = 8;
		switch(player){
		case 1:
			if(temp == 1 || temp == 2 || temp == 8)
				world.controllerPOV[0] = true;
			else
				world.controllerPOV[0] = false;
			if(temp == 2 || temp == 3 || temp == 4)
				world.controllerPOV[1] = true;
			else
				world.controllerPOV[1] = false;
			if(temp == 4 || temp == 5 || temp == 6)
				world.controllerPOV[2] = true;
			else
				world.controllerPOV[2] = false;
			if(temp == 6 || temp == 7 || temp == 8)
				world.controllerPOV[3] = true;
			else
				world.controllerPOV[3] = false;
			break;
		case 2:
			if(temp == 1 || temp == 2 || temp == 8)
				world.controllerPOV[0+4] = true;
			else
				world.controllerPOV[0+4] = false;
			if(temp == 2 || temp == 3 || temp == 4)
				world.controllerPOV[1+4] = true;
			else
				world.controllerPOV[1+4] = false;
			if(temp == 4 || temp == 5 || temp == 6)
				world.controllerPOV[2+4] = true;
			else
				world.controllerPOV[2+4] = false;
			if(temp == 6 || temp == 7 || temp == 8)
				world.controllerPOV[3+4] = true;
			else
				world.controllerPOV[3+4] = false;
			break;
		case 3:
			if(temp == 1 || temp == 2 || temp == 8)
				world.controllerPOV[0+8] = true;
			else
				world.controllerPOV[0+8] = false;
			if(temp == 2 || temp == 3 || temp == 4)
				world.controllerPOV[1+8] = true;
			else
				world.controllerPOV[1+8] = false;
			if(temp == 4 || temp == 5 || temp == 6)
				world.controllerPOV[2+8] = true;
			else
				world.controllerPOV[2+8] = false;
			if(temp == 6 || temp == 7 || temp == 8)
				world.controllerPOV[3+8] = true;
			else
				world.controllerPOV[3+8] = false;
			break;
		case 4:
			if(temp == 1 || temp == 2 || temp == 8)
				world.controllerPOV[0+12] = true;
			else
				world.controllerPOV[0+12] = false;
			if(temp == 2 || temp == 3 || temp == 4)
				world.controllerPOV[1+12] = true;
			else
				world.controllerPOV[1+12] = false;
			if(temp == 4 || temp == 5 || temp == 6)
				world.controllerPOV[2+12] = true;
			else
				world.controllerPOV[2+12] = false;
			if(temp == 6 || temp == 7 || temp == 8)
				world.controllerPOV[3+12] = true;
			else
				world.controllerPOV[3+12] = false;
			break;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean xSliderMoved(Controller controller, int sliderCode,
			boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ySliderMoved(Controller controller, int sliderCode,
			boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accelerometerMoved(Controller controller,
			int accelerometerCode, Vector3 value) {
		// TODO Auto-generated method stub
		return false;
	}

}
