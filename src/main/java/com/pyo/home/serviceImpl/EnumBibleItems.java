package com.pyo.home.serviceImpl;

import lombok.Getter;
import lombok.ToString;

@Getter
//@ToString
public enum EnumBibleItems {
	창세기("ge",50,26), 
	출애굽기("exo",40,38),
	레위기("lev",27,34),
	민수기("num",36,13),
	신명기("deu",34,12),
	
	여호수아("josh",24,33),
	사사기("jdgs",21,25),
	룻기("ruth",4,22),
	사무엘상("1sm",31,13),
	사무엘하("2sm",24,25),
	열왕기상("1ki",22,53),
	열왕기하("2ki",25,30),
	역대상("1chr",29,30),
	역대하("2chr",36,23),
	에스라("ezra",10,44),
	느헤미야("neh",13,31),
	에스더("est",10,3),
	
	욥기("job",42,17),
	시편("psa",150,6),
	잠언("prv",31,31),
	전도서("eccl",12,14),
	아가("ssol",8,14),
	
	이사야("isa",66,24),
	예레미야("jer",52,34),
	예레미야애가("lam",5,22),
	에스겔("eze",48,35),
	다니엘("dan",12,13),
	
	호세아("hos",14,9),
	요엘("joel",3,21),
	아모스("amos",9,15),
	오바댜("obad",1,21),
	요나("jonah",4,11),
	미가("mic",7,20),
	나훔("nahum",3,19),
	하박국("hab",3,19),
	스바냐("zep",3,20),
	학개("hag",2,23),
	스가랴("zep",14,21),
	말라기("mal",4,6),
	
	마태복음("mat",28,20),
	마가복음("mark",16,20),
	누가복음("luke",24,53),
	요한복음("john",21,25),
	사도행전("acts",28,31),
	로마서("rom",16,27),
	고린도전서("1cor",16,24),
	고린도후서("2cor",13,14),
	갈라디아서("gal",6,18),
	에베소서("eph",6,24),
	빌립보서("phi",4,23),
	골로새서("col",4,18),
	데살로니가전서("1th",5,28),
	데살로니가후서("2th",3,18),
	디모데전서("1tim",6,21),
	디모데후서("2tim",4,22),
	디도서("titus",3,15),
	빌레몬서("phmn",1,25),
	히브리서("heb",13,25),
	야고보서("jas",5,20),
	베드로전서("1pet",5,14),
	베드로후서("2pet",3,18),
	요한1서("1jn",5,21),
	요한2서("2jn",1,13),
	요한3서("3jn",1,15),
	유다서("jude",1,25),
	요한계시록("rev",22,21);

	EnumBibleItems(String book_eng, int lastChapter, int lastVerse) {
		this.book_eng = book_eng;
		this.lastChapter = lastChapter;
		this.lastVerse = lastVerse;
	}
	private final String book_eng;
	private final int lastChapter;
	private final int lastVerse;
	
}
