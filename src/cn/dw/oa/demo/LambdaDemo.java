package cn.dw.oa.demo;



class R implements Runnable{

	@Override
	public void run() {
		System.out.println("线程运行的业务逻辑代码。。。。。。");
	}
	
}

public class LambdaDemo {
	
	public static void main(String[] args) {
		new Thread(new R()).start();;
	}
}
