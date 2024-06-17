package test;

import static org.mockito.Mockito.*;

import dao.ProductDAO;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import view.FormProduct;

import javax.swing.*;

@ExtendWith(MockitoExtension.class)
public class TestFormProduct {

    @Mock
    private ProductDAO mockProductDAO;

    @InjectMocks
    private FormProduct formProduct;

    @BeforeEach
    public void setUp() {
        formProduct = new FormProduct();
        formProduct.txtName = new JTextField();
        formProduct.txtPrice = new JTextField();
        formProduct.btnSave = new JButton();
    }

    @Test
    public void testBtnSaveActionPerformed() {
        // Arrange
        formProduct.txtName.setText("Test Product");
        formProduct.txtPrice.setText("10.0");

        // Act
        formProduct.btnSave.doClick();

        // Assert
        verify(mockProductDAO, times(1)).insertProduct(any(Product.class));
    }
}
