package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.TabuleiroController;

public class MapScreen implements Screen {

	
	public final DungeonsAndDragons game;
	
	OrthographicCamera camera;
	
	public MapScreen(final DungeonsAndDragons game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
//		camera.setToOrtho(false, Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
	};
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
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
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		ScreenUtils.clear(0, 0, 0.2f, 1);
		int squareSize = 15;
	    camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		Texture parede = new Texture("parede.png");
		game.batch.begin();
		for (int i = 0; i < Gdx.graphics.getHeight() / squareSize; i++) {
			for (int j = 0; j < Gdx.graphics.getWidth() / squareSize; j++) {
				game.batch.draw(parede, j * squareSize, i * squareSize, squareSize, squareSize);
			}
		}
		Texture chao = new Texture("chao.png");
////		game.batch.draw(chao, squareSize*4, squareSize*4, squareSize, squareSize);
////		game.batch.begin();
		for (int i = 2; i < Math.min(27, Gdx.graphics.getHeight() / squareSize); i++) {
			for (int j = 14; j < Math.min(39, Gdx.graphics.getWidth() / squareSize); j++) {
				game.batch.draw(chao, j * squareSize, i * squareSize, squareSize, squareSize);
			}
		}
		// Initial position == (2, 14)
//		Skin skin = new Skin();
//		TextButton button = new TextButton("Close game", skin);
//		button.addListener (new ChangeListener() {
//		    // This method is called whenever the actor is clicked. We override its behavior here.
//		    @Override
//		    public void changed(ChangeEvent event, Actor actor) {
//		        // This is where we remove the window.
//		        dispose();
//		    }
//		});
		TabuleiroController.getInstance().drawMap(this, squareSize);
		game.batch.end();
//		dispose();
		if (Gdx.input.isTouched()) {
			dispose();
		}
	}

}
