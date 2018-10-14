package ru.alexbykov.cleancodesample.persons.personlist.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import ru.alexbykov.cleancodesample.persons.personlist.PersonItem;

public class PersonListAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private OnPersonClickListener personClickListener;

    private List<PersonItem> items = new ArrayList<>();

    public void addPersons(List<PersonItem> persons) {
        items.addAll(persons);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return PersonViewHolder.create(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
        final PersonItem personItem = items.get(i);
        personViewHolder.bind(personItem, personClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setPersonClickListener(OnPersonClickListener personClickListener) {
        this.personClickListener = personClickListener;
    }

    public void removePersonClickListener() {
        this.personClickListener = null;
    }

    public interface OnPersonClickListener {
        void onPersonClick(PersonItem person);
    }
}
