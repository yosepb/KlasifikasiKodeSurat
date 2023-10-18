package com.yosepbahtiar.klasifikasikodesurat;

import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PencarianActivity extends Activity {

	private static boolean diklik;
	private static ArrayList<Object> data;
	private static ArrayAdapter<Object> adapter;
	static ArrayList<Integer> indeks;
	static SQLHelper dbHelper;
	static ListView listNama;
	static EditText editNama;
	private static Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pencarian);
		Intent intent = getIntent();
		diklik = intent.getBooleanExtra("tombol_diklik", false);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container2, new PlaceholderFragment()).commit();
		}

		if (diklik == true) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container2, new PencarianNamaFragment())
					.commit();
		}
	}

	public static class PlaceholderFragment extends Fragment {
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

			View rootView;
			rootView = inflater.inflate(R.layout.fragment_pencarian_kode, container, false);

			mContext = getActivity();
			dbHelper = new SQLHelper(mContext);

			data = new ArrayList<>();
			indeks = new ArrayList<>();
			listNama = (ListView) rootView.findViewById(R.id.LVKode);

			editNama = (EditText) rootView.findViewById(R.id.etCariKode);

			getData();

			return rootView;
		}

		public void getOutput(int p, Cursor cursor) {
			String tingkat = TingkatKlasifikasi.cekTingkat(p);
			Intent i = new Intent(getActivity(), DetailActivity.class);
			i.putExtra("varTingkat", tingkat);
			i.putExtra("varKode", cursor.getString(1).toString());
			i.putExtra("varNama", cursor.getString(2).toString());
			i.putExtra("varCatatan", cursor.getString(3).toString());
			startActivity(i);
		}

		private void getData() {
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			final Cursor cursor = db.rawQuery("SELECT *FROM klasifikasi", null);

			if (cursor.getCount() == 0) {

			} else {
				while (cursor.moveToNext()) {
					data.add(cursor.getString(1).toString());
				}
			}

			adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);

			listNama.setAdapter(adapter);

			listNama.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> pa, View v, int p,
						long id) {
					cursor.moveToPosition(p);
					getOutput(p, cursor);
				}
			});

			editNama.addTextChangedListener(new TextWatcher() {

				@Override
				public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
					int j = 0;
					cursor.moveToFirst();
					adapter.clear();

					for (int i = 0; i < cursor.getCount(); i++) {
						String t = cursor.getString(1);
						String p = arg0.toString();

						char[] text = t.toCharArray();
						char[] pattern = p.toCharArray();

						int pos = BoyerMoore.indexOf(text, pattern);
						if (pos >= 0) {
							data.add(cursor.getString(1).toString());
							indeks.add(j, cursor.getInt(0));
							j = j + 1;
						}
						cursor.moveToNext();
					}

					if (data.size() == 0) {
						Toast.makeText(mContext, "Data tidak tersedia :(", Toast.LENGTH_SHORT).show();
					}

					adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
					listNama.setAdapter(PencarianActivity.adapter);

					listNama.setOnItemClickListener(new OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> pa, View v, int p, long id) {
							p = indeks.get(p);
							p = p - 1;
							cursor.moveToPosition(p);
							getOutput(p, cursor);
						}
					});
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

				}

				@Override
				public void afterTextChanged(Editable arg0) {

				}
			});

		}
	}
}
