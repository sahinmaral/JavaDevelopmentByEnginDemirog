package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result Add(Product product);
}
