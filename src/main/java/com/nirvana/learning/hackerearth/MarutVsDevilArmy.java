package com.nirvana.learning.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement
 * -----------------------
 * Marut is great warrior. Marut loves his girlfriend Shizuka very much. Being jealous from Marut's love, the Devil kidnaps his girlfriend. Hence, Marut declares a war against the Devil. The devil decides to send his army men one by one to fight with Marut. Marut being a smart person, he has a secret energy booster named "CodeRas". If Marut drinks "CodeRas" one time, his energy increases by V unit. Marut has an infinite amount of "CodeRas".
 * Each army man does some damage to Marut. If an army man has X amount energy and fights with Marut, energy of both of them will decrease by X unit. A person dies if his energy becomes zero unit.
 * Now, Marut knows the number of army men that Devil will send and their energy level. As poor Marut is bad in mathematics, he wants to know the minimum number of times he need to drink "CodeRas" in order to kill all army men and keep himself alive at the end of war. Help him !!!
 * Note: Marut cannot drink "CodeRas" in between the fight. He can only drink it before and after the fight.
 * <p>
 * Input:
 * First line contains an integer T, denoting the number of test cases.
 * Each testcase contains two lines.
 * First line of each testcase contains three integers N , E and V separated by single space. N denotes the size of army, E denotes the initial energy of Marut and V denotes the amount of energy which is increased after drinking "CodeRas".
 * Second line of each testcase contains N integers, separated by single space. ith integer of this line denotes the energy of ith army man.
 * <p>
 * Output:
 * For each test case, print the answer in a new line.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 105
 * 1 ≤ E ≤ 105
 * 1 ≤ V ≤ 105
 * 1 ≤ Army man's energy ≤ 105
 * <p>
 * SAMPLE INPUT
 * 2
 * 4 5 3
 * 1 4 5 1
 * 5 2 2
 * 5 1 3 1 2
 * SAMPLE OUTPUT
 * 3
 * 6
 * Explanation
 * In the first testcase, Initial enery of Marut is 5. He fights with the first man. His energy becomes 4. Now he faces a man of energy level 4, same as him. If he would not drink "CodeRas", his energy will become 0 and he would die. Hence he drinks it and increases his energy level to 7. He fights with him and his energy level becomes 3. Again, he drinks "CodeRas" and fights. After fighting, his energy level becomes 1. As he has to remain alive at the end of the game, he again drinks it and fights. So total number of times he drinks it is 3.
 * In the second testcase, for the first man, he drinks it 2 times and for the rest of the man, he drinks it 1 time. Hence total number of times, he drinks it is 6.
 */
public class MarutVsDevilArmy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int noOfTestCases = Integer.parseInt(br.readLine());
        int totalArmy, energy, energyBoost, currentArmyEnergy, i, x;
        long boostTime;
        while (noOfTestCases > 0) {
            String[] s = br.readLine().split("\\s");
            totalArmy = Integer.parseInt(s[0]);
            energy = Integer.parseInt(s[1]);
            energyBoost = Integer.parseInt(s[2]);
            s = br.readLine().split("\\s");
            boostTime = 0;
            currentArmyEnergy = 0;

            for (i = 0; i < totalArmy; i++) {
                currentArmyEnergy = Integer.parseInt(s[i]);
                if (currentArmyEnergy >= energy) {
                    x = (currentArmyEnergy - energy) / energyBoost;
                    x += 1;
                    energy += (energyBoost * x);
                    boostTime += x;
                }
                energy -= currentArmyEnergy;
            }
            System.out.println(boostTime);
            noOfTestCases--;
        }
    }
}
