package ch.laiw.matcho;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ch.laiw.matcho.InvalidScheduleInputException;
import ch.laiw.matcho.PriorityBacktrackScheduleGenerator;
import ch.laiw.matcho.ScheduleGenerationAlgorithm;
import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;
import ch.laiw.matcho.domain.SingleParticipant;
import ch.laiw.matcho.verification.ScheduleVerifier;


public class TestMatchGeneration {
	private static ScheduleVerifier scheduleVerifier;
	private static ScheduleGenerationAlgorithm scheduleGenerator;
	
	// Groups
	private static Group groupWomensA;
	private static Group groupMensA;
	private static Group groupMensB;
	private static Group groupMensC;
	private static Group groupMensD;
	private static Group groupDoublesA;
	private static Group groupDoublesB;
	private static Group groupDoublesC;
	private static Group groupDoublesD;
	
	// Doubles
	private static Participant amybinh;
	private static Participant angrybirds;
	private static Participant bananaaa;
	private static Participant bivi;
	private static Participant boigirl;
	private static Participant bunnypony;
	private static Participant echondiezwedetane;
	private static Participant huongteak;
	private static Participant ichaffdutiger;
	private static Participant just4fun;
	private static Participant kk;
	private static Participant kudasi;
	private static Participant lejong;
	private static Participant mathutien;
	private static Participant mynhien;
	private static Participant neighbours;
	private static Participant overtherainbow;
	private static Participant puccagaru;
	private static Participant stangeli;
	private static Participant xuetituan;
	private static Participant fischol;
	private static Participant teamlili;
	private static Participant theraqueteers;
	private static Participant vyjan;
	
	// Mens
	private static Participant annhien;
	private static Participant binhlai;
	private static Participant binhlam;
	private static Participant dat;
	private static Participant ductuan;
	private static Participant khanh;
	private static Participant liem;
	private static Participant mathu;
	private static Participant minh;
	private static Participant nghi;
	private static Participant nguyen;
	private static Participant phong;
	private static Participant quocthinh;
	private static Participant si;
	private static Participant stefan;
	private static Participant thien;
	private static Participant thomas;
	private static Participant toan;
	private static Participant tuan;
	private static Participant vantuan;
	private static Participant vuoung;
	private static Participant willy;
	private static Participant wing;
	
	// Womens
	private static Participant jasmin;
	private static Participant kim;
	private static Participant mylinh;
	private static Participant oliver;
	private static Participant sandra;
	private static Participant sarah; 
	private static Participant thaihien;
	private static Participant vincent;

	
	@Before
	public void setUp() {
		// initialize
		scheduleVerifier = new ScheduleVerifier();
		scheduleGenerator = new PriorityBacktrackScheduleGenerator();
		
		groupWomensA = new Group("WA");
		groupMensA = new Group("MA");
		groupMensB = new Group("MB");
		groupMensC = new Group("MC");
		groupMensD = new Group("MD");
		groupDoublesA = new Group("DA");
		groupDoublesB = new Group("DB");
		groupDoublesC = new Group("DC");
		groupDoublesD = new Group("DD");
		
		amybinh = new SingleParticipant("Amy & Binh");
		angrybirds = new SingleParticipant("Angry Birds");
		bananaaa = new SingleParticipant("Bänänäää");
		bivi = new SingleParticipant("BiVi");
		boigirl = new SingleParticipant("Boi&Girl");
		bunnypony = new SingleParticipant("Bunny & Pony");
		echondiezwedetane = new SingleParticipant("Ech ond die zwe detäne");
		huongteak = new SingleParticipant("Huong & Teak");
		ichaffdutiger = new SingleParticipant("Ich Aff' Du Tiger");
		just4fun = new SingleParticipant("Just4Fun");
		kk = new SingleParticipant("K&K");
		kudasi = new SingleParticipant("KUSADASI");
		lejong = new SingleParticipant("le jöng");
		mathutien = new SingleParticipant("Mäthu & Tien");
		mynhien = new SingleParticipant("M? Nhiên");
		neighbours = new SingleParticipant("Neighbours");
		overtherainbow = new SingleParticipant("Over The Rainbow");
		puccagaru = new SingleParticipant("Pucca & Garu");
		stangeli = new SingleParticipant("Stängeli");
		xuetituan = new SingleParticipant("XueTi & Tuan");
		fischol = new SingleParticipant("Fischöl");
		teamlili = new SingleParticipant("Team LiLi");
		theraqueteers = new SingleParticipant("The Racqueteers");
		vyjan = new SingleParticipant("Vy + Jan");
		
		annhien = new SingleParticipant("An Nhiên");
		binhlai = new SingleParticipant("Binh Lai");
		binhlam = new SingleParticipant("Binh Lam");
		dat = new SingleParticipant("Dat");
		ductuan = new SingleParticipant("Duc Tuan");
		khanh = new SingleParticipant("Khanh");
		liem = new SingleParticipant("Liem");
		mathu = new SingleParticipant("Mäthu");
		minh = new SingleParticipant("Minh");
		nghi = new SingleParticipant("Nghi");
		nguyen = new SingleParticipant("Nguyen");
		phong = new SingleParticipant("Phong");
		quocthinh = new SingleParticipant("Quoc Thinh");
		si = new SingleParticipant("Si");
		stefan = new SingleParticipant("Stefan");
		thien = new SingleParticipant("Thien");
		thomas = new SingleParticipant("Thomas");
		toan = new SingleParticipant("Toan");
		tuan = new SingleParticipant("Tuan");
		vantuan = new SingleParticipant("Van Tuan");
		vuoung = new SingleParticipant("Vuong");
		willy = new SingleParticipant("Willy");
		wing = new SingleParticipant("Wing");
		
		jasmin = new SingleParticipant("Jasmin");
		kim = new SingleParticipant("Kim");
		mylinh = new SingleParticipant("My Linh");
		oliver = new SingleParticipant("Oliver");
		sandra = new SingleParticipant("Sandra");
		sarah = new SingleParticipant("Sarah");
		thaihien = new SingleParticipant("Thai Hien");
		vincent = new SingleParticipant("Vincent");
	}

