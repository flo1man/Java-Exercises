package lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    // Axe
    private static final int AXE_ATTACK = 25;
    private static final int AXE_DURABILITY = 20;

    // Dummy
    private static final int DUMMY_HEALTH = 25;
    private static final int DUMMY_EXPERIENCE = 20;

    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @Before
    public void setUp(){
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    public void testAxeLosesDurabilityAfterAttack(){
        axe.attack(dummy);
        Assert.assertEquals(axe.getDurabilityPoints(), AXE_DURABILITY - 1);
    }

    @Test
    public void testDummyLosesHealthAfterAttack(){
        axe.attack(dummy);
        Assert.assertEquals(dummy.getHealth(), DUMMY_HEALTH - axe.getAttackPoints());
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwWhenAxeHaveNoDurabilityPoints(){
        brokenAxe.attack(dummy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwWhenDummyIsDead(){
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void testDummyExperience(){
        axe.attack(dummy);
        Assert.assertEquals(DUMMY_EXPERIENCE, dummy.giveExperience());
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwWhenGiveExperienceDummyAlive(){
        Assert.assertEquals(DUMMY_EXPERIENCE, dummy.giveExperience());
    }
}