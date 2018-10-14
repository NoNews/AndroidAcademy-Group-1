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

    private final static String EXTRA_PERSON = "EXTRA_PERSON";

    private TextView firstName;
    private TextView secondName;
    private TextView info;
    private ImageView image;

    public static void start(@NonNull Context context, @NonNull PersonItem person) {
        Intent starter = new Intent(context, PersonDetailActivity.class);
        starter.putExtra(EXTRA_PERSON, person);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        firstName = findViewById(R.id.detail_firstName);
        secondName = findViewById(R.id.detail_secondName);
        info = findViewById(R.id.detail_info);
        image = findViewById(R.id.detail_imagess);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            PersonItem person = (PersonItem) bundle.getSerializable(EXTRA_PERSON);
            firstName.setText(person.getName());
            secondName.setText(person.getSecondName());
            info.setText(person.getInfo());
            Glide.with(this).load(person.getImageUrl()).into(image);
        }
    }
}
