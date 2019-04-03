package com.nirvana.learning;

import com.nirvana.learning.enums.MatchType;
import com.nirvana.learning.enums.Teams;
import com.nirvana.learning.enums.TossType;
import com.nirvana.learning.enums.WeatherType;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class TossConditions {

    private static TossConditions instance = new TossConditions();

    private static Map<AbstractMap.SimpleEntry<Teams,WeatherType>, TossType> tossWeatherMatix;
    private static Map<AbstractMap.SimpleEntry<Teams, MatchType>,TossType> tossDayMatrix;

    private static void buildMap(){
        tossWeatherMatix = new HashMap<AbstractMap.SimpleEntry<Teams, WeatherType>, TossType>();
        tossDayMatrix = new HashMap<AbstractMap.SimpleEntry<Teams, MatchType>, TossType>();
        tossWeatherMatix.put(new AbstractMap.SimpleEntry<>(Teams.LENGABURU, WeatherType.CLEAR),TossType.BATS);
        tossWeatherMatix.put(new AbstractMap.SimpleEntry<>(Teams.LENGABURU, WeatherType.CLOUDY),TossType.BOWLS);
        tossWeatherMatix.put(new AbstractMap.SimpleEntry<>(Teams.ENCHAI, WeatherType.CLEAR),TossType.BOWLS);
        tossWeatherMatix.put(new AbstractMap.SimpleEntry<>(Teams.ENCHAI, WeatherType.CLOUDY),TossType.BATS);

        tossDayMatrix.put(new AbstractMap.SimpleEntry<>(Teams.LENGABURU, MatchType.DAY),TossType.BATS);
        tossDayMatrix.put(new AbstractMap.SimpleEntry<>(Teams.LENGABURU, MatchType.NIGHT),TossType.BOWLS);
        tossDayMatrix.put(new AbstractMap.SimpleEntry<>(Teams.ENCHAI, MatchType.DAY),TossType.BOWLS);
        tossDayMatrix.put(new AbstractMap.SimpleEntry<>(Teams.ENCHAI, MatchType.NIGHT),TossType.BATS);

    }

    private Integer evaluateToss(Teams teams, String [] inputs){
        Integer type = 0;
        for(String input: inputs){
            WeatherType[] weatherTypes = WeatherType.values();
            for(WeatherType weatherType : weatherTypes){
                if(weatherType.toString().equalsIgnoreCase(input)){
                    if(tossWeatherMatix.containsKey(new AbstractMap.SimpleEntry<>(teams, weatherType)))
                        type = tossWeatherMatix.get(new AbstractMap.SimpleEntry<>(teams, weatherType)).ordinal();
                    break;

                }
            }

            MatchType[] matchTypes = MatchType.values();
            for(MatchType matchType : matchTypes){
                if(matchType.toString().equalsIgnoreCase(input)){
                    if(tossDayMatrix.containsKey(new AbstractMap.SimpleEntry<>(teams, matchType)))
                        type |= tossDayMatrix.get(new AbstractMap.SimpleEntry<>(teams, matchType)).ordinal();
                    break;
                }
            }
        }
        return type;
    }

    public static TossConditions getInstance(){
        if(tossWeatherMatix == null)
            buildMap();
        return instance;
    }

    public String getTossResult(Teams teams, String ... inputs){
        String outputFormat = "%s wins toss and %s";
        int tossResult = evaluateToss(teams, inputs);
        return String.format(outputFormat, teams.toString(),  TossType.values()[tossResult].name().toLowerCase());
    }

}
