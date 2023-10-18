package com.yosepbahtiar.klasifikasikodesurat;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivity extends Activity {

	boolean induk;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		Intent intent = getIntent();
		induk = intent.getBooleanExtra("sebelumnya", true);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	public static class PlaceholderFragment extends Fragment {

		TextView txtTingkat;
		TextView txtKode;
		TextView txtNama;
		TextView txtCatatan;

		public PlaceholderFragment() {
			// constructor
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_detail,
					container, false);

			txtTingkat = (TextView) rootView.findViewById(R.id.tvTingkat);
			txtKode = (TextView) rootView.findViewById(R.id.tvKode);
			txtNama = (TextView) rootView.findViewById(R.id.tvNama);
			txtCatatan = (TextView) rootView.findViewById(R.id.tvCatatan);
			getData();
			return rootView;
		}

		private void getData() {
			txtTingkat.setText(getActivity().getIntent().getStringExtra(
					"varTingkat"));
			txtKode.setText(getActivity().getIntent().getStringExtra("varKode"));
			txtNama.setText(getActivity().getIntent().getStringExtra("varNama"));
			txtCatatan.setText(getActivity().getIntent().getStringExtra(
					"varCatatan"));
		}
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// if induk = true pencarianactivity, if induk false pencariannama
		if (induk == true) {
			Intent myIntent = new Intent(getApplicationContext(),
					PencarianActivity.class);
			startActivityForResult(myIntent, 0);
		} else {
			Intent myIntent = new Intent(getApplicationContext(),
					PencarianActivity.class);
			myIntent.putExtra("tombol_diklik", true);
			startActivityForResult(myIntent, 0);
		}

		return true;
	}

}
