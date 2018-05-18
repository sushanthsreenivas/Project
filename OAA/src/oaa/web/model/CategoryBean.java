package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

import org.apache.struts.action.ActionForm;

import oaa.web.entities.Category;

public class CategoryBean extends ActionForm {

	private int categoryId;
	private String categoryName;
	Context context = null;
	Connection connection = new ConnectionManager().connection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Category> getCategories() {

		List<Category> categoryList = new ArrayList<Category>();
		try {

			Category category = null;
			String sql = "SELECT category_id,category_name FROM category";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				category = new Category(rs.getInt(1), rs.getString(2));
				// add each employee to the list
				categoryList.add(category);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}

}
