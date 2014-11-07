/*
 * Copyright (c) 2014 Manuel Rodriguez
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package models;

import java.util.ArrayList;

public class PersonList {
	
	private ArrayList<Person> personList;
	int counter = 1;
	
	private PersonList(){
		this.personList = new ArrayList<Person>(10);
	}
	
	public Person addPerson(Person obj){
		long id = this.counter++;
		obj.setId(id);
		this.personList.add(obj);
		return obj;
	}
	
	public Person getPersonById(long id){
		for (Person p : this.personList){
			if (p.getId() == id){
				return p;
			}
		}
		return null;
	}
	
	public Person[] getAllPersons(){
		Person result[] = new Person[this.personList.size()];
		for (int i=0; i < this.personList.size(); ++i){
			result[i] = this.personList.get(i);
		}
		return result;
	}
	

	
	public boolean deletePerson(long id){
		int target = -1;
		
		for (int i=0; i< this.personList.size(); ++i){
			if (this.personList.get(i).getId() == id){
				target = i;
				break;
			}
		}
		if (target == -1){
			return false;
		}
		else {
			this.personList.remove(target);
			return true;
		}
	}
	
	public Person updatePerson(Person obj){
		int target = -1;
		
		for (int i=0; i< this.personList.size(); ++i){
			if (this.personList.get(i).getId() == obj.getId()){
				target = i;
				break;
			}
		}
		if (target == -1){
			return null;
		}
		else {
			Person P = this.personList.get(target);
			P.setAge(obj.getAge());
			P.setFirstName(obj.getFirstName());
			P.setLastName(obj.getLastName());
			return P;
		}
	}
	
	private static PersonList singleton= new PersonList();
	
	public static PersonList getInstance(){
		return singleton;
	}
}
