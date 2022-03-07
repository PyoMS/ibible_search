package com.pyo.home.DTO;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bible {
	@Id
	private String book;
	private int chapter;
	private int verse;
	private String contents;
}
