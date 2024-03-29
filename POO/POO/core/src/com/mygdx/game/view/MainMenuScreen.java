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
		Texture capa;
		OrthographicCamera camera;
		Viewport viewport;
		private int lastClick, contador;

		public MainMenuScreen(final DungeonsAndDragons game) {
			this.game = game;
			camera = new OrthographicCamera();
			camera.setToOrtho(false, 1060,580);
			capa = new Texture("CapaLetra.jpg");
			lastClick = contador = 0;
//			viewport = new ExtendViewport(1000, 1000, camera); // we create a new Viewport with our camera and we will display our world 300 x 250 units
//			game.batch = new SpriteBatch();
//			camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		@Override
		public void render(float delta) {
			ScreenUtils.clear(0, 0, 0.2f, 1);
			camera.update();
			game.batch.setProjectionMatrix(camera.combined);
			game.batch.begin();
			game.batch.draw(capa, 0, 0, 1060 ,580);
			game.batch.end();
			if (contador - lastClick >= 10) {
				if (Gdx.input.isTouched()) {
					game.setScreen(new SelectionScreen(game));
					dispose();
				}
				lastClick = contador;
			}
			contador++;
		}

		@Override
		public void resize(int width, int height) {
		}

		@Override
		public void show() {
		}

		@Override
		public void hide() {
		}
		
		@Override
		public void pause() {
		}
		
		@Override
		public void resume() {
		}

		@Override
		public void dispose() {
		}
}