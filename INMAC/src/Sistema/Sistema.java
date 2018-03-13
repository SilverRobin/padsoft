package Sistema;

public class Sistema {

	protected static String gerPass;
	protected static String gerID;
	
	public Sistema singleton;
	
	protected Sistema(String id, String pass) {
		gerID = id;
		gerPass = pass;
	}
}
