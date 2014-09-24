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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu extends ApplicationAdapter implements Screen{
	private Table table;
	private TextButton buttonExit, buttonPlay, buttonLevels, buttonEditor;
	private Skin skin;
	private Stage stage;
	private gaemMain game;
	private TweenManager tweenManager;
	private int level;
	
	private BitmapFont Zero;
	private LabelStyle ls;
	private Label title;
	private TextureAtlas atlas;
	
	public MainMenu(gaemMain game){
		this.game = game;
		level = 1;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
		tweenManager.update(delta);
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
		game.audio.playMusic("menu", 1);
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
				
		buttonExit = new TextButton("QUIT", textButtonStyle);
		buttonExit.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			};
		});
		buttonExit.pad(10, 75, 10, 75);
		
		buttonPlay = new TextButton("PLAY", textButtonStyle);
		buttonPlay.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.audio.stopMusic();
				game.setScreen(new GameScreen(game, level));
			}
		});
		buttonPlay.pad(10, 75, 10, 75);
		
		buttonLevels = new TextButton("LEVEL SELECT", textButtonStyle);
		buttonLevels.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				Gdx.input.getTextInput(new TextInputListener(){

					@Override
					public void input(String text) {
						level = Integer.parseInt(text);
						game.saves.putInteger("level", level);
						game.saves.flush();
					}

					@Override
					public void canceled() {
						
					}
					
				}, "Enter Level Number", "1");
			}
		});
		buttonLevels.pad(10, 75, 10, 75);
		
		buttonEditor = new TextButton("LEVEL EDITOR", textButtonStyle);
		buttonEditor.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				level = 0;
				game.audio.stopMusic();
				game.setScreen(new GameScreen(game, level));
			}
		});
		buttonEditor.pad(10, 75, 10, 75);
		
		ls = new LabelStyle(Zero, Color.WHITE);
		title = new Label(gaemMain.TITLE, ls);
		title.setFontScale(2.5f);
		table.add(title);
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
		stage.addActor(table);
		
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
		Tween.from(table, ActorAccessor.Y, 0.5f).target(Gdx.graphics.getHeight() / -8).start(tweenManager);
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
