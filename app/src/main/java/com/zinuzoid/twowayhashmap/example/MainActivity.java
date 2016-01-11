package com.zinuzoid.twowayhashmap.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zinuzoid.twowayhashmap.TwoWayHashMap;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TwoWayHashMap<Integer, String> map = new TwoWayHashMap<>();

	}

}
