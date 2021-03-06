/*
 *  (c) 2012 University of Bolton
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.edukapp.server.configuration;

import java.util.HashSet;
import java.util.Set;

//Jackson imports
import org.apache.wink.providers.jackson.WinkJacksonJaxbJsonProvider;

import javax.ws.rs.core.Application;

public class WinkJacksonApplication extends Application {

	
	
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> services = new HashSet<Class<?>>();
		services.add(uk.ac.edukapp.servlets.pojos.Widgets.class);
		services.add(uk.ac.edukapp.servlets.pojos.Users.class);
		//services.add(uk.ac.edukapp.servlets.pojos.Annotations.class);
		services.add(uk.ac.edukapp.servlets.pojos.Creator.class);
		services.add(uk.ac.edukapp.servlets.pojos.Reviews.class);
		services.add(uk.ac.edukapp.servlets.pojos.Tags.class);
		services.add(uk.ac.edukapp.servlets.pojos.Ratings.class);
		services.add(uk.ac.edukapp.servlets.pojos.Functionalities.class);
		services.add(uk.ac.edukapp.servlets.pojos.Stats.class);
		services.add(uk.ac.edukapp.servlets.pojos.Categories.class);
		return services;
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getSingletons()
	 */
	@Override
	public Set<Object> getSingletons() {
		WinkJacksonJaxbJsonProvider p = new WinkJacksonJaxbJsonProvider();

		Set<Object> s = new HashSet<Object>();
		s.add(p);
		return s;
	}
	
	
}
