package android.rgu.dtrack.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "readings")
public class Readings {
    @PrimaryKey(autoGenerate = true)
    private int id; // default value
    private String test_title;
    private long readingDate;
    private String readingText;
    private String test_note;



    private boolean checked = false;

    public Readings(String this_is_a_demo_output, long time) {
    }

    public Readings(String test_title, long readingDate, String readingText, String test_note) {
        this.test_title = test_title;
        this.readingDate = readingDate;
        this.readingText = readingText;
        this.test_note = test_note;

    }

    public String getReadingTex() {
        return readingText;
    }

    public void setReadingText(String readingText) {
        this.readingText = readingText;
    }

    public long getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(long readingDate) {
        this.readingDate = readingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Readings{" +
                "id=" + id +
                ", readingDate=" + readingDate +
                '}';
    }

    public String getReadingText() {
        return readingText;
    }
}

