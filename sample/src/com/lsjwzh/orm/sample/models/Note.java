package com.lsjwzh.orm.sample.models;

import java.util.Date;

import com.lsjwzh.orm.Model;
import com.lsjwzh.orm.annotations.AutoIncrement;
import com.lsjwzh.orm.annotations.Column;
import com.lsjwzh.orm.annotations.DynamicColumn;
import com.lsjwzh.orm.annotations.Key;
import com.lsjwzh.orm.annotations.Table;

@Table("Notes")
public class Note extends Model {

	@AutoIncrement
    @Key @Column("id") private long id;
	@Column("content") private String content;
	@Column("created_at") private Date createdAt = new Date();
	@Column("updated_at") private Date updatedAt = new Date();
    @DynamicColumn("tag_count") private int tagCount;
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

    public int getTagCount() {
        return tagCount;
    }
	
	protected void beforeCreate() {
		createdAt = new Date();
	}
	
	protected void beforeSave() {
		updatedAt = new Date();
	}

}
