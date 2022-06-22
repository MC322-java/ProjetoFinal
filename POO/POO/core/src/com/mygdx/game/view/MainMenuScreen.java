package com.mygdx.game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.DungeonsAndDragons;

public class MainMenuScreen implements Screen {

		final DungeonsAndDragons game;

		OrthographicCamera camera;
		Viewport viewport;

		public MainMenuScreen(final DungeonsAndDragons game) {
			this.game = game;
			camera = new OrthographicCamera();
			camera.setToOrtho(false, 800, 480);
//			viewport = new ExtendViewport(1000, 1000, camera); // we create a new Viewport with our camera and we will display our world 300 x 250 units
//			game.batch = new SpriteBatch();
//			camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void render(float delta) {
			ScreenUtils.clear(0, 0, 0.2f, 1);
			camera.update();
			game.batch.setProjectionMatrix(camera.combined);
			Texture img = new Texture("Capa.jpg");
			game.batch.begin();
			game.batch.draw(img, 0, 0, 800, 480);
			game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
//			game.batch.draw(new Texture("dragao.png"), 0, 0);
			game.batch.end();
			if (Gdx.input.isTouched()) {
				game.setScreen(new MapScreen(game));
				dispose();
			}
		}

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
//			viewport.update(width, height);
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

	}
