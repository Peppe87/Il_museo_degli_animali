package it.polito.am.video;

import java.io.File;
import java.io.InputStream;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	private VideoView videoview;
	private Button bplay;
	private Button bpause;
	private Button bstop;
	private Button bresume;
	private int counter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		videoview = (VideoView) findViewById(R.id.videoView1);
		bplay = (Button) findViewById(R.id.play);
		bpause = (Button) findViewById(R.id.pause);
		bstop = (Button) findViewById(R.id.stop);
		bresume = (Button) findViewById(R.id.resume);
		
		counter=0;
		
		videoview.setMediaController(null);
		
		bplay.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				videoview.start();
			}
		});
		
		bpause.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				videoview.pause();
			}
		});
		
		bstop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				videoview.stopPlayback();
			}
		});
		
		bresume.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				videoview.resume();
			}
		});
		
		videoview.setOnCompletionListener(new OnCompletionListener() {
		
			
			public void onCompletion(MediaPlayer mp) {
				videoview.seekTo(videoview.getDuration());
				carica();
			}
		});
		
		carica();
		
		
		
		
	}
	
	public void carica() {
		String path="";
		String completepath="";
		switch (counter){
		
			case 0: path="dog";
			completepath = ("android.resource://" + getPackageName() + "/" + R.raw.dog);
			break;
			
			case 1: path="bug";
			completepath = ("android.resource://" + getPackageName() + "/" + R.raw.bug);
			break;
			
			case 2: path="bull";
			completepath = ("android.resource://" + getPackageName() + "/" + R.raw.bull);
			break;
			
//			case 4: 
			
		}
		
		videoview.setVideoURI(Uri.parse(completepath));
		counter++;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
