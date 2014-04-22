package View;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import Models.MoveableEntity;
import Models.subObject;
import Models.Players.Player;
import Models.Players.Player1;
import Models.Players.Player2;
import Models.Players.Player3;
import Models.Players.Player4;
import View.Levels.level_1;
import View.Levels.level_2;
import View.Levels.level_3;
import View.Levels.level_TEST;

import com.amorphous.gaem.GamepadHandler;
import com.amorphous.gaem.InputHandler;
import com.amorphous.gaem.AudioManager;
import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;

public class World {
	public gaemMain game;
	AudioManager audio;
	public WorldRender render;
	public boolean[] keys, controllerButtons, controllerPOV;
	public float[] controllerAxis;
	public Timer timer;
	public int score = 0;

	public Array<MoveableEntity> actors;
	public Array<MoveableEntity> actors2;
	public Iterator<MoveableEntity> aIter;
	public Iterator<MoveableEntity> aIter2;
	public Array<MoveableEntity> background;
	public int players;
	public Array<Controller> gamepads;
	Controller player1Gamepad, player2Gamepad, player3Gamepad, player4Gamepad;

	MoveableEntity entity;
	MoveableEntity entity2;
	subObject subObject;

	Random rnd;
	public Player player1;
	public Player player2;
	public Player player3;
	public Player player4;
	public Vector2 spawn;
	
	public static final int PLAYER_ONE_FIRE = Keys.SHIFT_LEFT;
	public static final int PLAYER_ONE_UP = Keys.W;
	public static final int PLAYER_ONE_RIGHT = Keys.D;
	public static final int PLAYER_ONE_DOWN = Keys.S;
	public static final int PLAYER_ONE_LEFT = Keys.A;
	
	public static final int PLAYER_TWO_FIRE = Keys.ENTER;
	public static final int PLAYER_TWO_UP = Keys.NUM_8;
	public static final int PLAYER_TWO_RIGHT = Keys.NUM_6;
	public static final int PLAYER_TWO_DOWN = Keys.NUM_5;
	public static final int PLAYER_TWO_LEFT = Keys.NUM_4;
	
	public static final int PLAYER_THREE_FIRE = Keys.SHIFT_RIGHT;
	public static final int PLAYER_THREE_UP = Keys.O;
	public static final int PLAYER_THREE_RIGHT = Keys.SEMICOLON;
	public static final int PLAYER_THREE_DOWN = Keys.L;
	public static final int PLAYER_THREE_LEFT = Keys.K;
	
	public static final int PLAYER_FOUR_FIRE = Keys.SPACE;
	public static final int PLAYER_FOUR_UP = Keys.Y;
	public static final int PLAYER_FOUR_RIGHT = Keys.J;
	public static final int PLAYER_FOUR_DOWN = Keys.H;
	public static final int PLAYER_FOUR_LEFT = Keys.G;

	level_TEST levelT;
	level_1 level1;
	level_2 level2;
	level_3 level3;
	Array<level_1> levels;
	public level_1 level;
	int currentLevel;

	public int lives;
	//ignore this parker
	public World(gaemMain game, int level){
		this.game = game;
		timer = new Timer();
		levelT = new level_TEST();//0
		level1 = new level_1();//1
		level2 = new level_2();//2
		level3 = new level_3();//3
		currentLevel = level;

		levels = new Array<level_1>();
		levels.add(levelT); //0
		levels.add(level1); //1
		levels.add(level2); //2

		lives = 110;
		players = 1;

		actors = new Array<MoveableEntity>();
		background = new Array<MoveableEntity>();

		spawn = new Vector2(325, 725);
		player1=new Player1(new Vector2(9999 , 99999),60,60,45,45);
		player2=new Player2(new Vector2(9999 , 99999),60,60,45,45);
		player3=new Player3(new Vector2(9999 , 99999),60,60,45,45);
		player4=new Player4(new Vector2(9999 , 99999),60,60,45,45);

		rnd = new Random();

		Gdx.input.setInputProcessor(new InputHandler(this));
		//Controllers.addListener(new GamepadHandler(this));
		gamepads = Controllers.getControllers();
		if(gamepads.size < 4){
			for(int c = 0; c < gamepads.size; c++){
				switch(c){
				case 0:
					player2Gamepad = gamepads.get(c);
					player2.gamepad = true;
					player2Gamepad.addListener(new GamepadHandler(this, 2));
					break;
				case 1:
					player3Gamepad = gamepads.get(c);
					player3.gamepad = true;
					player3Gamepad.addListener(new GamepadHandler(this, 3));
					System.out.println(c);
					break;
				case 2:
					player4Gamepad = gamepads.get(c);
					player4.gamepad = true;
					player4Gamepad.addListener(new GamepadHandler(this, 4));
					break;
				default:
					break;
				}
			}
		} else{
			for(int c = 0; c < gamepads.size; c++){
				switch(c){
				case 0:
					player1Gamepad = gamepads.get(c);
					player1.gamepad = true;
					player1Gamepad.addListener(new GamepadHandler(this, 1));
					break;
				case 1:
					player2Gamepad = gamepads.get(c);
					player2.gamepad = true;
					player2Gamepad.addListener(new GamepadHandler(this, 2));
					break;
				case 2:
					player3Gamepad = gamepads.get(c);
					player3.gamepad = true;
					player3Gamepad.addListener(new GamepadHandler(this, 3));
					break;
				case 3:
					player4Gamepad = gamepads.get(c);
					player4.gamepad = true;
					player4Gamepad.addListener(new GamepadHandler(this, 4));
					break;
				default:
					break;
				}
			}
		}



		keys = new boolean[255];
		controllerButtons = new boolean[9*4];
		controllerAxis = new float[5*4];
		controllerPOV = new boolean[4*4];
		Arrays.fill(keys, Boolean.FALSE);
		Arrays.fill(controllerPOV, Boolean.FALSE);
		Arrays.fill(controllerButtons, Boolean.FALSE);
		Arrays.fill(controllerAxis, 0.0f);
		this.level = levels.get(currentLevel);
	}

