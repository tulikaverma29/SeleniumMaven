package automationProject;

import java.util.HashMap;

class MRSSiteRegistrationCalling {

	public static void main(String[] args) throws InterruptedException {
		// parameter for manual run or automatic run.
		// Set blnManual = false for automatic run
		// Set blnManual = true for manual run
		Boolean blnManual = false;
		HashMap <String,String> expectedHMap;

		// Login
		MRSSiteRegistrationManualAuto obj = new MRSSiteRegistrationManualAuto();
		Boolean blnLoginSuccess = obj.loginSite("Admin", "Admin123");

		// If Login is successful then Register Patient Manual or Automate
		System.out.println("Login Success = " + blnLoginSuccess);
		if (blnLoginSuccess) {
			if (blnManual == false) {
				// Register Patient Automatically
				expectedHMap =obj.RegisterAutomate( blnLoginSuccess);
			} else {
				// Register Patient Manually
				expectedHMap= obj.RegisterManual( blnLoginSuccess);
			}
			System.out.println("test3" + expectedHMap.get("Identifier"));
			obj.logout(blnLoginSuccess);
		}
		// Log out
		obj.DriverQuit();
	}

}
