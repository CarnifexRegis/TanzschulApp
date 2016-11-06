package database;

/**
 *  This Class Accesses the Picture Table
 *  @author Simon Stolz
 *  NOT READY
 */
public class Picture {
	String clientSource;
	String serverSource;
	int idp;
	long id;
	boolean me;
	public Picture(String clientSource, String serverSource, int idp,long id) {
		super();
		this.clientSource = clientSource;
		this.serverSource = serverSource;
		this.idp = idp;
		this.id = id;
		if(idp == -1){
			me =  true ;
		}
		
		
	}
	public Picture(){
		super();
		clientSource = null;	
		}	
	public String getClientSource() {
		return clientSource;
	}
	public void setClientSource(String clientSource) {
		this.clientSource = clientSource;
	}
	public String getServerSource() {
		return serverSource;
	}
	public void setServerSource(String serverSource) {
		this.serverSource = serverSource;
	}
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isMe() {
		return me;
	}
	public void setMe(boolean me) {
		this.me = me;
	}
	
}
