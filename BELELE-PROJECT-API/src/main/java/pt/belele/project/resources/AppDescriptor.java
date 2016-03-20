/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author P056913
 */
@ApplicationPath("belele")
public class AppDescriptor extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public AppDescriptor() {
	singletons.add(new BetResourceImpl());
	singletons.add(new SeasonResourceImpl());
	singletons.add(new MiscResourceImpl());
    }

    @Override
    public Set<Class<?>> getClasses() {
	return empty;
    }

    @Override
    public Set<Object> getSingletons() {
	return singletons;
    }
}
