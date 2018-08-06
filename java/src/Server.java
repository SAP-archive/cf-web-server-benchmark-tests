import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

	public static void main(String[] args) throws Exception {
		String port = System.getenv("PORT") != null ? System.getenv("PORT") : "8000";
		HttpServer server = HttpServer.create(new InetSocketAddress(Integer.parseInt(port)), 0);
		server.createContext("/", new HelloHandler());
		server.createContext("/fibonacci", new FibonacciHandler());
		server.createContext("/random", new RandomHandler());
		server.setExecutor(null);
		server.start();
	}

	static class HelloHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String res = "Hello SAP Cloud Platform!";

			t.sendResponseHeaders(200, res.length());
			OutputStream os = t.getResponseBody();
			os.write(res.getBytes());
			os.close();
		}
	}

	static class FibonacciHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String res = "";
			
			Fib fibo = new Fib();

			for (int i = 0; i < 75; i++) {
				res += (fibo.getNext());
				res += ('\n');
			}

			t.sendResponseHeaders(200, res.length());
			OutputStream os = t.getResponseBody();
			os.write(res.getBytes());
			os.close();
		}
	}

	static class RandomHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String res = "" + Math.random() ;

			t.sendResponseHeaders(200, res.length());
			OutputStream os = t.getResponseBody();
			os.write(res.getBytes());
			os.close();
		}
	}
}

class Fib {
	private long x = 0L;
	private long y = 1L;

	public long getNext() {
		long temp = x;
		x = y;
		y = temp + y;
		return x;
	}
}
