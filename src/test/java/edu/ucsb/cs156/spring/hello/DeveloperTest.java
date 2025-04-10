package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // Andrew Z
        assertEquals("Andrew Z.", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubID_return_correct_GithubID() {
        // @andrewzhang0708
        assertEquals("andrewzhang0708", Developer.getGithubId());
    }

    @Test
    public void getTeam_return_correct_Team() {
        Team team = Developer.getTeam();
        assertTrue(team.getMembers().contains("Andrew"), "No Andrew!");
        assertTrue(team.getMembers().contains("Chloe"), "No Chloe!");
        assertTrue(team.getMembers().contains("Ryan"), "No Ryan!");
        assertTrue(team.getMembers().contains("Siddhi"), "No Siddhi!");
        assertTrue(team.getMembers().contains("Karen"), "No Karen!");
        assertTrue(team.getMembers().contains("Shruthi"), "No Shruthi!");
    }
}
