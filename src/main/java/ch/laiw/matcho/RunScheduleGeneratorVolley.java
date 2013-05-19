package ch.laiw.matcho;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;
import ch.laiw.matcho.domain.SingleParticipant;
import ch.laiw.matcho.verification.ScheduleVerifier;

public class RunScheduleGeneratorVolley {

	private static ScheduleVerifier scheduleVerifier;
	private static ScheduleGenerationAlgorithm scheduleGenerator;

	public static void main(String[] args) throws InvalidScheduleInputException {
		// initialize
		scheduleVerifier = new ScheduleVerifier();
		scheduleGenerator = new PriorityBacktrackScheduleGenerator();

		// get participants
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(new SingleParticipant("VZH 2"));
		participantList.add(new SingleParticipant("Hnkn 1"));
		participantList.add(new SingleParticipant("NGU"));
		participantList.add(new SingleParticipant("KrPf"));
		participantList.add(new SingleParticipant("WnVt 2"));
		participantList.add(new SingleParticipant("Umxd"));
		participantList.add(new SingleParticipant("VSchw"));
		participantList.add(new SingleParticipant("VZH 1"));
		participantList.add(new SingleParticipant("Inter"));
		participantList.add(new SingleParticipant("Hnkn 2"));
		participantList.add(new SingleParticipant("Vnsprt"));
		participantList.add(new SingleParticipant("TshDlk"));
		participantList.add(new SingleParticipant("Frvt"));
		participantList.add(new SingleParticipant("Esper"));
		participantList.add(new SingleParticipant("VZH 3"));
		participantList.add(new SingleParticipant("Wnvt 1"));
		participantList.add(new SingleParticipant("IsBern"));
		participantList.add(new SingleParticipant("dblwhppr"));
		participantList.add(new SingleParticipant("DLn"));
		participantList.add(new SingleParticipant("thnmlss"));
		participantList.add(new SingleParticipant("Huda"));

		// get groups
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(new Group("G1"));
		groupList.add(new Group("G2"));
		groupList.add(new Group("G3"));
		
		
		// get fields
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Field 1"));
		fieldList.add(new Field("Field 2"));
		fieldList.add(new Field("Field 3"));

		// get dates
		Calendar calendar = Calendar.getInstance();
		ArrayList<Date> dateList = new ArrayList<Date>();
		calendar.set(2012, 4, 28, 9, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 15, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 30, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 45, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 15, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 30, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 45, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 15, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 30, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 45, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 12, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 12, 15, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 12, 30, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 12, 45, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 13, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 13, 15, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 13, 30, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 13, 45, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 14, 0, 0);
		dateList.add(calendar.getTime());
		
		// get schedule
		Schedule resultSchedule = scheduleGenerator.generateSchedule(participantList, groupList, true, fieldList, dateList, scheduleVerifier);

		System.out.println(resultSchedule);

		// createXLSX("test");
	}

	private static void createXLSX(String fileName) throws IOException {
		Workbook wb = new XSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream(fileName + ".xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

}
