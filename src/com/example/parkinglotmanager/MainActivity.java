package com.example.parkinglotmanager;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button3;
	private Button button1;
	private Button button2;
	private String returnedData;
//    将图片转化为参数为id的图片资源
//    public byte[] img(int id){
//    	ByteArrayOutputStream baos=new ByteArrayOutputStream();
//    	Bitmap bitmap=((BitmapDrawable)getResources().getDrawable(id)).getBitmap();
//    	bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//    	return baos.toByteArray();}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        DB db = new DB(this);      //DB对象db	
		
		//写入数据库30个车位，flag设为0
		final SQLiteDatabase dbWrite=db.getWritableDatabase();//SQLiteDatabase类用于修改数据库，getWritableDatabase打开数据库
		ContentValues cv=new ContentValues();//容器类对象cv
		int i = 1;
		while(i<=30){
			cv.put("place", i);
			cv.put("flag", "0");
	   	    dbWrite.insert("parkinglot",null,cv);
	   	    i++;
		}
		
		
		
		//显示剩余车位 gai
//		Cursor c=dbWrite.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
//		if(c.moveToFirst()){
//		    int leftplace=c.getCount();
//		    TextView leftplaceView = (TextView)findViewById(R.id.textView1);
//		    String leftplaceString=String.valueOf(leftplace);
//			leftplaceView.setText(leftplaceString);
//		    
//		}    

//		c.close();
//		dbWrite.close();	
		
		button3 = (Button)this.findViewById(R.id.button_comment);//留言按钮
		button3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent(MainActivity.this,Comment.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
        button1= (Button)this.findViewById(R.id.button_parking);//停车按钮
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){	
				Intent intent=new Intent(MainActivity.this,Parking.class);
				startActivityForResult(intent,1);
				
			}
		});
		
		
		button2= (Button)this.findViewById(R.id.button_leaving);//结算按钮
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent(MainActivity.this,Cash.class);
				MainActivity.this.startActivity(intent);
				
				//返回剩余车位
				Cursor c=dbWrite.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
				int returnint=c.getCount()+1;
				returnedData=String.valueOf(returnint);
				TextView leftplaceView = (TextView)findViewById(R.id.textView1);
				leftplaceView.setText(returnedData);
//				startActivityForResult(intent,2);
			}
		});
		

		
	}


	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		switch(requestCode){
		case 1:if(resultCode==RESULT_OK){
			 returnedData = data.getStringExtra("place_return1");
			 TextView leftplaceView = (TextView)findViewById(R.id.textView1);
			 leftplaceView.setText(returnedData);
			}
		    break;
		    
//		case 2:if(resultCode==RESULT_OK){
//			 returnedData = data.getStringExtra("place_return2");
//			 TextView leftplaceView = (TextView)findViewById(R.id.textView1);
//			 leftplaceView.setText(returnedData);
//			 Log.d("MainActivity", returnedData);
//			}
//		    break;
		
		default:
		
		}
	}
	

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	
}
