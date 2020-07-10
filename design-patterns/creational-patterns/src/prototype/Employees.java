package prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Prototype<Employees>{

	private List<String> empList;
	
	public Employees(){
		empList = new ArrayList<String>();
	}
	
	public Employees(List<String> list){
		this.empList=list;
	}

	public void loadData(){
		empList.add("Penka");
		empList.add("Reni");
		empList.add("David");
		empList.add("Ivan");
	}
	
	public List<String> getAllEmpoyees() {
		return empList;
	}

	@Override
	public Employees clone() {
		List<String> temp = new ArrayList<String>();
		
		for(String s : this.getAllEmpoyees()){
			temp.add(s);
		}
		
		return new Employees(temp);
	}
}
