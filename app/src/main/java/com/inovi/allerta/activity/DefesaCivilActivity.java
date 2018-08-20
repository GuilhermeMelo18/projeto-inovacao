package com.inovi.allerta.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.inovi.allerta.R;
import com.inovi.allerta.fragmentos.GraficoFragment;
import com.inovi.allerta.fragmentos.ListaAlertaFragment;
import com.inovi.allerta.fragmentos.PostFragment;
import com.inovi.allerta.fragmentos.VisualizarPublicacaoFragment;

public class DefesaCivilActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defesa_civil);
        this.setTitle(R.string.titulo_defesa_civil);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabsDefesaCivil);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new ListaAlertaFragment();
                case 1:
                    return new GraficoFragment();
                case 2:
                    return new VisualizarPublicacaoFragment();
            }
            return null;
        }

        //@Override
        public int getCount() {
            return 3;
        }
    }

}
