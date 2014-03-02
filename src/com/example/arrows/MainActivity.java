package com.example.arrows;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//reference for seekbar
		//TODO: make seekbar actually do something
		SeekBar speedSetting = (SeekBar)findViewById(R.id.animation_speed);
		
		speedSetting.setOnSeekBarChangeListener(new 
				SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
			}
		});
		
		//generating references to get to buttons
		
		Button straightArrow = (Button) findViewById(R.id.staight_arrow);
		Button rightArrow = (Button) findViewById(R.id.right_arrow);
		Button leftArrow = (Button) findViewById(R.id.left_arrow);
		Button slightLeft = (Button) findViewById(R.id.slight_left);
		Button slightRight = (Button) findViewById(R.id.slight_right);
		
		
		/*button listeners: each one only calls constructor for 
		 * ArrowAnimation.java and passes in the appropriate values
		 */
		
		straightArrow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v = new ArrowAnimation(MainActivity.this, 1);
				setContentView(v);
			}
		});
		
		leftArrow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v = new ArrowAnimation(MainActivity.this, 2);
				setContentView(v);
			}
		});
		
		rightArrow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v = new ArrowAnimation(MainActivity.this, 3);
				setContentView(v);
			}
		});
		
		slightLeft.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v = new ArrowAnimation(MainActivity.this, 4);
				setContentView(v);
			}
		});
		
		slightRight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v = new ArrowAnimation(MainActivity.this, 5);
				setContentView(v);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
