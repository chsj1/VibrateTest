package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	Stage stage;
	//以下变量用于实现使用按钮来操控滚动条
	TextureAtlas atlas;//按钮的素材.
	Image zuojiantouImage;//左箭头
	Image youjiantouImage;//右箭头
	@Override
	public void create() {
		stage = new Stage(480,800,false);
		atlas = new TextureAtlas(Gdx.files.internal("data/event.atlas"));
		zuojiantouImage = new Image(atlas.findRegion("zuo"));//初始化左箭头
		youjiantouImage = new Image(atlas.findRegion("you"));//初始化右箭头
		zuojiantouImage.setPosition(100, 500);//设置左箭头的位置
		youjiantouImage.setPosition(220, 500);//设置有箭头的位置
		zuojiantouImage.setColor(Color.YELLOW);
		youjiantouImage.setColor(Color.YELLOW);
		zuojiantouImage.addListener(new InputListener(){//给左箭头添加点击事件
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.input.vibrate(2000);//震动两秒 
				
				return true;
			}
		});
		youjiantouImage.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.input.vibrate(new long[]{//每两个参数组成一对.第一个表示休息多少秒,第二个表示振动多少秒  
		                0,200,200,200,200,200  
		        },-1);//第二个参数表示不重复.若为1,则表示不停地震动  
				return true;
			}
		});
		stage.addActor(zuojiantouImage);//将左箭头添加到舞台上
		stage.addActor(youjiantouImage);//将右箭头添加到舞台上
		Gdx.input.setInputProcessor(stage);
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏
		stage.act();
		stage.draw();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
