package sru.edu.luczak.GoogleMaps.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NonNull
    private String name;
    
    @NonNull
    private String email;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 /* class CRUDStudent{
		public static void main(String[]args) {
			
			Collection<Users> c new ArrayList<Users>();
			Scanner s = new Scanner(System.in);
			Scanner s1 = new Scanner(System.in);
			int ch;
			do {
				System.out.println("1.ADD");
				System.out.println("2.EDIT");
				System.out.println("1.DELETE");
				System.out.println("Enter your choice: ");
				ch = s.nextInt();
				
				switch(ch) {
				case 1;
				System.out.print("Enter ID: ");
				int id = s1.nextInt();
				System.out.print("Enter Name: ");
				string name = s1.nextLine();
				System.out.print("Enter Email: ");
				string email = s1.nextLine();
				
				c.add (new Users(id,name,email));
				break;
				
				}
				System.out.println("")
				}
		} while (ch!=0); */
	}
	
    // standard constructors / setters / getters / toString
