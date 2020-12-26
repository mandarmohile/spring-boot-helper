package cs.spring.common.examples.beanscopesandlifecycle;

public class BeanPostProcessHelper {
	
	public static void beforeInit() {
		System.out.println("BeanPostProcessor.postProcessBeforeInitialization() called");
	}
	
	public static void afterInit() {
		System.out.println("BeanPostProcessor.postProcessAfterInitialization() called");
	}
	
}
