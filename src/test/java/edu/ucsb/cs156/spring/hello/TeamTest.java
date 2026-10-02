package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertEquals(false, team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team other = new Team("test-team");
        assertEquals(true, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team other = new Team("different-team");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team other = new Team("test-team");
        other.addMember("Grace");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void hashCode_same_for_equal_objects() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");

        int result = t.hashCode();
        int expectedResult = 130294;

        assertEquals(expectedResult, result);
    }

}
