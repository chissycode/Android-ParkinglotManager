package com.example.parkinglotmanager;

import java.io.ByteArrayOutputStream;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.BaseColumns;

public class PictureDatabase extends SQLiteOpenHelper {

    //���ݿ���ֶ�
    public static class PictureColumns implements BaseColumns {
        public static final String PICTURE = "picture";
    }

    private Context mContext;

    //���ݿ���
    private static final String DATABASE_NAME = "picture.db";
    //���ݿ�汾��
    private static final int DATABASE_Version = 1;
    //����
    private static final String TABLE_NAME = "picture";

    //�������ݿ�
    public PictureDatabase (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.mContext = context;
    }

    //��������ʼ����
    @Override
    public void onCreate (SQLiteDatabase db) {
        String sql = "Create table " + TABLE_NAME + "(" + BaseColumns._ID
        + " integer primary key autoincrement," + PictureColumns.PICTURE
        + " blob not null);";
        db.execSQL(sql);

        //��ʼ��
        initDataBase(db,mContext);
    }

    //��ת�����ͼƬ���뵽���ݿ���
    private void initDataBase (SQLiteDatabase db, Context context) {
        Drawable drawable;
        ContentValues cv = new ContentValues();
        
        drawable=context.getResources().getDrawable(R.drawable.r1);
        cv.put(PictureColumns.PICTURE, getPicture(drawable));
        db.insert(TABLE_NAME, null, cv);
        
        drawable = context.getResources().getDrawable(R.drawable.r2);
        cv.put(PictureColumns.PICTURE, getPicture(drawable));
        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r3);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r4);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r5);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r6);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
        
//        drawable = context.getResources().getDrawable(R.drawable.r7);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r8);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r9);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r10);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r11);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r12);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r13);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r14);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r15);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r16);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r17);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r18);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable=context.getResources().getDrawable(R.drawable.r19);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r20);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r21);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r22);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r23);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r24);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r25);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r26);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r27);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r28);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r29);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//        
//        drawable = context.getResources().getDrawable(R.drawable.r30);
//        cv.put(PictureColumns.PICTURE, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
        
       
    }

    //��drawableת���ɿ��������洢��byte[]����
    private byte[] getPicture(Drawable drawable) {
        if(drawable == null) {
            return null;
        }
        BitmapDrawable bd = (BitmapDrawable) drawable;
        Bitmap bitmap = bd.getBitmap();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, os);
        return os.toByteArray();
    }

    //�������ݿ�
    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = " DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    } 
}

