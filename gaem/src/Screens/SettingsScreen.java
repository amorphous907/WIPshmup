package Screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.amorphous.gaem.ActorAccessor;
import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import View.MenuWorld;
import View.WorldRender;

public class SettingsScreen extends ApplicationAdapter implements Screen{
	private Table table;
	private TextButton ShakeAdd, ShakeMinus, LightToggle, AudioAdd, AudioMinus, Apply, Exit;
	private Skin skin;
	private Stage stage;
	private gaemMain game;
	private TweenManager tweenManager;
	private int level;
	
	private BitmapFont Zero;
	private LabelStyle ls;
	private Label title, audioLevel, shakeLevel, lightLevel, audioLabel, shakeLabel, lightLabel;
	private int audioSetting, shakeSetting, lightSetting;
	private TextureAtlas atlas;
	WorldRender render;
	MenuWorld world;
	
	public SettingsScreen(gaemMain game){
		this.game = game;
		world = new MenuWorld(game, 0);
		render = new WorldRender(world, game);
		level = 1;
		audioSetting = 100;
		shakeSetting = 100;
		lightSetting = 100;
	}

	@Override
	public void render(float delta) {
		world.update();
		render.render();
        stage.act(delta);
        stage.draw();
		//tweenManager.update(delta);
		level = game.saves.getInteger("level");
        
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
		table.invalidateHierarchy();
		table.setSize(width, height);
	}

	@Override
	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("data/UI/button.pack");
		skin = new Skin(atlas);
		table = new Table(skin);
		
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Zero = new BitmapFont(Gdx.files.internal("data/font/Zero.fnt"), false);
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("buttonUp");
		textButtonStyle.down = skin.getDrawable("buttonDown");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = Zero;
		textButtonStyle.fontColor = Color.BLACK;
				
		ShakeAdd = new TextButton("+", textButtonStyle);
		ShakeAdd.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y) {
				//ADD SHAKE
			};
		});
		ShakeAdd.pad(0, 10, 0, 10);
		
		ShakeMinus = new TextButton("-", textButtonStyle);
		ShakeMinus.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//MINUS SHAKE
			}
		});
		ShakeMinus.pad(0, 10, 0, 10);
		
		AudioAdd = new TextButton("+", textButtonStyle);
		AudioAdd.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y) {
				audioSetting++;
				audioLevel.setText(""+audioSetting);
				game.audio.setVolume(audioSetting);
			};
		});
		AudioAdd.pad(0, 10, 0, 10);
		
		AudioMinus = new TextButton("-", textButtonStyle);
		AudioMinus.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				audioSetting--;
				audioLevel.setText(""+audioSetting);
				game.audio.setVolume(audioSetting);
			}
		});
		AudioMinus.pad(0, 10, 0, 10);
		
		LightToggle = new TextButton("", textButtonStyle);
		LightToggle.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				//TOGGLE LIGHT
			}
		});
		LightToggle.pad(20, 20, 20, 20);
		
		Apply = new TextButton("APPLY", textButtonStyle);
		Apply.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//APPLY
			}
		});
		Apply.pad(10, 10, 10, 10);
		
		Exit = new TextButton("EXIT", textButtonStyle);
		Exit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MainMenu(game));
			}
		});
		Exit.pad(10, 75, 10, 75);
		
		ls = new LabelStyle(Zero, Color.WHITE);
		title = new Label("SETTINGS", ls);
		title.setFontScale(2.5f);
		audioLevel = new Label(""+audioSetting, ls);
		shakeLevel = new Label(""+shakeSetting, ls);
		lightLevel = new Label("YES", ls);
		audioLabel = new Label("AUDIO VOLUME", ls);
		shakeLabel = new Label("SHAKE AMMOUNT", ls);
		lightLabel = new Label("LIGHTING", ls);
		table.align(Align.center);
		table.add();
		table.add(audioLabel);
		table.add();
		table.row();
		table.add(AudioMinus);
		//table.getCell(AudioMinus).spaceRight(100);
		table.getCell(AudioMinus).spaceBottom(20);
		table.add(audioLevel);
		//table.getCell(audioLevel).spaceRight(100);
		table.getCell(audioLevel).spaceBottom(20);
		table.add(AudioAdd);
		table.getCell(AudioAdd).spaceBottom(20);
		table.row();
		table.add();
		table.add(shakeLabel);
		table.add();
		table.row();
		table.add(ShakeMinus);
		//table.getCell(ShakeMinus).spaceRight(100);
		table.getCell(ShakeMinus).spaceBottom(20);
		table.add(shakeLevel);
		//table.getCell(shakeLevel).spaceRight(100);
		table.getCell(shakeLevel).spaceBottom(20);
		table.add(ShakeAdd);
		table.getCell(ShakeAdd).spaceBottom(20);
		table.row();
		table.add();
		table.add(lightLabel);
		table.add();
		table.row();
		table.add(LightToggle);
		table.getCell(LightToggle).spaceBottom(200);
		table.add(lightLevel);
		table.getCell(lightLevel).spaceBottom(200);
		table.row();
		table.add(Apply);
		table.add();
		table.add(Exit);
		
		/*table.add(title);
		table.getCell(title).spaceBottom(150);
		table.row();
		table.add(buttonPlay);
		table.getCell(buttonPlay).spaceBottom(15);
		table.row();
		table.add(buttonLevels);
		table.getCell(buttonLevels).spaceBottom(15);
		table.row();
		table.add(buttonEditor);
		table.getCell(buttonEditor).spaceBottom(15);
		table.row();
		table.add(buttonExit);
		table.debug();
		*/
		stage.addActor(table);
		/*
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createSequence().beginSequence()
			.push(Tween.set(buttonPlay, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonLevels, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonEditor, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonExit, ActorAccessor.ALPHA).target(0))
			.push(Tween.from(title, ActorAccessor.ALPHA, .5f).target(0))
			.push(Tween.to(buttonPlay, ActorAccessor.ALPHA, .25f).target(1))
			.push(Tween.to(buttonLevels, ActorAccessor.ALPHA, .25f).target(1))
			.push(Tween.to(buttonEditor, ActorAccessor.ALPHA, .25f).target(1))
			.push(Tween.to(buttonExit, ActorAccessor.ALPHA, .25f).target(1))
			.end().start(tweenManager);
		
		Tween.from(table, ActorAccessor.ALPHA, 0.5f).target(0).start(tweenManager);
		Tween.from(table, ActorAccessor.Y, 0.5f).target(Gdx.graphics.getHeight() / -8).start(tweenManager);*/
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		Zero.dispose();
		
	}

}
