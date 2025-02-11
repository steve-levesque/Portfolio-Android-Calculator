
package com.example.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.example.calculator.models.CalculatorItem;
import com.example.calculator.utilities.PdfUtility;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.calculator.utilities.DataUtility;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {
    Button buttonClearList, buttonSaveListPDF;
    ProgressBar spinner;
    Handler handler;
    FloatingActionButton fab;
    Toolbar toolbar;
    int clickSpinnerDelay = 250;
    private boolean mTwoPane;
    private static View recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();
        setContentView(R.layout.activity_item_list);

        spinner = (ProgressBar) findViewById(R.id.progressSpinner);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        buttonClearList = (Button) findViewById(R.id.buttonClearList);
        buttonSaveListPDF = (Button) findViewById(R.id.buttonSaveListPDF);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        recyclerView = findViewById(R.id.item_list);
        assert getRecyclerView() != null;
        setupRecyclerView((RecyclerView) getRecyclerView());

        // The detail container view will be present only in the (res/values-w900dp).
        // If this view is present, then the activity should be in two-pane mode.
        if (findViewById(R.id.item_detail_container) != null) mTwoPane = true;

        // Float button used to open the calculator interface.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Removes all items from the list with DataUtility and RecyclerView adapter notify.
        buttonClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                spinner.setVisibility(View.VISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recView = ((RecyclerView) getRecyclerView());
                        int itemCount = recView.getAdapter().getItemCount();
                        DataUtility.removeItems();
                        Snackbar.make(view, "Items deleted: "+itemCount+".", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        recView.getAdapter().notifyDataSetChanged();
                        spinner.setVisibility(View.GONE);
                    }
                }, clickSpinnerDelay);

            }
        });

        // Saves the data with the PdfUtility.
        buttonSaveListPDF.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(final View view) {
                spinner.setVisibility(View.VISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String path = PdfUtility.printPDF(DataUtility.ITEMS);
                        Snackbar.make(view, "PDF created at "+ path +".", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        spinner.setVisibility(View.GONE);
                    }
                }, clickSpinnerDelay);
            }
        });
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, DataUtility.ITEMS, mTwoPane));
    }

    public static View getRecyclerView() {
        return recyclerView;
    }

    public static class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
        private final ItemListActivity mParentActivity;
        private final List<CalculatorItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculatorItem item = (CalculatorItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent, List<CalculatorItem> items, boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
