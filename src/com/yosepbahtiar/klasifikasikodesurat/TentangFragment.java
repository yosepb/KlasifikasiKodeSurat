package com.yosepbahtiar.klasifikasikodesurat;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TentangFragment extends Fragment {
	public TentangFragment() {
		// constructor public kosong
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tentang, container,
				false);

		// Toast.makeText(getActivity(),
		// "Fragment Tentang Saya",Toast.LENGTH_SHORT).show();
		return view;
	}
}
