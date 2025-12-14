package ndyudev.asm.practice.dao.impl;


import ndyudev.asm.practice.dao.CategoryDAO;
import ndyudev.asm.practice.entity.Category;

public class CategoryDAOImpl extends BaseDAOImpl<Category, String> implements CategoryDAO {

	public CategoryDAOImpl() {
		super(Category.class);

	}

}
