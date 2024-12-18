module BradleyBeverageShop {
    requires java.desktop;
	requires junit; // Allow access to javax.swing
    exports com.beverageshop; // Export your custom package
}
