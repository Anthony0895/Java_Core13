package lgs;

public class Deputat extends Human {
	private String name;
	private String surName;
	private int age;
	private boolean bribetaker;
	private int bribeSize;

	public Deputat(int weight, int heigth) {
		super(weight, heigth);
		this.name = "";
		this.surName = "";
		this.age = 0;
		this.bribetaker = false;
	}

	public Deputat(int weight, int heigth, String name, String surName, int age, boolean bribetaker) {
		super(weight, heigth);
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.bribetaker = bribetaker;
	}

	public boolean givebribe(int bribeNew) {
		boolean bool = false;
		if (bribeNew <= 5000) {
			this.bribeSize = bribeNew;
			bool = true;
			System.out.println("The size of bride is \" + bribeSize");
		} else {
			System.out.println("The police will imprison the deputy!!!");
			//this.bribeSize = 0;
		}

		return bool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribetaker() {
		return bribetaker;
	}

	public void setBribetaker(boolean bribetaker) {
		this.bribetaker = bribetaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	@Override
	public String toString() {
		return "Deputat [name=" + name + ", surName=" + surName + ", age=" + age + ", bribetaker=" + bribetaker
				+ ", bribeSize=" + bribeSize + "]";
	}
}