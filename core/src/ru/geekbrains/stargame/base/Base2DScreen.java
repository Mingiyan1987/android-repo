package ru.geekbrains.stargame.base;


/*
    * Базовый класс для всех экранов
 */

public class Base2DScreen implements Screen {
    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize w = " + " h = " + height);
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void hide() {
        System.out.println("hide");
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
    }
}
