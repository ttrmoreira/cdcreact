package java.magazine.shards.exemplo.client;

import java.magazine.shards.exemplo.modelo.Contato;
import java.magazine.shards.exemplo.util.ContatoShardSelectionStrategy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.shards.ShardId;
import org.hibernate.shards.ShardedConfiguration;
import org.hibernate.shards.cfg.ConfigurationToShardConfigurationAdapter;
import org.hibernate.shards.cfg.ShardConfiguration;
import org.hibernate.shards.strategy.ShardStrategy;
import org.hibernate.shards.strategy.ShardStrategyFactory;
import org.hibernate.shards.strategy.ShardStrategyImpl;
import org.hibernate.shards.strategy.access.SequentialShardAccessStrategy;
import org.hibernate.shards.strategy.access.ShardAccessStrategy;
import org.hibernate.shards.strategy.resolution.AllShardsShardResolutionStrategy;
import org.hibernate.shards.strategy.resolution.ShardResolutionStrategy;
import org.hibernate.shards.strategy.selection.ShardSelectionStrategy;


public class ContatoApp {
	private SessionFactory sessionFactory;

	public static void main(String[] args) throws Exception {
	    ContatoApp app = new ContatoApp();
	    app.run();
	}

	private void run() throws SQLException {
	    sessionFactory = createSessionFactory();
	
	    addData();
	
	    Session session = sessionFactory.openSession();
	    try {
	    	Criteria crit = session.createCriteria(Contato.class);
		    List count = crit.list();
		    System.out.println(count.size());
		    
		    List contatos = getData();
		    for (int i = 0; i < contatos.size(); i++) {
		    	Contato contato = (Contato) contatos.get(i);
		    	System.out.println(contato.toString());
		    }
	    } finally {
	      session.close();
	    }
	}

	private List getData() {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    List result = session.createQuery("from Contato").list();
	    session.getTransaction().commit();
	    session.close();
	    
	    return result;
	}

	private void addData() {
	    Session session = sessionFactory.openSession();
	    try {
	      session.beginTransaction();
	      Contato contato1 = new Contato();
	      contato1.setContatoId(1);
	      contato1.setNome("João");
	      contato1.setEndereco("Rua X - 441");
	      contato1.setInquilinoId(0);
	      contato1.setTelefone("1111-1111");
	      session.save(contato1);

	      /*Adicione novos contatos com diferentes Tenants no banco de dados*/
	      
	      session.getTransaction().commit();
	    } finally {
	      session.close();
	    }
	}
	
		  public SessionFactory createSessionFactory() {
		   Configuration config = new Configuration();
		   config.configure("shard0.hibernate.cfg.xml");
		   config.addResource("contato.hbm.xml");

		   List shardConfigs = new ArrayList();
		   shardConfigs.add(buildShardConfig("shard0.hibernate.cfg.xml"));

		   ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
		   ShardedConfiguration shardedConfig = new ShardedConfiguration(
		                                                        config,
		                                                        shardConfigs,
		                                                        shardStrategyFactory);
		   return shardedConfig.buildShardedSessionFactory();
		}

	  ShardStrategyFactory buildShardStrategyFactory() {
		   return new ShardStrategyFactory() {
		      public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
		         ShardSelectionStrategy pss = new ContatoShardSelectionStrategy();
		         ShardResolutionStrategy prs = new AllShardsShardResolutionStrategy(shardIds);
		         ShardAccessStrategy pas = new SequentialShardAccessStrategy();
		         return new ShardStrategyImpl(pss, prs, pas);
		      }
		   };
		}

	ShardConfiguration buildShardConfig(String configFile) {
		Configuration config = new Configuration().configure(configFile);
		return new ConfigurationToShardConfigurationAdapter(config);
	}

}
