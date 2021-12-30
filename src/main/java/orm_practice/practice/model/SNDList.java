package orm_practice.practice.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tbl_SNDList")
public class SNDList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true, name = "snd_id")
	private Integer sndId;
	private String sNDName;
	private Integer computerCenterId;
	private Integer displayOrder;
	@OneToMany(targetEntity = BillInfoEntity.class, mappedBy = "sndList", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<BillInfoEntity> billInfoEntities;

	public SNDList(Integer sndId, String sNDName, Integer computerCenterId, Integer displayOrder, Set<BillInfoEntity> billInfoEntities) {
		this.sndId = sndId;
		this.sNDName = sNDName;
		this.computerCenterId = computerCenterId;
		this.displayOrder = displayOrder;
		this.billInfoEntities = billInfoEntities;
	}

	public SNDList() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getSndId() {
		return sndId;
	}

	public void setSndId(Integer sndId) {
		this.sndId = sndId;
	}

	public String getsNDName() {
		return sNDName;
	}

	public void setsNDName(String sNDName) {
		this.sNDName = sNDName;
	}

	public Integer getComputerCenterId() {
		return computerCenterId;
	}

	public void setComputerCenterId(Integer computerCenterId) {
		this.computerCenterId = computerCenterId;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Set<BillInfoEntity> getBillInfoEntities() {
		return billInfoEntities;
	}

	public void setBillInfoEntities(Set<BillInfoEntity> billInfoEntities) {
		this.billInfoEntities = billInfoEntities;
	}
}
