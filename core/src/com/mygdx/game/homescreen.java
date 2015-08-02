package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by alexfranklin on 7/8/15.
 */
public class homescreen {
    private OrthographicCamera camera;
    private Texture gameBackround;
    private Texture title;
    private Texture ball;
    private Texture playbutton;
    private Rectangle playbox;
    private SpriteBatch batch;
    private int height;
    private int width;
    private int playwidth;
    private int playheight;
    private int touchx;
    private int touchy;

public void create() {
    gameBackround = new Texture("grayCrossTextureBigger.png");
    title = new Texture("GuideTitle.png");
    ball = new Texture ("meta-ball.png");
    playbutton = new Texture ("playv3.png");
    playbox = new Rectangle();
    height = Gdx.graphics.getHeight();
    width  = Gdx.graphics.getWidth();
    camera  = new OrthographicCamera(width,height);
    batch = new SpriteBatch();


  playwidth = 2* playbutton.getWidth();
  playheight = 2* playbutton.getHeight();
//    playbox.set(width/2 - 208, height/4, playwidth, playheight);
    playbox.set(width/2 - 208, height - height/4 - 225, playwidth, playheight);
    camera.setToOrtho(false, width, height);

}
    public void update(){
   if(Gdx.input.isTouched()){
       touchx = Gdx.input.getX();
       touchy = Gdx.input.getY();
       if(playbox.contains(touchx, touchy)){
            System.out.println("TACO");
           MyGdxGame.atMenu = false;
       }
    }
    }

public void draw() {
    camera.update();
    batch.setProjectionMatrix(camera.combined);
    update();
    batch.begin();
    batch.draw(gameBackround, 0, 0, 2 * width, 2 * width);
    batch.draw(title, width/2 - 387, height - 500, width, height/3);
    batch.draw(ball, width/2 - 200, height/2 - 100, width/2, height/3);
    batch.draw(playbutton, width/2 - 208, height/4, playwidth, playheight) ;
    batch.end();

    }

}
