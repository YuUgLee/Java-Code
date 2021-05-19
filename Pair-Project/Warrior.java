public class Warrior extends EnemyDecorator {

  public Warrior(String n, int mHp, Item I) {
    super(n,mHp+2,I);
    if (!super.getName().contains("Warrior")){
      super.setName(getName() + " Warrior");
    }
  }

	public String getName(){
	  return super.getName();
	}

	public String attack(Entity e){
	    int damage = (int)(Math.random()*e.getHP()+1);
	    e.takeDamage(damage);
	    return getName() + " attacks " + e.getName() + " for " + damage + " damage.";
	}
}