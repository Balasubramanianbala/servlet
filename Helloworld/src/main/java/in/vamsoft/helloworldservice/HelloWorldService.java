package in.vamsoft.helloworldservice;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldService {

	String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String sayHello() {
		return "Hello" +msg;
	}
}
