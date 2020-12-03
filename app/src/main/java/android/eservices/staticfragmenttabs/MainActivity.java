package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity implements Counter {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private int currentCounter;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {

        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        //TODO set adapter to viewpager and handle tragment change inside
        //viewpager.setAdapter(...);

        //TabLayoutMediator tabLayoutMediator...

        viewPager = findViewById(R.id.tab_viewpager);
        counterTextView = findViewById(R.id.counter_textview);
        tabLayout = findViewById(R.id.tablayout);

        counterTextView.setText(getString(R.string.counter_text, currentCounter));

        final FragmentOne fragmentOne = FragmentOne.newInstance();
        final FragmentTwo fragmentTwo = FragmentTwo.newInstance();

        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if(position == 0) return fragmentOne;
                return fragmentTwo;
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0)
                    tab.setText(FragmentOne.TAB_NAME);
                else
                    tab.setText(FragmentTwo.TAB_NAME);
            }
        });
        tabLayoutMediator.attach();
    }

    @Override
    public void increment() {
        currentCounter++;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }

    @Override
    public void decrement() {
        currentCounter--;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }
}
