package com.yosepbahtiar.klasifikasikodesurat;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	// Fragment managing the behaviours, interactions and presentation of the
	// navigation drawer.
	private NavigationDrawerFragment mNavigationDrawerFragment;

	// Used to store the last screen title. For use in {@link
	// #restoreActionBar()}.
	private CharSequence mTitle;

	protected Cursor cursor;
	SQLHelper dbHelper;

	Button btnCariKode, btnCariNama;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnCariKode = (Button) findViewById(R.id.btn_cari_kode);
		btnCariNama = (Button) findViewById(R.id.btn_cari_nama);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

		dbHelper = new SQLHelper(this);
		try {
			dbHelper.createDataBase();
		} catch (Exception ioe) {
			Toast.makeText(getApplicationContext(),
					"Basis Data gagal di-Import :(", Toast.LENGTH_LONG).show();
		}

	}
	
	public void methodTombol(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_cari_kode:
			intent = new Intent(MainActivity.this, PencarianActivity.class);
			startActivity(intent);
			break;

		case R.id.btn_cari_nama:
			intent = new Intent(MainActivity.this, PencarianActivity.class);
			intent.putExtra("tombol_diklik", true);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	// dari sini kah untuk menambahkan layout
	public void onSectionAttached(int number) {
		mTitle = getString(R.string.app_name);
		FragmentManager fragmentManager = getFragmentManager();

		switch (number) {
		case 1:
			// mTitle = getString(R.string.title_section1);
			break;
		case 2:
			// mTitle = getString(R.string.title_section2);
			fragmentManager.beginTransaction()
					.replace(R.id.container, new StrukturNomorFragment())
					.commit();
			break;
		case 3:
			// mTitle = getString(R.string.title_section3);
			fragmentManager.beginTransaction()
					.replace(R.id.container, new TentangFragment()).commit();
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	// A placeholder fragment containing a simple view.
	public static class PlaceholderFragment extends Fragment {
		// The fragment argument representing the section number for this
		// fragment.
		private static final String ARG_SECTION_NUMBER = "section_number";

		// Returns a new instance of this fragment for the given section number.
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}
}
