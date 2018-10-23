package biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class LibClient
{
	public static void main(String[] args)
	{	final int X=3000; //tempo de espera
	final int N=50; //numero de tentativas para se ligar ao server
	while(true){
		boolean sucesso=true;
		boolean terminar=false;
		for(int i=0; i<N; i++){
			try
			{

				// Returns a reference to the remote object Registry on the specified host and port.
				Registry registry = LocateRegistry.getRegistry("localhost", 8000);

				// 'lookup' returns the remote reference bound to the specified name in this registry.
				ILib myLib = (ILib) registry.lookup("aMinhaBibliotecaDistribuida");
				myLib.readBin();
				Scanner reader=new Scanner(System.in);
				System.out.println("que acao deseja realizar?\n1. adicionar um livro\n2. remover um livro\n3. consulta informacoes sobre um livro"
						+ "\n4. atualizar um livro\n5. consultar todas as editoras\n6. terminar o programa\n(introduza o numero de acao que pretende realizar)");
				int informacao=reader.nextInt();
				reader.nextLine();
				if(informacao==1){
					System.out.println("insira nome, autores (separados por ,), ISBN10 e ISBN 13 separados por ;");
					String dados=reader.nextLine();
					String a[]=dados.split(";");
					boolean repeticao=false;
					Livro book= new Livro(a[0],a[1],Long.parseLong(a[2]),Long.parseLong(a[3]));
					repeticao=myLib.repeticao(Long.parseLong(a[2]),Long.parseLong(a[3]), repeticao);
					if(repeticao==false){
						while (true){
							System.out.println("pretende adicionar mais informacoes ao livro?");
							System.out.println("1 - descricao \n2 - formato \n3 - dimensao \n4 - data de publicacao \n5 - editora \n6 - impressao \n7 - local de publicacao \n8 - lingua \n9 - edicao \n10 - ranking \n11- nao pretendo inserir mais informacoes");
							System.out.println("insira o numero da acao que pretende realizar");
							int acao = reader.nextInt();
							reader.nextLine();
							if (acao==1){
								System.out.println("introduza a descricao que pretende adicionar");
								String descricao = reader.nextLine();
								book.setDescricao(descricao);
							}
							else if (acao==2){
								System.out.println("introduza o formato que pretende adicionar");
								String formato = reader.nextLine();
								book.setFormato(formato);
							}
							else if (acao==3){
								System.out.println("introduza a dimensao que pretende adicionar");
								String dimensao = reader.nextLine();
								book.setDimensao(dimensao);
							}
							else if (acao==4){
								System.out.println("introduza a data de publicacao que pretende adicionar");
								String data = reader.nextLine();
								book.setDataDePublicacao(data);
							}
							else if (acao==5){
								System.out.println("introduza a editora que pretende adicionar");
								String editora = reader.nextLine();
								book.setEditora(editora);
							}
							else if (acao==6){
								System.out.println("introduza o local de impressao que pretende adicionar");
								String impressao = reader.nextLine();
								book.setImpressao(impressao);
							}
							else if (acao==7){
								System.out.println("introduza o local de publicacao que pretende adicionar");
								String publicacao = reader.nextLine();
								book.setLocalDePublicacao(publicacao);
							}
							else if (acao==8){
								System.out.println("introduza a lingua que pretende adicionar");
								String lingua = reader.nextLine();
								book.setLingua(lingua);
							}
							else if (acao==9){
								System.out.println("introduza a edicao que pretende adicionar");
								String descricao = reader.nextLine();
								book.setDescricao(descricao);
							}
							else if (acao==10){
								System.out.println("introduza o ranking que pretende adicionar");
								String rank = reader.nextLine();
								book.setRanking(rank);
							}
							else if (acao==11){
								break;
							}

						}
						myLib.adicionar(book);
					}
					else{
						System.out.println("o livro que pretende adicionar ja existe");
					}
				}
				else if(informacao==2){
					System.out.println("insira o ISBN do livro que pretende remover");
					int isbn=reader.nextInt();
					myLib.remover(isbn);
				}
				else if(informacao==3){
					System.out.println("deseja pesquisar o livro por autor ou por titulo?\n 1. titulo\n2. autor\n introduza o numero do que pretende");
					int indice=reader.nextInt();
					reader.nextLine();
					if(indice==1){
						System.out.println("insira o título ou parte do titulo");
						String search=reader.nextLine();
						ArrayList<Livro> ListaIgual=myLib.pesquisarTitulo(search);
						Livro book = null;
						if(ListaIgual.size()>1){
							System. out.println("existe mais de um livro com essas letras");
							System. out.println("qual deles pretende consultar?");
							for (int k=0;k<ListaIgual.size();k++){
								int num=k+1;
								System. out.println(num+" - "+ListaIgual.get(k).getNome());
							}
							int indice1=reader.nextInt();
							reader.nextLine();
							book=ListaIgual.get((indice1-1));
						}
						else if(ListaIgual.size()==1){
							book=ListaIgual.get(0);
						}
						if(book!=null){
							System.out.println(book.toString());
						}
						else{
							System.out.println("o livro nao foi encontrado");
						}

					}
					else if(indice==2){
						System.out.println("introduza o nome do(s) Autor(es) exatamente como esta no livro:)");
						String search=reader.nextLine();
						ArrayList<Livro> ListaIgual=myLib.pesquisarAutor(search);
						Livro book = null;
						if(ListaIgual.size()>1){
							System. out.println("existe mais de um livro com esse Autor");
							System. out.println("qual deles pretende consultar?");
							for (int k=0;k<ListaIgual.size();k++){
								int num=k+1;
								System. out.println(num+" - "+ListaIgual.get(k).getNome());
							}
							int indice1=reader.nextInt();
							reader.nextLine();
							book=ListaIgual.get((indice1-1));
						}
						else if(ListaIgual.size()==1){
							book=ListaIgual.get(0);
						}
						if(book!=null){
							System.out.println(book.toString());
						}
						else{
							System.out.println("o livro nao foi encontrado");
						}
					}
				}
				else if(informacao==4){

					System.out.println("insira o título ou parte do titulo");
					String search=reader.nextLine();
					ArrayList<Livro> ListaIgual=myLib.encontrar(search);
					Livro book = null;
					if(ListaIgual.size()>1){
						System. out.println("existe mais de um livro com essas letras");
						System. out.println("qual deles pretende alterar?");
						for (int k=0;k<ListaIgual.size();k++){
							int num=k+1;
							System. out.println(num+" - "+ListaIgual.get(k).getNome());
						}
						int indice=reader.nextInt();
						reader.nextLine();
						book=ListaIgual.get(indice-1);
						for (int k=0;k<ListaIgual.size();k++){
							if(k!=(indice-1)){
								myLib.adicionar(ListaIgual.get(k));
							}
						}	

					}
					else if(ListaIgual.size()==1){
						book=ListaIgual.get(0);
					}
					if (book!=null){
						while (true){
							System.out.println("que informacoes pretende atualizar ao livro?");
							System.out.println("1 - descricao \n2 - formato \n3 - dimensao \n4 - data de publicacao \n5 - editora \n6 - impressao \n7 - local de publicacao \n8 - lingua \n9 - edicao \n10 - ranking \n11- nao pretendo inserir mais informacoes");
							System.out.println("insira o numero da acao que pretende realizar");
							int acao = reader.nextInt();
							reader.nextLine();
							if (acao==1){
								System.out.println("introduza a descricao que pretende atualizar");
								String descricao = reader.nextLine();
								book.setDescricao(descricao);
							}
							else if (acao==2){
								System.out.println("introduza o formato que pretende atualizar");
								String formato = reader.nextLine();
								book.setFormato(formato);
							}
							else if (acao==3){
								System.out.println("introduza a dimensao que pretende atualizar");
								String dimensao = reader.nextLine();
								book.setDimensao(dimensao);
							}
							else if (acao==4){
								System.out.println("introduza a data de publicacao que pretende atualizar");
								String data = reader.nextLine();
								book.setDataDePublicacao(data);
							}
							else if (acao==5){
								System.out.println("introduza a editora que pretende atualizar");
								String editora = reader.nextLine();
								book.setEditora(editora);
							}
							else if (acao==6){
								System.out.println("introduza o local de impressao que pretende atualizar");
								String impressao = reader.nextLine();
								book.setImpressao(impressao);
							}
							else if (acao==7){
								System.out.println("introduza o local de publicacao que pretende atualizar");
								String publicacao = reader.nextLine();
								book.setLocalDePublicacao(publicacao);
							}
							else if (acao==8){
								System.out.println("introduza a lingua que pretende atualizar");
								String lingua = reader.nextLine();
								book.setLingua(lingua);
							}
							else if (acao==9){
								System.out.println("introduza a edicao que pretende atualizar");
								String descricao = reader.nextLine();
								book.setDescricao(descricao);
							}
							else if (acao==10){
								System.out.println("introduza o ranking que pretende atualizar");
								String rank = reader.nextLine();
								book.setRanking(rank);
							}
							else if (acao==11){
								break;
							}

						}
						myLib.adicionar(book);
					}

				}
				else if(informacao==5){
					ArrayList<String> paresEditorasImpressao = myLib.editoras();
					System.out.println("os pares editora-impressao sao:");
					for(int j=0; j<paresEditorasImpressao.size();j++){
						System.out.println(paresEditorasImpressao.get(j));
					}
				}
				else if(informacao==6){
					terminar=true;
				}

			}
			catch (Exception e) // catching Exception means that we are handling all errors in the same block
			{                   // usually it is advisable to use multiple catch blocks and perform different error handling actions
				// depending on the specific exception type caught
				sucesso=false;
				System.err.println("Ocorreu um erro: ");
				e.printStackTrace(); // prints detailed information about the exception
				try
				{
					Thread.sleep(X); // sleeps for 3 seconds
				}
				catch (InterruptedException e1)
				{
					// do nothing
				}
			}
			if(sucesso==true){ // segnifica que se sucesso for true tem de sair do ciclo de N tentivas
				break;
			}
			if(i==(N-1)){ // se vir esta condiçao significa que o programa tem de terminar pq ja houve N tenativas
				// esta condiçao e valida pq se chegar a esta condiçao significa que na ultima de todas o secesso aina era falso
				terminar=true;
			}
			sucesso=true;
		}
		if(terminar==true){
			System.out.println("o programa terminou");
			break;
		}
	}
	}
}