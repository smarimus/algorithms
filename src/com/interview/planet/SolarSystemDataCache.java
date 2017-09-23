/*package com.interview.planet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SolarSystemDataCache implements Runnable {
    
    private SolarSystem solarSystem;
    private Map<String,Planet> planetMap;

    private DataLoader dataLoader = null;

// to be called periodically by a cache update thread
    public void refreshOriginal() {
        Map<String,Planet> tmpPlanetMap = new 
            HashMap<String,Planet>();

        // get planet data (returns NEW Planet objects)
        Planet[] planets = dataLoader.getPlanets();
        for( Planet planet : planets ) {
            planet.solarSystem = this.solarSystem;
            tmpPlanetMap.put( planet.name, planet );
        }

        // assign after all planets have been updated
        this.planetMap = tmpPlanetMap;

        // get solar system data (returns NEW SolarSystem object)
        SolarSystem tmpSolarSystem = dataLoader.getSolarSystem();
        tmpSolarSystem.planetMap = this.planetMap;
        this.solarSystem = tmpSolarSystem;
    }


    // to be called periodically by a cache update thread
    public void refresh() {
         planetMap = new ConcurrentHashMap<String,Planet>();

        // get planet data (returns NEW Planet objects)
        Planet[] planets = dataLoader.getPlanets();
        for( Planet planet : planets ) {
            tmpPlanetMap.put( planet.name, planet );
        }

        // get solar system data (returns NEW SolarSystem object)
        solarSystem = dataLoader.getSolarSystem();
        solarSystem.planetMap = planetMap;

    }

 outside threads will be able to modify map after this call 
    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public Planet getPlanet( String planetName ) {
        return this.planetMap.get(planetName);
    }

    public void run() {
        while(true) {
            self.refresh();
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }



}

*/