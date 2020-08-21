package application;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.RobotDao;
import entity.Robot;

  public class Menu {

		
		private RobotDao robotDao = new RobotDao();
		private Scanner scanner = new Scanner(System.in);
		private List<String> options = Arrays.asList("Display Robots", "Display a robot", "create robot", "delete robot");

		public void start() {
			String selection = "";
			
			do {
				printMenu();
				selection = scanner.nextLine();
				try {

					if(selection.contentEquals("1")) {
						displayRobots();
					}else if (selection.contentEquals("2")) {
						displayRobot();
					}
					else if (selection.contentEquals("3")) {
						createRobot();
					}
					else if (selection.contentEquals("4")) {
						deleteRobot();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					System.out.println("finally");
				}
				
				System.out.println("press enter to continue...");
				scanner.nextLine();
				
			} while (!selection.contentEquals("-1"));
		}

		

		private void deleteRobot() throws SQLException {
			System.out.println("enter robot id to delete");
			int id = Integer.parseInt(scanner.nextLine());
			robotDao.deleteRobotById(id);
		}

		private void createRobot()throws SQLException {
			System.out.println("enter new robot: ");
			String robotName = scanner.nextLine();
			robotDao.createNewRobot(robotName);
		}

		private void displayRobot() throws SQLException {
			System.out.println("Eneter Robot ID: ");
			int id = Integer.parseInt(scanner.nextLine());
			Robot robot = robotDao.getRobotById(id);
			System.out.println(robot.getRobotId() + ": " + robot.getName());
		}

		private void displayRobots() throws SQLException {
			List<Robot> robots = robotDao.getRobots();
			for(Robot robot : robots) {
				System.out.println(robot.getRobotId() + ": " + robot.getName());
			}
		}

		private void printMenu() {
			System.out.println("Select an Option:\n...........................");
			for(int i = 0; i < options.size(); i++) {
				System.out.println(i + 1 + ") " + options.get(i));
			}
		}
	}
