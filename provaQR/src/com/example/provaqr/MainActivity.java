package com.example.provaqr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends Activity {
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    HandleClick hc = new HandleClick();
	    findViewById(R.id.butQR).setOnClickListener(hc);
	   
	  }
	  private class HandleClick implements OnClickListener{
	    public void onClick(View arg0) {
	      Intent intent = new Intent("com.google.zxing.client.android.SCAN");
	      switch(arg0.getId()){
	        case R.id.butQR:
	          intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
	        break;
	  
	      }
	      startActivityForResult(intent, 0); 
	    }
	  }
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	      TextView tvStatus=(TextView)findViewById(R.id.tvStatus);
	      TextView tvResult=(TextView)findViewById(R.id.tvResult);
	      if (resultCode == RESULT_OK) {
	        tvStatus.setText(intent.getStringExtra("SCAN_RESULT_FORMAT"));
	        tvResult.setText(intent.getStringExtra("SCAN_RESULT"));
	        
	        String multiLines = tvResult.getText().toString();
	        String delimiter = "\n";

	        String[] animal = multiLines.split(delimiter);
	        
	      } else if (resultCode == RESULT_CANCELED) {
	        tvStatus.setText("Press a button to start a scan.");
	        tvResult.setText("Scan cancelled.");
	      }
	    }
	  }
	}