/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class InMemoryPersistenceTest {

    InMemoryBlueprintPersistence ibpp;

    
    @Test
    public void saveNewAndLoadTest() throws BlueprintPersistenceException, BlueprintNotFoundException{
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        ibpp.saveBlueprint(bp0);
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        ibpp.saveBlueprint(bp);
        
        assertNotNull("Loading a previously stored blueprint returned null.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()));
        
        assertEquals("Loading a previously stored blueprint returned a different blueprint.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bp);
        
    }


    @Test
    public void saveExistingBpTest() {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        try {
            ibpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException ex) {
            fail("Blueprint persistence failed inserting the first blueprint.");
        }
        
        Point[] pts2=new Point[]{new Point(10, 10),new Point(20, 20)};
        Blueprint bp2=new Blueprint("john", "thepaint",pts2);

        try{
            ibpp.saveBlueprint(bp2);
            fail("An exception was expected after saving a second blueprint with the same name and autor");
        }
        catch (BlueprintPersistenceException ex){
            
        }

    }

    @Test
    public void shouldGetBlueprint() throws BlueprintNotFoundException, BlueprintPersistenceException {
        ibpp = new InMemoryBlueprintPersistence();

        // Verificar que el blueprint que debería existir se puede recuperar
        Blueprint expectedBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(10, 10), new Point(20, 20)});

        // Guardar el blueprint en la instancia de prueba
        ibpp.saveBlueprint(expectedBlueprint);

        // Obtener el blueprint
        Blueprint retrievedBlueprint = ibpp.getBlueprint("John", "HousePlan");

        // Verificar que el blueprint recuperado es el esperado
        assertEquals("El blueprint recuperado debería ser igual al esperado", expectedBlueprint, retrievedBlueprint);
    }

    @Test
    public void shouldGetBlueprintsByAuthor() throws BlueprintPersistenceException, BlueprintNotFoundException {
        ibpp = new InMemoryBlueprintPersistence();
        Set<Blueprint> authorBlueprints = new HashSet<>();


        // Verificar que el blueprint que debería existir se puede recuperar
        Blueprint expectedBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(10, 10), new Point(20, 20)});
        authorBlueprints.add(expectedBlueprint);

        // Guardar el blueprint en la instancia de prueba
        ibpp.saveBlueprint(expectedBlueprint);

        assertEquals("La lista de blueprint guardado debe ser igual a la del autpr",authorBlueprints, ibpp.getBlueprintsByAuthor("John"));

    }

    @Test
    public void shouldGetAllBlueprints() throws BlueprintPersistenceException {
        ibpp = new InMemoryBlueprintPersistence();

        Blueprint expectedBlueprint = new Blueprint("John", "HousePlan", new Point[]{new Point(10, 10), new Point(20, 20)});

        //Agregar el el blueprint a la instancia de prueba
        ibpp.saveBlueprint(expectedBlueprint);

        assertEquals(2, ibpp.getAllBlueprints().size());

    }


    
}
