package ru.alexbykov.cleancodesample.persons.personlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ru.alexbykov.cleancodesample.R;
import ru.alexbykov.cleancodesample.persons.personlist.PersonItem;

public class PersonViewHolder extends RecyclerView.ViewHolder{

    private static final int LAYOUT = R.layout.item_person;

    private TextView firstName;
    private TextView secondName;
    private ImageView image;
    private Context context;
    private View view;

    private PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews();
    }

    public void bind(final PersonItem person, @Nullable PersonListAdapter.OnPersonClickListener listener) {
        setupUi(person);
        setupUx(person, listener);
    }

    private void setupUx(@NonNull PersonItem person, @Nullable PersonListAdapter.OnPersonClickListener listener) {
        if(listener == null){
            return;
        }

        view.setOnClickListener(v -> onClickPerson(person,listener));
    }

    private void setupUi(PersonItem person){
        firstName.setText(person.getName());
        secondName.setText(person.getSecondName());
        Glide.with(context).load(person.getImageUrl()).into(image);
    }

    private void onClickPerson(@NonNull PersonItem person, @NonNull PersonListAdapter.OnPersonClickListener listener) {
        listener.onPersonClick(person);
    }

    public static PersonViewHolder create(ViewGroup viewGroup){
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(LAYOUT, viewGroup, false);
        return new PersonViewHolder(view);
    }

    private void findViews() {
        firstName = itemView.findViewById(R.id.personFirstName);
        secondName = itemView.findViewById(R.id.personSecondName);
        image = itemView.findViewById(R.id.personImage);
        view = itemView;
        context = itemView.getContext();
    }
}
