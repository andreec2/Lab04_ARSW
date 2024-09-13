/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author hcadavid
 */
@Service
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final Map<Tuple<String,String>,Blueprint> blueprints=new HashMap<>();

    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts=new Point[]{new Point(140, 140),new Point(115, 115),new Point(115, 115), new Point(140, 140), new Point(140, 140)};
        Point[] points = new Point[]{new Point(10, 10), new Point(20, 20)};
        Blueprint bp=new Blueprint("_authorname_", "_bpname_ ",pts);
        //Blueprint an=new Blueprint("andres","MyPlane", pts);
        //Blueprint jp=new Blueprint("juan","MyBook", points);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        //blueprints.put(new Tuple<>(an.getAuthor(),an.getName()), an);
        //blueprints.put(new Tuple<>(jp.getAuthor(),jp.getName()), jp);
    }    
    
    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
            throw new BlueprintPersistenceException("The given blueprint already exists: " +bp);
        }
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        Blueprint bpt = blueprints.get(new Tuple<>(author, bprintname));
        if (bpt == null) {
            throw new BlueprintNotFoundException("Blueprint not found for author: " + author + " and name: " + bprintname);
        }
        return bpt;
    }


    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> authorBlueprints = new HashSet<>();

        // Recorrer el Map buscando los Blueprints del autor
        for (Map.Entry<Tuple<String, String>, Blueprint> entry : blueprints.entrySet()) {
            if (entry.getKey() != null && entry.getKey().first != null && entry.getKey().first.equals(author)) {
                authorBlueprints.add(entry.getValue());
            }
        }

        if (authorBlueprints.isEmpty()) {
            throw new BlueprintNotFoundException("No blueprints found for author: " + author);
        }

        return authorBlueprints;
    }

    @Override
    public Set<Blueprint> getAllBlueprints() {
        return new HashSet<>(blueprints.values());
    }


}
