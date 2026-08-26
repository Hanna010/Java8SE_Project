package workshop.animal.entity;

public class Cat extends Animal implements Pet {

	private String name;
	
	public Cat() {
		this("");
	}
	
	public Cat(String name) {
		super(4);
		this.name= name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name= name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("고양이는 장화신고 논다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("고양이는 생선을 먹어요!");
	}

}
