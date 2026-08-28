package workshop.animal.entity;

public interface Pet { //인터페이스는 규격. 클래스가 지켜야하는 약속 (규칙)이다.
	String getName();
	void setName(String name);
	public abstract void play();
}
