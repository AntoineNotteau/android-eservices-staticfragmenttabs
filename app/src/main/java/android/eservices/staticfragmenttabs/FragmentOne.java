package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment {

    private View view;
    private Counter counter;
    public static final String TAB_NAME = "ADD TO COUNTER";

    public FragmentOne() {

    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setupButton();
    }

    public void setupButton() {
        Button button = view.findViewById(R.id.button_increment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter != null) counter.increment();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Counter) {
            this.counter = (Counter) context;
        }
    }
}
