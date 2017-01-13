package com.example.parkinglotmanager;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Comment extends Activity {
	private Button button1;
	private Button button2;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment);
		

	
		button1 = (Button)this.findViewById(R.id.title_save);
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				DB db = new DB(Comment.this,"comment",null,1);   
				String editString=(String) getText(R.id.edit_comment);
				SQLiteDatabase dbWrite=db.getWritableDatabase();
				
				ContentValues cv=new ContentValues();
				cv.put("comment",editString);
				
				dbWrite.insert("comment",null, cv);
				db.close();
				
				Toast toast = Toast.makeText(getApplicationContext(),
					     "您的留言保存成功", Toast.LENGTH_LONG);
					   toast.setGravity(Gravity.CENTER, 0, 0);
					   LinearLayout toastView = (LinearLayout) toast.getView();
					   ImageView imageCodeProject = new ImageView(getApplicationContext());
					   imageCodeProject.setImageResource(R.drawable.about);
					   toastView.addView(imageCodeProject, 0);
					   toast.show();
			}
		});
		
		button2= (Button)this.findViewById(R.id.button1);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent(Comment.this,MainActivity.class);
	
				Comment.this.startActivity(intent);
				  
			}
		});
		

	}
	

}
