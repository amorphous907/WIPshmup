package View;

import java.util.Iterator;

import Models.MoveableEntity;
import Models.Players.SelectShip;
import Screens.GameScreen;

import com.amorphous.gaem.GamepadHandler;
import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class ShipSelectionWorld extends World{
	Array<MoveableEntity> entity;
	Array<SelectShip> ships1;
	Array<SelectShip> ships2;
	Array<SelectShip> ships3;
	Array<SelectShip> ships4;
	Array<SelectShip> selectedShips;
	int ship1select, ship2select, ship3select, ship4select;
	Iterator<MoveableEntity> eIter;
	int levelthing;

	public ShipSelectionWorld(gaemMain game, int level) {
		super(game, level);
		game.audio.playMusic("ship_selection", 1);
		renderHud = false;
		entity = new Array<MoveableEntity>();
		ships1 = new Array<SelectShip>();
		ships2 = new Array<SelectShip>();
		ships3 = new Array<SelectShip>();
		ships4 = new Array<SelectShip>();
		selectedShips = new Array<SelectShip>();
		ship1select = 0;
		ship2select = 0;
		ship3select = 0;
		ship4select = 0;
		levelthing  = level;
		for(int c = 0; c < 7; c++){
			ships1.add(new SelectShip(new Vector2(175, 1000), c));
		}
		if(gamepads.size >= 1){
			for(int c = 0; c < 7; c++){
				ships2.add(new SelectShip(new Vector2(350, 1000), c));
			}
		}
		if(gamepads.size >= 2){
			for(int c = 0; c < 7; c++){
				ships3.add(new SelectShip(new Vector2(525, 1000), c));
			}
		}
		if(gamepads.size >= 3){
			for(int c = 0; c < 7; c++){
				ships4.add(new SelectShip(new Vector2(700, 1000), c));
			}
		}
	}
	
	@Override
	public void update(){
		handleInputs();
		updateMenu();

		handlePlayer1();
		if(gamepads.size >= 1){
			handlePlayer2();
		}
		if(gamepads.size >= 2){
			handlePlayer3();
		}
		if(gamepads.size >= 3){
			handlePlayer4();
		}
	}
	
	private void updateMenu(){
		eIter = getActors().iterator();
		while(eIter.hasNext()){
			MoveableEntity temp = eIter.next();
			temp.update(this);
			if(temp.remove){
				eIter.remove();
			}
		}
	}
	
	private void handlePlayer1(){
		for(int i = 0; i < 7; i++){
			if(ships1.get(i).enter){
				
			}
			if(i == ship1select){
				if(ships1.get(i).position.y > 900){
					ships1.get(i).enter = true;
					ships1.get(i).leave = false;
					moving = true;
				}
				
			} else {
				if(ships1.get(i).position.y < 900){
					ships1.get(i).leave = true;
					ships1.get(i).enter = false;
					moving = true;
				}
			}
		}
		
		if(keys[PLAYER_ONE_RIGHT] && !moving){
			ship1select++;
			if(ship1select >= 7){
				ship1select = 0;
			}
		}
		if(keys[PLAYER_ONE_LEFT] && !moving){
			ship1select--;
			if(ship1select <= 0){
				ship1select = 6;
			}
		}
		if(keys[PLAYER_ONE_FIRE]){
			selectedShips.add(ships1.get(ship1select));
			if(gamepads.size >= 1){
				selectedShips.add(ships2.get(ship2select));
			}
			if(gamepads.size >= 2){
				selectedShips.add(ships3.get(ship3select));
			}
			if(gamepads.size >= 3){
				selectedShips.add(ships4.get(ship4select));
			}
			game.audio.stopMusic();
			game.setScreen(new GameScreen(game, levelthing, selectedShips));
		}
	}
	
	@Override
	public Array<MoveableEntity> getActors(){
		Array<MoveableEntity> temp = new Array<MoveableEntity>();
		temp.addAll(ships1);
		temp.addAll(ships2);
		temp.addAll(ships3);
		temp.addAll(ships4);
		temp.addAll(entity);
		return temp;
	}
	
	private void handlePlayer2(){
		for(int i = 0; i < 7; i++){
			if(ships2.get(i).enter){
				
			}
			if(i == ship2select){
				if(ships2.get(i).position.y > 900){
					ships2.get(i).enter = true;
					ships2.get(i).leave = false;
					moving = true;
				}
				
			} else {
				if(ships2.get(i).position.y < 900){
					ships2.get(i).leave = true;
					ships2.get(i).enter = false;
					moving = true;
				}
			}
		}
		
		if((keys[PLAYER_TWO_RIGHT] || controllerPOV[GamepadHandler.PLAYER_TWO_POV_RIGHT] ) && !moving){
			ship2select++;
			if(ship2select >= 7){
				ship2select = 0;
			}
		}
		if((keys[PLAYER_TWO_LEFT] || controllerPOV[GamepadHandler.PLAYER_TWO_POV_LEFT]) && !moving){
			ship2select--;
			if(ship2select <= 0){
				ship2select = 6;
			}
		}
	}

	private void handlePlayer3(){
		for(int i = 0; i < 7; i++){
			if(ships3.get(i).enter){
				
			}
			if(i == ship3select){
				if(ships3.get(i).position.y > 900){
					ships3.get(i).enter = true;
					ships3.get(i).leave = false;
					moving = true;
				}
				
			} else {
				if(ships3.get(i).position.y < 900){
					ships3.get(i).leave = true;
					ships3.get(i).enter = false;
					moving = true;
				}
			}
		}
		
		if((keys[PLAYER_THREE_RIGHT] || controllerPOV[GamepadHandler.PLAYER_THREE_POV_RIGHT] ) && !moving){
			ship3select++;
			if(ship3select >= 7){
				ship3select = 0;
			}
		}
		if((keys[PLAYER_THREE_LEFT] || controllerPOV[GamepadHandler.PLAYER_THREE_POV_LEFT]) && !moving){
			ship3select--;
			if(ship3select <= 0){
				ship3select = 6;
			}
		}
	}

	private void handlePlayer4(){
		for(int i = 0; i < 7; i++){
			if(ships4.get(i).enter){
				
			}
			if(i == ship4select){
				if(ships4.get(i).position.y > 900){
					ships4.get(i).enter = true;
					ships4.get(i).leave = false;
					moving = true;
				}
				
			} else {
				if(ships4.get(i).position.y < 900){
					ships4.get(i).leave = true;
					ships4.get(i).enter = false;
					moving = true;
				}
			}
		}
		
		if((keys[PLAYER_FOUR_RIGHT] || controllerPOV[GamepadHandler.PLAYER_FOUR_POV_RIGHT] ) && !moving){
			ship4select++;
			if(ship4select >= 7){
				ship4select = 0;
			}
		}
		if((keys[PLAYER_FOUR_LEFT] || controllerPOV[GamepadHandler.PLAYER_FOUR_POV_LEFT]) && !moving){
			ship4select--;
			if(ship4select <= 0){
				ship4select = 6;
			}
		}
	}
	
	@Override
	protected void handleInputs(){
		super.handleInputs();
		
	}
	
}
