import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) throws CloneNotSupportedException{
		final Employees employees = new Employees();
		employees.loadEmployees();
		
		final Employees otherEmployees = (Employees)employees.clone();
		final List<String> otherEmployeesList = otherEmployees.getEmployeesList();
		otherEmployeesList.add("Jogi");
		
		Employees anotherEmployees = (Employees)employees.clone();
		List<String> anotherEmployeesList = anotherEmployees.getEmployeesList();
		anotherEmployeesList.remove("Anu");
		
		System.out.println("Other employee list: " + otherEmployeesList);
		System.out.println("Another employee list: " + anotherEmployeesList);
		System.out.println("Original employee list: " + employees.getEmployeesList());
	}
}

class Employees implements Cloneable {
    
    List<String> employeesList;
    
    Employees() {
        this.employeesList = new ArrayList<>();
    }
    
    Employees(final List<String> empList) {
        this.employeesList = empList;
    }
    
    public void loadEmployees(){
		this.employeesList.add("Manu");
		this.employeesList.add("Anu");
		this.employeesList.add("Sukh");
		this.employeesList.add("Pawan");
	}
	
	public List<String> getEmployeesList() {
		return this.employeesList;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    List<String> temp = new ArrayList<>();
	    for(final String employee: this.getEmployeesList()) {
	        temp.add(employee);
	    }
	    return new Employees(temp);
	}
}
