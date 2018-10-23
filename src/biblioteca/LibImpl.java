package biblioteca;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class LibImpl extends UnicastRemoteObject implements ILib
{
	private ArrayList<Livro> ListaLivros = new ArrayList<Livro>();
	//private FileOutputStream fos=new FileOutputStream("myFile.bin");
	
	


	public LibImpl() throws RemoteException
	{
		// empty
	}
	
	public void readBin() throws RemoteException{
		FileInputStream fos;
		ObjectInputStream in;
		try
		{
			fos = new FileInputStream("myFile.bin");
			in= new ObjectInputStream(fos);
			this.ListaLivros=(ArrayList<Livro>) in.readObject();
			
			
		}
		catch (IOException | ClassNotFoundException  e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addBin(ArrayList<Livro> a) throws RemoteException{
		FileOutputStream fos;
		ObjectOutputStream out;
		try
		{
			fos = new FileOutputStream("myFile.bin");
			out= new ObjectOutputStream(fos);
			out.writeObject(a);
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean repeticao(long a, long b, boolean v) throws RemoteException{
		for(int i=0; i<ListaLivros.size(); i++){
			if(a!=ListaLivros.get(i).getISBN10() & b!=ListaLivros.get(i).getISBN13()){
				v=false;	
			}
			else{
				v=true;	
			}

		}
		return v;
	}

	public ArrayList<Livro> pesquisarAutor(String search) throws RemoteException
	{
		System.out.println("A executar...");
		ArrayList<Livro> ListaIgual=new ArrayList<Livro>();

		for(int i=0; i<ListaLivros.size();i++){
			Livro book = null;
			String autor=ListaLivros.get(i).getAutor();
			if ( autor.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {
				book=ListaLivros.get(i);
				ListaIgual.add(book);
			} 
		}
		return ListaIgual;

	}

	public void remover(long a) throws RemoteException
	{	
		System.out.println("A executar...");
		
		for(int i=0; i<ListaLivros.size();i++){
			Livro b=ListaLivros.get(i);
			if(a==b.getISBN10()){
				ListaLivros.remove(b);
				addBin(this.ListaLivros);
			
			

			}
			else if(a==b.getISBN13()){
				ListaLivros.remove(b);
				addBin(this.ListaLivros);
				
				
			}
		}
	}
	//FEITO
	public void adicionar(Livro book) throws RemoteException
	{
		ListaLivros.add(book);
		addBin(this.ListaLivros);
	

	}
	

	public ArrayList<Livro> pesquisarTitulo(String search) throws RemoteException
	{
		System.out.println("A executar...");
		ArrayList<Livro> ListaIgual=new ArrayList<Livro>();
		
		for(int i=0; i<ListaLivros.size();i++){
			Livro book = null;
			String titulo=ListaLivros.get(i).getNome();
			if ( titulo.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {
				book=ListaLivros.get(i);
				ListaIgual.add(book);
			} 
		}
		return ListaIgual;

	}

	public ArrayList<Livro> encontrar(String search) throws RemoteException
	{
		System.out.println("A executar...");
		ArrayList<Livro> ListaIgual=new ArrayList<Livro>();
		ArrayList<Livro> Comparar=this.ListaLivros;
		Livro book = null;
		for(int i=0; i<Comparar.size();i++){
			String titulo=Comparar.get(i).getNome();
			if ( titulo.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {
				book=Comparar.get(i);
				ListaIgual.add(book);
			} 
		}
		for(int i=0; i<Comparar.size();i++){
			String titulo=Comparar.get(i).getNome();
			if ( titulo.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {
				book=Comparar.get(i);
				ListaLivros.remove(book);
			} 
		}
		Comparar.clear();
		return ListaIgual;
		
	}
	
	public ArrayList<String> editoras() throws RemoteException
	{
		ArrayList<String> ListaEditoras = new ArrayList<String>();
		for(int i=0; i<ListaLivros.size();i++){
			String editora="--";
			String impressao="--";
			if(ListaLivros.get(i).getEditora().equals(null)){
				//nao adicionar
			}
			else{
				editora=ListaLivros.get(i).getEditora();
			}
			if(ListaLivros.get(i).getImpressao().equals(null)){
				//nao adicionar
			}
			else{
				impressao=ListaLivros.get(i).getImpressao();
			}
			String editoraImpressao=editora+"-"+impressao;
			if(ListaEditoras.size()==0){
				ListaEditoras.add(editoraImpressao);
			}
			else{
				for (int k=0; k<ListaEditoras.size();k++){
					if(editoraImpressao.equals(ListaEditoras.get(k))){
						//nao se pode adicionar este par
					}
					else{
						ListaEditoras.add(editoraImpressao);
					}
				}
			}

		}
		return ListaEditoras;
	}





}