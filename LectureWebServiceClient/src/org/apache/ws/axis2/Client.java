package org.apache.ws.axis2;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.LectureManagerStub.*;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Client is the class for RMI client. The user will be able to input commands in the console.<br>
 * Valid commands are: help, add, time, lecture, quit.
 * <p>
 * 'help' shows the list of available commands.<br>
 * 'add' allows the client to input lectures.<br>
 * 'time' shows the free time the student has on each day.<br>
 * 'lecture' shows all the already input lectures.<br>
 * 'quit' closes the socket, as well as the server.<br>
 * </p>
 *
 * @author M Chi Nguyen, 1206243
 * @version 27.05.2017
 */
public class Client {

	private LectureManagerStub lectureManagerStub;

	public Client () {
		try {
			lectureManagerStub = new LectureManagerStub();
		} catch (AxisFault e) {}
	}

	/**
	 * Main method, used to start the client
	 * @param args String array of main method
	 */
	public static void main(String[] args) throws Exception {
		Client client = new Client();
		AddLecture addLecture = new AddLecture();
		Lecture lecture = new Lecture();
		lecture.setId("10");
		lecture.setTitle("a");
		lecture.setWeekDay("b");
		lecture.setTime("c");
		addLecture.setInput(lecture);
		client.lectureManagerStub.addLecture(addLecture);
							/*
							GetAllLecturesResponse getAllLecturesResponse = new GetAllLecturesResponse();
							Lecture[] allLectures = getAllLecturesResponse.get_return();
							for (int i = 0; i < allLectures.length; i++) {
								out.println(allLectures[i]);
							}
							*/
		GetLecture getLecture = new GetLecture();
		getLecture.setId("10");
		GetLectureResponse test = client.lectureManagerStub.getLecture(getLecture);
		Lecture testLecture = test.get_return();
		out.println(testLecture.toString());
		//client.initialize();
	}

	/**
	 * This method starts the client, enabling the user to input in the console.
	 * Depending which command user inputs, the method will call other methods.<br>
	 * Commands are non-case sensitive.
	 * @throws Exception
	 */
	public void initialize() throws Exception {
		try {
			out.println("Connected to server");
			while (true) {
				out.println("What would you like to do? type 'help' for list of commands");
				Scanner scanner = new Scanner(System.in);
				String data = scanner.nextLine();
				if (data.equalsIgnoreCase("quit")) {
					break;
				} else if (data.equalsIgnoreCase("help")) {
					out.println("add     \t to add more lectures in your time table");
					out.println("get     \t to show your lectures you've input");
					out.println("update  \t to update a lecture's information");
					out.println("delete  \t to delete a lecture");
					out.println("time    \t to show all your free time in your weekdays");
					out.println("quit    \t to quit the program");
				} else if (data.equalsIgnoreCase("add")) {
					out.println("Input format: 'ID Title Weekday HourStart:MinStart' E.G: '01 Math monday 8:00'");
					add();
				} else if (data.equalsIgnoreCase("get")) {
					getLectures();
				} else if (data.equalsIgnoreCase("update")) {
					updateLecture();
				} else if (data.equalsIgnoreCase("delete")) {
					deleteLecture();
				} else if (data.equalsIgnoreCase("time")) {
					getTime();
				} else {
					out.println("Command not recognized.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println("Server successfully shut down.");
	}

	/**
	 * The method is called when the user inputs 'add'. User can then add new lectures with the format
	 * 'ID Title Weekday TimeStart(HH:mm)'. <br> Weekday is non-case sensitive.<br> TimeStart has to be between 8:00 and 17:00.
	 * <br> If the input are all valid, lecture will be added and send to the server through IRemoteLecture.addLecture()
	 * @throws Exception
	 */
	public void add() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (!input.equalsIgnoreCase("stop")) {
			String[] split = input.split("\\s+");
			if (split.length == 4) {
				if (split[2].equalsIgnoreCase("monday") || (split[2].equalsIgnoreCase("tuesday"))
						|| (split[2].equalsIgnoreCase("wednesday")) || (split[2].equalsIgnoreCase("thursday"))
						|| (split[2].equalsIgnoreCase("friday"))) {
					try {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
						LocalTime time = LocalTime.parse(split[3], formatter);
						LocalTime minTime = LocalTime.parse("7:59", formatter);
						LocalTime maxTime = LocalTime.parse("17:01", formatter);
						if (time.isAfter(minTime) && time.isBefore(maxTime)) {
							String timeString = time.toString();
							out.println(timeString);
							AddLecture addLecture = new AddLecture();
							Lecture lecture = new Lecture();
							lecture.setId(split[0]);
							lecture.setTitle(split[1]);
							lecture.setWeekDay(split[2]);
							lecture.setTime(timeString);
							addLecture.setInput(lecture);
							lectureManagerStub.addLecture(addLecture);
							/*
							GetAllLecturesResponse getAllLecturesResponse = new GetAllLecturesResponse();
							Lecture[] allLectures = getAllLecturesResponse.get_return();
							for (int i = 0; i < allLectures.length; i++) {
								out.println(allLectures[i]);
							}
							*/
							GetLecture getLecture = new GetLecture();
							getLecture.setId("10");
							GetLectureResponse test = lectureManagerStub.getLecture(getLecture);
							Lecture testLecture = test.get_return();
							out.println(testLecture.toString());
							add();

							/*
							if (check == 0) {
								AddLectureResponse addLectureResponse = new AddLectureResponse();
								if (addLectureResponse.get_return()) {
									addLecture.setLecture(lecture);
									lectureManagerStub.addLecture(addLecture);
									out.println("Lecture added! Continue adding lecture, 'stop' to stop adding.");
								} else {
									out.println("ID not unique. Lecture not added! Continue adding lecture, 'stop' to stop adding.");
								}
								add();
							} else if (check == 1) {
								out.println("Lecture not added! Continue adding lecture, 'stop' to stop adding.");
								add();
							} else {
								out.println("Lecture replaced. Continue adding lecture, 'stop' to stop adding.");
								add();
							}
							*/
						} else error();
					} catch (DateTimeParseException e) { error(); }
				} else error();
			} else error();
		}
	}

	/**
	 * Sub-method of addLecture(), called when there's an error. It prints in the console an error message and then
	 * tries to repeat the addLecture() for the user to input again.
	 * @throws Exception
	 */
	public void error() throws Exception {
		out.println("Invalid input! Continue adding lecture, 'stop' to stop adding.");
		add();
	}

	/**

	 */
	/**
	 * The method is called when the user inputs 'lecture'. The method sends a request to the server, in return
	 * the server replies with all lectures that were previously input by the user (even from previous sessions).
	 *
	 * @throws Exception
	 */
	public void getLectures() throws Exception{

	}

	public void updateLecture() {

	}

	public void deleteLecture() {

	}

	/**
	 * The method is called when the user inputs 'time'. The method sends a request to the server, in return
	 * the server replies with the free time on each day printed in the client's console.
	 *
	 * @throws Exception
	 */
	public void getTime() throws Exception {

	}



}
