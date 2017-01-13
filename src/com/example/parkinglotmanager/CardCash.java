package com.example.parkinglotmanager;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import android.R.string;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CardCash extends Activity {
	
//���ս������

	private TextView leavingtime1;
	private TextView cardcash_number;
	private TextView money;
    private String returnString;
	
	String place;
	long endtime = 0;

	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cardcash);
		//�õ����ݵĳ�λ��
		//��ʼ��
		leavingtime1 = (TextView) findViewById(R.id.leavingtime);
		cardcash_number = (TextView) findViewById(R.id.cardcash_number);
		money = (TextView) findViewById(R.id.money);
		Bundle bundle = getIntent().getExtras();
		place = bundle.getString("cashplace");
		cardcash_number.setText(place);
	
	
	
	   //��ʾ�뿪ʱ��
        Date leavingtime = new Date();
	    long end= leavingtime.getTime();
	  	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	    
	    leavingtime1.setText(df.format(leavingtime.getTime()));
	 

	    
	
//		DB db = new DB(this);
//		SQLiteDatabase dbWrite = db.getReadableDatabase();
//	     //������ĳ�λflag��Ϊ0
//		ContentValues cv = new ContentValues();
//		cv.put("flag","0");
//		String whereClause = "place=?";//�޸�����
//		String[] whereArgs = {place};//�޸������Ĳ���
//		dbWrite.update("parkinglot",cv,whereClause,whereArgs);//ִ���޸�
//		
//		//����ʣ�೵λ
//		Cursor c2=dbWrite.rawQuery("select * from parkinglot where flag=?", new String[]{"0"});
//		returnString = String.valueOf(c2.getCount());
//		dbWrite.close();
		
		

		//������	    
		DB db1 = new DB(this);
        SQLiteDatabase dbWrite1 = db1.getReadableDatabase();
		Cursor c= dbWrite1.rawQuery("select * from parkinglot where place=?",
				new String[]{place});
		String parkingtime=null;
		
		if(c.moveToFirst())
		{
		String parkingtime1= c.getString(c.getColumnIndex("parkingtime"));
		parkingtime = parkingtime1;
		}
		try {
			Date d1 = df.parse(parkingtime);
			long diff = end-d1.getTime();
			long minutes =(int)(diff/60000);
			int cash = (int)(minutes+3);
			money.setText(cash+"");
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		c.close();
		dbWrite1.close();
		
	
	Button button = (Button)this.findViewById(R.id.button2);
	button.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v){
			Intent intent=new Intent(CardCash.this,MainActivity.class);
			
			CardCash.this.startActivity(intent);
		
			  
		}
	});
	
	
	}
}
