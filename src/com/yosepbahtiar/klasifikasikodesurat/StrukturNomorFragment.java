package com.yosepbahtiar.klasifikasikodesurat;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StrukturNomorFragment extends Fragment {
	public StrukturNomorFragment() {
		// constructor public kosong
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_struktur_nomor,
				container, false);

		// Toast.makeText(getActivity(),
		// "Fragment Bagian Surat",Toast.LENGTH_SHORT).show();
		return view;
	}
}
