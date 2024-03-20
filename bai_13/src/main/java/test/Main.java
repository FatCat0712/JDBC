package test;

import java.util.ArrayList;

import dao.DogDAO;
import model.Dog;

public class Main {
	public static void main(String[] args) {
//		Dog dog1 = new Dog("Husky","Siberia",27);
//		Dog dog2 = new Dog("Alaska Malamute","Alaska",43);
//		DogDAO.getInstance().insert(dog1);
//		DogDAO.getInstance().insert(dog2);
//		
//		Dog dog3 = new Dog("Pitbull","US",30);
//		DogDAO.getInstance().insert(dog3);
//		
//		Dog dog4 = new Dog("Doberman","Germany",35);
//		DogDAO.getInstance().insert(dog4);
		
		//Dog dog5 = new Dog("German Shepherd","Germany",40);
		//DogDAO.getInstance().insert(dog5);
		
//		Dog dog4 = new Dog();
//		dog4.setId(4);
		
//		Dog dog5 = new Dog("Husky","Siberia",30);
//		dog5.setId(2);
//		DogDAO.getInstance().update(dog5);
		
		
//		ArrayList<Dog> dogList = DogDAO.getInstance().selectAll();
//		for(Dog d: dogList) {
//			System.out.println(d);
//		}
		
		
		Dog dog6 = new Dog();
		dog6.setId(5);
		System.out.println(DogDAO.getInstance().selectById(dog6));
	}
}
