package ru.alexbykov.cleancodesample.persons.personlist;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import ru.alexbykov.cleancodesample.R;
import ru.alexbykov.cleancodesample.persons.PersonDataUtil;
import ru.alexbykov.cleancodesample.persons.persondetail.PersonDetailActivity;
import ru.alexbykov.cleancodesample.persons.personlist.adapter.PersonListAdapter;

public class PersonListActivity extends AppCompatActivity implements PersonListAdapter.OnPersonClickListener {

    private static final int LAYOUT = R.layout.activity_main;

    private PersonListAdapter personsListAdapter;
    private RecyclerView rvPersons;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        setupUi();
        loadPersons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupUx();
    }

    @Override
    protected void onPause() {
        unbindUx();
        super.onPause();
    }

    private void setupUi() {
        findViews();
        setupPersonsRecyclerView();
    }

    private void setupUx() {
        personsListAdapter.setPersonClickListener(this);
    }

    private void unbindUx() {
        personsListAdapter.removePersonClickListener();
    }

    @Override
    public void onPersonClick(PersonItem person) {
        PersonDetailActivity.start(this, person);
    }

    private void loadPersons() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(this::showPersons, 2000);
    }

    private void showPersons() {
        personsListAdapter.addPersons(PersonDataUtil.getPersons());
        progressBar.setVisibility(View.GONE);
        rvPersons.setVisibility(View.VISIBLE);
    }

    private void setupPersonsRecyclerView() {
        personsListAdapter = new PersonListAdapter();
        rvPersons.setLayoutManager(new LinearLayoutManager(this));
    }

    private void findViews() {
        rvPersons = findViewById(R.id.rv_persons);
        progressBar = findViewById(R.id.progressbar);
    }

}
