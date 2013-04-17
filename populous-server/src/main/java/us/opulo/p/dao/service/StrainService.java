package us.opulo.p.dao.service;

import java.util.List;

import us.opulo.p.dao.Strain;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * A service interface for the Strain table. Implementing classes serve the requested object(s) 
 * in a means consistent with the interface. For example, XServiceSoap would service requests 
 * on the SOAP protocol.
 * 
 * @author Jason Campos
 */
public interface StrainService extends RemoteService {
	
	/**
	 * @return All Strains
	 */
	List<Strain> getAllStrains();
	
	/**
	 * Retrives a list of all descendents of the argument strain. No descendent heirarchy is implied by the order of the list.
	 * @param strain The Strain for which to retrieve the descendents
	 * @return A List of Strains which descended from the argument strain
	 */
	List<Strain> getDescendentStrains(Strain strain);
	
	/**
	 * Retrives a list of all children of the argument strain.
	 * @param strain The Strain for which to retrieve all children
	 * @return A List of Strains which are children of the argument strain
	 */
	List<Strain> getChildStrains(Strain strain);
	
	/**
	 * Retrives a list of all ancestors of the argument strain. No ancestor heirarchy is implied by the order of the list.
	 * @param strain The Strain for which to retrieve the ancestors
	 * @return A List of Strains which are ancestors to the argument Strain
	 */
	List<Strain> getAncestorStrains(Strain strain);
	
	/**
	 * Retrives a list of all parents of the argument strain.
	 * @param strain The Strain for which to retrieve the parents
	 * @return A List of Strains which parented the argument strain
	 */
	List<Strain> getParentStrains(Strain strain);
	
	/**
	 * Retrieves the Strain which matches the argument ID
	 * @param id The ID of the Strain to retrieve.
	 * @return The Strain which matches the argument ID
	 */
	Strain getStrainById(Integer id);
	
	/**
	 * Retrieves the Strain with the argument name
	 * @param name The name of the Strain to retreive
	 * @return The Strain which matches the argument name.
	 */
	Strain getStrainByName(String name);
	
}
