package br.com.ifce.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.ifce.config.HibernateConfig;
import br.com.ifce.model.Filme;

public class FilmeRepository {
	public void salvar (Filme filme) {
		Transaction transacao = null;
		Session session = HibernateConfig.getSessionFactory().openSession();
		transacao = session.beginTransaction();
		session.save(filme);
		transacao.commit();
 		
	}
	public void atualizar(Filme filme) {
		Transaction transacao = null;
		Session session = HibernateConfig.getSessionFactory().openSession();
		transacao = session.beginTransaction();
		session.saveOrUpdate(filme);
		transacao.commit();
	}
	
	public Filme buscarPorId(Long id) {
		Transaction transacao = null;
		Session session = HibernateConfig.getSessionFactory().openSession();
		transacao = session.beginTransaction();
		Filme filme = session.get(Filme.class, id);
		transacao.commit();
		
		return filme;
				
	}
	
		
	public  Filme remover(Long id) {
		Transaction transacao = null;
		Session session = HibernateConfig.getSessionFactory().openSession();
		transacao = session.beginTransaction();
		Filme filme = session.get(Filme.class, id);
		session.remove(filme);
		transacao.commit();
		return filme;
		
	}
	
	public List<Filme> listar() {
        List<Filme> filmes = new ArrayList<Filme>();
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transacao = session.beginTransaction();
        filmes = session.createQuery("select f from Filme as f").list();
        transacao.commit();
        return filmes;
    }


}
