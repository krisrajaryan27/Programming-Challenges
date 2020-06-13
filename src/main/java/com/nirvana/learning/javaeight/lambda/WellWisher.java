package com.nirvana.learning.javaeight.lambda;

@FunctionalInterface
interface Greeting {
    void greet();
}

class HindiGreeting implements Greeting {

    // Overriding greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Namaste!");
    }
}

class EnglishGreeting implements Greeting {

    // Overriding greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Hello!");
    }
}

public class WellWisher {
    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String[] args) {
        //OOP example
        Greeting hindiGreeting = new HindiGreeting();
        wish(hindiGreeting);
        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting);

        //Anonymous class
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("Ni Hao!");
            }
        });

        //Lambda Expression
        wish(() -> System.out.println("Sat Sri Akal!"));

    }
}
