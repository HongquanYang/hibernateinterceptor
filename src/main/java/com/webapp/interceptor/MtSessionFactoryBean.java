package com.webapp.interceptor;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.TypeHelper;
import org.hibernate.classic.Session;
import org.hibernate.engine.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

public class MtSessionFactoryBean extends AnnotationSessionFactoryBean {
	private Interceptor defaultInterceptor;
	
	public Interceptor getDefaultInterceptor() {
		return defaultInterceptor;
	}
	public void setDefaultInterceptor(Interceptor defaultInterceptor) {
		this.defaultInterceptor = defaultInterceptor;
	}
	protected SessionFactory wrapSessionFactoryIfNecessary(SessionFactory rawSf) {
		return new MtSessionFactory(rawSf);
	}
	private class MtSessionFactory implements SessionFactory{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final SessionFactory delegateFactory;
		
		public MtSessionFactory(SessionFactory sf){
			this.delegateFactory  = sf;
		}
		public Reference getReference() throws NamingException {
			// TODO Auto-generated method stub
			return delegateFactory.getReference();
		}

		public Session openSession() throws HibernateException {
			// TODO Auto-generated method stub
			return delegateFactory.openSession(defaultInterceptor);
			
		}

		public Session openSession(Interceptor interceptor)
				throws HibernateException {
			// TODO Auto-generated method stub
			return delegateFactory.openSession(interceptor);
		}

		public Session openSession(Connection connection) {
			// TODO Auto-generated method stub
			return delegateFactory.openSession(connection,defaultInterceptor);
		}

		public Session openSession(Connection connection,
				Interceptor interceptor) {
			// TODO Auto-generated method stub
			return delegateFactory.openSession(connection,interceptor);
		}

		public Session getCurrentSession() throws HibernateException {
			// TODO Auto-generated method stub
			return delegateFactory.getCurrentSession();
		}

		public StatelessSession openStatelessSession() {
			// TODO Auto-generated method stub
			return delegateFactory.openStatelessSession();
		}

		public StatelessSession openStatelessSession(Connection connection) {
			// TODO Auto-generated method stub
			return delegateFactory.openStatelessSession(connection);
		}

		public ClassMetadata getClassMetadata(Class entityClass) {
			// TODO Auto-generated method stub
			return delegateFactory.getClassMetadata(entityClass);
		}

		public ClassMetadata getClassMetadata(String entityName) {
			// TODO Auto-generated method stub
			return delegateFactory.getClassMetadata(entityName);
		}

		public CollectionMetadata getCollectionMetadata(String roleName) {
			// TODO Auto-generated method stub
			return delegateFactory.getCollectionMetadata(roleName);
		}

		public Map<String, ClassMetadata> getAllClassMetadata() {
			// TODO Auto-generated method stub
			return delegateFactory.getAllClassMetadata();
		}

		public Map getAllCollectionMetadata() {
			// TODO Auto-generated method stub
			return delegateFactory.getAllCollectionMetadata();
		}

		public Statistics getStatistics() {
			// TODO Auto-generated method stub
			return delegateFactory.getStatistics();
		}

		public void close() throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.close();
		}

		public boolean isClosed() {
			// TODO Auto-generated method stub
			return delegateFactory.isClosed();
		}

		public Cache getCache() {
			// TODO Auto-generated method stub
			return delegateFactory.getCache();
		}

		public void evict(Class persistentClass) throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evict(persistentClass);
			
		}

		public void evict(Class persistentClass, Serializable id)
				throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evict(persistentClass, id);
		}

		public void evictEntity(String entityName) throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evictEntity(entityName);
		}

		public void evictEntity(String entityName, Serializable id)
				throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evictEntity(entityName, id);
		}

		public void evictCollection(String roleName) throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evictCollection(roleName);
		}

		public void evictCollection(String roleName, Serializable id)
				throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evictCollection(roleName, id);
		}

		public void evictQueries(String cacheRegion) throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evictQueries(cacheRegion);
		}

		public void evictQueries() throws HibernateException {
			// TODO Auto-generated method stub
			delegateFactory.evictQueries();
		}

		public Set getDefinedFilterNames() {
			// TODO Auto-generated method stub
			return delegateFactory.getDefinedFilterNames();
		}

		public FilterDefinition getFilterDefinition(String filterName)
				throws HibernateException {
			// TODO Auto-generated method stub
			return delegateFactory.getFilterDefinition(filterName);
		}

		public boolean containsFetchProfileDefinition(String name) {
			// TODO Auto-generated method stub
			return delegateFactory.containsFetchProfileDefinition(name);
		}

		public TypeHelper getTypeHelper() {
			// TODO Auto-generated method stub
			return delegateFactory.getTypeHelper();
		}
		
	}
}
