// Prototype interface (type-safe)
interface Prototype<T> {
    T clone();
}

class NPC implements Prototype<NPC> {
    private String name;
    private int health;
    private int attack;
    private int defense;

    public NPC(String name, int health, int attack, int defense) {
        // Simulate heavy setup
        System.out.println("Setting up template NPC '" + name + "'");
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    // Copy constructor
    public NPC(NPC other) {
        System.out.println("Cloning NPC '" + other.name + "'");
        this.name = other.name;
        this.health = other.health;
        this.attack = other.attack;
        this.defense = other.defense;
    }

    @Override
    public NPC clone() {
        return new NPC(this);
    }

    public void describe() {
        System.out.println("NPC " + name + " [HP=" + health + 
                           " ATK=" + attack + " DEF=" + defense + "]");
    }

    // Setters
    public void setName(String n) { name = n; }
    public void setHealth(int h) { health = h; }
    public void setAttack(int a) { attack = a; }
    public void setDefense(int d) { defense = d; }
}

public class PrototypePattern {
    public static void main(String[] args) {
        NPC alien = new NPC("Alien", 30, 5, 2);

        NPC alienCopy1 = alien.clone();
        alienCopy1.describe();

        NPC alienCopy2 = alien.clone();
        alienCopy2.setName("Powerful Alien");
        alienCopy2.setHealth(50);
        alienCopy2.describe();
    }
}
