package biblioteca;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ILib extends Remote
{
	public void readBin() throws RemoteException;
	
	public ArrayList<Livro> pesquisarAutor(String search) throws RemoteException;

	public void remover(long a) throws RemoteException;
	
	public void adicionar(Livro book) throws RemoteException;
	
	public ArrayList<Livro> pesquisarTitulo(String search) throws RemoteException;
	
	public ArrayList<Livro> encontrar(String search) throws RemoteException;
	
	public boolean repeticao(long a, long b, boolean v) throws RemoteException;
	
	public ArrayList<String> editoras() throws RemoteException;
	
	
}