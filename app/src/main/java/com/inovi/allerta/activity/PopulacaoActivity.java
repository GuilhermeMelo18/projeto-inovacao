package com.inovi.allerta.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inovi.allerta.R;
import com.inovi.allerta.fragmentos.ConfiguracoesFragment;
import com.inovi.allerta.fragmentos.GraficoFragment;
import com.inovi.allerta.fragmentos.PostFragment;
import com.inovi.allerta.fragmentos.PublicacaoFragment;
import com.inovi.allerta.fragmentos.VisualizarPublicacaoFragment;

public class PopulacaoActivity extends AppCompatActivity {
    private PopulacaoActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populacao);
        this.setTitle(R.string.titulo_meu_allerta);

        mSectionsPagerAdapter = new PopulacaoActivity.SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabsPopulacao);

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
                    return new PublicacaoFragment();
                case 1:
                    return new VisualizarPublicacaoFragment();
                case 2:
                    return new ConfiguracoesFragment();
            }
            return null;
        }

        //@Override
        public int getCount() {
            return 3;
        }
    }

}
