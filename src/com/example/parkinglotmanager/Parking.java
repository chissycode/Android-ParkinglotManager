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
		
		
		DB db = new DB(this);      //DB对象db	
		
//		//规定存储时间格式
//		String timeStr = "16:20";
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//		format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));// 中国北京时间，东八区
//		Time time = null;
//		try {
//		     time = (Time) format.parse(timeStr);
//		} catch (ParseException e) {
//		     e.printStackTrace();
//		}
		

		
		//查询数据库所有flag=0的
		SQLiteDatabase dbRead =db.getReadableDatabase();
		Cursor c=dbRead.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
		
		
		if(c.moveToFirst()){     //判断游标是否为空,移动到指定记录
			
			//分配flag=0的第一行的place
		    id=c.getString(c.getColumnIndex("_id"));
		    TextView place = (TextView)findViewById(R.id.text_cardnumber);
			place.setText(c.getString(c.getColumnIndex("place")));
			
			//将分配的车位flag设为1,更新开始时间
			Date writeTime = new Date();
			ContentValues cv1 = new ContentValues();
			cv1.put("flag","1");//添加要更改的字段及内容	
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cv1.put("parkingtime", myFmt.format(writeTime.getTime()));
			String whereClause = "_id=?";//修改条件
			String[] whereArgs = {id};//修改条件的参数
			dbRead.update("parkinglot",cv1,whereClause,whereArgs);//执行修改
			
			c=dbRead.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
			returnString=String.valueOf(c.getCount());
		}
		else{
			Toast toast = Toast.makeText(getApplicationContext(),
				     "抱歉！车位已满！", Toast.LENGTH_LONG);
				   toast.setGravity(Gravity.CENTER, 0, 0);
				   LinearLayout toastView = (LinearLayout) toast.getView();
				   ImageView imageCodeProject = new ImageView(getApplicationContext());
				   imageCodeProject.setImageResource(R.drawable.about);
				   toastView.addView(imageCodeProject, 0);
				   toast.show();
		}
		dbRead.close();
		
		//返回主界面
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
		
		//进入路线图查看
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