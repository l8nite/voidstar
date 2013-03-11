package edu.sjsu.voidstar.dao.service;


public class ServiceProvider {
//
//	public interface Service {};
//	
//	private static final Map<Class<? extends Service>, Map<Class<? extends DaoService>, DaoService>> providers = new HashMap<>();
//	
//	public static <T extends DaoService> ServiceProviderQueryResult<T> get(Class<T> serviceClass) {
//		return new ServiceProviderQueryResult<T>(serviceClass);
//	}
//	
//	/*
//	 * (non-javadoc)
//	 * API helper class for retrieving a DAO service for a specific interface.
//	 */
//	public static final class ServiceProviderQueryResult <T extends DaoService> {
//		
//		Class<T> daoServiceClass; 
//		public ServiceProviderQueryResult(Class<T> daoServiceClass) {
//			this.daoServiceClass = daoServiceClass;
//		}
//		
//		/*
//		 * Safe cast so long as items are added to the map correctly
//		 */
//		@SuppressWarnings("unchecked")
//		public T forInterface(Class<? extends Service> serviceInterface) {
//			Map<Class<? extends DaoService>, DaoService> provider = providers.get(serviceInterface);
//			return provider != null ? (T) provider.get(daoServiceClass) : null;
//		}
//	}
}
