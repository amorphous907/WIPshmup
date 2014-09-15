package View;

import Models.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Hud extends Entity{
	private WorldRender render;
	private Texture texture;
	
	public Hud(Vector2 position, float width, float height, WorldRender render) {
		super(position, width, height);
		this.render = render;
		texture = new Texture(Gdx.files.internal("data/UI/UI.png"));
	}
	
	public void update(){
		renderHud();
		renderText();
	}

	private void renderText() {
		render.renderText("PLAYER 1", 2, 795,  800, 0.5f);
		render.renderText("GUN: "+render.world.player1.gun.name, 2, 795,  828, 0.3f);
		if(render.world.player1.isPlaying()){
			render.renderText(render.world.player1.health+"/"+render.world.player1.maxHealth, 2, 865, 860, 0.3f);
		} else if(render.world.player1.spawnTic != render.world.player1.spawnTime) {
			render.renderText(""+(Math.round((5-render.world.player1.spawnTic))), 2, 885, 860, 0.3f);
		} else {
			render.renderText("PRESS FIRE!", 2, 845, 860, 0.3f);
		}
		
		render.renderText("PLAYER 2", 2, 795,  800-120, 0.5f);
		render.renderText("GUN: "+render.world.player2.gun.name, 2, 795,  828-120, 0.3f);
		if(render.world.player2.isPlaying()){
			render.renderText(render.world.player2.health+"/"+render.world.player2.maxHealth, 2, 865, 860-120, 0.3f);
		} else if(render.world.player2.spawnTic != render.world.player2.spawnTime) {
			render.renderText(""+(Math.round((5-render.world.player2.spawnTic))), 2, 885, 860-120, 0.3f);
		} else {
			render.renderText("PRESS FIRE!", 2, 845, 860-120, 0.3f);
		}
		
		render.renderText("PLAYER 3", 2, 795,  800-234, 0.5f);
		render.renderText("GUN: "+render.world.player3.gun.name, 2, 795,  828-234, 0.3f);
		if(render.world.player3.isPlaying()){
			render.renderText(render.world.player3.health+"/"+render.world.player3.maxHealth, 2, 865, 860-234, 0.3f);
		} else if(render.world.player3.spawnTic != render.world.player3.spawnTime) {
			render.renderText(""+(Math.round((5-render.world.player3.spawnTic))), 2, 885, 860-234, 0.3f);
		} else {
			render.renderText("PRESS FIRE!", 2, 845, 860-234, 0.3f);
		}
		
		render.renderText("PLAYER 2", 2, 795,  800-354, 0.5f);
		render.renderText("GUN: "+render.world.player4.gun.name, 2, 795,  828-354, 0.3f);
		if(render.world.player4.isPlaying()){
			render.renderText(render.world.player4.health+"/"+render.world.player4.maxHealth, 2, 865, 860-354, 0.3f);
		} else if(render.world.player4.spawnTic != render.world.player4.spawnTime) {
			render.renderText(""+(Math.round((5-render.world.player4.spawnTic))), 2, 885, 860-354, 0.3f);
		} else {
			render.renderText("PRESS FIRE!", 2, 845, 860-354, 0.3f);
		}
		
		render.renderText("Score:\n  "+render.world.score, 2, 790, 50, 0.6f);
		render.renderText("Lives:\n  "+render.world.lives, 2, 790, 120, 0.6f);
			
		
	}

	private void renderHud() {
		if((render.world.player1.isPlaying())){
				render.renderHealthBar(render.world.player1, 100, 200, 790, 800, "UEFHealth", "blue background");
		} else{
			render.renderRespawnBar(render.world.player1, 100, 200, 790, 800, "UEFHealth", "blue backgroud");
		}
		
		render.renderProgressBar(render.world.levels.get(render.world.currentLevel), 50, 895, 710, 0, "UEFHealth", "blue background");
		render.draw(this, texture);
	}
}
