package workshop.animal.entity;

public interface Pet { //인터페이스는 규격. 클래스가 지켜야하는 약속 (규칙)이다.
	String getName(); //인터페이스 안에 변수는 선언될 수 없다. 추상메소드로 이루어져 있다.
	void setName(String name); //유의하자. String name는 매개변수일 뿐. 바디가 아님. 그래서 추상메소드. / 메서드 바디는 중괄호 {} 가 있어야함.
	public abstract void play(); //바디가 없음. 추상메서드.
}
