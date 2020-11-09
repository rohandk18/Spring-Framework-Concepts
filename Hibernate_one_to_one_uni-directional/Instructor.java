package hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor
{

	public Instructor() {
		
	}


	public Instructor(String firstName, String lasttName, String email
			) {
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lasttName=" + lasttName + ", email=" + email
				+ ", InstructorDetail=" + InstructorDetail + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLasttName() {
		return lasttName;
	}


	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructorDetail() {
		return InstructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		InstructorDetail = instructorDetail;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lasttName;
	
	
	@Column(name="email")
	private String email;
	
	
	//setting up mapping to instructor detail entity
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail InstructorDetail;

}
