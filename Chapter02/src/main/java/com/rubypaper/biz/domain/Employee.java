package com.rubypaper.biz.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="S_EMP")
@TableGenerator(name = "SEQ_GENERATOR",
				table = "SHOPPING_SEQUENCES",
				pkColumnName = "SEQ_NAME",
				pkColumnValue = "EMP_SEQ",
				valueColumnName = "NEXT_VALUE",
				initialValue = 0,
				allocationSize = 1)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,
					generator = "SEQ_GENERATOR")
	@Column(length = 7, nullable = false)
	private Long id;
	
	private String name;
}
