package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;

/*
    * Экран меню
 */

public class MenuScreen extends Base2DScreen {

    private static final float SPEED = 1f;

    SpriteBatch batch;
    Texture img;
    Texture imgBackGround;

    Vector2 pos;
    Vector2 speed;

    Vector2 touch;

    Vector2 buf;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        imgBackGround = new Texture("background.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0, 0);
        touch = new Vector2();
        speed = new Vector2(0, 0);
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        if (buf.cpy().sub(pos).len() > SPEED) {
            pos.add(speed);
        } else {
            pos.set(touch);
            speed.setZero();
        }
        batch.begin();
        batch.draw(imgBackGround, 0, 0);
        batch.draw(img, pos.x, pos.y);
        batch.end();
        pos.add(speed);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        speed.set(touch.cpy().sub(pos).setLength(SPEED));
        System.out.println("touch.x " + touch.x + "touch.y" + touch.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }
}
