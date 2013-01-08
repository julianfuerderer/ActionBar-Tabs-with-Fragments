ActionBar-Tabs-with-Fragments
=============================

Android ActionBar-Tabs with Fragments - This code shows an ActionBar in Mode "Tabs" build with Fragments

public class MainActivity extends FragmentActivity 
{
  public static int currentPos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getActionBar();
		
		Tab tabDashBoard = actionBar.newTab();
		tabDashBoard.setText("Dashboard");
		TabListener<DashBoardFragment> tabListenerDashBoard = new TabListener<DashBoardFragment>(this,"Dashboard", DashBoardFragment.class);
		tabDashBoard.setTabListener(tabListenerDashBoard);
		actionBar.addTab(tabDashBoard);
		
		Tab tabSuche = actionBar.newTab();
		tabSuche.setText("Suche");
		TabListener<SucheFragment> tabListenerSuche = new TabListener<SucheFragment>(this,"Suche",SucheFragment.class);
		tabSuche.setTabListener(tabListenerSuche);
		actionBar.addTab(tabSuche);
		
		Tab tabMap = actionBar.newTab();
		tabMap.setText("Map");
		TabListener<MapFragment> tabListenerMap = new TabListener<MapFragment>(this,"Map",MapFragment.class);
		tabMap.setTabListener(tabListenerMap);
		actionBar.addTab(tabMap);
		
		Tab tabProfil = actionBar.newTab();
		tabProfil.setText("Profil");
		TabListener<ProfilFragment> tabListenerProfil = new TabListener<ProfilFragment>(this,"Profil",ProfilFragment.class);
		tabProfil.setTabListener(tabListenerProfil);
		actionBar.addTab(tabProfil);
		
		Tab tabNachrichten = actionBar.newTab();
		tabNachrichten.setText("Nachrichten");
		TabListener<NachrichtenFragment> tabListenerNachrichten = new TabListener<NachrichtenFragment>(this,"Nachrichten",NachrichtenFragment.class);
		tabNachrichten.setTabListener(tabListenerNachrichten);
		actionBar.addTab(tabNachrichten);
		
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);	
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(false);

		 if( savedInstanceState != null ){
	         actionBar.setSelectedNavigationItem(savedInstanceState.getInt("tabState"));
	     }
	}

	private class TabListener<T extends Fragment> implements ActionBar.TabListener
	{
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		
		
		 public TabListener(Activity activity,String tag,Class<T> clz)
		 {
			 mActivity = activity;
			 mTag = tag;
			 mClass = clz; 
		 }
		
		 @Override
		 public void onTabSelected(Tab tab, FragmentTransaction ft) 
		 {
			 
		   currentPos = tab.getPosition();
			 
			Fragment prevFragment;
	        FragmentManager fm = mActivity.getFragmentManager();
	        prevFragment = fm.findFragmentByTag(mTag); 
	        if (prevFragment != null) { 
	            mFragment = prevFragment; 
	        } // \previous Fragment management
		        
			// Check if the fragment is already initialized
			if(mFragment == null){
				// If not, instantiate and add it to the activity:
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment,mTag);
			}else{
				// If it exists, simply attach it in order to show it:
				ft.attach(mFragment);
			}	
		 }
		
		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) 
		{
			currentPos = tab.getPosition();
			if(mFragment != null){
				 // Detach the fragment, because another one is being attached:
				ft.detach(mFragment);
			}else{
				// If not, instantiate and add it to the activity:
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment,mTag);
				
			}
		}
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) 
		{
			 // User selected the already selected tab. Usually do nothing.	
		}	
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putInt("tabState", currentPos);
	}	
  
  
And here is an Fragment,- DashBoardFragment.class:


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









