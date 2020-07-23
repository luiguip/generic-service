package tech.swapy.abstract_service.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel implements Serializable {

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

	private void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}
		BaseModel that = (BaseModel) obj;
		return this.id.equals(that.getId());
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}
