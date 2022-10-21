package br.com.sevendaycode.fonte;

record Movie(String title, String urlImage, String rating, String year) implements Content {
	
	@Override
	public int compareTo(Content c) {
		return this.rating().compareTo(c.rating());
	}
}
