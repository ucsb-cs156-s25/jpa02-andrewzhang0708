package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TeamTest {

    Team team;
    ArrayList<String> memberString = new ArrayList<String>();

    @BeforeEach
    public void setup() {
        team = new Team("test-team");   
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test 
    public void setName_correctly_sets() {
        team.setName("TestTeam");
        assert(team.getName().equals("TestTeam"));
    }

    @Test
    public void setMembers_correctly_sets() {
        memberString.add("Justin");
        team.setMembers(memberString);
        assertTrue(team.getMembers().contains("Justin"), "Set members is not working correctly.");
    }

    @Test
    public void toString_test() {
        assertEquals(team.toString(), "Team(name=test-team, members=[])");
        team.addMember("Justin");
        team.setName("Big");
        assertEquals(team.toString(), "Team(name=Big, members=[Justin])");
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void hashCode_test() {
        Team t1 = new Team();
        Team t2 = new Team();
        t1.addMember("Justin");
        assertEquals(t1.hashCode(), -2064817328);
        t2.addMember("Justin");
        t1.setName("Mango");
        t2.setName("Mango");
        assertEquals(t1.hashCode(), t2.hashCode());
        t2.setName("Strawberry");
        assertTrue(t1.hashCode() != t2.hashCode());
    }

    @Test 
    public void equals_test() {
        Team t1 = new Team();
        Team t2 = new Team();
        t1.addMember("Justin");
        t2.addMember("Justin");
        t1.setName("Mango");
        t2.setName("Mango");
        assertTrue(t1.equals(t2));
        assertTrue(t1.equals(t1));
        assertTrue(!t1.equals(memberString));
        t2.setName("Strawberry");
        assertTrue(!t1.equals(t2));
        t2.addMember("Keanu");
        assertTrue(!t1.equals(t2));
        t2.setName("Mango");
        assertTrue(!t1.equals(t2));
    }

}
