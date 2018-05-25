import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements the interface IRemoteLecture will functional methods.
 *
 * @author M Chi Nguyen, 1206243
 * @version 27.05.2017
 */
public class LectureManager {
    ArrayList<Lecture> lecture = new ArrayList<>();
    String[] free = new String[5];

    /**
     * This method is called when the user input 'add'. A lecture will be added to the ArrayList.
     * @param input the to be added lecture
     */
    public boolean addLecture(Lecture input) {
    	System.out.println("ABC");
        lecture.add(input);
        return true;
    }

    /**
     * This method is called when the user input 'lecture'.
     * @return return all lectures that were added.
     */
    public Lecture[] getAllLectures() {
    	Lecture[] outputLectures = new Lecture[lecture.size()];
    	for (int i = 0; i < lecture.size(); i++) {
    		outputLectures[i] = lecture.get(i);
    	}
    	return outputLectures;
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public Lecture getLecture(String id) {
    	for (int i = 0; i < lecture.size(); i++) {
    		if (lecture.get(i).getId() == id)
                return lecture.get(i);
    	}
    	return null;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean deleteLecture(String id) {
    	for (int i = 0; i < lecture.size(); i++) {
    		if (lecture.get(i).getId() == id) {
                lecture.remove(i);
                return true;
            }
    	}
    	return false;
    }
    
    /**
     * 
     * @param input lecture with new values
     * @return the successfully updated lecture
     */
    public Lecture updateLecture(Lecture input) {
    	for (int i = 0; i < lecture.size(); i++) {
    		if (lecture.get(i).getId() == input.getId()) {
    			lecture.get(i).setTitle(input.getTitle());
    			lecture.get(i).setTime(input.getTime());
    			lecture.get(i).setWeekDay(input.getWeekDay());
    			return lecture.get(i);
    		}
    	}
    	return null;
    }
    /**
     * This method is called when the user input 'time'.
     * @return return free time of the user in a String array.
     */
    public String[] getFreeTime() {
        for (int i = 0; i < free.length; i++) {
            free[i] = "10";
        }
        for (int i = 0; i < lecture.size(); i++) {
            String weekDay = lecture.get(i).getWeekDay();
            if (weekDay.equalsIgnoreCase("monday")) {
                free[0] = Integer.toString(Integer.parseInt(free[0]) - 1);
            } else if (weekDay.equalsIgnoreCase("tuesday")) {
                free[1] = Integer.toString(Integer.parseInt(free[1]) - 1);
            } else if (weekDay.equalsIgnoreCase("wednesday")) {
                free[2] = Integer.toString(Integer.parseInt(free[2]) - 1);
            } else if (weekDay.equalsIgnoreCase("thursday")) {
                free[3] = Integer.toString(Integer.parseInt(free[3]) - 1);
            } else if (weekDay.equalsIgnoreCase("friday")) {
                free[4] = Integer.toString(Integer.parseInt(free[4]) - 1);
            }
        }
        return free;
    }

    /**
     * This method is called when the client input 'quit'. It will save all the lectures into lectures.txt and then shutdown the server.
     */
    public void quit() {
        try {
            OutputStream outputStream2 = new FileOutputStream("lectures.txt");
            PrintStream printStream2 = new PrintStream(outputStream2);
            for (int i = 0; i < lecture.size(); i++) {
                String id = lecture.get(i).getId();
                String title = lecture.get(i).getTitle();
                String weekDay = lecture.get(i).getWeekDay();
                String time = lecture.get(i).getTime().toString();
                printStream2.println(id + " " + title + " " + weekDay + " " + time);
            }
        } catch (Exception e) {}
    }

    /**
     * This method is called when the server is starting. It will read the lectures.txt and add lectures into the ArrayList.
     */
    public void init() {
        try {
            File file = new File("lectures.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {}
    }
}
