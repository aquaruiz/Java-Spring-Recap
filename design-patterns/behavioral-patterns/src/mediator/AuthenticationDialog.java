package mediator;

public class AuthenticationDialog implements Mediator {

	private String title;
    private Checkbox loginOrRegisterChkBx;
    private Textbox loginUsername;
    private Textbox loginPassword;
    private Textbox registrationUsername;
    private Textbox registrationPassword;
    private Textbox registrationEmail;
    private Button okBtn;
    private Button cancelBtn;

    public AuthenticationDialog(String title) {
    	this.title = title;
    	this.loginOrRegisterChkBx = new Checkbox(this);
    	this.loginUsername = new Textbox(this);
    	this.loginPassword = new Textbox(this);
    	this.registrationUsername = new Textbox(this);
    	this.registrationPassword = new Textbox(this);
    	this.registrationEmail = new Textbox(this);
    	this.okBtn = new Button(this);
    	this.cancelBtn = new Button(this);
	}
	    
	@Override
	public void notify(Component sender, String event) {
		  if (sender == loginOrRegisterChkBx && event == "check")
	            if (loginOrRegisterChkBx.checked) {
	                this.title = "Log in";
	                // 1. Show login form components.
	                // 2. Hide registration form components.
	            } else {
	                this.title = "Register";
	                // 1. Show registration form components.
	                // 2. Hide login form components
	            }
		  
	        if (sender == okBtn && event == "click") {
	            if (loginOrRegisterChkBx.checked) {
	                // Try to find a user using login credentials.
	            	boolean found = false;
	                if (!found) {
	                    // Show an error message above the login
	                    // field.
	                }
	            } else {
	                // 1. Create a user account using data from the
	                // registration fields.
	                // 2. Log that user in.
	                // ...
	            }
	        }
	}

}
