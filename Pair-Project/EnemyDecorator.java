public abstract class EnemyDecorator extends Enemy {

	public EnemyDecorator(String n, int mHp, Item I) {
		super(n,mHp,I);
	}

  
	public String getName(){
		return super.getName();
	}
}