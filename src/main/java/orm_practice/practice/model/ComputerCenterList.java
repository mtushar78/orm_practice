package orm_practice.practice.model;

import javax.persistence.*;

@Entity
@Table(name="tbl_ComputerCenterList")
public class ComputerCenterList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	@Column(unique=true)
	private Integer computerCenterId;
	private String computerCenterName;
	private String reconciliationEmail;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getComputerCenterId() {
		return computerCenterId;
	}
	public void setComputerCenterId(Integer computerCenterId) {
		this.computerCenterId = computerCenterId;
	}
	public String getComputerCenterName() {
		return computerCenterName;
	}
	public void setComputerCenterName(String computerCenterName) {
		this.computerCenterName = computerCenterName;
	}
	public String getReconciliationEmail() {
		return reconciliationEmail;
	}
	public void setReconciliationEmail(String reconciliationEmail) {
		this.reconciliationEmail = reconciliationEmail;
	}
	@Override
	public String toString() {
		return "ComputerCenterList [id=" + id + ", computerCenterId=" + computerCenterId + ", computerCenterName="
				+ computerCenterName + ", reconciliationEmail=" + reconciliationEmail + "]";
	}
	public ComputerCenterList(Integer computerCenterId, String computerCenterName, String reconciliationEmail) {
		this.computerCenterId = computerCenterId;
		this.computerCenterName = computerCenterName;
		this.reconciliationEmail = reconciliationEmail;
	}
	public ComputerCenterList() {
		// TODO Auto-generated constructor stub
	}
	
	

}
