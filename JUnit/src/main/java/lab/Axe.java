package lab;

public class Axe {
    private int attackPoints;
    private int durabilityPoints;

    public Axe(int attackPoints, int durabilityPoints) {
        this.attackPoints = attackPoints;
        this.durabilityPoints = durabilityPoints;
    }

    public int getAttackPoints() { return this.attackPoints;}

    public int getDurabilityPoints() { return this.durabilityPoints;}

    public void attack(Dummy target){
        if (this.durabilityPoints <= 0){
            throw new IllegalArgumentException("Axe is broken");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints--;
    }
}

