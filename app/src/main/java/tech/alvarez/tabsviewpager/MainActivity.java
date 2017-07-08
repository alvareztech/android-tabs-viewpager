package tech.alvarez.tabsviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import tech.alvarez.tabsviewpager.fragments.CameraFragment;
import tech.alvarez.tabsviewpager.fragments.FavoritesFragment;
import tech.alvarez.tabsviewpager.fragments.HomeFragment;
import tech.alvarez.tabsviewpager.fragments.ProfileFragment;
import tech.alvarez.tabsviewpager.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    Fragment homeFragment;
    Fragment searchFragment;
    Fragment cameraFragment;
    Fragment favoritesFragment;
    Fragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        cameraFragment = new CameraFragment();
        favoritesFragment = new FavoritesFragment();
        profileFragment = new ProfileFragment();

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return homeFragment;
            } else if (position == 1) {
                return searchFragment;
            } else if (position == 2) {
                return cameraFragment;
            } else if (position == 3) {
                return favoritesFragment;
            } else if (position == 4) {
                return profileFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
