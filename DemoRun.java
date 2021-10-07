package com.example.jumbledwords;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DemoRun extends Activity implements OnClickListener {

	Button b1,b2,b3;
	SQLiteDatabase db;
	EditText ed1;
	
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
		ed1=(EditText)findViewById(R.id.dr_et1);
		
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		db=openOrCreateDatabase("firstdb", MODE_WORLD_READABLE, null);
		String q="create table if not exists scoretable(name varchar, score int)";
		db.execSQL(q);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int so = v.getId();
		WordsDB.name =ed1.getText().toString();
		for(int e=0;e<100;e++)
		{
			WordsDB.wrds4[e]=null;
			WordsDB.wrds5[e]=null;
			WordsDB.wrds7[e]=null;
			WordsDB.Wordcount=0;
			WordsDB.k=0;
		}
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
			finish();
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
			finish();

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
			finish();

		}
	}
}