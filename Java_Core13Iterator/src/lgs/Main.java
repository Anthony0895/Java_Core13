package lgs;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws Exception {

		String st;
		while (true) {
			printMenu();
			st = new Scanner(System.in).nextLine();
			switch (st) {
			case "1": { 
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().addFaction(st)) {
						System.err.println("Error " + st + " . Maybe, this Faction already exist!");
					} else {
						System.out.println("Faction " + st + " was added!");
					}
				}
				break;
			}
			case "2": { 
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().removeFaction(st)) {
						System.out.println("Faction " + st + " isn't found!");
					}
				}
				break;
			}
			case "3": {
				System.out.println("There are such Factions: ");
				VRada.ifCreation().printAllFaction();
				System.out.println();
				break;
			}
			case "4": {
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().removeAllDeputatInFaction(st)) {
						System.out.println("Faction " + st + " isn't found!");
					}
				}
				break;
			}
			case "5": { 
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("Faction " + st + " isn't found!");
					}
				}
				break;
			}

			case "6": { 
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {

					Deputat d = new Deputat(0, 0);
					Random rand = new Random();
					String[] nameMass = { "Artem", "Pawlo", "Oleg", "Sanja", "Mykola", "Misha", "David", "Danil" };
					String[] surNameMass = { "Omarov", "Zelensk", "Poroshenko", "Nagijev", "Krawzow", "Talochovich", "Indruk",
							"Pokronov" };

					System.out.print("Enter by hand (1) or generate randomly (2)?");
					String s = new Scanner(System.in).nextLine();
					int i = 0;
					if (s.equals("1")) {
						System.out.print("Enter name ");
						String ss = new Scanner(System.in).nextLine();
						if (checkErrors(ss)) {
							d.setName(ss);
						}
						System.out.print("Enter surname");
						ss = new Scanner(System.in).nextLine();
						if (checkErrors(ss)) {
							d.setSurName(ss);
						}
						System.out.print("Enter age ");
						i = Integer.parseInt(new Scanner(System.in).nextLine());
						d.setAge(i);
						System.out.print("Enter weight ");
						i = Integer.parseInt(new Scanner(System.in).nextLine());
						d.setWeight(i);
						System.out.print("Enter height ");
						i = Integer.parseInt(new Scanner(System.in).nextLine());
						d.setHeigth(i);

						System.out.print("Does he take bribe, yes or not?");
						ss = new Scanner(System.in).nextLine();
						if (ss.equals("yes")) {
							d.setBribetaker(true);
						}
						if (ss.equals("not")) {
							d.setBribetaker(false);
						}
					}
					if (s.equals("2")) {
						d.setWeight(rand.nextInt(100) + 100);
						d.setHeigth(rand.nextInt(100) + 100);
						d.setAge(rand.nextInt(50) + 25);
						d.setBribetaker(true);
						d.setSurName(surNameMass[rand.nextInt(7)]);
						d.setName(nameMass[rand.nextInt(7)]);

					}

					if (d.isBribetaker()) {
						System.out.println("This deputat is bribetaker " + d.getName() + " " + d.getSurName()
								+ " How much will you give bribe?");
						int BribeNew = Integer.parseInt(new Scanner(System.in).nextLine());
						d.givebribe(BribeNew);
					}

					if (VRada.ifCreation().addDeputatInFaction(st, d)) {
						System.out.println("In Faction " + st + "was added " + d.toString());
					} else {
						System.out.println("Faction" + st + " is not found!");
					}
				}
				break;
			}
			case "7": { 
				String st1 = "";
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("Faction" + st + " is not found!");
					} else {
						System.out.print("Enter a name and a surname of the deputat you want to delete (with a space) :");
						st1 = new Scanner(System.in).nextLine();
						if (checkErrors(st)) {
							String[] s = st1.split(" ");
							VRada.ifCreation().removeDeputatFromFaction(st, s[0], s[1]);

						}
					}
				}
				break;
			}
			case "8": { 
				System.out.print("Enter the name of Faction");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("Faction " + st + " is not found!");
					} else {
						System.out.println("List of deputies of the faction bribe-takers " + st);
						VRada.ifCreation().printAllDeputatBribetaker(st);
					}
				}
				break;
			}
			case "9": { 
				System.out.print("Enter the name of Faction ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("Faction " + st + " is not found!");
					} else {
						System.out.println("The biggest bribe-taker in Faction is " + st);
						VRada.ifCreation().printBiggestDeputatBribetakerInFraction(st);
					}
				}
				break;
			}

			case "0": {
				System.exit(0);
			}
			}
		}
	}

	private static void printMenu() {
		System.out.println ("Enter 1 to create a fraction");
		System.out.println ("Enter 2 to delete a fraction");
		System.out.println ("Enter 3 to print all fractions");
		System.out.println ("Enter 4 to clear the faction from deputies");
		System.out.println ("Enter 5 to print deputies of the specified faction");
		System.out.println ("Enter 6 to add deputies to the faction");
		System.out.println ("Enter 7 to remove deputata from faction");
		System.out.println ("Enter 8 to print a list of bribe-takers of the faction");
		System.out.println ("Enter 9 to print the largest bribe of the faction");
		System.out.println ("Enter 0 to exit the program");

	}

	private static boolean checkErrors(String s1) throws Exception {
		String kirilica = "[à-ÿÀ-ß+]";
		Pattern pattern = Pattern.compile(kirilica);
		Matcher mather = pattern.matcher(s1);

		if (s1.length() < 2 || s1.length() > 15)
			throw new IllegalArgumentException("The name "+ s1 +" was entered incorrectly (number of characters)");
		if (!s1.matches("^\\D*$"))
			throw new IllegalArgumentException("The name "+ s1 + " cannot contain numbers");
		if (mather.find())
			throw new IllegalArgumentException("The name "+ s1 + " cannot contain ñyrillic");
		return true;

	}

}
