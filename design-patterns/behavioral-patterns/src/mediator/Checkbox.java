package mediator;

public class Checkbox extends Component {

	public boolean checked;

	public Checkbox(Mediator dialog) {
		super(dialog);
	}

	void check() {
		this.checked = true;
		super.dialog.notify(this, "check");
	}
}
