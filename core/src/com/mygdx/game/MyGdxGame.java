package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	private Texture gameBackround;
	SpriteBatch batch;
	private Texture ballImage;
    public wallBlock wallObstacle;
	public wallBlock[] multipleWalls;
    float offSetY = 0;
	private Rectangle homeButton;
	public  static Rectangle ballBounce;
    public static Rectangle obstacle1;
	private OrthographicCamera camera;
    public static Vector2 ballPosition;
    private int height;
    private int width;
	static boolean atMenu =true;
	static boolean atCredits = false;

    private homescreen Homescreen;
	@Override
	public void create () {
		gameBackround = new Texture("grayCrossTextureBigger.png");
        camera  = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		height = Gdx.graphics.getHeight();
		width  = Gdx.graphics.getWidth();
		camera.setToOrtho(false, width, height);
		Homescreen = new homescreen();
		Homescreen.create();
		batch = new SpriteBatch();
		multipleWalls = new wallBlock[12];
		for(int R = 0; R < multipleWalls.length; R++) {
            multipleWalls[R] = new wallBlock();
            multipleWalls[R].setWallPosition((int)(Math.random()*500),R *200);
		}
		ballImage = new Texture ("meta-ball.png");
        ballPosition = new Vector2(width/2 - 150/2, 65);
		ballBounce = new Rectangle((width/2 - 150/2), 65, ballImage.getWidth(), ballImage.getHeight());
//		ballBounce = new Rectangle(60, height-ballPosition.y, ballImage.getWidth(), ballImage.getHeight());
			Gdx.input.setInputProcessor(new GestureDetector(new MyGestureListener()));
		renderHomescreen();
    }
	public void renderHomescreen () {
	//yeah

	}
	@Override
	public void render () {
		// R G B A
		Gdx.gl.glClearColor(1, 1, 1, 1);
 		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		camera.position.set(width, ballPosition.y);
		//
		if(!atMenu) {
			updateGame();
			camera.update();
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			batch.draw(gameBackround, 0, 0, 2*width, 3*height);
			// batch.draw(gameBackround.getHeight());


			batch.draw(ballImage, ballPosition.x, ballPosition.y);
			for (int R = 0; R < multipleWalls.length; R++) {
				batch.draw(multipleWalls[R].getRockWall(), multipleWalls[R].getWallPosition().x, multipleWalls[R].getWallPosition().y);
			}


			batch.end();
		}
		else{
			Homescreen.draw();
		}

	}

	public float flip(float y){
		y = (Gdx.graphics.getHeight()) - y;
		return y;
	}
	public  void updateGame () {
		if(!atMenu) {
			ballBounce.setX(ballPosition.x);
			ballBounce.setY(ballPosition.y);

			for (int R = 0; R < multipleWalls.length; R++) {
				multipleWalls[R].updateGame();
			}
			camera.position.set(width / 2, ballPosition.y + (height / 2), 0);

//			if (camera.position.y - offSetY > gameBackround.getHeight() + 457) {
//				System.out.println("Camera " + (camera.position.y - offSetY));
//				System.out.println("back " + gameBackround.getHeight() + 457);
//
//				offSetY += gameBackround.getHeight();
//			}


			if (ballPosition.y >= 1235){
				camera.position.set(width / 2, 1235 + (height / 2), 0);
			}

			if (ballPosition.y >= (camera.position.y - height/2) + height){
				atMenu = true;
				reset();

			}
		}

	}
    public void reset(){
		ballPosition = new Vector2(width/2 - 150/2, 65);
		ballBounce = new Rectangle((width/2 - 150/2), 65, ballImage.getWidth(), ballImage.getHeight());
		camera.setToOrtho(false, width, height);
		camera.position.set(width / 2, ballPosition.y + (height / 2), 0);
	}




	public Rectangle getBallBounce() {
		return ballBounce;
	}


}
