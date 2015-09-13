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
	//���±�������ʵ��ʹ�ð�ť���ٿع�����
	TextureAtlas atlas;//��ť���ز�.
	Image zuojiantouImage;//���ͷ
	Image youjiantouImage;//�Ҽ�ͷ
	@Override
	public void create() {
		stage = new Stage(480,800,false);
		atlas = new TextureAtlas(Gdx.files.internal("data/event.atlas"));
		zuojiantouImage = new Image(atlas.findRegion("zuo"));//��ʼ�����ͷ
		youjiantouImage = new Image(atlas.findRegion("you"));//��ʼ���Ҽ�ͷ
		zuojiantouImage.setPosition(100, 500);//�������ͷ��λ��
		youjiantouImage.setPosition(220, 500);//�����м�ͷ��λ��
		zuojiantouImage.setColor(Color.YELLOW);
		youjiantouImage.setColor(Color.YELLOW);
		zuojiantouImage.addListener(new InputListener(){//�����ͷ��ӵ���¼�
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.input.vibrate(2000);//������ 
				
				return true;
			}
		});
		youjiantouImage.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.input.vibrate(new long[]{//ÿ�����������һ��.��һ����ʾ��Ϣ������,�ڶ�����ʾ�񶯶�����  
		                0,200,200,200,200,200  
		        },-1);//�ڶ���������ʾ���ظ�.��Ϊ1,���ʾ��ͣ����  
				return true;
			}
		});
		stage.addActor(zuojiantouImage);//�����ͷ��ӵ���̨��
		stage.addActor(youjiantouImage);//���Ҽ�ͷ��ӵ���̨��
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
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����
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
