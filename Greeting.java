package com.example.jumbledwords;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Greeting extends Activity implements OnClickListener {

	TextView tv1;
	Button b1;
	SQLiteDatabase f;
	String str,sort1,sort,addval,str3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_greeting);
		
		tv1=(TextView)findViewById(R.id.g_tv1);
		
		b1=(Button)findViewById(R.id.g_b1);
		b1.setOnClickListener(this);
		f=openOrCreateDatabase("firstdbh", MODE_WORLD_READABLE, null);
		
		
		str="create table if not exists scoretablee(name varchar, score int)";
		f.execSQL(str);
		
		
		String n=WordsDB.name;
		String sc=String.valueOf(WordsDB.scoret);
		String str2="insert into scoretablee values("+"'"+n+"',"+sc+")";
		f.execSQL(str2);
		
		sort="";
		sort1="";
		addval="";
		str3="";
		String q="select *from scoretablee";
		Cursor ob=f.rawQuery(q, null);
		
		
		while(ob.moveToNext()==true)
		{
		String name=ob.getString(0);
		String sco=ob.getString(1);
		sort=sort+sco+" ";
		sort1=sort1+name+" ";
		}
		
		sort=sort.trim();
		sort1=sort1.trim();
		String scor[]=sort.split(" ");
		String na[]=sort1.split(" ");
		int s[]=new int[scor.length];
		
		for(int i=0;i<scor.length;i++)
		{
			s[i]=Integer.parseInt(scor[i]);
		
		}
		try{
		String tmp="";String tmp1="";
		int tmp2;tmp2=0;
		for(int f=0;f<s.length-1;f++)    //Sorting the score in descending order
		{
			for(int g=f+1;g<s.length;g++)
			{
				if(s[g]>=s[f])
				{
					tmp2=s[g];
					s[g]=s[f];
					s[f]=tmp2;
					
					tmp=scor[g];
					scor[g]=scor[f];
					scor[f]=tmp;
					
					tmp1=na[g];
					na[g]=na[f];
					na[f]=tmp1;
				}
			}
		}
		/*8for(int h=0;h<scor.length;h++)
		{
		
		str3+="\n"+scor[h]+"\t\t"+na[h];
		}*/
		/*int len;
		len=scor.length;
		while(true)
		{
			if(len<=5)
			{
				for(int i=0;i<len;i++)
				{
					
					addval=addval+"\n"+na[i]+"\t\t"+scor[i];
					TrialDB.score_name[i]=na[i];
					TrialDB.scoreboard[i]=s[i];
					
					
				}
				break;
			}
			else if(len>5)
			{
				for(int i=0;i<5;i++)
				{
					addval=addval+"\n"+na[i]+"\t\t"+scor[i];
					TrialDB.score_name[i]=na[i];
					TrialDB.scoreboard[i]=s[i];
					
				}break;
			}
		}*/
		}catch(Exception e){}
		WordsDB.highscore ="Score : "+scor[0];
		WordsDB.highname=na[0];
	
		tv1.setText(WordsDB.name+":\n SCORE:"+WordsDB.scoret+"\n\nHIGHSCORE: "+ WordsDB.highname + "\n "+ "SCORE :"+ WordsDB.highscore);
		WordsDB.scoree=WordsDB.scorem=WordsDB.scoreh=WordsDB.scoret=0;
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String vsn=Context.VIBRATOR_SERVICE;
		Vibrator vib;
		vib=(Vibrator)getSystemService(vsn);
		vib.vibrate(100);
		
		finish();
	}
}
