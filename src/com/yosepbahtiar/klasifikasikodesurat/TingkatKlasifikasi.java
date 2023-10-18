package com.yosepbahtiar.klasifikasikodesurat;

public class TingkatKlasifikasi {

	public static String cekTingkat(int p) {
		String tingkat = "";
		// TODO Auto-generated method stub
		// keuangan
		if (p >= 2327) {
			tingkat = "Keuangan\\Bendaharawan";
		} else if (p >= 2314) {
			tingkat = "Keuangan\\Pendapatan";
		} else if (p >= 2307) {
			tingkat = "Keuangan\\Pembinaan Kebendaharaan";
		} else if (p >= 2297) {
			tingkat = "Keuangan\\Perbendaharaan";
		} else if (p >= 2291) {
			tingkat = "Keuangan\\Pembukuan";
		} else if (p >= 2281) {
			tingkat = "Keuangan\\Verifikasi";
		} else if (p >= 2273) {
			tingkat = "Keuangan\\Otorisasi/SKO";
		} else if (p >= 2261) {
			tingkat = "Keuangan\\Anggaran";
		} else if (p >= 2251) {
			tingkat = "Keuangan";
		}

		// kepegawaian
		else if (p >= 2205) {
			tingkat = "Kepegawaian\\Pendidikan Pegawai";
		} else if (p >= 2187) {
			tingkat = "Kepegawaian\\Pemberhentian Pegawai";
		} else if (p >= 2167) {
			tingkat = "Kepegawaian\\Tata Usaha Kepegawaian";
		} else if (p >= 2145) {
			tingkat = "Kepegawaian\\Penilaian";
		} else if (p >= 2135) {
			tingkat = "Kepegawaian\\Cuti";
		} else if (p >= 2103) {
			tingkat = "Kepegawaian\\Kesejahteraan Pegawai";
		} else if (p >= 2091) {
			tingkat = "Kepegawaian\\Kedudukan";
		} else if (p >= 2046) {
			tingkat = "Kepegawaian\\Mutasi";
		} else if (p >= 2027) {
			tingkat = "Kepegawaian\\Pengadaan";
		} else if (p >= 2020) {
			tingkat = "Kepegawaian";
		}

		// pengawasan
		else if (p >= 2010) {
			tingkat = "Pengawasan\\Bidang Keuangan";
		} else if (p >= 2000) {
			tingkat = "Pengawasan\\Bidang Kepegawaian";
		} else if (p >= 1987) {
			tingkat = "Pengawasan\\Bidang Pekerjaan Umum";
		} else if (p >= 1977) {
			tingkat = "Pengawasan\\Bidang Perekonomian";
		} else if (p >= 1967) {
			tingkat = "Pengawasan\\Bidang Kesejahteraan Rakyat";
		} else if (p >= 1957) {
			tingkat = "Pengawasan\\Bidang Keamanan/Ketertiban";
		} else if (p >= 1949) {
			tingkat = "Pengawasan\\Bidang Politik";
		} else if (p >= 1939) {
			tingkat = "Pengawasan\\Bidang Pemerintahan";
		} else if (p >= 1929) {
			tingkat = "Pengawasan";
		}

		// pekerjaan umum dan ketenagaan
		else if (p >= 1883) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Air Minum";
		} else if (p >= 1879) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Peralatan";
		} else if (p >= 1846) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Ketenagaan";
		} else if (p >= 1829) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Tata Lingkungan";
		} else if (p >= 1788) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Tata Kota";
		} else if (p >= 1728) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Bangunan";
		} else if (p >= 1620) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Jembatan";
		} else if (p >= 1526) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Jalan";
		} else if (p >= 1375) {
			tingkat = "Pekerjaan Umum dan Ketenagaan\\Pengairan";
		} else if (p >= 1334) {
			tingkat = "Pekerjaan Umum dan Ketenagaan";
		}

		// perekonomian
		else if (p >= 1252) {
			tingkat = "Perekonomian\\Agraria";
		} else if (p >= 1242) {
			tingkat = "Perekonomian\\Perbankan/Moneter";
		} else if (p >= 1234) {
			tingkat = "Perekonomian\\Permodalan";
		} else if (p >= 1221) {
			tingkat = "Perekonomian\\Tenaga Kerja";
		} else if (p >= 1169) {
			tingkat = "Perekonomian\\Perhubungan";
		} else if (p >= 1147) {
			tingkat = "Perekonomian\\Pertambangan/Kesamudraan";
		} else if (p >= 1133) {
			tingkat = "Perekonomian\\Perindustrian";
		} else if (p >= 1023) {
			tingkat = "Perekonomian\\Pertanian";
		} else if (p >= 1004) {
			tingkat = "Perekonomian\\Perdagangan";
		} else if (p >= 996) {
			tingkat = "Perekonomian";
		}

		// kesejahteraan
		else if (p >= 993) {
			tingkat = "Kesejahteraan\\Pengaduan Masyarakat";
		} else if (p >= 972) {
			tingkat = "Kesejahteraan\\Media Massa";
		} else if (p >= 853) {
			tingkat = "Kesejahteraan\\Kependudukan";
		} else if (p >= 817) {
			tingkat = "Kesejahteraan\\Sosial";
		} else if (p >= 764) {
			tingkat = "Kesejahteraan\\Agama";
		} else if (p >= 717) {
			tingkat = "Kesejahteraan\\Kesehatan";
		} else if (p >= 700) {
			tingkat = "Kesejahteraan\\Kebudayaan";
		} else if (p >= 651) {
			tingkat = "Kesejahteraan\\Pendidikan";
		} else if (p >= 538) {
			tingkat = "Kesejahteraan\\Pembangunan Desa";
		} else if (p >= 533) {
			tingkat = "Kesejahteraan";
		}

		// keamanan dan ketertiban
		else if (p >= 517) {
			tingkat = "Keamanan dan Ketertiban\\Kecelakaan/Sar";
		} else if (p >= 507) {
			tingkat = "Keamanan dan Ketertiban\\Bencana";
		} else if (p >= 497) {
			tingkat = "Keamanan dan Ketertiban\\Kejahatan";
		} else if (p >= 492) {
			tingkat = "Keamanan dan Ketertiban\\Pertahanan Sipil";
		} else if (p >= 478) {
			tingkat = "Keamanan dan Ketertiban\\Keamanan";
		} else if (p >= 468) {
			tingkat = "Keamanan dan Ketertiban\\Kemiliteran";
		} else if (p >= 460) {
			tingkat = "Keamanan dan Ketertiban\\Pertahanan";
		} else if (p >= 456) {
			tingkat = "Keamanan dan Ketertiban";
		}

		// politik
		else if (p >= 451) {
			tingkat = "Politik\\Pengucapan Sumpah Janji MPR, DPR, DPD";
		} else if (p >= 436) {
			tingkat = "Politik\\Pemilihan Umum";
		} else if (p >= 426) {
			tingkat = "Politik\\Organisasi Wanita";
		} else if (p >= 417) {
			tingkat = "Politik\\Organisasi Buruh, Tani, Nelayan, dan Angkutan";
		} else if (p >= 408) {
			tingkat = "Politik\\Organisasi Pemuda";
		} else if (p >= 398) {
			tingkat = "Politik\\Organisasi Profesi dan Fungsional";
		} else if (p >= 386) {
			tingkat = "Politik\\Organisasi Kemasyarakatan";
		} else if (p >= 379) {
			tingkat = "Politik\\Kepartaian";
		} else if (p >= 372) {
			tingkat = "Politik";
		}

		// pemerintahan
		else if (p >= 360) {
			tingkat = "Pemerintahan\\Hubungan Luar Negeri";
		} else if (p >= 310) {
			tingkat = "Pemerintahan\\Hukum";
		} else if (p >= 294) {
			tingkat = "Pemerintahan\\DPRD Kabupaten";
		} else if (p >= 276) {
			tingkat = "Pemerintahan\\DPRD Provinsi";
		} else if (p >= 258) {
			tingkat = "Pemerintahan\\Legislatif";
		} else if (p >= 237) {
			tingkat = "Pemerintahan\\Pemerintahan Desa/Kelurahan";
		} else if (p >= 208) {
			tingkat = "Pemerintahan\\Pemerintah Kabupaten/Kota";
		} else if (p >= 184) {
			tingkat = "Pemerintahan\\Pemerintah Provinsi";
		} else if (p >= 166) {
			tingkat = "Pemerintahan\\Pemerintahan Pusat";
		} else if (p >= 160) {
			tingkat = "Pemerintahan";
		}

		// umum
		else if (p >= 150) {
			tingkat = "Umum\\Perjalanan Dinas";
		} else if (p >= 140) {
			tingkat = "Umum\\Konferensi/Rapat/Seminar";
		} else if (p >= 130) {
			tingkat = "Umum\\Penelitian";
		} else if (p >= 117) {
			tingkat = "Umum\\Organisasi Ketatalaksanaan";
		} else if (p >= 103) {
			tingkat = "Umum\\Perencanaan";
		} else if (p >= 74) {
			tingkat = "Umum\\Perpustakaan Dokumentasi/Kearsipan/Sandi";
		} else if (p >= 67) {
			tingkat = "Umum\\Kekayaan Daerah";
		} else if (p >= 56) {
			tingkat = "Umum\\Peralatan";
		} else if (p >= 33) {
			tingkat = "Umum\\Urusan Dalam";
		} else if (p >= 0) {
			tingkat = "Umum";
		}
		return tingkat;
	}

}
