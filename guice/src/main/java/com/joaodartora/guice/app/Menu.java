package com.joaodartora.guice.app;

import java.util.Scanner;
import com.joaodartora.guice.model.Pet;
import com.joaodartora.guice.services.Bath;
import com.joaodartora.guice.services.Haircut;

public class Menu {

	private static Scanner scanner;
	private static final int ADD_PET = 1;
	private static final int REMOVE_PET = 2;
	private static final int SEARCH_PET_BY_ID = 3;
	private static final int SEARCH_PET_BY_AGE = 4;
	private static final int DO_DRY_BATH_PERFUMED = 5;
	private static final int DO_DRY_BATH_WITHOUT_PERFUME = 6;
	private static final int DO_WATER_BATH_PERFUMED = 7;
	private static final int DO_WATER_BATH_WITHOUT_PERFUME = 8;
	private static final int DO_LONG_HAIRCUT = 9;
	private static final int DO_SHORT_HAIRCUT = 10;
	private static final int SHOW_TOP_10_LIST = 11;
	private static final int SHOW_SERVICE_HISTORY = 12;
	private static final int EXIT = 13;

	private Store store;
	private Bath bath;
	private Haircut haircut;
	private History history;
	
	public Menu(Store store, Bath bath, Haircut haircut, History history) {
		this.store = store;
		this.bath = bath;
		this.haircut = haircut;
		this.history = history;
	}

	public void generateMenu() {
		
		scanner = new Scanner(System.in);
		int menuControl = 0;
		
		do {
			System.out.println("\nEnter the chosen option:\n");
			System.out.println("1 - Add new pet");
			System.out.println("2 - Remove pet");
			System.out.println("3 - Search pet by ID");
			System.out.println("4 - Search pet by age");
			System.out.println("5 - Do dry bath with perfume");
			System.out.println("6 - Do dry bath without perfume");
			System.out.println("7 - Do water bath with perfume");
			System.out.println("8 - Do water bath without perfume");
			System.out.println("9 - Do long haircut");
			System.out.println("10 - Do short haircut");
			System.out.println("11 - Show top 10 revenue pets");
			System.out.println("12 - Show history of services");
			System.out.println("13 - Exit");
			
			int option = -1;
			try {
				option = Integer.parseInt(scanner.next());
				scanner.hasNextLine();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			
			switch(option) {
			
			case ADD_PET:
				menuAddPet(store);
				break;
			case REMOVE_PET:
				menuRemovePet(store);
				break;
			case SEARCH_PET_BY_ID:
				menuSearchPetId(store);
				break;
			case SEARCH_PET_BY_AGE:
				menuSearchPetAge(store);
				break;
			case DO_DRY_BATH_PERFUMED:
				menuDoDryBathPerfumed(bath);
				break;
			case DO_DRY_BATH_WITHOUT_PERFUME:
				menuDoDryBathWithoutPerfume(bath);
				break;
			case DO_WATER_BATH_PERFUMED:
				menuDoWaterBathPerfumed(bath);
				break;
			case DO_WATER_BATH_WITHOUT_PERFUME:
				menuDoWaterBathWithoutPerfume(bath);
				break;
			case DO_LONG_HAIRCUT:
				menuDoLongHaircut(haircut);
				break;
			case DO_SHORT_HAIRCUT:
				menuDoShortHaircut(haircut);
				break;
			case SHOW_TOP_10_LIST:
				menuShowTop10List(history);
				break;
			case SHOW_SERVICE_HISTORY:
				menuShowServicesHistory(history);
				break;
			case EXIT:
				menuControl++;
				System.out.println("Program closed!");
				break;
			default:
				System.out.println("Nonexistent option!");
			}
			
		} while (menuControl == 0);
	}
	
	public void menuAddPet (Store store) {
		scanner = new Scanner(System.in);
		System.out.println("Enter new pet name: \n");
		String petName = (scanner.nextLine());
		scanner = new Scanner(System.in);
		System.out.println("Enter new pet race: \n");
		String petRace = scanner.nextLine();
		scanner = new Scanner(System.in);
		System.out.println("Enter new pet age: \n");
		String petAge = scanner.nextLine();
		store.addPet(new Pet(petName, petRace, petAge));
	}
	
	public void menuRemovePet (Store store) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet to be removed: \n");
		int petId = (scanner.nextInt());
		store.removePet(petId);	
	}
	
	public void menuSearchPetId (Store store) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to search: \n");
		int searchPetId = (scanner.nextInt());
		System.out.println(store.searchPetById(searchPetId));
	}
	
	public void menuSearchPetAge (Store store) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the age of the pets you want to search: \n");
		String searchPetAge = (scanner.nextLine());
		System.out.println(store.searchPetByAge(searchPetAge));
	}
	
	public void menuDoDryBathPerfumed (Bath bath) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to bath: \n");
		int dryPerfumeBath = (scanner.nextInt());
		bath.doDryBathPerfumed(store.searchPetById(dryPerfumeBath).get());
	}
	
	public void menuDoDryBathWithoutPerfume (Bath bath) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to bath: \n");
		int dryNoPerfumeBath = (scanner.nextInt());
		bath.doDryBathWithoutPerfume(store.searchPetById(dryNoPerfumeBath).get());
	}
	
	public void menuDoWaterBathPerfumed (Bath bath) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to bath: \n");
		int waterPerfumeBath = (scanner.nextInt());
		bath.doWaterBathPerfumed(store.searchPetById(waterPerfumeBath).get());
	}
	
	public void menuDoWaterBathWithoutPerfume (Bath bath) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to bath: \n");
		int waterNoPerfumeBath = (scanner.nextInt());
		bath.doWaterBathWithoutPerfume(store.searchPetById(waterNoPerfumeBath).get());
	}
	
	public void menuDoLongHaircut (Haircut haircut) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to cut the hair: \n");
		int longHaircut = (scanner.nextInt());
		haircut.doLongHaircut(store.searchPetById(longHaircut).get());
	}
	
	public void menuDoShortHaircut (Haircut haircut) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the ID of the pet you want to cut the hair: \n");
		int shortHaircut = (scanner.nextInt());
		haircut.doShortHaircut(store.searchPetById(shortHaircut).get());
	}	
	
	public void menuShowTop10List (History history) {
		System.out.println(history.getMostExpensivePets(store.getPetList()));
	}
	
	public void menuShowServicesHistory (History history) {
		System.out.println(history.getServicesHistory());
	}
}
