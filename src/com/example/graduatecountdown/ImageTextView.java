package com.example.graduatecountdown;

import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class ImageTextView extends TextView {

	private int length_side;
	private final int color_blue = 0xaa0099ff;
	private final int WIDTH = 200;
	Paint paintBack;
	
	RectF rectBackF;
	
	public ImageTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		paintBack = new Paint();
		paintBack.setColor(color_blue);
		paintBack.setAntiAlias(true);
		paintBack.setStyle(Style.STROKE);
		paintBack.setTextAlign(Align.CENTER);
		
//		setLayoutParams(new LayoutParams(WIDTH,WIDTH));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int width = getWidth();
		int height = getHeight();
		length_side = Math.max(width, height);
		rectBackF = new RectF(0,0,width,height);
		drawCircleBackground(canvas);
		
	}

	//画北京后面的圆
	private void drawCircleBackground(Canvas canvas) {
	}
	
	
	
}
