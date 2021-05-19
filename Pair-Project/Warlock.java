import java.util.*;
public class Warlock extends EnemyDecorator implements Magical {

  public Warlock(String n, int mHp, Item I) {
		super(n,mHp+1,I);
    if (!super.getName().contains("Warlok")){
      super.setName(getName() + " Warlok");
    }
	}

  public String getName() {
    return super.getName();
  }

  /** 
	 * Hero attacks entity passed in
	 * @param e is the enemy hero is fighting
	 * @return a String with Heros name, HP, and items in inventory 
	 */
	@Override
	public String attack(Entity e) {
	    Random rand = new Random();
	    int r = rand.nextInt(3);
	    if (r == 0) {
	    	return magicMissile(e);
	    }
	    if (r == 1) {
	    	return fireball(e);
	    }
	    if (r == 2) {
	    	return thunderclap(e);
	    }
	    return null;
	}

  /** 
	 * Magic Missile attack
	 * @param e is the entity Magic Missile is being performed on
	 */
  @Override
	public String magicMissile(Entity e) {
    int damage = (int)(Math.random()*e.getHP()+1);
    e.takeDamage(damage);
		return getName() + " pokes " + e.getName() + " with Magic Missile for " + damage + " damage.";
	}

  /** 
	 * Fireball attack
	 * @param e is the entity Fireball is being performed on
	 */
	@Override
	public String fireball(Entity e) {
    int damage = (int)(Math.random()*e.getHP()+1);
    e.takeDamage(damage);
		return getName() + " blasts " + e.getName() + " with Fireball for " + damage + " damage.";
	}

  /** 
	 * Magic Missile attack
	 * @param e is the entity Magic Missile is being performed on
	 */
	@Override
	public String thunderclap(Entity e) {
    int damage = (int)(Math.random()*e.getHP()+1);
    e.takeDamage(damage);
		return getName() + " zaps " + e.getName() + " with Thunder Clap for " + damage + " damage.";
	}
}