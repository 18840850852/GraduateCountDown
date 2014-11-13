package com.example.graduatecountdown;

import java.util.Date;
import java.util.GregorianCalendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppWidgetProvider {
    /** Called when the activity is first created. */
	RemoteViews remoteViews;
	ComponentName widgetCount;
	static int GRADUATE_YEAR=2016,GRADUATE_MONTH=6,GRADUATE_DAY=30;//��ҵ���꣬�£���
	static long MILLS = new GregorianCalendar(GRADUATE_YEAR,GRADUATE_MONTH,GRADUATE_DAY).getTimeInMillis();
	static final float TEXTSIZE_SCALE=2.0F;
	static int counter=0;
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
	
		widgetCount=new ComponentName(context,MainActivity.class);
		remoteViews=new RemoteViews(context.getPackageName(), R.layout.main);
		//����ʣ���ʱ��
		long days = (MILLS-new Date().getTime())/86400000;
		String time=days+"��";
		SpannableString msp = new SpannableString(time);
		msp.setSpan(new RelativeSizeSpan(TEXTSIZE_SCALE),0,time.length()-1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); 
		msp.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, time.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //����ǰ��ɫΪ���ɫ    
		msp.setSpan(new RelativeSizeSpan(0.5f),time.length()-1,time.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); 

		remoteViews.setTextViewText(R.id.tv_countDown,msp);
		appWidgetManager.updateAppWidget(widgetCount,remoteViews);
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		if(counter==0){
			Toast.makeText(context, "�����������㵽��ҵ����", 1000*10).show();
			counter=1;
		}
	}
	
	
	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		System.out.println("����");
		Toast.makeText(context, "�����������㵽��ҵ����", 1000*10).show();
	}


	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		System.out.println("ɾ��w");
		Toast.makeText(context, "����˵��һ���ҵ���𡣡�", 1000*10).show();
	}


	
		/*@SuppressLint("NewApi") private void showMoneyErrorDialog(Context con){
			new AlertDialog.Builder(con,AlertDialog.THEME_HOLO_LIGHT)  
	  .setTitle("��ʾ") 
	  .setMessage("���ҵ���𣿣����ھ�ɾ����")
	  .setIcon(android.R.drawable.ic_dialog_info)  
	  .setPositiveButton("", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
		}
	})  
	  .show();*/
//}

	
  
}