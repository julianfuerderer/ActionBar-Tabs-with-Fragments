package com.example.actionbarubung;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DashBoardFragment extends Fragment{

  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.dashboard,container, false);
		/*TextView tv = (TextView) ll.findViewById(R.id.textView1);

		tv.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		    
		    }
		});*/
		return ll;

	}
}
