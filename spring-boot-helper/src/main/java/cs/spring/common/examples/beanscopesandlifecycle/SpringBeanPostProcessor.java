package cs.spring.common.examples.beanscopesandlifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object pBean, String pBeanName)
	{
		
		if(pBean instanceof SpringBeanLifeCycle)
		{
			/**
			 * ((SpringBeanLifeCycle) pBean).beforeInit();
			 *  
			 * The above method won't be called from Bean instance when
			 * SpringBeanLifeCycle.java is getting instantiated and because instantiation is not yet completed.
			 * It can only be called from outside of SpringBeanLifeCycle class.
			 * 
			 * https://stackoverflow.com/questions/49492858/beanpostprocessor-is-not-invoked-for-beans-that-are-autowired-as-list-of-map
			 */
			BeanPostProcessHelper.beforeInit();
		}
		return pBean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object pBean, String pBeanName)
	{
		if(pBean instanceof SpringBeanLifeCycle)
		{
			/**
			 * ((SpringBeanLifeCycle) pBean).afterInit();
			 * 
			 * The above method won't be called from Bean instance when
			 * SpringBeanLifeCycle.java is getting instantiated and because instantiation is not yet completed.
			 * It can only be called from outside of SpringBeanLifeCycle class.
			 * 
			 * https://stackoverflow.com/questions/49492858/beanpostprocessor-is-not-invoked-for-beans-that-are-autowired-as-list-of-map
			 */
			BeanPostProcessHelper.afterInit();
		}
		return pBean;
	}

}
