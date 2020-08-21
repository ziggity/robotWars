package entity;

public class Robot {
	private int robotId;
	private String name;
	
	public Robot(int robotId, String name) {
		this.setRobotId(robotId);
		this.setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setRobotId(int robotId) {
		this.robotId = robotId;
	}

	public int getRobotId() {
		return robotId;
	}

	public String getName() {
		return name;
	}
}

	
