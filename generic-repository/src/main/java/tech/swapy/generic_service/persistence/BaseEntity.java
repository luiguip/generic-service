package tech.swapy.generic_service.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4807875741017925970L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public BaseEntity(LocalDateTime cratedAt, LocalDateTime updatedAt) {
		this.createdAt = cratedAt;
		this.updatedAt = updatedAt;
	}
}
