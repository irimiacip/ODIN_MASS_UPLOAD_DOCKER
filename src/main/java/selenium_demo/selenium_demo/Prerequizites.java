package selenium_demo.selenium_demo;

import java.io.File;

public class Prerequizites {

	public static void runcurl() {

		String x = "/tmp/DeliveryFlagMassUpload.csv https://raw.githubusercontent.com/irimiacip/ODIN_SOURCEFILE/master/DeliveryFlagMassUpload.csv";
		String y = "/home/ciprian/Downloads/test/1.csv https://raw.githubusercontent.com/irimiacip/ODIN_SOURCEFILE/master/DeliveryFlagMassUpload.csv";

		try {
			// System.out.println("afisare user" + x);
			Process process = Runtime.getRuntime().exec("curl -o" + " " + x);
			File f = new File("/tmp/DeliveryFlagMassUpload.csv");
			System.out.println("verificatre fisier downloadat : " + f.exists());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void runcurltest() {

		String xxx = System.getProperty("var");

		String x = "/tmp/" + xxx + " " + "https://raw.githubusercontent.com/irimiacip/ODIN_SOURCEFILE/master/" + xxx;
		String y = "/home/ciprian/Downloads/test/1.csv https://raw.githubusercontent.com/irimiacip/ODIN_SOURCEFILE/master/DeliveryFlagMassUpload.csv";

		try {
			// System.out.println("afisare user" + x);
			Process process = Runtime.getRuntime().exec("curl -o" + " " + x);
			File f = new File("/tmp/" + xxx);
			System.out.println("verificatre fisier downloadat : " + f.exists());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getUserName() {
		return System.getProperty("user.name");

	}
}
