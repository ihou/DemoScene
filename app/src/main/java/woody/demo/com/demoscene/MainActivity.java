package woody.demo.com.demoscene;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity {

    private TransitionManager transitionManager;
    private Scene mScene1;
    private Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        transitionManager = new TransitionManager();

        TransitionInflater inflater = TransitionInflater.from(this);
        Transition transition = inflater.inflateTransition(R.transition.my_transition);

        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.container);
        mScene1 = Scene.getSceneForLayout(sceneRoot, R.layout.fragment_scene1, this);
        mScene2 = Scene.getSceneForLayout(sceneRoot, R.layout.fragment_scene2, this);

        transitionManager.setTransition(mScene1,transition);
        transitionManager.setTransition(mScene2,transition);
    }

    public void goScene1(View view) {
        transitionManager.transitionTo(mScene1);
    }

    public void goScene2(View view) {
        transitionManager.transitionTo(mScene2);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_scene1, container, false);
            return rootView;
        }

    }
}
