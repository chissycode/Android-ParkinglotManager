package com.example.parkinglotmanager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class Cash extends Activity {

	private SimpleCursorAdapter adapter;
	private String returnString;
  
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.cash);	
		
		 final DB db = new DB(this);      //DB对象db	
		//查询数据库所有place，显示到gridview
		SQLiteDatabase dbRead =db.getReadableDatabase();
		Cursor c=dbRead.query("parkinglot", new String[]{"*"}, null, null, null, null, null,null);
		//将查询结果（c）放入容器中（格式listviewitem），在list中加载
		GridView gridView=(GridView)findViewById(R.id.gridView1);
		adapter=new SimpleCursorAdapter(this, R.layout.listviewitem,c, new String[]{"place"}, new int[]{R.id.item_title});
		gridView.setAdapter(adapter);

		
        
	    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) {
				// TODO Auto-generated method stub

				Cursor cur=(Cursor)adapter.getItem(position);
				cur.moveToPosition(position);
				String place = cur.getString(cur.getColumnIndexOrThrow("place"));
				

			     //将结算的车位flag设为0
				SQLiteDatabase dbWrite =db.getReadableDatabase();
				ContentValues cv = new ContentValues();
				cv.put("flag","0");
				String whereClause = "place=?";//修改条件
				String[] whereArgs = {place};//修改条件的参数
				dbWrite.update("parkinglot",cv,whereClause,whereArgs);//执行修改
				
//				//返回剩余车位
//				Cursor c=dbWrite.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
//				returnString = String.valueOf(c.getCount());
//				Intent intent1=new Intent();
//				intent1.putExtra("place_return2", returnString);
//				setResult(RESULT_OK, intent1);
//				
				//点击gridView传结算车位到结算页面
				Intent intent=new Intent(Cash.this,CardCash.class);
				intent.putExtra("cashplace",place);
				Cash.this.startActivity(intent);
				
				
			
			}
		});
	    dbRead.close();
        
	    
	}
	
	
	


	

}
