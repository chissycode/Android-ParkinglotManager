package com.example.parkinglotmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
	
	
	
	public DB(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	private static final String DATABASE_NAME = "test.db";  
	 private static final int DATABASE_VERSION = 1; 
	
	public DB(Context context) {  
	        //CursorFactory设置为null,使用默认值  
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
	    }  

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 db.execSQL("CREATE TABLE parkinglot(" +  
	                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"place INT,"+"flag INT,"+"parkingtime INT,"+"leavingtime INT)");  
         db.execSQL("CREATE TABLE comment("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"comment)");
         
	}
	
	  //将转换后的图片存入到数据库中
//    private void initDataBase (SQLiteDatabase db, Context context) {
//        Drawable d1 = context.getResources().getDrawable(R.drawable.r1);
//        Drawable d2 = context.getResources().getDrawable(R.drawable.r2);
//        Drawable d3 = context.getResources().getDrawable(R.drawable.r3);
//        Drawable d4 = context.getResources().getDrawable(R.drawable.r4);
//        Drawable d5 = context.getResources().getDrawable(R.drawable.r5);
//        Drawable d6 = context.getResources().getDrawable(R.drawable.r6);
//        Drawable d7 = context.getResources().getDrawable(R.drawable.r7);
//        Drawable d8 = context.getResources().getDrawable(R.drawable.r8);
//        Drawable d9 = context.getResources().getDrawable(R.drawable.r9);
//        Drawable d10 = context.getResources().getDrawable(R.drawable.r10);
//        Drawable d11 = context.getResources().getDrawable(R.drawable.r11);
//        Drawable d12 = context.getResources().getDrawable(R.drawable.r12);
//        Drawable d13 = context.getResources().getDrawable(R.drawable.r13);
//        Drawable d14 = context.getResources().getDrawable(R.drawable.r14);
//        Drawable d15 = context.getResources().getDrawable(R.drawable.r15);
//        Drawable d16 = context.getResources().getDrawable(R.drawable.r16);
//        Drawable d17 = context.getResources().getDrawable(R.drawable.r17);
//        Drawable d18 = context.getResources().getDrawable(R.drawable.r18);
//        Drawable d19 = context.getResources().getDrawable(R.drawable.r19);
//        Drawable d20 = context.getResources().getDrawable(R.drawable.r20);
//        Drawable d21 = context.getResources().getDrawable(R.drawable.r21);
//        Drawable d22 = context.getResources().getDrawable(R.drawable.r22);
//        Drawable d23 = context.getResources().getDrawable(R.drawable.r23);
//        Drawable d24 = context.getResources().getDrawable(R.drawable.r24);
//        Drawable d25 = context.getResources().getDrawable(R.drawable.r25);
//        Drawable d26 = context.getResources().getDrawable(R.drawable.r26);
//        Drawable d27 = context.getResources().getDrawable(R.drawable.r27);
//        Drawable d28 = context.getResources().getDrawable(R.drawable.r28);
//        Drawable d29 = context.getResources().getDrawable(R.drawable.r29);
//        Drawable d30 = context.getResources().getDrawable(R.drawable.r30);
        
//        ContentValues cv = new ContentValues();
//        cv.put( PictureColumns.PICTURE, getPicture(d1));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d2));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d3));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d4));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d5));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d6));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d7));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d8));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d9));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d10));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d11));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d12));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d13));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d14));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d15));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d16));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d17));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d18));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d19));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d20));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d21));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d22));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d23));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d24));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d25));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d26));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d27));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d28));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d29));
//        db.insert("patkinglot", null, cv);
//        cv.put("img", getPicture(d30));
//        db.insert("patkinglot", null, cv);
//    }
    
  //将drawable转换成可以用来存储的byte[]类型
//    private byte[] getPicture(Drawable drawable) {
//        if(drawable == null) {
//            return null;
//        }
//        BitmapDrawable bd = (BitmapDrawable) drawable;
//        Bitmap bitmap = bd.getBitmap();
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        bitmap.compress(CompressFormat.JPEG, 100, os);
//        return os.toByteArray();
//    }

    

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("ALTER TABLE parkinglot ADD COLUMN other STRING");

	}

}
