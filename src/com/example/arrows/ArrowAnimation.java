package com.example.arrows;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.*;
import android.view.View;

public class ArrowAnimation extends View {

	// just a placeholder paint for bitmap generation
	Paint p = new Paint();

	// an int to count how many animation cycles we've gone through
	int counter = 0;

	/*
	 * a float holds the speed of the animation. Used to calculate how many
	 * animation cycles should pass before bitmaps are changed TODO: import from
	 * slider
	 */
	float animationSpeed = 20;

	/*
	 * an int that is used to indicate which arrow has been passed in 1:
	 * straight 2: left 3: right 4: Slight left 5: Slight right
	 */
	int arrowType;

	/*
	 * int used to count how many times the arrow has been displayed (not used
	 * in final version)
	 */
	int loops = 0;

	// int for where the top of the arrow should be in pixels
	// TODO: make this passed in from somewhere
	int arrowTop = 350;

	// boolean to see if we should go back to our old view
	boolean done = false;

	// bitmaps declared here in order to unify use for all methods
	Bitmap arrow1;
	Bitmap arrow2;
	Bitmap arrow3;
	Bitmap arrow4;
	Bitmap arrow5;

	// locations of where each arrow should be
	float arrow1Left;
	float arrow2Left;
	float arrow3Left;
	float arrow4Left;
	float arrow5Left;

	float arrow1Top;
	float arrow2Top;
	float arrow3Top;
	float arrow4Top;
	float arrow5Top;

	// TODO: change arrow generation so that it only happens once (for memory)

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (arrowType == 1)
			drawStraightArrow(canvas);
		if (arrowType == 2)
			drawLeftArrow(canvas);
		if (arrowType == 3)
			drawRightArrow(canvas);
		if (arrowType == 4)
			; // TODO drawSlightLeft method
		if (arrowType == 5)
			; // TODO drawSlightRightmethod
		if (loops < 3) {
			if (counter > animationSpeed * 5)
				canvas.drawBitmap(arrow5, arrow5Left, arrow5Top, p);
			if (counter > animationSpeed * 4)
				canvas.drawBitmap(arrow4, arrow4Left, arrow4Top, p);
			if (counter > animationSpeed * 3)
				canvas.drawBitmap(arrow3, arrow3Left, arrow3Top, p);
			if (counter > animationSpeed * 2)
				canvas.drawBitmap(arrow2, arrow2Left, arrow2Top, p);
			if (counter > animationSpeed)
				canvas.drawBitmap(arrow1, arrow1Left, arrow1Top, p);
			if (counter > animationSpeed * 6) {
				counter = 0;
				loops++;
			} else {
				counter++;
			}
		}
		if (loops < 6 && loops >= 3) {
			if (counter > animationSpeed * 4)
				canvas.drawBitmap(arrow5, arrow5Left, arrow5Top, p);
			if (counter > animationSpeed * 3)
				canvas.drawBitmap(arrow4, arrow4Left, arrow4Top, p);
			if (counter > animationSpeed * 2)
				canvas.drawBitmap(arrow3, arrow3Left, arrow3Top, p);
			if (counter > animationSpeed)
				canvas.drawBitmap(arrow2, arrow2Left, arrow2Top, p);
			canvas.drawBitmap(arrow1, arrow1Left, arrow1Top, p);
			if (counter > animationSpeed * 5) {
				counter = 0;
				loops++;
			} else {
				counter++;
			}
		}
		if (loops < 9 && loops >= 6) {
			if (counter > animationSpeed * 3)
				canvas.drawBitmap(arrow5, arrow5Left, arrow5Top, p);
			if (counter > animationSpeed * 2)
				canvas.drawBitmap(arrow4, arrow4Left, arrow4Top, p);
			if (counter > animationSpeed * 1)
				canvas.drawBitmap(arrow3, arrow3Left, arrow3Top, p);
			canvas.drawBitmap(arrow2, arrow2Left, arrow2Top, p);
			canvas.drawBitmap(arrow1, arrow1Left, arrow1Top, p);
			if (counter > animationSpeed * 4) {
				counter = 0;
				loops++;
			} else {
				counter++;
			}
		}

