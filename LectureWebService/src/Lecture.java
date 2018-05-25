import java.time.LocalTime;

/**
 *
 * @author M Chi Nguyen, 1206243
 * @version 27.05.2017
 */
public class Lecture{
    private String id;
    private String title;
    private String weekDay;
    private String time;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * toString() method
     * @return output the lecture in this following format:
     * <p>ID: id <br>Title: <br>Weekday: <br>Time start:</p>
     */
    public String toString() {
        String output = "ID:         " + this.id;
        output +=     "\nTitle:      " + this.title;
        output +=     "\nWeek day:   " + this.weekDay;
        output +=     "\nTime start: " + this.time.toString() + "\n";
        return output;
    }
}
