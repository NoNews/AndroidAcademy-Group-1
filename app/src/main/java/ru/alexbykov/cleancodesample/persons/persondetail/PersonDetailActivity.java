package ru.alexbykov.cleancodesample.persons.persondetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ru.alexbykov.cleancodesample.R;
import ru.alexbykov.cleancodesample.persons.personlist.PersonItem;

public class PersonDetailActivity extends AppCompatActivity {


    private static final int LAYOUT = R.layout.activity_person_detail;

    private final static String EXTRA_PERSON = "EXTRA_PERSON";

    private TextView tvFirstName;
    private TextView tvSecondName;
    private TextView tvInfo;
    private ImageView ivPhoto;

    public static void start(@NonNull Context context, @NonNull PersonItem person) {
        Intent starter = new Intent(context, PersonDetailActivity.class);
        starter.putExtra(EXTRA_PERSON, person);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        findViews();
        setupData();
    }

    private void setupData() {
        final Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        PersonItem person = (PersonItem) bundle.getSerializable(EXTRA_PERSON);
        if (person == null) {
            return;
        }

        tvFirstName.setText(person.getName());
        tvSecondName.setText(person.getSecondName());
        tvInfo.setText(person.getInfo());
        Glide.with(this).load(person.getImageUrl()).into(ivPhoto);
    }

    private void findViews() {
        tvFirstName = findViewById(R.id.tv_first_name);
        tvSecondName = findViewById(R.id.tv_second_name);
        tvInfo = findViewById(R.id.tv_info);
        ivPhoto = findViewById(R.id.iv_photo);
    }
}
