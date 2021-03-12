package com.dkit.gd2.johnloane;

import java.util.concurrent.ThreadLocalRandom;

public class VoterThread implements Runnable
{
    private Poll poll;

    public VoterThread(Poll poll)
    {
        this.poll = poll;
    }

    @Override
    public void run()
    {
        //Cast 100 votes at random and sleep for random amount of time between each vote
        for(int i=0; i < 100; i++)
        {
            castRandomVote();
            int randomSleepTime = ThreadLocalRandom.current().nextInt(0, 100);
            try
            {
                Thread.currentThread().sleep(randomSleepTime);
            } catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }


    }

    private void castRandomVote()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(0, this.poll.getOptions().size());
        this.poll.castVote(randomNum);
    }
}
