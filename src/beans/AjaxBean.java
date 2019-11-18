package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AjaxBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
