package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.AtBat;
import entities.Game;
import entities.Player;
import entities.Season;
import entities.Team;
import entities.User;

public class EntityTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	AtBat atBat = null;
	Player player = null;
	Game game = null;
	Season season = null;
	Team team = null;
	User user = null;
	
	@Before
	public void setUp() throws Exception {
		
		emf = Persistence.createEntityManagerFactory("toto");
		em = emf.createEntityManager();
		
		atBat = em.find(AtBat.class, 1);
		player = em.find(Player.class, 1);
		game = em.find(Game.class, 1);
		season = em.find(Season.class, 1);
		team = em.find(Team.class, 1);
		user = em.find(User.class, 1);
	}
	
	@Test
	public void test_atBat() {
		assertEquals(3, atBat.getInning().intValue());
	}
	
	@Test
	public void test_player() {
		assertEquals(11, player.getNumber().intValue());
	}
	
	@Test
	public void test_game() {
		assertEquals("Squirrels", game.getOpponent());
	}
	
	@Test
	public void test_season() {
		assertEquals("Summer", season.getPeriod());
	}
	
	@Test
	public void test_team() {
		assertEquals("Giants", team.getMascot());
	}
	
	@Test
	public void test_user() {
		assertEquals("jandis", user.getUsername());
	}
	
	@Test
	public void test_user_team() {
		assertEquals("Giants", user.getTeams().get(0).getMascot());
		assertEquals(2, user.getTeams().size());
	}
	
	@Test
	public void test_team_user() {
		assertEquals("jandis", team.getUser().getUsername());
	}
	
	@Test
	public void test_team_season() {
		assertEquals("Winter", team.getSeasons().get(1).getPeriod());
		assertEquals(2, team.getSeasons().size());
	}
	
	@Test
	public void test_season_team() {
		assertEquals("Giants", season.getTeam().getMascot());
	}
	
	@Test
	public void test_season_game() {
		assertEquals("Squirrels", season.getGames().get(0).getOpponent());
		assertEquals(1, season.getGames().size());
	}
	
	@Test
	public void test_game_season() {
		assertEquals(2015, game.getSeason().getYear().intValue());
	}
	
	@Test
	public void test_game_atBat() {
		assertEquals(1, game.getAtBats().get(2).getBalls().intValue());
		assertEquals(4, game.getAtBats().size());
	}
	
	@Test
	public void test_atBat_game() {
		assertEquals("Wed Jul 19 2017 14:57:08 GMT-0700 (PDT)", atBat.getGame().getDate());
	}
	
	@Test
	public void test_atBat_player() {
		assertEquals("Ruth", atBat.getPlayer().getLastName());
	}
	
	@Test
	public void test_player_atBat() {
		assertEquals(9, player.getAtBats().get(1).getInning().intValue());
		assertEquals(2, player.getAtBats().size());
	}
	
	@Test
	public void test_player_team() {
		assertEquals("Giants", player.getTeams().get(0).getMascot());
		assertEquals(1, player.getTeams().size());
	}
	
	@Test
	public void test_team_player() {
		assertEquals("Hank", team.getPlayers().get(1).getFirstName());
		assertEquals(2, team.getPlayers().size());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
}
