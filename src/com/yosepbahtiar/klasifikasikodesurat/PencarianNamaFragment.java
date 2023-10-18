package com.yosepbahtiar.klasifikasikodesurat;

import java.util.ArrayList;
import android.app.Fragment;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PencarianNamaFragment extends Fragment {
	
	SQLHelper dbHelper;
	ListView listNama;
	EditText editNama;
	private Context mContext;
	private ArrayList<Object> data;
	private static ArrayAdapter<Object> adapter;
	ArrayList<Integer> indeks;

	public PencarianNamaFragment() {
		// Constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pencarian_nama,
				container, false);
		
		mContext = getActivity();
		dbHelper = new SQLHelper(mContext);

		data = new ArrayList<>();
		indeks = new ArrayList<>();
		listNama = (ListView) view.findViewById(R.id.LVNama);

		editNama = (EditText) view.findViewById(R.id.etCariNama);

		getData();

		return view;
	}

	public void getOutput(int p, Cursor cursor) {
		String tingkat = TingkatKlasifikasi.cekTingkat(p);
		Intent i = new Intent(getActivity(), DetailActivity.class);
		i.putExtra("sebelumnya", false);
		i.putExtra("varTingkat", tingkat);
		i.putExtra("varKode", cursor.getString(1).toString());// e[p]
		i.putExtra("varNama", cursor.getString(2).toString());
		i.putExtra("varCatatan", cursor.getString(3).toString());
		startActivity(i);
	}

	private void getData() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		final Cursor cursor = db.rawQuery("SELECT *FROM klasifikasi", null);
		
		if (cursor.getCount() == 0) {
			// jika data tidak ada untuk ditampilkan
		} else {
			while (cursor.moveToNext()) {
				data.add(cursor.getString(2).toString());
			}
		}

		// mendefine adapter
		adapter = new ArrayAdapter<>(getActivity(),
				android.R.layout.simple_list_item_1, data);

		// menempatkan ke listview
		// listNama.setAdapter(adapter);
		listNama.setAdapter(adapter);

		// ini yg baru
		listNama.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> pa, View v, int p, long id) {
				cursor.moveToPosition(p);
				getOutput(p, cursor);
			}
		});

		// ini yg baru 2
		editNama.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

				int j = 0;

				cursor.moveToFirst();

				adapter.clear();

				for (int i = 0; i < cursor.getCount(); i++) {
					//
					String t = cursor.getString(2).toLowerCase();
					String p = arg0.toString().toLowerCase();

					char[] text = t.toCharArray();
					char[] pattern = p.toCharArray();

					int pos = BoyerMoore.indexOf(text, pattern);
					if (pos >= 0) {
						data.add(cursor.getString(2).toString());
						indeks.add(j, cursor.getInt(0));
						j = j + 1;
					}
					cursor.moveToNext();
				}

				// notifikasi error
				if (data.size() == 0) {
					Toast.makeText(mContext, "Data tidak tersedia :(",
							Toast.LENGTH_SHORT).show();
				}

				adapter = new ArrayAdapter<>(getActivity(),
						android.R.layout.simple_list_item_1, data);

				listNama.setAdapter(adapter);

				listNama.setOnItemClickListener(new OnItemClickListener() {
					@Override
					// int p adalah indeks yg diklik
					public void onItemClick(AdapterView<?> pa, View v, int p,
							long id) {
						p = indeks.get(p);
						p = p - 1;
						cursor.moveToPosition(p);
						getOutput(p, cursor);
					}
				});

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});

	}
}
