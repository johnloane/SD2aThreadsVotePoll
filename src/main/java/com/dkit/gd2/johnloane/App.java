package com.dkit.gd2.johnloane;

import java.util.ArrayList;

/**
 * a) A Poll is composed of a question, an ArrayList of answers (all text) and an ArrayList of numbers of votes for each possible answer. Write a Poll class to model this e.g Question - "What is the best programming language in the world ever?", Options - "Java", "C++", "Python", "Javascript", "Php", Votes - 3, 0, 1, 0,0
 * b) Write a VoterThread class that takes in a shared Poll object and cast 100 random votes. It should wait a random amount of time between each votes
 * c) Write a VotingBooth class that creates a Poll object and share the Poll object with 10 VoterThreads. When the 10 VoterThreads complete print the result of the Poll
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Voter Threads" );
        Poll bestProgrammingLanguagePoll = createPoll();
        Thread voterThread = new Thread(new VoterThread(bestProgrammingLanguagePoll));
        voterThread.start();

        try
        {
            voterThread.join();
            System.out.println(bestProgrammingLanguagePoll.getVotes());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    private static Poll createPoll()
    {
        ArrayList<String> options = new ArrayList<>();
        options.add("Java");
        options.add("C++");
        options.add("Python");
        Poll poll = new Poll("What is the best programming language?", options);
        return poll;
    }
}
