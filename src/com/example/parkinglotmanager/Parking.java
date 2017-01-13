package com.example.parkinglotmanager;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Parking extends Activity {
	private Button button1,button2;
	private String id;
	private String returnString;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parkingnote);
		
		
		DB db = new DB(this);      //DB����db	
		
//		//�涨�洢ʱ���ʽ
//		String timeStr = "16:20";
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//		format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));// �й�����ʱ�䣬������
//		Time time = null;
//		try {
//		     time = (Time) format.parse(timeStr);
//		} catch (ParseException e) {
//		     e.printStackTrace();
//		}
		

		
		//��ѯ���ݿ�����flag=0��
		SQLiteDatabase dbRead =db.getReadableDatabase();
		Cursor c=dbRead.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
		
		
		if(c.moveToFirst()){     //�ж��α��Ƿ�Ϊ��,�ƶ���ָ����¼
			
			//����flag=0�ĵ�һ�е�place
		    id=c.getString(c.getColumnIndex("_id"));
		    TextView place = (TextView)findViewById(R.id.text_cardnumber);
			place.setText(c.getString(c.getColumnIndex("place")));
			
			//������ĳ�λflag��Ϊ1,���¿�ʼʱ��
			Date writeTime = new Date();
			ContentValues cv1 = new ContentValues();
			cv1.put("flag","1");//���Ҫ���ĵ��ֶμ�����	
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cv1.put("parkingtime", myFmt.format(writeTime.getTime()));
			String whereClause = "_id=?";//�޸�����
			String[] whereArgs = {id};//�޸������Ĳ���
			dbRead.update("parkinglot",cv1,whereClause,whereArgs);//ִ���޸�
			
			c=dbRead.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
			returnString=String.valueOf(c.getCount());
		}
		else{
			Toast toast = Toast.makeText(getApplicationContext(),
				     "��Ǹ����λ������", Toast.LENGTH_LONG);
				   toast.setGravity(Gravity.CENTER, 0, 0);
				   LinearLayout toastView = (LinearLayout) toast.getView();
				   ImageView imageCodeProject = new ImageView(getApplicationContext());
				   imageCodeProject.setImageResource(R.drawable.about);
				   toastView.addView(imageCodeProject, 0);
				   toast.show();
		}
		dbRead.close();
		
		//����������
		button1= (Button)this.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent();
				intent.putExtra("place_return1", returnString);
				setResult(RESULT_OK, intent);
				finish();
				  
			}
		});
		
		//����·��ͼ�鿴
		button2= (Button)this.findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent(Parking.this,Route.class);
				intent.putExtra("id",id);
				Parking.this.startActivity(intent);
			}
		});
		
	}
}