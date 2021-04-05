package lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class VRada {
	private static VRada VR;
	List<Faction> factionVR = new ArrayList<Faction>();
	public static final String nonFractional = "NONFRACTIONAL";

	private VRada() {
	}

	public static VRada ifCreation() {
		if (VR == null) {
			VR = new VRada();
			VR.addFaction(nonFractional);
		}
		return VR;
	}

	public boolean addFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				bool = true;
			}
		}
		if (!bool) {
			Faction newFaction = new Faction(nameFaction);
			factionVR.add(newFaction);
		}
		return !bool;
	}

	public boolean removeFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR.listIterator();
		boolean bool = false;
		while ((f.hasNext()) && (nameFaction != nonFractional)) {
			Faction tempFaction = f.next();
			if (tempFaction.getNameFaction().equalsIgnoreCase(nameFaction)) {
				System.out.println(
						"Faction " + nameFaction + " was removed!");
				Iterator<Deputat> tempDeputat = tempFaction.getDeputaty().iterator();
				while (tempDeputat.hasNext()) {
					Deputat temp = tempDeputat.next();
					addDeputatInFaction(nonFractional, temp);
				}

				f.remove();
				bool = true;
			}
		}
		return bool;
	}

	public void printAllFaction() {
		ListIterator<Faction> f = factionVR.listIterator();
		while (f.hasNext()) {
			Faction temp = f.next();
			System.out.print(temp.getNameFaction() + " ");
		}
	}

	public boolean removeAllDeputatInFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction tempFaction = f.next();
			if (tempFaction.getNameFaction().equalsIgnoreCase(nameFaction)) {
				System.out.println(
						"All Deputat in Faction " + nameFaction + " were removed");

				Iterator<Deputat> tempDeputat = tempFaction.getDeputaty().iterator();
				while (tempDeputat.hasNext()) {
					Deputat temp = tempDeputat.next();
					addDeputatInFaction(nonFractional, temp);
				}

				tempFaction.removeAllDeputat();
				bool = true;
			}
		}
		return bool;
	}

	public boolean printAllDeputatInFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				System.out.println("In Faction" + nameFaction + " are :");
				temp.printAllDeputat();
				bool = true;
			}
		}
		return bool;
	}

	public boolean addDeputatInFaction(String nameFaction, Deputat deputat) {
		ListIterator<Faction> f = factionVR.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				temp.addDeputat(deputat);
				bool = true;
			}
		}
		return bool;
	}

	public boolean removeDeputatFromFaction(String nameFaction, String name, String surName) {
		ListIterator<Faction> f = factionVR.listIterator();
		boolean bool = false;
		while ((f.hasNext()) && (nameFaction != nonFractional)) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				Deputat tempDeputat = temp.returnDeputat(name, surName);
				addDeputatInFaction(nonFractional, tempDeputat);
				temp.removeDeputat(name, surName);
				System.out.println("From Faction " + nameFaction + " was removed " + name + " " + surName
						+ " !");
				bool = true;
			}
		}
		return bool;

	}

	public void printAllDeputatBribetaker(String nameFaction) {
		ListIterator<Faction> f = factionVR.listIterator();
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				temp.printAllDeputatBribetaker();
			}
		}

	}

	public void printBiggestDeputatBribetakerInFraction(String nameFaction) {
		ListIterator<Faction> f = factionVR.listIterator();
		Deputat maxDeputatBribetaker = null;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				maxDeputatBribetaker = temp.findBiggestDeputatBribetaker();
				System.out.println(maxDeputatBribetaker.toString());

			}
		}
	}

}