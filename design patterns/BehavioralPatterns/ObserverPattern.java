/**
 * This program demos the Observer pattern. 
 * 
 * Output
 * ------
 * The data for observer is: 1
 * The data for observer is: 1
 * The data for observer is: 2
 * The data for observer is: 2
 * 
 * 
 * @author pyav
 * 
 */

package designPatterns.BehavioralPatterns;

import java.util.ArrayList;
import java.util.List;

interface IObservable {
	void add(IObserver observer);
	void remove(IObserver observer);
	void notifyObservers();
}

interface IObserver {
	void update();
}

class Subject implements IObservable {
	private List<IObserver> observers = new ArrayList<IObserver>();
	private int data;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
		notifyObservers();
	}

	public void add(IObserver observer) {
		this.observers.add(observer);
	}

	public void remove(IObserver observer) {
		this.observers.remove(observer);
	}

	public void notifyObservers() {
		for (IObserver iobserver : this.observers) {
			iobserver.update();
		}
	}
}

class Observer implements IObserver {
	Subject subject;
	
	public Observer(Subject subject) {
		this.subject = subject;
	}
	
	public void update() {
		System.out.println("The data for observer is: " + this.subject.getData());
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer observer1 = new Observer(subject);
		Observer observer2 = new Observer(subject);
		subject.add(observer1);
		subject.add(observer2);
		subject.setData(1);
		subject.setData(2);
	}

}
