package android.rgu.dtrack.adapters;

import android.content.Context;
import android.rgu.dtrack.R;
import android.rgu.dtrack.model.Readings;
import android.rgu.dtrack.utils.ReadingUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// create an adapter for the recycler view
public class ReadingsAdapter extends RecyclerView.Adapter<ReadingsAdapter.ReadingHolder> {
    private Context context;
    private ArrayList<Readings> readings;

    @NonNull
    @Override
    public ReadingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.readings_layout, parent, false);
        return new ReadingHolder(v);
    }

    @Override
    public void onBindViewHolder(ReadingHolder holder, int position) {
        final Readings readings = getReading(position);
        if (readings != null) {
            holder.readingText.setText(readings.getReadingText());
            holder.readingDate.setText(ReadingUtils.dateFromLong(readings.getReadingDate()));

        }
    }

    @Override
    public int getItemCount() {
        return readings.size();
    }

    private Readings getReading(int position) {
        return readings.get(position);
    }

     // get checked reading and return array
    public List<Readings> getCheckedReadings() {
        List<Readings> checkedReadings = new ArrayList<>();
        for (Readings n : this.readings) {
            if (n.isChecked())
                checkedReadings.add(n);
        }

        return checkedReadings;
    }


    class ReadingHolder extends RecyclerView.ViewHolder {
        TextView test_title, readingDate, readingText, test_note;
        CheckBox checkBox;

        public ReadingHolder(View itemView) {
            super(itemView);
            test_title = itemView.findViewById(R.id.test_title);
            readingDate = itemView.findViewById(R.id.reading_date);
            readingText = itemView.findViewById(R.id.reading_text);
            test_note = itemView.findViewById(R.id.test_note);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }

}

