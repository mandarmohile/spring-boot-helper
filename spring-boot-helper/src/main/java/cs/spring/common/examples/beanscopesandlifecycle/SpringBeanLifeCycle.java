package cs.spring.common.examples.beanscopesandlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, 
InitializingBean, DisposableBean {
	
	public SpringBeanLifeCycle() {
		System.out.println("Constructor of SpringBeanLifeCycle class called. SpringBeanLifeCycle class constructed.");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() called");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		System.out.println("BeanFactoryAware.setBeanFactory() called");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		System.out.println("BeanApplicationContextAware.setApplicationContext() called");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("@PostConstruct annotation called");
	}
	
	/*
	 * This method won't be called from BeanPostProcessor instance when
	 * SpringBeanLifeCycle.java is getting instantiated and because instantiation is not yet completed.
	 * It can only be called from outside of SpringBeanLifeCycle class.
	 * 
	 * https://stackoverflow.com/questions/49492858/beanpostprocessor-is-not-invoked-for-beans-that-are-autowired-as-list-of-map
	 */
	public void beforeInit() {
		System.out.println("BeanPostProcessor.postProcessBeforeInitialization() called");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() called");
	}
	
	/*
	 * This method won't be called from BeanPostProcessor instance when
	 * SpringBeanLifeCycle.java is getting instantiated and because instantiation is not yet completed.
	 * It can only be called from outside of SpringBeanLifeCycle class.
	 * 
	 * https://stackoverflow.com/questions/49492858/beanpostprocessor-is-not-invoked-for-beans-that-are-autowired-as-list-of-map
	 */
	public void afterInit() {
		System.out.println("BeanPostProcessor.postProcessAfterInitialization() called");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy annotation called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy() called");
	}
	
}

/**
 * Spring Bean Scopes :
 * The most widely used :
 * Singleton
 * Prototype
 * 
 * The following scopes are valid only in context of web-aware Spring ApplicationContext :
 * Request : Single instance per http request. 
 * Session : Single instance per http session.
 * Global Session : Works in case of Portlet context (Legacy).
 * Application : Bean is scoped to the life-cycle of ServletContext.
 * Websocket : Scopes a single bean definition to the lifecycle of a web-socket.
 * 
 * Spring Scopes are extensible and one can define their own scope by implementing the Scope interface.
 * One cannot override the built in Singleton and Prototype scopes.
 * 
 * Whenever working with Bean scopes and using any web-aware scope, singletons won't give the desired result since any
 * web-aware bean shall be injected when the singleton-scoped bean are instantiated. Prototype is the way to go.
 */