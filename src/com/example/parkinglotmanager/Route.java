package com.example.parkinglotmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Route extends Activity {
	
	private String id;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
//		setContentView(R.layout.route);	
		Intent intent=getIntent();
		id=intent.getStringExtra("id");
		
//        iv=(ImageView)findViewById(R.id.imageView);
//        iv.setImageDrawable(getDrawable());
		ImageView iv = new ImageView(this);
        if(getDrawable().size() != 0) {
            iv.setImageDrawable(getDrawable().get(0));
        }
        setContentView(iv);
        
        
      
	}

	 private ArrayList<Drawable> getDrawable() {
	        PictureDatabase pd = new PictureDatabase(this);
	        SQLiteDatabase sd = pd.getWritableDatabase();

	        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	        String[] args = {String.valueOf(id)};
	        //查询数据库
	        Cursor c = sd.query("picture", null,BaseColumns._ID+"=?",args, null, null, null);

	        
	        if(c.moveToFirst() ){
	           
	                //获取数据
	                byte[] b = c.getBlob(c.getColumnIndexOrThrow(PictureDatabase.PictureColumns.PICTURE));
	                //将获取的数据转换成drawable
	                Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length, null);
	                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
	                Drawable drawable = bitmapDrawable;
	                drawables.add(drawable);
	                
	            
	        }
	        
	        sd.close();
	        pd.close();
	        return drawables;
	    }
	}

