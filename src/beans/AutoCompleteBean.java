package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.component.autocomplete.AutoComplete;
import org.primefaces.event.SelectEvent;

@ManagedBean
public class AutoCompleteBean {
	List<String> namen = Arrays.asList("Anton", "Koziol", "Kara", "Inek", "Martha", "Anna");
	private String auswahl;
	public String getAuswahl() {
		return auswahl;
	}
	public void setAuswahl(String auswahl) {
		this.auswahl = auswahl;
	}
	
	public List<String> loadList(String query) {
		System.out.println(query);
		ArrayList<String> list = new ArrayList<String>();
		for (String name : namen) {
			if (name.toLowerCase().startsWith(query.toLowerCase())) {
				list.add(name);
			}
		}
		
		return list;
	}
	
	public void select(SelectEvent e) {
		AutoComplete ac = (AutoComplete) e.getSource();
		System.out.println(ac.getId());
		
		FacesMessage fmsg = new FacesMessage(auswahl);
		fmsg.setSeverity(FacesMessage.SEVERITY_INFO);
//		fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
		
		fmsg.setDetail("detail . . .");
		
		FacesContext.getCurrentInstance().addMessage(null, fmsg);
	}
}
