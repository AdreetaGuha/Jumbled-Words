package com.example.jumbledwords;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Trial extends Activity implements OnClickListener{
ImageButton b1,b2,b3,b4,bb,bs;
TextView tv1;
int j=0,f=0;
int l,correctans=0;
String s1,ranword="",s="";
int bu1=0,bu3=0,bu2=0,bu4=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_trial);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		b1=(ImageButton)findViewById(R.id.t_b1);
		b2=(ImageButton)findViewById(R.id.t_b2);
		b3=(ImageButton)findViewById(R.id.t_b3);
		b4=(ImageButton)findViewById(R.id.t_b4);
		bb=(ImageButton)findViewById(R.id.t_bb);
		bs=(ImageButton)findViewById(R.id.t_bs);
		tv1=(TextView)findViewById(R.id.t_tv1);
		
		//int x=(int)((Math.random())*60);
		Intent ri = getIntent();
		Bundle data = ri.getExtras();
		String s1 = data.getString("k2");
		//s1=WordsDB.word[x];
		int flag=0;
		for(int g=0;g<5;g++)
		{
			if(WordsDB.wrds4[g]==null)
			{
				//String temp= "";
				//Toast.makeText(this, temp, 100).show();
				//WordsDB.wrds4[g]=s1;
				flag=0;
				for(int t=0;t<g;t++)
				{
					//temp = temp + WordsDB.wrds4[t];
					if(WordsDB.wrds4[t].equalsIgnoreCase(s1))
					{
						//Toast.makeText(this, "END", 100).show();
						flag=1;
						//finish();
						
					}					
				}
				//Toast.makeText(this, temp, 100).show();
				break;
			}
		}
		if(WordsDB.Wordcount ==5)
		{
			Intent y = new Intent(this, Greeting.class);
			startActivity(y);
			finish();
		}
		if(flag==0)
		{
			
			WordsDB.Wordcount++;
			
		WordsDB.wrds4[WordsDB.k++]=s1;	
		//Toast.makeText(this, WordsDB.wrds4[0] , 100).show();
		s = s1.toLowerCase();
		ranword=random1(s);
		//Toast.makeText(this,ranword+"	"+s+"	"+x, 100).show();
		
		//char ch[]=ranword.toCharArray();
		
		//Toast.makeText(this,ch[2], 100).show();
		//(int)Math.random()*10
		try{
		//String temp = "R.drawable." + (int)ch[0];
		//int t=getResources().getIdentifier(temp, temp, defPackage)
		int iid1=getImageID(ranword.charAt(0));
		int iid2=getImageID(ranword.charAt(1));
		int iid3=getImageID(ranword.charAt(2));
		int iid4=getImageID(ranword.charAt(3));
		//Toast.makeText(this,iid1, 100).show();
		/*int st1=R.drawable.(int)ch[0];
		int st2=R.drawable.b;
		int st3=R.drawable.c;
		int st4=R.drawable.d;*/
		b1.setImageResource(iid1);
		b2.setImageResource(iid2);
		b3.setImageResource(iid3);
		b4.setImageResource(iid4);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		bb.setOnClickListener(this);
		bs.setOnClickListener(this);
		}catch(Exception e){
			Toast.makeText(this,"ERROR", 100).show();
		}
		}
		else
		{
			final Intent i = new Intent(this,calling.class);
			Thread t= new Thread(){
				public void run(){
					try{
					Thread.sleep(2000);
					i.putExtra("k1", "four");
					startActivity(i);
					finish();
					}catch(Exception e){}
					}
					
			};
			t.start();
		}
	}
		
	String random1(String word)
	{
		String str="";
		String s=word;
		l=s.length();
		int a[]=new int[l];
		for(int j =0;j<l;j++)
			a[j]=-1;
		int flag=0,count=0,k=0;
		while(true)
		{
			int i=(int) (Math.random()*l);
			for(int j=0;j<l;j++)
			{
				if(a[j]==-1)
				{
					flag=0;
					for(int p=0;p<j;p++)
					{
						if(a[p]==i)
							flag=1;
					}
					break;
				}
			
			}
			if(flag==0)
			{
				a[k]=i;
				k=k+1;
				str=str+s.charAt(i);
				count++;
			}
			if(count==l)
			{
				if(s.equalsIgnoreCase(str)==true){
					for(int j =0;j<l;j++)
						a[j]=-1;
					flag=count=k=0;
					str="";
				}
				else
				break;
			}	
		}
		return str;
	}
	String ans="";
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int s0=v.getId();
		String vsn=Context.VIBRATOR_SERVICE;
		Vibrator vib;
		vib=(Vibrator)getSystemService(vsn);
		vib.vibrate(100);
		correctans=0;
		if(s0==R.id.t_b1)
		{
			if(bu1==0)
			{
			ans=ans+ranword.charAt(0);
			bu1=1;
			int iid1=getRedImageID(ranword.charAt(0));
			b1.setImageResource(iid1);
			tv1.setText(ans.toUpperCase());
			}
			
		}
		
		if(s0==R.id.t_b2)
		{
			if(bu2==0)
			{
			ans=ans+ranword.charAt(1);
			bu2=1;
			int iid2=getRedImageID(ranword.charAt(1));
			b2.setImageResource(iid2);
			tv1.setText(ans.toUpperCase());
		}}
		//if(bu3==0){
		if(s0==R.id.t_b3)
		{
			if(bu3==0){
			ans=ans+ranword.charAt(2);
			bu3=1;
			int iid3=getRedImageID(ranword.charAt(2));
			b3.setImageResource(iid3);
			tv1.setText(ans.toUpperCase());
		}}
		
		if(s0==R.id.t_b4)
		{
			if(bu4==0){
			ans=ans+ranword.charAt(3);
			bu4=1;
			int iid4=getRedImageID(ranword.charAt(3));
			b4.setImageResource(iid4);
			tv1.setText(ans.toUpperCase());
		}}
		if(s0==R.id.t_bb)
		{
			try{
			
				char te=ans.charAt(ans.length()-1);
				if(te==ranword.charAt(0))
				{
					bu1=0;
					int iid1=getImageID(ranword.charAt(0));
					b1.setImageResource(iid1);
				}
				if(te==ranword.charAt(1))
				{	bu2=0;
				int iid2=getImageID(ranword.charAt(1));
				b2.setImageResource(iid2);
				}
				if(te==ranword.charAt(2))
				{	bu3=0;
				int iid3=getImageID(ranword.charAt(2));
				b3.setImageResource(iid3);
				
				}
				if(te==ranword.charAt(3))
				{	bu4=0;
				int iid4=getImageID(ranword.charAt(3));
				b4.setImageResource(iid4);}
			
			ans=ans.substring(0,ans.length()-1);
			tv1.setText(ans.toUpperCase());
			}catch(Exception e){}
		}
		if(s0==R.id.t_bs)
		{
			ranword=random1(s);
			
			try{
			
			int iid1=getImageID(ranword.charAt(0));
			int iid2=getImageID(ranword.charAt(1));
			int iid3=getImageID(ranword.charAt(2));
			int iid4=getImageID(ranword.charAt(3));
			
			b1.setImageResource(iid1);
			b2.setImageResource(iid2);
			b3.setImageResource(iid3);
			b4.setImageResource(iid4);
			
			ans="";
			bu1=bu2=bu3=bu4=0;
			tv1.setText("----");
			

		}catch(Exception e){}
		}
		
		/*if(ans.equalsIgnoreCase(s)==true)
		{
			Toast.makeText(this,"CORRECT ANSWER", 100).show();
			correctans=1;
		}
		
		else if(ans.length()>l)
		{if(ans==""){}
		else{
			ans=ans.substring(0,l);
			tv1.setText(ans);}
		}
		
		if(correctans==1)
		{
			//try{
			final Intent i = new Intent(this,calling.class);
			Thread t= new Thread(){
				public void run(){
					try{
					Thread.sleep(2000);
					i.putExtra("k1", "four");
					startActivity(i);
					finish();
					}catch(Exception e){}
					}
					
			};
			t.start();
	
		}*/
		if(ans.length()==4)
		{
			if(ans.equalsIgnoreCase(s)==true)
			{
				
				WordsDB.scoree=WordsDB.scoree+20;
				WordsDB.scoret=WordsDB.scoret+20;
				Toast.makeText(this,"CORRECT ANSWER\n"+WordsDB.scoree, 100).show();

			}
			else
			{
				//WRONG ANSWER
				Toast.makeText(this,"WRONG ANSWER\n"+WordsDB.scoree, 100).show();

			}
			
				
				//try{
				final Intent i = new Intent(this,calling.class);
				Thread t= new Thread(){
					public void run(){
						try{
						Thread.sleep(400);
						i.putExtra("k1", "four");
						startActivity(i);
						finish();
						}catch(Exception e){}
						}
				};
				t.start();
		}		
	}
	int getImageID(char c)
	{
		switch (c){
		case 'a': return R.drawable.a;
		case 'b': return R.drawable.b;				
		case 'c': return R.drawable.c;		
		case 'd': return R.drawable.d;
		case 'e': return R.drawable.e;		
		case 'f': return R.drawable.f;		
		case 'g': return R.drawable.g;		
		case 'h': return R.drawable.h;		
		case 'i': return R.drawable.i;		
		case 'j': return R.drawable.j;		
		case 'k': return R.drawable.k;		
		case 'l': return R.drawable.l;		
		case 'm': return R.drawable.m;		
		case 'n': return R.drawable.n;		
		case 'o': return R.drawable.o;		
		case 'p': return R.drawable.p;		
		case 'q': return R.drawable.q;		
		case 'r': return R.drawable.r;		
		case 's': return R.drawable.s;		
		case 't': return R.drawable.t;		
		case 'u': return R.drawable.u;		
		case 'v': return R.drawable.v;		
		case 'w': return R.drawable.w;		
		case 'x': return R.drawable.x;		
		case 'y': return R.drawable.y;		
		case 'z': return R.drawable.z;
		default: return 0;
		
		}
		
	}
	int getRedImageID(char c)
	{
		switch (c){
		case 'a': return R.drawable.ar;
		case 'b': return R.drawable.br;				
		case 'c': return R.drawable.cr;		
		case 'd': return R.drawable.dr;
		case 'e': return R.drawable.er;		
		case 'f': return R.drawable.fr;		
		case 'g': return R.drawable.gr;		
		case 'h': return R.drawable.hr;		
		case 'i': return R.drawable.ir;		
		case 'j': return R.drawable.jr;		
		case 'k': return R.drawable.kr;		
		case 'l': return R.drawable.lr;		
		case 'm': return R.drawable.mr;		
		case 'n': return R.drawable.nr;		
		case 'o': return R.drawable.or;		
		case 'p': return R.drawable.pr;		
		case 'q': return R.drawable.qr;		
		case 'r': return R.drawable.rr;		
		case 's': return R.drawable.sr;		
		case 't': return R.drawable.tr;		
		case 'u': return R.drawable.ur;		
		case 'v': return R.drawable.vr;		
		case 'w': return R.drawable.wr;		
		case 'x': return R.drawable.xr;		
		case 'y': return R.drawable.yr;		
		case 'z': return R.drawable.zr;
		default: return 0;
		
		}
		
	}
}
