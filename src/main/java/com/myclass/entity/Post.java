package com.myclass.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.repository.CategoryRepository;

@Entity(name = "posts") 
public class Post {
	
	@Id
	private String id;

//	@Column(name = "user_id")
//	private int userId;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "edited_date")
	private Date editDate;

	private String content;
	private String title;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "category_post", // Tạo ra một join Table tên là "address_person"
			joinColumns = @JoinColumn(name = "post_id"), // Trong đó, khóa ngoại chính là post_id trỏ tới class
														// hiện tại (Post)
			inverseJoinColumns = @JoinColumn(name = "category_id") // Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới
																	// (Person)
	)
	private List<Category> categories;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;

	@OneToMany(mappedBy="post")
    private List<Comment> comments;
	
	@ManyToOne 
	@JoinColumn(name = "user_id") // thông qua khóa ngoại user_id 
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Category> getCategories() {
		return categories;
		//return this.repo.findTest();
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
