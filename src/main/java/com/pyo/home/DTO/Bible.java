package com.pyo.home.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bible {
	@Id
	@GeneratedValue
	private Integer id; //book을 id로 갖게되면 무결성 위배(but, 에러 안뜨고 마지막 데이터만 처리됨.)
	
	private String book;
	private String chapter;
	private String verse;
	private String contents;
}
