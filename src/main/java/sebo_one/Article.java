package sebo_one;

public class Article {
	public int CodeArticle ;
	public double Prix ;
	public String Designation ;
	public int Stock ;
	public Long id_cat ;
	public String cat ;
	public String photo ;
	public String RefCAt ;
	
	public Article() {
		super();
	}

	public Article(double prix, String designation, int stock, String refCAt, String photo) {
		super();
		this.Prix = prix;
		this.Designation = designation;
		this.Stock = stock;
		this.photo = photo;
		this.RefCAt = refCAt;
	}
	
	public int getCodeArticle() {
		return CodeArticle;
	}

	public void setCodeArticle(int codeArticle) {
		CodeArticle = codeArticle;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRefCAt() {
		return RefCAt;
	}

	public void setRefCAt(String refCAt) {
		RefCAt = refCAt;
	}

	public Long getId_cat() {
		return id_cat;
	}

	public void setId_cat(Long id_cat) {
		this.id_cat = id_cat;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
	
	

}
