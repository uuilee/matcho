package ch.laiw.matcho;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import util.TournamentUtilities;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Tournament;
import ch.laiw.matcho.persistence.HibernateUtil;

public class TestPersistence {

	private static Serializable tournamentId;
	
	@Before
	public void setUp() throws Exception {
		// Make sure that the database is set up correctly.
		// Since we use Hibernate this should be handled already.
	}

	@Test
	public void testInsertTournament() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Tournament testTournament = new Tournament();
		testTournament.setName("Test Tournament");
		tournamentId = session.save(testTournament);
		session.getTransaction().commit();

	}

	@Test
	public void testRetrieveTournament() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Tournament testTournament = (Tournament) session.get(Tournament.class, tournamentId);
		assertNotNull(testTournament);
		assertTrue("Test Tournament".equals(testTournament.getName()));
		session.getTransaction().commit();
	}
	
	@Test
	public void testRetrieveAndModifyTournament() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Tournament testTournament = (Tournament) session.get(Tournament.class, tournamentId);
		assertNotNull(testTournament);
		assertTrue("Test Tournament".equals(testTournament.getName()));
		testTournament.setName("Sample Tournament");
		session.getTransaction().commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		testTournament = (Tournament) session.get(Tournament.class, tournamentId);
		assertNotNull(testTournament);
		assertTrue("Sample Tournament".equals(testTournament.getName()));
		session.getTransaction().commit();
	}
	
	@Test
	public void testRetrieveAndAddParticipantsToTournament() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Tournament testTournament = (Tournament) session.get(Tournament.class, tournamentId);
		assertNotNull(testTournament);
		assertTrue("Sample Tournament".equals(testTournament.getName()));
		Collection<Participant> participants = TournamentUtilities.generateParticipants(5);
		testTournament.setParticipants(participants);
		session.getTransaction().commit();
	}

}
