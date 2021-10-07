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

public class TrialFive extends Activity implements OnClickListener{
	ImageButton b1,b2,b3,b4,b5,bb,bs;
	TextView tv;
	int f=0;
	int j = 0;
	int l,correctans=0;
	String s1="";
	String ranword="";
	String s="";
	int bu1=0,bu3=0,bu2=0,bu4=0,bu5=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trial_five);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		b1=(ImageButton)findViewById(R.id.t5_b1);
		b2=(ImageButton)findViewById(R.id.t5_b2);

		b3=(ImageButton)findViewById(R.id.t5_b3);

		b4=(ImageButton)findViewById(R.id.t5_b4);

		b5=(ImageButton)findViewById(R.id.t5_b5);
		bb=(ImageButton)findViewById(R.id.t5_bb);
		bs=(ImageButton)findViewById(R.id.t5_bs);
		tv=(TextView)findViewById(R.id.t5_tv);
		Intent ri=getIntent();
		Bundle data = ri.getExtras();
		String s1= data.getString("k2");
		int flag=0;
		for(int g=0;g<5;g++)
		{
			if(WordsDB.wrds5[g]==null)
			{
				//String temp= "";
				//Toast.makeText(this, temp, 100).show();
				//WordsDB.wrds4[g]=s1;
				flag=0;
				for(int t=0;t<g;t++)
				{
					//temp = temp + WordsDB.wrds4[t];
					if(WordsDB.wrds5[t].equalsIgnoreCase(s1))
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
			
		WordsDB.wrds5[WordsDB.k++]=s1;	
		s=s1.toLowerCase();
		ranword = random1(s);
		try{
			
			int iid1=getImageID(ranword.charAt(0));
			int iid2=getImageID(ranword.charAt(1));
			int iid3=getImageID(ranword.charAt(2));
			int iid4=getImageID(ranword.charAt(3));
			int iid5=getImageID(ranword.charAt(4));
			
			
			b1.setImageResource(iid1);
			b2.setImageResource(iid2);
			b3.setImageResource(iid3);
			b4.setImageResource(iid4);
			b5.setImageResource(iid5);
		

			b1.setOnClickListener(this);
			b2.setOnClickListener(this);
			b3.setOnClickListener(this);
			b4.setOnClickListener(this);
			b5.setOnClickListener(this);
		
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
					i.putExtra("k1", "five");
					startActivity(i);
					finish();
					}catch(Exception e){}
					}
					
			};
			t.start();
		}
		
		

	}

	 int getImageID(char c) {
		// TODO Auto-generated method stub
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
	

	 String random1( String word) {
		// TODO Auto-generated method stub
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trial_five, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int s0=v.getId();
		correctans=0;
		String vsn=Context.VIBRATOR_SERVICE;
		Vibrator vib;
		vib=(Vibrator)getSystemService(vsn);
		vib.vibrate(100);
		if(s0==R.id.t5_b1)
		{
			if(bu1==0)
			{
			ans=ans+ranword.charAt(0);
			bu1=1;
			int iid1=getRedImageID(ranword.charAt(0));
			b1.setImageResource(iid1);
			tv.setText(ans.toUpperCase());
			}
		}
		
		if(s0==R.id.t5_b2)
		{
			if(bu2==0)
			{
			ans=ans+ranword.charAt(1);
			bu2=1;
			int iid2=getRedImageID(ranword.charAt(1));
			b2.setImageResource(iid2);
			tv.setText(ans.toUpperCase());
		}}
		//if(bu3==0){
		if(s0==R.id.t5_b3)
		{
			if(bu3==0){
			ans=ans+ranword.charAt(2);
			bu3=1;
			int iid3=getRedImageID(ranword.charAt(2));
			b3.setImageResource(iid3);
			tv.setText(ans.toUpperCase());
		}}
		
		if(s0==R.id.t5_b4)
		{
			if(bu4==0){
			ans=ans+ranword.charAt(3);
			bu4=1;
			int iid4=getRedImageID(ranword.charAt(3));
			b4.setImageResource(iid4);
			tv.setText(ans.toUpperCase());
		}}

		if(s0==R.id.t5_b5)
		{
			if(bu5==0){
			ans=ans+ranword.charAt(4);
			bu5=1;
			int iid5=getRedImageID(ranword.charAt(4));
			b5.setImageResource(iid5);
			tv.setText(ans.toUpperCase());
		}}
		if(s0==R.id.t5_bb)
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
				if(te==ranword.charAt(4))
				{
					bu5=0;
					int iid5=getImageID(ranword.charAt(4));
					b5.setImageResource(iid5);
				}
				
			
			ans=ans.substring(0,ans.length()-1);
			tv.setText(ans.toUpperCase());
			}catch(Exception e){}
		}
		
		if(s0==R.id.t5_bs)
		{
			ranword=random1(s);
			
			try{
			
			int iid1=getImageID(ranword.charAt(0));
			int iid2=getImageID(ranword.charAt(1));
			int iid3=getImageID(ranword.charAt(2));
			int iid4=getImageID(ranword.charAt(3));
			int iid5=getImageID(ranword.charAt(4));
		
			
			
			b1.setImageResource(iid1);
			b2.setImageResource(iid2);
			b3.setImageResource(iid3);
			b4.setImageResource(iid4);
			b5.setImageResource(iid5);
			
			
			ans="";
			bu1=bu2=bu3=bu4=bu5=0;
			tv.setText("-------");
			

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
			tv.setText(ans);}
		}
		
		if(correctans==1)
		{
			
			final Intent i = new Intent(this,calling.class);
			Thread t= new Thread(){
				public void run(){
					try{
					Thread.sleep(2000);
					i.putExtra("k1", "five");
					startActivity(i);
					finish();
					}catch(Exception e){}
					}
					
			};
			t.start();
		}*/
		if(ans.length()==5)
		{
			if(ans.equalsIgnoreCase(s)==true)
			{
				
				WordsDB.scorem=WordsDB.scorem+20;
				WordsDB.scoret=WordsDB.scoret+20;
				Toast.makeText(this,"CORRECT ANSWER:  \n"+WordsDB.scorem, 100).show();

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
						i.putExtra("k1", "five");
						startActivity(i);
						finish();
						}catch(Exception e){}
						}
				};
				t.start();
		}		
		
	}

	 int getRedImageID(char c) {
		// TODO Auto-generated method stub
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