	public void update(){
		//and this
		updateActors();
		if(level.bossDead)
		{
			game.audio.stopMusic();
			currentLevel++;
			level.update(this);
			level.bossDead = false;
			level = levels.get(currentLevel);
		}
		level.update(this);
	}

	//updates everything
	private void updateActors() {
		//ignore all this parker

		if(player1.isPlaying()){
			player1.update(this);
		}
		else{
			player1.setPosition(new Vector2(spawn));
			player1.spawnTic++;
			if(player1.spawnTic > 300)
				player1.spawnTic = 300;
			if(keys[PLAYER_ONE_FIRE] || controllerButtons[GamepadHandler.PLAYER_ONE_A])
				respawn(player1);
		}

		if(player2.isPlaying())
			player2.update(this);
		else{
			player2.setPosition(new Vector2(spawn));
			player2.spawnTic++;
			if(player2.spawnTic > 300)
				player2.spawnTic = 300;
			if(keys[PLAYER_TWO_FIRE] || controllerButtons[GamepadHandler.PLAYER_TWO_A])
				respawn(player2);
		}
		if(player3.isPlaying())
			player3.update(this);
		else{
			player3.setPosition(new Vector2(spawn));
			player3.spawnTic++;
			if(player3.spawnTic > 300)
				player3.spawnTic = 300;
			if(keys[PLAYER_THREE_FIRE] || controllerButtons[GamepadHandler.PLAYER_THREE_A])
				respawn(player3);
		}

		if(player4.isPlaying())
			player4.update(this);
		else{
			player4.setPosition(new Vector2(spawn));
			player4.spawnTic++;
			if(player4.spawnTic > 300)
				player4.spawnTic = 300;
			if(keys[PLAYER_FOUR_FIRE] || controllerButtons[GamepadHandler.PLAYER_FOUR_A])
				respawn(player4);
		}

		aIter = actors.iterator();
		while(aIter.hasNext()){
			entity = aIter.next();
			entity.update(this);
			if(entity.remove){
				if(entity.dead)
					score += entity.score;
				aIter.remove();
			}
		}
		aIter = background.iterator();
		while(aIter.hasNext()){
			entity = aIter.next();
			entity.update(this);
			if(entity.remove){
				if(entity.dead)
					score += entity.score;
				aIter.remove();
			}
		}
		collideActors(getCollisionActors());
	}


	private void collideActors(Array<MoveableEntity> entities) {
		aIter = entities.iterator();
		while(aIter.hasNext()){
			entity = aIter.next();
			actors2 = entities;
			for(int c = 0 ; c < actors2.size ; c++){
				if(entity.circle){
					if(actors2.get(c).circle){
						if(com.badlogic.gdx.math.Intersector.overlaps(entity.getCircle(), actors2.get(c).getCircle()))
							entity.collidesWith(actors2.get(c), this);
					} else{
						if(com.badlogic.gdx.math.Intersector.overlaps(entity.getCircle(), actors2.get(c).getBounds()))
							entity.collidesWith(actors2.get(c), this);
					}
				} else if(actors2.get(c).circle){
					if(com.badlogic.gdx.math.Intersector.overlaps(actors2.get(c).getCircle(), entity.getBounds()))
						entity.collidesWith(actors2.get(c), this);
				} else{
					if(com.badlogic.gdx.math.Intersector.overlaps(entity.getBounds(), actors2.get(c).getBounds()))
						entity.collidesWith(actors2.get(c), this);
				}
				/*if(entity.getBounds().overlaps(actors2.get(c).getBounds())){
					entity.collidesWith(actors2.get(c), this);
				}*/
			}
		}
	}

	public Array<MoveableEntity> getActors(){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		array.addAll(getSubActors(background));
		array.addAll(getSubActors(actors));
		array.add(player1);
		array.add(player2);
		array.add(player3);
		array.add(player4);
		return array;
	}

	public Array<MoveableEntity> getCollisionActors(){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		array.addAll(getSubActors(actors));
		array.add(player1);
		array.add(player2);
		array.add(player3);
		array.add(player4);
		return array;
	}

	public Array<MoveableEntity> getSubActors(Array<MoveableEntity> targetArray){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		array.addAll(targetArray);
		Iterator<MoveableEntity> tempIter = targetArray.iterator();
		MoveableEntity tempEntity;
		while(tempIter.hasNext()){
			tempEntity = tempIter.next();
			if(tempEntity.subObjects.size > 0){
				Array<MoveableEntity> tempArray = new Array<MoveableEntity>();
				tempArray.addAll(tempEntity.subObjects);
				array.addAll(getSubActors(tempArray));
			}
		}
		return array;
	}

	private void handleInputs() {

	}

	public void dispose(){

	}

	public void setRender(WorldRender render){
		this.render = render;
	}

	public WorldRender getRender(){
		return render;
	}

	public void respawn(Player player) {
		if(lives > 0 && player.setPlaying()){
			lives--;
		}
	}


}
