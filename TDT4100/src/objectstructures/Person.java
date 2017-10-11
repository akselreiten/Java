package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class Person {

	String name; 
	char gender;
	Person mother, father;
	List<Person> children = new ArrayList<Person>();
	
	
	public Person(String name, char gender){
		if (gender == 'F' || gender == 'M'){
			this.gender = gender;
		}
		this.name = name;
		mother = null;
		father = null;
	}
	
	public String getName(){
		return name; 
	}
	
	public char getGender(){
		return gender; 
	}
	
	public Person getMother(){
		return mother; 
	}
	
	public Person getFather(){
		return father; 
	}
	
	public int getChildCount(){
		return children.size();
	}
	
	public Person getChild(int n){
		if (n < children.size()){
			return children.get(n);
		} else {
			throw new IllegalArgumentException("n må være mindre enn antall barn!");
		}
	}
	
	public void addChild(Person child){
		if (!(children.contains(child))){
			if (gender == 'M'){
				children.add(child); 
				child.father = this;
			} else {
				children.add(child);
				child.mother=this;
			}
		}
	}
	
	public void removeChild(Person child){
		if (children.contains(child)){
			children.remove(children.indexOf(child));
			if (gender == 'M'){
				child.father = this;
			} else {
				child.mother = this;
			}
		} else{
			throw new IllegalArgumentException("No children to remove!");
		}
	}
	
	
	public void setMother(Person newMother){
		if (newMother.getGender() == 'F') {
			if (newMother == null && mother != null) {
					mother.removeChild(this); 
					mother = null;  
			} else if (newMother != null && mother == null){
				mother = newMother;
				mother.addChild(this);
			} else if (newMother != null && mother != null){
				mother.removeChild(this);
				mother = newMother; 
				mother.addChild(this);
			} 
		} else {
			throw new IllegalArgumentException("A male cannot be a mother.");
		}
	}
	
	public void setFather(Person newFather){
		if (newFather.getGender() == 'M') {
			if (newFather == null && father != null) {
					father.removeChild(this); 
					father = null;  
			} else if (newFather != null && father == null){
				father = newFather;
				father.addChild(this);
			} else if (newFather != null && father != null){
				father.removeChild(this);
				father = newFather; 
				father.addChild(this);
			} 
		} else {
			throw new IllegalArgumentException("A female cannot be a father.");
		}
	}
	
	/*
	public void setMother(Person newMother){
		if (newMother != null && newMother.getGender() == 'F'){
			if (newMother != mother){
				Person oldMother = mother;
				oldMother.removeChild(this);
				mother = newMother; 
				newMother.addChild(this);
			} else {
				return; 
			}
		} else {
			if (mother != null){
				mother.removeChild(this);
				mother = null;
			}
		}
	}
	*/
	/*
	public void setFather(Person newFather){
		if (newFather != null && newFather.getGender() == 'M'){
			if (newFather != father){
				Person oldFather = father;
				oldFather.removeChild(this);
				father = newFather; 
				newFather.addChild(this);
			} else {
				return; 
			}
		} else {
			if (father != null){
				father.removeChild(this);
				father = null;
			}
		}
		
		
		father = newFather;
		father.addChild(this);
	}
	*/
	
	public String toString(){
		return name; 
	}
	
}
