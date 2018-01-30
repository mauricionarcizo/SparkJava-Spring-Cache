package sparkteste;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class WebConfig {

	private MyService service;

	public WebConfig(final MyService service) {
		this.service = service;
		staticFileLocation("/public");

		get("/hello", (req, res) -> {
			Thread.sleep(1000);
			this.service.run();
			return "Hello teste!";
		});

		System.out.println(this.service);
	}

}
