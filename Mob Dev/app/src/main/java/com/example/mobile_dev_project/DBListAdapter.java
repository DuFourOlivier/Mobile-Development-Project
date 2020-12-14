package com.example.mobile_dev_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DBListAdapter extends RecyclerView.Adapter<DBListAdapter.WordViewHolder>{

    public final static String EXTRA_MSG = "com.example.android.mobile_deb_project.extra.MESSAGE";
    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cached copy of words

     public DBListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }
    public Word getWordAtPosition(int position)
    {
        return mWords.get(position);
    }

    public void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView wordItemView;
        final DBListAdapter mAdapter;

        private WordViewHolder(View itemView,DBListAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;
            wordItemView = itemView.findViewById(R.id.textView);
            wordItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.
            //String element = mWordList.get(mPosition);
            String element = mWords.get(mPosition).toString();
// Change the word in the mWordList.
            Intent intent = new Intent(v.getContext(),InfoPage.class);
            intent.putExtra(EXTRA_MSG,mPosition);
            v.getContext().startActivity(intent);

// Notify the adapter, that the data has changed so it can
// update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();

        }
    }
}

