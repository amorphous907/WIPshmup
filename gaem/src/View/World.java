package View;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import Models.MoveableEntity;
import Models.PointLight;
import Models.Text;
import Models.subObject;
import Models.Players.Player;
import Models.Players.Player1;
import Models.Players.Player2;
import Models.Players.Player3;
import Models.Players.Player4;
import Models.Players.SelectShip;
import Screens.MainMenu;
import View.Levels.levelEditor;
import View.Levels.level_1;
import View.Levels.level_10;
import View.Levels.level_11;
import View.Levels.level_12;
import View.Levels.level_13;
import View.Levels.level_14;
import View.Levels.level_15;
import View.Levels.level_16;
import View.Levels.level_17;
import View.Levels.level_18;
import View.Levels.level_19;
import View.Levels.level_2;
import View.Levels.level_20;
import View.Levels.level_3;
import View.Levels.level_4;
import View.Levels.level_5;
import View.Levels.level_6;
import View.Levels.level_7;
import View.Levels.level_8;
import View.Levels.level_9;
import View.Levels.level_TEST;

import com.amorphous.gaem.GamepadHandler;
import com.amorphous.gaem.InputHandler;
import com.amorphous.gaem.AudioManager;
import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
	public int layers = 15;
	public boolean moving = false;
	public float ShakeAmmount;

	public Array<Array<MoveableEntity>> actors;
	public Array<MoveableEntity> actors2;
	public Iterator<MoveableEntity> aIter;
	public Iterator<MoveableEntity> aIter2;
	public Iterator<Array<MoveableEntity>> layerIter;
	public Array<Array<MoveableEntity>> background;
	public Array<Array<MoveableEntity>> foreground;
	public Array<Text> text;
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
	
	public Vector3 mousePos;
	public int mouseDown;

	level_TEST levelT;
	level_1 level1;
	level_2 level2;
	level_3 level3;
	level_4 level4;
	level_5 level5;
	level_6 level6;
	level_7 level7;
	level_8 level8;
	level_9 level9;
	level_10 level10;
	level_11 level11;
	level_12 level12;
	level_13 level13;
	level_14 level14;
	level_15 level15;
	level_16 level16;
	level_17 level17;
	level_18 level18;
	level_19 level19;
	level_20 level20;
	levelEditor edit;
	public Array<View.Levels.level> levels;
	public View.Levels.level level;
	public int currentLevel;
	
	public Vector3 ambientLightColor = new Vector3(0.8f, 0.8f, 0.8f);;
	public float ambientLightIntensity = .6f;
	public PointLight light;
	
	public int lives;
	public boolean renderHud;
	//ignore this parker
	public World(gaemMain game, int level, Array<SelectShip> selectedShips){
		
		this.game = game;
		timer = new Timer();
		renderHud = true;
		mousePos = new Vector3();
		mouseDown = -1;
		
		edit = new levelEditor(this);//0
		level1 = new level_1(this);//1
		level2 = new level_2(this);//2
		level3 = new level_3(this);//2
		level4 = new level_4(this);//2
		level5 = new level_5(this);//2
		level6 = new level_6(this);//2
		level7 = new level_7(this);//2
		level8 = new level_8(this);//2
		level9 = new level_9(this);//2
		level10 = new level_10(this);//2
		level11 = new level_11(this);//2
		level12 = new level_12(this);//2
		level13 = new level_13(this);//2
		level14 = new level_14(this);//2
		level15 = new level_15(this);//2
		level16 = new level_16(this);//2
		level17 = new level_17(this);//2
		level18 = new level_18(this);//2
		level19 = new level_19(this);//2
		level20 = new level_20(this);//2
		currentLevel = level;

		levels = new Array<View.Levels.level>();
		levels.add(edit); //0
		levels.add(level1); //1
		levels.add(level2); //2
		levels.add(level3);
		levels.add(level4);
		levels.add(level5);
		levels.add(level6);
		levels.add(level7);
		levels.add(level8);
		levels.add(level9);
		levels.add(level10);
		levels.add(level12);
		levels.add(level13);
		levels.add(level14);
		levels.add(level15);
		levels.add(level16);
		levels.add(level17);
		levels.add(level18);
		levels.add(level19);
		levels.add(level20);

		lives = 110;
		players = 1;

		actors = new Array<Array<MoveableEntity>>();
		for(int c = 0; c <= layers; c++){
			actors.add(new Array<MoveableEntity>());
		}
		background = new Array<Array<MoveableEntity>>();
		for(int c = 0; c <= layers; c++){
			background.add(new Array<MoveableEntity>());
		}
		foreground = new Array<Array<MoveableEntity>>();
		for(int c = 0; c <= layers; c++){
			foreground.add(new Array<MoveableEntity>());
		}
		text = new Array<Text>();
		
		spawn = new Vector2(325, 725);

		rnd = new Random();

		Gdx.input.setInputProcessor(new InputHandler(this));
		//Controllers.addListener(new GamepadHandler(this));
		gamepads = Controllers.getControllers();
		
		player1=new Player1(new Vector2(9999 , 99999),60,60,45,45, selectedShips.get(0));
		if(gamepads.size >= 1){
			player2=new Player2(new Vector2(9999 , 99999),60,60,45,45,selectedShips.get(1));
		} else {
			player2=new Player2(new Vector2(9999 , 99999),60,60,45,45);
		}
		if(gamepads.size >= 2){
			player3=new Player3(new Vector2(9999 , 99999),60,60,45,45,selectedShips.get(2));
		} else {
			player3=new Player3(new Vector2(9999 , 99999),60,60,45,45);
		}
		if(gamepads.size >= 3){
			player4=new Player4(new Vector2(9999 , 99999),60,60,45,45,selectedShips.get(3));
		} else {
			player4=new Player4(new Vector2(9999 , 99999),60,60,45,45);
		}
		
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
			ShakeAmmount = 0;
		}

		light = new PointLight(new Vector2(0,0), 300, 300, 0, 0);
		light.hasLight = false;
		actors.get(0).add(light);

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

	public World(gaemMain game, int level) {
		this.game = game;
		timer = new Timer();
		renderHud = true;
		mousePos = new Vector3();
		mouseDown = -1;
		
		edit = new levelEditor(this);//0
		level1 = new level_1(this);//1
		level2 = new level_2(this);//2
		level3 = new level_3(this);//2
		level4 = new level_4(this);//2
		level5 = new level_5(this);//2
		level6 = new level_6(this);//2
		level7 = new level_7(this);//2
		level8 = new level_8(this);//2
		level9 = new level_9(this);//2
		level10 = new level_10(this);//2
		level11 = new level_11(this);//2
		level12 = new level_12(this);//2
		level13 = new level_13(this);//2
		level14 = new level_14(this);//2
		level15 = new level_15(this);//2
		level16 = new level_16(this);//2
		level17 = new level_17(this);//2
		level18 = new level_18(this);//2
		level19 = new level_19(this);//2
		level20 = new level_20(this);//2
		
		currentLevel = level;

		levels = new Array<View.Levels.level>();
		levels.add(edit); //0
		levels.add(level1); //1
		levels.add(level2); //2
		levels.add(level3);
		levels.add(level4);
		levels.add(level5);
		levels.add(level6);
		levels.add(level7);
		levels.add(level8);
		levels.add(level9);
		levels.add(level10);
		levels.add(level11);
		levels.add(level12);
		levels.add(level13);
		levels.add(level14);
		levels.add(level15);
		levels.add(level16);
		levels.add(level17);
		levels.add(level18);
		levels.add(level19);
		levels.add(level20);

		lives = 110;
		players = 1;

		actors = new Array<Array<MoveableEntity>>();
		for(int c = 0; c <= layers; c++){
			actors.add(new Array<MoveableEntity>());
		}
		background = new Array<Array<MoveableEntity>>();
		for(int c = 0; c <= layers; c++){
			background.add(new Array<MoveableEntity>());
		}
		foreground = new Array<Array<MoveableEntity>>();
		for(int c = 0; c <= layers; c++){
			foreground.add(new Array<MoveableEntity>());
		}
		text = new Array<Text>();
		
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


		light = new PointLight(new Vector2(0,0), 300, 300, 0, 0);
		light.hasLight = false;
		actors.get(0).add(light);

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
		handleInputs();
		updateActors();
		if(level.bossDead)
		{
			game.audio.stopMusic();
			currentLevel++;
			level.update();
			level = levels.get(currentLevel);
		}
		level.update();
		light.position.x = mousePos.x-light.width/2;
		light.position.y = mousePos.y-light.height/2;
	}

	//updates everything
	protected void updateActors() {
		//ignore all this parker

		if(player1.isPlaying()){
			player1.update(this);
		}
		else{
			player1.setPosition(new Vector2(spawn));
			player1.spawnTic += Gdx.graphics.getDeltaTime();;
			if(player1.spawnTic > 5)
				player1.spawnTic = 5;
			if(keys[PLAYER_ONE_FIRE] || controllerButtons[GamepadHandler.PLAYER_ONE_A])
				respawn(player1);
		}

		if(player2.isPlaying())
			player2.update(this);
		else{
			player2.setPosition(new Vector2(spawn));
			player2.spawnTic += Gdx.graphics.getDeltaTime();;
			if(player2.spawnTic > 5)
				player2.spawnTic = 5;
			if(keys[PLAYER_TWO_FIRE] || controllerButtons[GamepadHandler.PLAYER_TWO_A])
				respawn(player2);
		}
		if(player3.isPlaying())
			player3.update(this);
		else{
			player3.setPosition(new Vector2(spawn));
			player3.spawnTic += Gdx.graphics.getDeltaTime();;
			if(player3.spawnTic > 5)
				player3.spawnTic = 5;
			if(keys[PLAYER_THREE_FIRE] || controllerButtons[GamepadHandler.PLAYER_THREE_A])
				respawn(player3);
		}

		if(player4.isPlaying())
			player4.update(this);
		else{
			player4.setPosition(new Vector2(spawn));
			player4.spawnTic += Gdx.graphics.getDeltaTime();
			if(player4.spawnTic > 5)
				player4.spawnTic = 5;
			if(keys[PLAYER_FOUR_FIRE] || controllerButtons[GamepadHandler.PLAYER_FOUR_A])
				respawn(player4);
		}

		layerIter = actors.iterator();
		while(layerIter.hasNext()){
			aIter = layerIter.next().iterator();
			while(aIter.hasNext()){
				entity = aIter.next();
				entity.update(this);
				if(entity.remove){
					if(entity.dead)
						score += entity.score;
					aIter.remove();
				}
			}
		}
		layerIter = background.iterator();
		while(layerIter.hasNext()){
			aIter = layerIter.next().iterator();
			while(aIter.hasNext()){
				entity = aIter.next();
				entity.update(this);
				if(entity.remove){
					if(entity.dead)
						score += entity.score;
					aIter.remove();
				}
			}
		}
		layerIter = foreground.iterator();
		while(layerIter.hasNext()){
			aIter = layerIter.next().iterator();
			while(aIter.hasNext()){
				entity = aIter.next();
				entity.update(this);
				if(entity.remove){
					if(entity.dead)
						score += entity.score;
					aIter.remove();
				}
			}
		}
		collideActors(getCollisionActors());
		if(ShakeAmmount > 0){
			ShakeAmmount -= (3 * Gdx.graphics.getDeltaTime());
		}
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
		array.addAll(getSubActors(getLayeredBackground()));
		array.addAll(getSubActors(getLayeredActors()));
		array.add(player1);
		array.add(player2);
		array.add(player3);
		array.add(player4);
		array.addAll(getSubActors(getLayeredForeground()));
		return array; 
	}

	public Array<MoveableEntity> getCollisionActors(){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		array.addAll(getSubActors(getLayeredActors()));
		array.add(player1);
		array.add(player2);
		array.add(player3);
		array.add(player4);
		return array;
	}
	
	public Array<MoveableEntity> getLayeredActors(){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		for(int c =  actors.size-1; c >= 0 ; c--){
			for(int a = 0; a < actors.get(c).size; a++){
				array.add(actors.get(c).get(a));
			}
		}
		return array;
	}
	
	public Array<MoveableEntity> getLayeredBackground(){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		for(int c = background.size-1; c >= 0 ; c--){
			for(int a = 0; a < background.get(c).size; a++){
				array.add(background.get(c).get(a));
			}
		}
		return array;
	}
	
	public Array<MoveableEntity> getLayeredForeground(){
		Array<MoveableEntity> array = new Array<MoveableEntity>();
		for(int c =  foreground.size-1; c >= 0 ; c--){
			for(int a = 0; a < foreground.get(c).size; a++){
				array.add(foreground.get(c).get(a));
			}
		}
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

	protected void handleInputs() {
		if(keys[Keys.ESCAPE]){
			game.audio.stopMusic();
			game.setScreen(new MainMenu(game));
		}
		if(keys[Keys.PLUS]){
			ambientLightIntensity += 0.03;
		}
		if(keys[Keys.MINUS]){
			ambientLightIntensity -= 0.03;
		}
		
		if(mouseDown == 0){
			light.hasLight = true;
		} else{
			light.hasLight = false;
		}
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

	public Array<Text> getText() {
		Array<Text> temp = new Array<Text>();
		temp.addAll(text);
		text.clear();
		return temp;
	}

	public float getShakeAmmount() {
		return ShakeAmmount;
	}


}
