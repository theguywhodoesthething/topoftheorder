package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "at_bat")
public class AtBat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Integer inning;
	private Integer balls;
	private Integer strikes;
	private Boolean scored;
	private Integer out;
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	public Integer getInning() {
		return inning;
	}

	public void setInning(Integer inning) {
		this.inning = inning;
	}

	public Integer getBalls() {
		return balls;
	}

	public void setBalls(Integer balls) {
		this.balls = balls;
	}

	public Integer getStrikes() {
		return strikes;
	}

	public void setStrikes(Integer strikes) {
		this.strikes = strikes;
	}

	public Boolean getScored() {
		return scored;
	}

	public void setScored(Boolean scored) {
		this.scored = scored;
	}

	public Integer getOut() {
		return out;
	}

	public void setOut(Integer out) {
		this.out = out;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getId() {
		return id;
	}

}
