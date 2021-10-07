package com.example.jumbledwords;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class calling extends Activity implements OnClickListener {
		
Button b1,b2,b3;
String rw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_run);
		b1=(Button)findViewById(R.id.dr_b1);
		b1.setOnClickListener(this);
		b2=(Button)findViewById(R.id.dr_b2);
		b2.setOnClickListener(this);
		b3=(Button)findViewById(R.id.dr_b3);
		b3.setOnClickListener(this);
		Intent ri = getIntent();
		Bundle data = ri.getExtras();
		rw = data.getString("k1");
		//Toast.makeText(this,rw, 50).show();
		if(rw.equalsIgnoreCase("four"))
		{
			try{
			int x=(int)((Math.random())*60)+1;
			String s1=WordsDB.word[x];
			String s=s1.toLowerCase();
			//Toast.makeText(this, s, 50).show();
			Intent i4 = new Intent(this,Trial.class);
			i4.putExtra("k2", s);
			startActivityForResult(i4,40);
			finish();
			//Toast.makeText(this,"Passed", 50).show();
			}catch(Exception e){}
		}
		else if(rw.equalsIgnoreCase("seven"))
		{
			int x=(int)((Math.random())*45)+1;
			String s1=WordsDB.word7[x];
			String s=s1.toLowerCase();
			Intent i7 = new Intent(this,WordTrail7.class);
			i7.putExtra("k2", s);
			startActivityForResult(i7,70);
			finish();
			
		}
		else if(rw.equalsIgnoreCase("five"))
		{
			int x= (int)((Math.random())*45)+1;
			String s1= WordsDB.word5[x];
			String s = s1.toLowerCase();
			Intent i5 = new Intent(this,TrialFive.class);
			i5.putExtra("k2", s);
			startActivityForResult(i5, 50);
			finish();
		}
		
		

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int so = v.getId();
		if(so==R.id.dr_b1)
		{
			
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			WordsDB.scoree=0;
			WordsDB.scoret=0;
			Intent i = new Intent(this,calling.class);
			i.putExtra("k1", "four");
			startActivityForResult(i, 10);
		}
		else if(so==R.id.dr_b2)
		{
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			WordsDB.scorem=0;
			WordsDB.scoret=0;
			Intent i = new Intent(this,calling.class);
			i.putExtra("k1", "seven");
			startActivityForResult(i, 10);
		}
		else if(so == R.id.dr_b3)
		{
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			WordsDB.scoreh=0;
			WordsDB.scoret=0;
			Intent i = new Intent(this,calling.class);
			i.putExtra("k1", "five");
			startActivityForResult(i,10);
		}
		
	}
}