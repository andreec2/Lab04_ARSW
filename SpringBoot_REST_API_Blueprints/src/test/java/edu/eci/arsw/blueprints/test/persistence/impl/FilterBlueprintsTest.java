package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.filter.FilterBlueprints;
import edu.eci.arsw.blueprints.filter.FilterSuprimePoints;
import edu.eci.arsw.blueprints.filter.FilterSuprimePointsRepetitive;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilterBlueprintsTest {

    InMemoryBlueprintPersistence ibpp;

    FilterSuprimePoints fsp;

    FilterSuprimePointsRepetitive fpr;

    @Test
    public void shouldFilterBlueprint() throws BlueprintPersistenceException {
        fsp = new FilterSuprimePoints();
        Blueprint pBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(10, 10), new Point(20, 20), new Point(20, 20), new Point(20, 20)});
        Blueprint resBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(20, 20), new Point(20, 20)});
        fsp.filterBlueprint(pBlueprint);
        List<Point> expected = new ArrayList<>(resBlueprint.getPoints());
        List<Point> result = new ArrayList<>(pBlueprint.getPoints());
        assertEquals(expected, result);
    }

    @Test
    public void shouldFilterBlueprintRepetitive() throws BlueprintPersistenceException {
        fpr = new FilterSuprimePointsRepetitive();
        Blueprint pBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(10, 10), new Point(20, 20), new Point(20, 20), new Point(20, 20)});
        Blueprint resBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(10, 10), new Point(20, 20)});
        fpr.filterBlueprint(pBlueprint);
        List<Point> expected = new ArrayList<>(resBlueprint.getPoints());
        List<Point> result = new ArrayList<>(pBlueprint.getPoints());
        assertEquals(expected, result);
    }



}
