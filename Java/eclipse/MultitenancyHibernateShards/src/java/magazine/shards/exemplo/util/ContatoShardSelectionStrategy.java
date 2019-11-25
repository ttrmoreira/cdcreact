package java.magazine.shards.exemplo.util;

import java.magazine.shards.exemplo.modelo.Contato;

import org.hibernate.shards.ShardId;
import org.hibernate.shards.strategy.selection.ShardSelectionStrategy;


public class ContatoShardSelectionStrategy implements ShardSelectionStrategy {

	   public ShardId selectShardIdForNewObject(Object obj) {
	      if (obj instanceof Contato) {
	         return getShardId(((Contato) obj).getInquilinoId().toString());
	      }
	      throw new IllegalArgumentException();
	   }

	   public ShardId getShardId(String inquilinoId) {
	      int shardId = 0; 
	      if(inquilinoId.equalsIgnoreCase("1"))
	         shardId = 0;
	      else if(inquilinoId.equalsIgnoreCase("2"))
	         shardId = 1;
	      else if(inquilinoId.equalsIgnoreCase("3"))
	         shardId = 2;
	      return new ShardId(shardId);
	   }
}
