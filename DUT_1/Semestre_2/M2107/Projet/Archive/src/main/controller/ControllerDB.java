package controller;

import model.InitJDBC;

/**
 * This class check the connection to the DataBase
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class ControllerDB {

	/**
	 * The InitJDBC object who initiate the connection
	 */
	private InitJDBC initJdbc;
	
	/**
	 * Check the connection to the DataBase
	 * @param base The name of the DataBase
	 */
	public ControllerDB(String base){
		this.initJdbc = new InitJDBC(base);
	}

	/**
	 * Give the InitJDBC object
	 * @return The initJdbc Object
	 */
	public InitJDBC getInitJdbc() {
		return initJdbc;
	}
	
}
