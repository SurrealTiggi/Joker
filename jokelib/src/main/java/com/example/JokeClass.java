package com.example;

import java.util.Random;

public class JokeClass {

    public String[] mJokes = {
            "My fake plants died because I did not pretend to water them.",
            "I'm against picketing, but I don't know how to show it.","I used to do drugs. I still do, but I used to, too.",
            "I bought a seven dollar pen because I always lose pens and I got sick of not caring.",
            "You know, I'm sick of following my dreams, man. I'm just going to ask where they're going and hook up with 'em later.",
            "My friend asked me if I wanted a frozen banana, I said 'no, but I want a regular banana later, so ... yeah'.",
            "If carrots got you drunk, rabbits would be messed up.",
            "I haven't slept for ten days, because that would be too long.",
            "This shirt is dry-clean only...which means it's dirty.",
            "I wanted to buy a candle holder, but the store didn't have one. So I got a cake.",
            "My fake plants died because I did not pretend to water them.",
            "An escalator can never break: it can only become stairs. You should never see an Escalator " +
                    "Temporarily Out Of Order sign, just Escalator Temporarily Stairs. Sorry for the convenience.",
            "Is a hippopotamus a hippopotamus, or just a really cool Opotamus?",
            "I don't have a girlfriend. But I do know a woman who'd be mad at me for saying that.",
            "A severed foot is the ultimate stocking stuffer"};

    public String getJoke() {
        String fact = "";
        // Randomly select a fact
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(mJokes.length);
        fact = mJokes[randomNum];

        return fact;
    }
}
