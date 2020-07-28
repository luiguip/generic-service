package tech.swapy.abstract_service.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import tech.swapy.utils.model.HashCodeCalculator;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 4807875741017925970L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public BaseModel() {
		this.setCreatedAt(LocalDateTime.now());
		this.setUpdatedAt(LocalDateTime.now());
	}

	public BaseModel(BaseModel baseModel) {
		this.setId(baseModel.getId());
		this.setCreatedAt(baseModel.getCreatedAt());
		this.setUpdatedAt(LocalDateTime.now());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		HashCodeCalculator hashCodeCalculator = new HashCodeCalculator(getAllAsObjectList());
		return hashCodeCalculator.getHashCodeValue();
	}

	@Override
	public boolean equals(Object object) {
		if (!isMinimumRequirementsSatisfied(object)) {
			return false;
		}
		return this.isSameObject(object);
	}

	private List<Object> getAllAsObjectList() {
		return Arrays.asList(getId(), getCreatedAt(), getUpdatedAt());
	}

	private boolean isMinimumRequirementsSatisfied(Object object) {
		return isIdNotNull() && isObjectNotNull(object) && isSameClass(object);
	}

	private boolean isObjectNotNull(Object object) {
		return object != null;
	}

	private boolean isIdNotNull() {
		return this.getId() != null;
	}

	private boolean isSameClass(Object object) {
		return this.getClass().equals(object.getClass());
	}

	private boolean isSameObject(Object object) {
		BaseModel that = (BaseModel) object;
		if(this == that) {
			return true;
		} else {
			return this.areSameFields(that);
		}
	}

	private boolean areSameFields(BaseModel that) {
		return isSameId(that) && isSameCreatedAt(that) && isSameUpdatedAt(that);
	}

	private boolean isSameId(BaseModel that) {
		return this.getId().equals(that.getId());
	}

	private boolean isSameCreatedAt(BaseModel that) {
		return this.getCreatedAt().equals(that.getUpdatedAt());
	}

	private boolean isSameUpdatedAt(BaseModel that) {
		return this.getUpdatedAt().equals(that.getUpdatedAt());
	}
}
