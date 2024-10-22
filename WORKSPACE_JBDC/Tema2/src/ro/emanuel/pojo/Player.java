package ro.emanuel.pojo;

public class Player {
	
	private int id;
	private String name;
	private int level;
	private int score;
	
	public Player(int id, String name, int level, int score) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}