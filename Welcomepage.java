package com.example.jumbledwords;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Welcomepage extends Activity implements OnClickListener{
Button b1,b2,b3,b4;
MediaPlayer mp;
SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcomepage);
		b1=(Button)findViewById(R.id.w_b1);
		b2=(Button)findViewById(R.id.w_b2);
		b3=(Button)findViewById(R.id.w_b3);
		b4=(Button)findViewById(R.id.w_b4);
		
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

		sp=PreferenceManager.getDefaultSharedPreferences(this);

		
		if(mp==null){
		mp=MediaPlayer.create(this, R.raw.puzzlemusic);	
		mp.start();
		}
		
		boolean pts=sp.getBoolean("pt", true);
		if(pts==true)
			mp.start();
		if(pts==false)
		{
			mp.pause();
		}
		//else{
		//	mp.start();
		//}
	}
	@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			sp=PreferenceManager.getDefaultSharedPreferences(this);
			boolean pts=sp.getBoolean("pt", true);
			if(pts==true)
				mp.start();
			if(pts==false)
			{
				mp.pause();
			}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int s=v.getId();
		if(s==R.id.w_b1)
		{
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			Intent i= new  Intent(this,DemoRun.class);
			startActivity(i);
			
		}
		if(s==R.id.w_b2)
		{
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			Intent i= new  Intent(this,Instructions.class);
			startActivity(i);
			
		}
		
		else if(s==R.id.w_b3)
		{
			//SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			
			Intent i=new Intent(this,Settings.class);
			startActivity(i);
		}
		else if(s==R.id.w_b4)
		{
			
			String vsn=Context.VIBRATOR_SERVICE;
			Vibrator vib;
			vib=(Vibrator)getSystemService(vsn);
			vib.vibrate(100);
			onBackPressed();
			
		}
	}
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle("EXIT APPLICATION")
	        .setMessage("Are you sure you want to exit?")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
	    {
	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	        	mp.pause();
	            finish();    
	        }

	    })
	    .setNegativeButton("No", null)
	    .show();
	}
	
}

