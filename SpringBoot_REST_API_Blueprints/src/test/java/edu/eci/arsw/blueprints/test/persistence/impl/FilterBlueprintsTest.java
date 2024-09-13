package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.filter.FilterBlueprints;
import edu.eci.arsw.blueprints.filter.FilterSuprimePoints;
import edu.eci.arsw.blueprints.filter.FilterSuprimePointsRepetitive;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import org.junit.Test;

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
        assertEquals(pBlueprint, resBlueprint);
    }
}
