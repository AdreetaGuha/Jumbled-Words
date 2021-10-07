package com.example.jumbledwords;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HomeScreen extends Activity {

	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		db=openOrCreateDatabase("firstdb", MODE_WORLD_READABLE, null);
		String q="create table if not exists scoretable(name varchar, score int)";
		db.execSQL(q);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		db=openOrCreateDatabase("firstdb", MODE_WORLD_READABLE, null);
		String q="create table if not exists scoretable(name varchar, score int)";
		db.execSQL(q);
	}

	
}
