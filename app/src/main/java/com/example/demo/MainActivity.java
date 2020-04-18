package com.example.demo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ChatsFragment chatsFragment;
    private StatusFragment statusFragment;
    private CallsFragment callsFragment;
    private ProfileFragment profileFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        viewPager=findViewById( R.id.view_pager );
        tabLayout=findViewById( R.id.tab_layout );
        toolbar=findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        chatsFragment=new ChatsFragment();
        callsFragment=new CallsFragment();
        statusFragment=new StatusFragment();
        profileFragment=new ProfileFragment();
        homeFragment=new HomeFragment();

        tabLayout.setupWithViewPager( viewPager );

        ViewPagerAdapter viewpageradapter=new ViewPagerAdapter(getSupportFragmentManager(),0);

        viewpageradapter.addFragment( homeFragment,"Home" );
        viewpageradapter.addFragment( chatsFragment,"Chats" );
        viewpageradapter.addFragment( statusFragment,"Status" );
        viewpageradapter.addFragment( callsFragment,"Calls" );
        viewpageradapter.addFragment( profileFragment,"Profile" );

        viewPager.setAdapter( viewpageradapter );
        tabLayout.getTabAt( 0 ).setIcon( R.drawable.ic_home_home_24dp );
        tabLayout.getTabAt( 1 ).setIcon( R.drawable.ic_people_chatk_24dp );
        tabLayout.getTabAt( 2 ).setIcon( R.drawable.ic_rowing_status_24dp );
        tabLayout.getTabAt( 3 ).setIcon( R.drawable.ic_call_call_24dp );
        tabLayout.getTabAt( 4 ).setIcon( R.drawable.ic_mood_profile_24dp );

        BadgeDrawable badgeDrawable=tabLayout.getTabAt( 1).getOrCreateBadge();
        badgeDrawable.setVisible( true );
        badgeDrawable.setNumber( 12 );

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter  {

        private List<Fragment> fragments=new ArrayList<>(  );
        private List<String> fragmentTitle=new ArrayList<>(  );

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super( fm, behavior );
        }

      public void addFragment(Fragment fragment,String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
      }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get( position );
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get( position );
        }
    }
}
