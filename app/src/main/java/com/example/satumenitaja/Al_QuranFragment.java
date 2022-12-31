package com.example.satumenitaja;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Al_QuranFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterAlquran adapterAlquran;
    ArrayList<Surah> objSurah = new ArrayList<>();
    private MenuItem menuItem;
    private SearchView searchView1;

    public Al_QuranFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_al__quran, container, false);

        recyclerView = view.findViewById(R.id.tampil_recyclerview_alquran);

        objSurah.add(new Surah("Al-Fatiha (The Opening)", "1 - 7"));
        objSurah.add(new Surah("Al-Baqarah (The Cow)", "1 - 286"));
        objSurah.add(new Surah("Aali Imran (the Family of Imran)", "1 - 200"));
        objSurah.add(new Surah("An-Nisa’ (the Women)", "1 - 176"));
        objSurah.add(new Surah("Al-Ma’idah (the Table)", "1 - 120"));
        objSurah.add(new Surah("Al-An’am (the Cattle)", "1 - 165"));
        objSurah.add(new Surah("Al-A’raf (the Heights)", "1 - 206"));
        objSurah.add(new Surah(" Al-Anfal (the Spoils of War)", "1 - 75"));
        objSurah.add(new Surah("At-Taubah (the Repentance)", "1 - 129"));
        objSurah.add(new Surah("Yunus (Yunus)", "1 - 109"));
        objSurah.add(new Surah("Hud (Hud)", "1 - 123"));
        objSurah.add(new Surah("Yusuf (Yusuf)", "1 - 111"));
        objSurah.add(new Surah("Ar-Ra’d (the Thunder))", "1 - 43"));
        objSurah.add(new Surah("Ibrahim (Ibrahim)", "1 - 52"));
        objSurah.add(new Surah("Al-Hijr (the Rocky Tract)", "1 - 99"));
        objSurah.add(new Surah("An-Nahl (the Bees)", "1 - 128"));
        objSurah.add(new Surah(" Al-Isra’ (the Night Journey)", "1 - 111"));
        objSurah.add(new Surah("Al-Kahf (the Cave)", "1 - 110"));
        objSurah.add(new Surah("Maryam (Maryam)", "1 - 98"));
        objSurah.add(new Surah("Ta-Ha (Ta-Ha)", "1 - 135"));
        objSurah.add(new Surah("Al-Anbiya’ (the Prophets)", "1 - 112"));
        objSurah.add(new Surah("Al-Haj (the Pilgrimage)", "1 - 78"));
        objSurah.add(new Surah("Al-Mu’minun (the Believers)", "1 - 118"));
        objSurah.add(new Surah("An-Nur (the Light)", "1 - 64"));
        objSurah.add(new Surah("Al-Furqan (the Criterion)", "1 - 77"));
        objSurah.add(new Surah("Ash-Shu’ara’ (the Poets)", "1 - 227"));
        objSurah.add(new Surah("An-Naml (the Ants)", "1 - 93"));
        objSurah.add(new Surah("Al-Qasas (the Stories)", "1 - 88"));
        objSurah.add(new Surah("Al-Ankabut (the Spider)", "1 - 69"));
        objSurah.add(new Surah("Ar-Rum (the Romans)", "1 - 60"));
        objSurah.add(new Surah("Luqman (Luqman)", "1 - 34"));
        objSurah.add(new Surah("As-Sajdah (the Prostration)", "1 - 30"));
        objSurah.add(new Surah("Al-Ahzab (the Combined Forces)", "1 - 73"));
        objSurah.add(new Surah("Saba’ (the Sabeans)", "1 - 54"));
        objSurah.add(new Surah("Al-Fatir (the Originator)", "1 - 45"));
        objSurah.add(new Surah("Ya-Sin (Ya-Sin)", "1 - 83"));
        objSurah.add(new Surah(" As-Saffah (Those Ranges in Ranks)", "1 - 182"));
        objSurah.add(new Surah("Sad (Sad)", "1 - 88"));
        objSurah.add(new Surah("Az-Zumar (the Groups)", "1 - 75"));
        objSurah.add(new Surah("Ghafar (the Forgiver)", "1 - 85"));
        objSurah.add(new Surah("Fusilat (Distinguished)", "1 - 54"));
        objSurah.add(new Surah("Ash-Shura (the Consultation)", "1 - 53"));
        objSurah.add(new Surah("Az-Zukhruf (the Gold)", "1 - 89"));
        objSurah.add(new Surah("Ad-Dukhan (the Smoke)", "1 - 59"));
        objSurah.add(new Surah("Al-Jathiyah (the Kneeling)", "1 - 37"));
        objSurah.add(new Surah("Al-Ahqaf (the Valley)", "1 - 35"));
        objSurah.add(new Surah("Muhammad (Muhammad)", "1 - 38"));
        objSurah.add(new Surah("Al-Fat’h (the Victory)", "1 - 29"));
        objSurah.add(new Surah("Al-Hujurat (the Dwellings)", "1 - 18"));
        objSurah.add(new Surah("Qaf (Qaf)", "1 - 45"));
        objSurah.add(new Surah("Adz-Dzariyah (the Scatterers)", "1 - 60"));
        objSurah.add(new Surah("At-Tur (the Mount)", "1 - 49"));
        objSurah.add(new Surah("An-Najm (the Star)", "1 - 62"));
        objSurah.add(new Surah("Al-Qamar (the Moon)", "1 - 55"));
        objSurah.add(new Surah("Ar-Rahman (the Most Gracious)", "1 - 78"));
        objSurah.add(new Surah("Al-Waqi’ah (the Event)", "1 - 96"));
        objSurah.add(new Surah("Al-Hadid (the Iron)", "1 - 29"));
        objSurah.add(new Surah("Al-Mujadilah (the Reasoning)", "1 - 22"));
        objSurah.add(new Surah("Al-Hashr (the Gathering)", "1 - 24"));
        objSurah.add(new Surah("Al-Mumtahanah (the Tested)", "1 - 13"));
        objSurah.add(new Surah("As-Saf (the Row)", "1 - 14"));
        objSurah.add(new Surah("Al-Jum’ah (Friday)", "1 - 11"));
        objSurah.add(new Surah("Al-Munafiqun (the Hypocrites)", "1 - 11"));
        objSurah.add(new Surah("At-Taghabun (the Loss & Gain)", "1 - 18"));
        objSurah.add(new Surah("At-Talaq (the Divorce)", "1 - 12"));
        objSurah.add(new Surah("At-Tahrim (the Prohibition)", "1 - 12"));
        objSurah.add(new Surah("Al-Mulk – (the Kingdom)", "1 - 30"));
        objSurah.add(new Surah("Al-Qalam (the Pen)", "1 - 52"));
        objSurah.add(new Surah("Al-Haqqah (the Inevitable)", "1 - 52"));
        objSurah.add(new Surah("Al-Ma’arij (the Elevated Passages)", "1 - 44"));
        objSurah.add(new Surah("Nuh (Nuh)", "1 - 28"));
        objSurah.add(new Surah("Al-Jinn (the Jinn)", "1 - 28"));
        objSurah.add(new Surah("Al-Muzammil (the Wrapped)", "1 - 20"));
        objSurah.add(new Surah("Al-Mudaththir (the Cloaked)", "1 - 56"));
        objSurah.add(new Surah("Al-Qiyamah (the Resurrection)", "1 - 40"));
        objSurah.add(new Surah("Al-Insan (the Human)", "1 - 31"));
        objSurah.add(new Surah("Al-Mursalat (Those Sent Forth)", "1 - 50"));
        objSurah.add(new Surah("An-Naba’ (the Great News)", "1 - 40"));
        objSurah.add(new Surah("An-Nazi’at (Those Who Pull Out)", "1 - 46"));
        objSurah.add(new Surah(" ‘Abasa (He Frowned)", "1 - 42"));
        objSurah.add(new Surah("At-Takwir (the Overthrowing)", "1 - 29"));
        objSurah.add(new Surah("Al-Infitar (the Cleaving)", "1 - 19"));
        objSurah.add(new Surah("Al-Mutaffifin (Those Who Deal in Fraud)", "1 - 36"));
        objSurah.add(new Surah("Al-Inshiqaq (the Splitting Asunder)", "1 - 25"));
        objSurah.add(new Surah("Al-Buruj (the Stars)", "1 - 22"));
        objSurah.add(new Surah("At-Tariq (the Nightcomer)", "1 - 17"));
        objSurah.add(new Surah("Al-A’la (the Most High)", "1 - 19"));
        objSurah.add(new Surah("Al-Ghashiyah (the Overwhelming)", "1 - 26"));
        objSurah.add(new Surah("Al-Fajr (the Dawn)", "1 - 30"));
        objSurah.add(new Surah("Al-Balad (the City)", "1 - 20"));
        objSurah.add(new Surah("Ash-Shams (the Sun)", "1 - 15"));
        objSurah.add(new Surah("Al-Layl (the Night)", "1 - 21"));
        objSurah.add(new Surah("Adh-Dhuha (the Forenoon)", "1 - 11"));
        objSurah.add(new Surah("Al-Inshirah (the Opening Forth)", "1 - 8"));
        objSurah.add(new Surah("At-Tin (the Fig)", "1 - 8"));
        objSurah.add(new Surah("Al-‘Alaq (the Clot)", "1 - 19"));
        objSurah.add(new Surah("Al-Qadar (the Night of Decree)", "1 - 5"));
        objSurah.add(new Surah("Al-Bayinah (the Proof)", "1 - 8"));
        objSurah.add(new Surah("Az-Zalzalah (the Earthquake)", "1 - 8"));
        objSurah.add(new Surah("Al-‘Adiyah (the Runners)", "1 - 11"));
        objSurah.add(new Surah("Al-Qari’ah (the Striking Hour)", "1 - 11"));
        objSurah.add(new Surah("Al-Qari’ah (the Striking Hour)", "1 - 8"));
        objSurah.add(new Surah("Al-‘Asr (the Time)", "1 - 3"));
        objSurah.add(new Surah("Al-Humazah (the Slanderer)", "1 - 9"));
        objSurah.add(new Surah("Al-Fil (the Elephant)", "1 - 5"));
        objSurah.add(new Surah("Quraish (Quraish)", "1 - 4"));
        objSurah.add(new Surah("Al-Ma’un (the Assistance)", "1 - 7"));
        objSurah.add(new Surah("Al-Kauthar (the River of Abundance)", "1 - 3"));
        objSurah.add(new Surah("Al-Kafirun (the Disbelievers)", "1 - 6"));
        objSurah.add(new Surah("An-Nasr (the Help)", "1 - 3"));
        objSurah.add(new Surah("Al-Masad (the Palm Fiber)", "1 - 5"));
        objSurah.add(new Surah("Al-Ikhlas (the Sincerity)", "1 - 4"));
        objSurah.add(new Surah("Al-Falaq (the Daybreak)", "1 - 5"));
        objSurah.add(new Surah("An-Nas (Mankind)", "1 - 6"));


        adapterAlquran = new AdapterAlquran(objSurah);
        recyclerView.setAdapter(adapterAlquran);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchView1 = view.findViewById(R.id.search);
        searchView1.clearFocus();
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SeachSurah(newText);
                return false;
            }
        });
        return view;
    }
    private void SeachSurah(String Text) {
        ArrayList<Surah> seachlist = new ArrayList<>();
        for (Surah item : objSurah){
            if(item.getSurah().toLowerCase().contains(Text.toLowerCase())){
                seachlist.add(item);
            }
        }
        if (seachlist.isEmpty()){
            Toast.makeText(getActivity(),"Surah tidak ada",Toast.LENGTH_SHORT).show();
        }else {
            adapterAlquran.filterlist(seachlist);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
}
