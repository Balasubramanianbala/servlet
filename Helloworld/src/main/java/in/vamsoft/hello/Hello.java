package in.vamsoft.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.vamsoft.helloworldservice.HelloWorldService;

public class Hello {

		@SuppressWarnings("resource")
		public static void main(String[] args) {
			
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			HelloWorldService service=(HelloWorldService) context.getBean("helloWorldService");
			String msg=service.sayHello();
			System.out.println(msg);
			service.setMsg("Spring ");
			msg=service.sayHello();
			System.out.println(msg);
		}
}
