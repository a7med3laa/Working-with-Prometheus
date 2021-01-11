package Testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPerformance {

	private final String USER_AGENT = "Mozilla/5.0";

	private static String Throughput = "http://localhost:9090/api/v1/query?query=irate(node_network_receive_bytes{device=%22wlp2s0%22}[5m])";
	private static String CPU_Utlization = "http://localhost:9090/api/v1/query?query=100%20-%20(avg%20by%20(instance)%20(irate(node_cpu{job=%22node%22,mode=%22idle%22}[1m]))%20*%20100)";
	private static String Active_Memory = "http://localhost:9090/api/v1/query?query=node_memory_Active";
	private static String Load_Average = "http://localhost:9090/api/v1/query?query=node_load5";

	// ArrayList<Metric> Metrics;
	// AppendToFile file;
	// ExcelWriter Exel;

	public TestPerformance() {
		// Exel = new ExcelWriter();
	}

	public void runTest(int iteration) throws Exception {

		System.out.println("Start Testing..");
		System.out.println("-------------------------------");

		// TimeUnit.MINUTES.sleep(1);
		// TimeUnit.SECONDS.sleep(20);

		System.out.println("Testing iteration number " + iteration + " Send Http GET requests\n");

		Metric test = new Metric();
		double throughput = Double.parseDouble(sendGet(Throughput));
		double CPU = Double.parseDouble(sendGet(CPU_Utlization));
		double mem = Double.parseDouble(sendGet(Active_Memory));
		double loud = Double.parseDouble(sendGet(Load_Average));

		test.setThroughput(throughput);
		test.setCPU(CPU);
		test.setMemory(mem);
		test.setLoad(loud);

		System.out.println("Throughput is = " + throughput + " KB/sec");
		System.out.println("CPU Utilization = " + CPU + " KB");
		System.out.println("Load Average = " + loud + " KB");
		System.out.println("Active Memory = " + mem + " KB");

		// Exel.writeMetric(test);
	}

	// HTTP GET request
	private String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		// int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode+"\n");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {

			response.append(inputLine);

		}
		in.close();

		String delims = "," + "\""; // so the delimiters are: ,&"
		inputLine = response.toString();
		String[] tokens = inputLine.split(delims);
		String result = tokens[tokens.length - 1].split("\"")[0];

		// print HTTP response
		// System.out.println("HTTP response is " + inputLine);

		return result;
	}
	/*
	 * public void WriteToFile() { file = new AppendToFile("Test Result.txt"); for
	 * (int i = 0; i < Metrics.size(); i++) { file.Writter("Testing number " + i);
	 * file.Writter("---------------------------------");
	 * file.Writter("Throughput is = " + Metrics.get(i).getThroughput() +
	 * " KB/sec");
	 * 
	 * file.Writter("CPU Utilization = " + Metrics.get(i).getCPU() + " KB");
	 * 
	 * file.Writter("Active Memory = " + Metrics.get(i).getMemory() + " KB");
	 * 
	 * file.Writter("Load Average = " + Metrics.get(i).getLoad() + " KB"); }
	 * getAverage(); }
	 * 
	 * private void getAverage() {
	 * 
	 * double res; double ith = 0; double icpu = 0; double iload = 0; double imem =
	 * 0; for (int i = 0; i < Metrics.size(); i++) { ith +=
	 * Metrics.get(i).getThroughput(); icpu += Metrics.get(i).getCPU(); iload +=
	 * Metrics.get(i).getLoad(); imem += Metrics.get(i).getMemory(); }
	 * 
	 * System.out.println("\nAverage of all testing ");
	 * System.out.println("-------------------------------");
	 * file.Writter("Average of all testing");
	 * file.Writter("---------------------------------"); res = ith /
	 * Metrics.size(); System.out.println("Throughput is = " + res + " KB/sec");
	 * file.Writter("Throughput is = " + res + " KB/sec"); res = icpu /
	 * Metrics.size(); System.out.println("CPU Utilization = " + res + " KB");
	 * file.Writter("CPU Utilization = " + res + " KB"); res = imem /
	 * Metrics.size(); System.out.println("Active Memory = " + res + " KB");
	 * file.Writter("Active Memory = " + res + " KB"); res = iload / Metrics.size();
	 * System.out.println("Load Average = " + res + " KB");
	 * file.Writter("Load Average = " + res + " KB");
	 * 
	 * }
	 */
}