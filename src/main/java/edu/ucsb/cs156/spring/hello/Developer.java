package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        // Andrew Z.
        return "Andrew Z.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        // andrewzhang0708
        return "andrewzhang0708";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        // team 14
        Team team = new Team("s25-14");
        team.addMember("Andrew");
        team.addMember("Chloe");
        team.addMember("Karen");
        team.addMember("Ryan");
        team.addMember("Shruthi");
        team.addMember("Siddhi");
        return team;
    }
}
