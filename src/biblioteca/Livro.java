package biblioteca;

import java.io.Serializable;

public class Livro implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String Nome;
	private String Autor;
	private String Descricao;
	private String Formato;
	private String Dimensao;
	private String DataDePublicacao;
	private String Editora;
	private String Impressao;
	private String LocalDePublicacao;
	private String Lingua;
	private String Edicao;
	private long ISBN10;
	private long ISBN13;
	private String Ranking;



	public Livro(String Nome, String Autor,long ISBN10,long ISBN13)
	{
		this.Nome = Nome;
		this.Autor=Autor;
		this.ISBN10 = ISBN10;
		this.ISBN13 = ISBN13;
	}
	public String toString(){
		String descricao=""+this.Descricao;
		if(this.Descricao==null){descricao="--";}
		else{descricao=this.Descricao;}
		
		String formato=""+this.Formato;
		if(this.Formato==null){formato="--";}
		else{formato=this.Formato;}
		
		String dimensao=""+this.Dimensao;
		if(this.Dimensao==null){dimensao="--";}
		else{dimensao=this.Dimensao;}
		
		String datadepub=""+this.DataDePublicacao;
		if(this.DataDePublicacao==null){datadepub="--";}
		else{datadepub=this.DataDePublicacao;}
		
		String editora=""+this.Editora;
		if(this.Editora==null){editora="--";}
		else{editora=this.Editora;}
		
		String impressao=""+this.Impressao;
		if(this.Impressao==null){impressao="--";}
		else{impressao=this.Impressao;}
		
		String localdepub=""+this.LocalDePublicacao;
		if(this.LocalDePublicacao==null){localdepub="--";}
		else{localdepub=this.LocalDePublicacao;}

		String lingua=""+this.Lingua;
		if(this.Lingua==null){lingua="--";}
		else{lingua=this.Lingua;}
		
		String edicao=""+this.Edicao;
		if(this.Edicao==null){ edicao="--";}
		else{ edicao=this.Edicao;}
		
		String ranking=""+this.Ranking;
		if(this.Ranking==null){ ranking="--";}
		else{ranking=this.Ranking;}
		
		return "==========================================================\n"+"titulo: "+this.Nome+"\nAutor(s): "+this.Autor+"\nDescricao: "+descricao+"\nFormato: "+formato+
				"\nDimensao: "+dimensao+"\nData de publicacao: "+datadepub+"\nEditora: "+editora+"\nImpressao: "+impressao+"\nLocal de publicacao: "+localdepub+
				"\nLingua: "+lingua+"\nEdicao: "+edicao+"\nISBN10: "+this.ISBN10+"\nISBN13: "+this.ISBN13+"\nRanking: "+ranking;	
		
	}


	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public String getAutor() {
		return Autor;
	}



	public void setAutor(String autor) {
		Autor = autor;
	}



	public String getDescricao() {
		return Descricao;
	}



	public void setDescricao(String descricao) {
		Descricao = descricao;
	}



	public String getFormato() {
		return Formato;
	}



	public void setFormato(String formato) {
		Formato = formato;
	}



	public String getDimensao() {
		return Dimensao;
	}



	public void setDimensao(String dimensao) {
		Dimensao = dimensao;
	}



	public String getDataDePublicacao() {
		return DataDePublicacao;
	}



	public void setDataDePublicacao(String dataDePublicacao) {
		DataDePublicacao = dataDePublicacao;
	}



	public String getEditora() {
		return Editora;
	}



	public void setEditora(String editora) {
		Editora = editora;
	}



	public String getImpressao() {
		return Impressao;
	}



	public void setImpressao(String impressao) {
		Impressao = impressao;
	}



	public String getLocalDePiblicacao() {
		return LocalDePublicacao;
	}



	public void setLocalDePublicacao(String localDePublicacao) {
		LocalDePublicacao = localDePublicacao;
	}



	public String getLingua() {
		return Lingua;
	}



	public void setLingua(String lingua) {
		Lingua = lingua;
	}



	public String getEdicao() {
		return Edicao;
	}



	public void setEdicao(String edicao) {
		Edicao = edicao;
	}



	public long getISBN10() {
		return ISBN10;
	}



	public void setISBN10(long iSBN10) {
		ISBN10 = iSBN10;
	}



	public long getISBN13() {
		return ISBN13;
	}



	public void setISBN13(long iSBN13) {
		ISBN13 = iSBN13;
	}



	public String getRanking() {
		return Ranking;
	}



	public void setRanking(String ranking) {
		Ranking = ranking;
	}



}