	@Test
	public void testGroupingDoubles() {
		// get participants
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(amybinh);
		participantList.add(angrybirds);
		participantList.add(bananaaa);
		participantList.add(bivi);
		participantList.add(boigirl);
		participantList.add(bunnypony);
		participantList.add(echondiezwedetane);
		participantList.add(huongteak);
		participantList.add(ichaffdutiger);
		participantList.add(just4fun);
		participantList.add(kk);
		participantList.add(kudasi);
		participantList.add(lejong);
		participantList.add(mathutien);
		participantList.add(mynhien);
		participantList.add(neighbours);
		participantList.add(overtherainbow);
		participantList.add(puccagaru);
		participantList.add(stangeli);
		participantList.add(xuetituan);
		participantList.add(fischol);
		participantList.add(teamlili);
		participantList.add(theraqueteers);
		participantList.add(vyjan);

		// get groups
		groupDoublesA.getGroupMemberList().add(bivi);
		groupDoublesA.getGroupMemberList().add(boigirl);
		groupDoublesA.getGroupMemberList().add(echondiezwedetane);
		groupDoublesA.getGroupMemberList().add(just4fun);
		groupDoublesA.getGroupMemberList().add(lejong);
		groupDoublesA.getGroupMemberList().add(stangeli);
		
		groupDoublesB.getGroupMemberList().add(amybinh);
		groupDoublesB.getGroupMemberList().add(kk);
		groupDoublesB.getGroupMemberList().add(neighbours);
		groupDoublesB.getGroupMemberList().add(overtherainbow);
		groupDoublesB.getGroupMemberList().add(theraqueteers);
		groupDoublesB.getGroupMemberList().add(vyjan);
		
		groupDoublesC.getGroupMemberList().add(bunnypony);
		groupDoublesC.getGroupMemberList().add(fischol);
		groupDoublesC.getGroupMemberList().add(ichaffdutiger);
		groupDoublesC.getGroupMemberList().add(mathutien);
		groupDoublesC.getGroupMemberList().add(mynhien);
		groupDoublesC.getGroupMemberList().add(teamlili);
		
		groupDoublesD.getGroupMemberList().add(angrybirds);
		groupDoublesD.getGroupMemberList().add(bananaaa);
		groupDoublesD.getGroupMemberList().add(huongteak);
		groupDoublesD.getGroupMemberList().add(kudasi);
		groupDoublesD.getGroupMemberList().add(puccagaru);
		groupDoublesD.getGroupMemberList().add(xuetituan);
		
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(groupDoublesA);
		groupList.add(groupDoublesB);
		groupList.add(groupDoublesC);
		groupList.add(groupDoublesD);

		// get fields
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Field 1"));
		fieldList.add(new Field("Field 2"));
		fieldList.add(new Field("Field 3"));
		fieldList.add(new Field("Field 4"));
		fieldList.add(new Field("Field 5"));
		fieldList.add(new Field("Field 6"));
		fieldList.add(new Field("Field 7"));
		fieldList.add(new Field("Field 8"));

		// get dates
		Calendar calendar = Calendar.getInstance();
		ArrayList<Date> dateList = new ArrayList<Date>();
		calendar.set(2012, 4, 28, 9, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 00, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 20, 0);
		dateList.add(calendar.getTime());

		// generate schedule
		try {
			Schedule schedule = scheduleGenerator.generateSchedule(participantList, groupList, false, fieldList, dateList, scheduleVerifier);
			System.out.println(schedule.getCSV());
		} catch (InvalidScheduleInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGroupingMens() {
		// get participants
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(annhien);
		participantList.add(binhlai);
		participantList.add(binhlam);
		participantList.add(dat);
		participantList.add(ductuan);
		participantList.add(khanh);
		participantList.add(liem);
		participantList.add(mathu);
		participantList.add(minh);
		participantList.add(nghi);
		participantList.add(nguyen);
		participantList.add(phong);
		participantList.add(quocthinh);
		participantList.add(si);
		participantList.add(stefan);
		participantList.add(thien);
		participantList.add(thomas);
		participantList.add(toan);
		participantList.add(tuan);
		participantList.add(vantuan);
		participantList.add(vuoung);
		participantList.add(willy);
		participantList.add(wing);

		// get groups
		groupMensA.getGroupMemberList().add(binhlai);
		groupMensA.getGroupMemberList().add(minh);
		groupMensA.getGroupMemberList().add(nghi);
		groupMensA.getGroupMemberList().add(nguyen);
		groupMensA.getGroupMemberList().add(thomas);
		groupMensA.getGroupMemberList().add(toan);
		
		groupMensB.getGroupMemberList().add(annhien);
		groupMensB.getGroupMemberList().add(ductuan);
		groupMensB.getGroupMemberList().add(liem);
		groupMensB.getGroupMemberList().add(si);
		groupMensB.getGroupMemberList().add(vantuan);
		groupMensB.getGroupMemberList().add(wing);
		
		groupMensC.getGroupMemberList().add(binhlam);
		groupMensC.getGroupMemberList().add(mathu);
		groupMensC.getGroupMemberList().add(thien);
		groupMensC.getGroupMemberList().add(tuan);
		groupMensC.getGroupMemberList().add(vuoung);
		groupMensC.getGroupMemberList().add(willy);
		
		groupMensD.getGroupMemberList().add(dat);
		groupMensD.getGroupMemberList().add(khanh);
		groupMensD.getGroupMemberList().add(phong);
		groupMensD.getGroupMemberList().add(quocthinh);
		groupMensD.getGroupMemberList().add(stefan);
		
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(groupMensA);
		groupList.add(groupMensB);
		groupList.add(groupMensC);
		groupList.add(groupMensD);

		// get fields
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Field 1"));
		fieldList.add(new Field("Field 2"));
		fieldList.add(new Field("Field 3"));
		fieldList.add(new Field("Field 4"));
		fieldList.add(new Field("Field 5"));
		fieldList.add(new Field("Field 6"));
		fieldList.add(new Field("Field 7"));
		fieldList.add(new Field("Field 8"));

		// get dates
		Calendar calendar = Calendar.getInstance();
		ArrayList<Date> dateList = new ArrayList<Date>();
		calendar.set(2012, 4, 28, 9, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 00, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 20, 0);
		dateList.add(calendar.getTime());

		// generate schedule
		try {
			Schedule schedule = scheduleGenerator.generateSchedule(participantList, groupList, false, fieldList, dateList, scheduleVerifier);
			System.out.println(schedule.getCSV());
		} catch (InvalidScheduleInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGroupingWomens() {
		// get participants
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(jasmin);
		participantList.add(kim);
		participantList.add(mylinh);
		participantList.add(oliver);
		participantList.add(sandra);
		participantList.add(sarah);
		participantList.add(thaihien);
		participantList.add(vincent);


		// get groups
		groupWomensA.getGroupMemberList().add(jasmin);
		groupWomensA.getGroupMemberList().add(kim);
		groupWomensA.getGroupMemberList().add(mylinh);
		groupWomensA.getGroupMemberList().add(oliver);
		groupWomensA.getGroupMemberList().add(sandra);
		groupWomensA.getGroupMemberList().add(sarah);
		groupWomensA.getGroupMemberList().add(thaihien);
		groupWomensA.getGroupMemberList().add(vincent);
		
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(groupWomensA);

		// get fields
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Field 1"));
		fieldList.add(new Field("Field 2"));
		fieldList.add(new Field("Field 3"));
		fieldList.add(new Field("Field 4"));

		// get dates
		Calendar calendar = Calendar.getInstance();
		ArrayList<Date> dateList = new ArrayList<Date>();
		calendar.set(2012, 4, 28, 9, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 9, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 10, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 00, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 4, 28, 11, 20, 0);
		dateList.add(calendar.getTime());


		// generate schedule
		try {
			Schedule schedule = scheduleGenerator.generateSchedule(participantList, groupList, false, fieldList, dateList, scheduleVerifier);
			System.out.println(schedule.getCSV());
		} catch (InvalidScheduleInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
