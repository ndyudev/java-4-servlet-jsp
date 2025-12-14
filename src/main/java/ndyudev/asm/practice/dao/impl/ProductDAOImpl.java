package ndyudev.asm.practice.dao.impl;

import ndyudev.asm.practice.dao.ProductDAO;
import ndyudev.asm.practice.entity.Product;

public class ProductDAOImpl extends BaseDAOImpl<Product, Integer> implements ProductDAO {

	public ProductDAOImpl() {
		super(Product.class);
	}

}