		if (loops < 12 && loops >= 9) {
			if (counter > animationSpeed * 2)
				canvas.drawBitmap(arrow5, arrow5Left, arrow5Top, p);
			if (counter > animationSpeed)
				canvas.drawBitmap(arrow4, arrow4Left, arrow4Top, p);
			canvas.drawBitmap(arrow3, arrow3Left, arrow3Top, p);
			canvas.drawBitmap(arrow2, arrow2Left, arrow2Top, p);
			canvas.drawBitmap(arrow1, arrow1Left, arrow1Top, p);
			if (counter > animationSpeed * 3) {
				counter = 0;
				loops++;
			} else {
				counter++;
			}
		}
		if (loops < 15 && loops >= 12) {
			if (counter > animationSpeed)
				canvas.drawBitmap(arrow5, arrow5Left, arrow5Top, p);
			canvas.drawBitmap(arrow4, arrow4Left, arrow4Top, p);
			canvas.drawBitmap(arrow3, arrow3Left, arrow3Top, p);
			canvas.drawBitmap(arrow2, arrow2Left, arrow2Top, p);
			canvas.drawBitmap(arrow1, arrow1Left, arrow1Top, p);
			if (counter > animationSpeed * 2) {
				counter = 0;
				loops++;
			} else {
				counter++;
			}
			loops = 0;
		}
		if (done) {
			// TODO find out how to exit view
		}

		invalidate();
	}

	private void drawStraightArrow(Canvas canvas) {

		// arrows set to appropriate bitmaps
		arrow1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow4 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_trap);
		arrow5 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_tip);

		// set the appropriate variables

		arrow1Left = canvas.getWidth() / 2 - arrow1.getWidth() / 2;
		arrow2Left = canvas.getWidth() / 2 - arrow2.getWidth() / 2;
		arrow3Left = canvas.getWidth() / 2 - arrow3.getWidth() / 2;
		arrow4Left = canvas.getWidth() / 2 - arrow4.getWidth() / 2;
		arrow5Left = canvas.getWidth() / 2 - arrow5.getWidth() / 2;

		arrow1Top = canvas.getHeight() - arrowTop;
		arrow2Top = canvas.getHeight() - arrowTop - arrow1.getHeight();
		arrow3Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();
		arrow4Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight() - arrow3.getHeight();
		arrow5Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight() - arrow3.getHeight() - arrow4.getHeight();
	}

	private void drawRightArrow(Canvas canvas) {
		arrow1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow4 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow5 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);

		// Only works if arrow is perfectly square in the end
		arrow1Left = canvas.getWidth() / 2 - arrow1.getWidth() * 2;
		arrow2Left = arrow1Left;
		arrow3Left = arrow1Left;
		arrow4Left = canvas.getWidth() / 2 - arrow4.getWidth();
		arrow5Left = canvas.getWidth() / 2;

		arrow1Top = canvas.getHeight() - arrowTop;
		arrow2Top = canvas.getHeight() - arrowTop - arrow1.getHeight();
		arrow3Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();
		arrow4Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();
		arrow5Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();

	}

	private void drawLeftArrow(Canvas canvas) {
		arrow1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow4 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);
		arrow5 = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_stem);

		// Only works if arrow is perfectly square in the end
		arrow1Left = canvas.getWidth() / 2 + arrow1.getWidth() * 2;
		arrow2Left = arrow1Left;
		arrow3Left = arrow1Left;
		arrow4Left = canvas.getWidth() / 2 + arrow4.getWidth();
		arrow5Left = canvas.getWidth() / 2;

		arrow1Top = canvas.getHeight() - arrowTop;
		arrow2Top = canvas.getHeight() - arrowTop - arrow1.getHeight();
		arrow3Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();
		arrow4Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();
		arrow5Top = canvas.getHeight() - arrowTop - arrow1.getHeight()
				- arrow2.getHeight();
	}

	public ArrowAnimation(Context context, int arrowTypeInt) {
		super(context);

		arrowType = arrowTypeInt;
	}
}
