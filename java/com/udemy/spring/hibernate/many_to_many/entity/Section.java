package com.udemy.spring.hibernate.many_to_many.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.REFRESH, CascadeType.DETACH})
	//Прописываем в какой таблице и с какими столбцами связывается наша таблица
	@JoinTable(name = "child_section", 
				joinColumns = @JoinColumn(name = "section_id"), // c этим столбцом связывается таблица section
				inverseJoinColumns = @JoinColumn(name = "child_id")) // в этом столбце таблица child_section свяжется с таблицей child
	private List<Child> children;
	
	public Section() {		
	}

	public Section(String name) {		
		this.name = name;
	}
	
	public void addChildToSection(Child child) {
		if (children == null) {
			children = new ArrayList<>();
		}
		children.add(child);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + "]";
	}
	
}
